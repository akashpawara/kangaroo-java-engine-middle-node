package file.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.StudentAttendance;
import model.StudentMarks;
import model.TeacherAttendance;
import repository.StudentAttendanceRepository;
import repository.StudentMarksRepository;
import repository.TeacherAttendanceRepository;
import sockets.Client;

public class FileWatcher extends Thread {
	// usage
	public static void main(String args[]) throws Exception {
		Thread runner = new FileWatcher("C://xampp/htdocs/sikkim_3/vanashing_log/vanashing_student_attendance.txt", 1,
				"192.168.43.183", 3001, 1);
		runner.run();
	}

	FileReader file;
	FileWriter wf;
	String fileContents;
	String path;
	int length, port;
	String ip;
	int type; // 1|2|3

	public FileWatcher(String path, int lineLength, String ip, int port, int type) throws Exception {
		this.path = path;
		this.length = lineLength;
		this.ip = ip;
		this.port = port;
		this.type = type;
	}

	public void run() {
		while (1 < 2) {
			try {
				this.file = new FileReader(path);
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				BufferedReader br = new BufferedReader(this.file);
				Stack<String> listOfString = new Stack<String>();
				String line = "";

				while ((line = br.readLine()) != null) {
					listOfString.push(line);
				}

				int lengthOfArray = listOfString.size();
				System.out.println(lengthOfArray);

				if (lengthOfArray >= this.length) {
//					listOfString.pop();
					System.out.println("in if");
					while (listOfString.size() > 0) {
						String hash = listOfString.pop();
						String rLine = "";
						try {
							switch (this.type) {
							case 1:
								try {
									StudentAttendanceRepository sar = new StudentAttendanceRepository();
									StudentAttendance sa = sar.getRow(hash);
									sar.closeConnection();
									//System.out.println("i hate you");
									rLine = sa.getLog();
								} catch (Exception e) {
									e.printStackTrace();
								}
								break;
							case 2:
								StudentMarksRepository smr = new StudentMarksRepository();
								smr.closeConnection();
								StudentMarks sm = smr.getRow(rLine);
								rLine = sm.getLog();
								break;
							case 3:
								TeacherAttendanceRepository tar = new TeacherAttendanceRepository();
								tar.closeConnection();
								TeacherAttendance ta = tar.getRow(rLine);
								rLine = ta.getLog();
								break;
							default:
								throw new Exception("Something");
							}

							new Client("192.168.43.183", 3001, rLine,hash);

							System.out.println(rLine);

						} catch (Exception e) {
							// e.printStackTrace();
							listOfString.push(hash);
						}
					}

					System.out.println("Sending receiving done here");
					this.file.close();
					this.wf = new FileWriter(path);
					BufferedWriter bw = new BufferedWriter(this.wf);

					while (listOfString.size() > 0) {
						String rLine = listOfString.remove(lengthOfArray - 1);
						bw.write(rLine + "\n");
					}
//					//System.out.println("here");
				} else {
					this.file.close();
				}

				System.out.println(listOfString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
