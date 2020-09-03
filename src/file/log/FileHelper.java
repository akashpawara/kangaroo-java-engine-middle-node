package file.log;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import model.StudentAttendance;
import model.StudentMarks;
import model.TeacherAttendance;

public class FileHelper {
	public static int writeStudentAttendanceToFile(StudentAttendance sa, String text, String filePath) throws Exception {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
		if (sa != null) {			
			bufferedWriter.write(sa.getLog());
		} else {		
			bufferedWriter.write(text);
		}
		bufferedWriter.newLine();
		bufferedWriter.close();
		return FileHelper.count(filePath);
	}

	public static int writeStudentMarksToFile(StudentMarks sm,  String text, String filePath) throws Exception {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
		if (sm != null) {			
			bufferedWriter.write(sm.getLog());
		} else {		
			bufferedWriter.write(text);
		}
		bufferedWriter.newLine();
		bufferedWriter.close();
		return FileHelper.count(filePath);
	}

	public static int writeTeacherAttendanceToFile(TeacherAttendance ta, String text, String filePath) throws Exception {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
		if (ta != null) {			
			bufferedWriter.write(ta.getLog());
		} else {		
			bufferedWriter.write(text);
		}
		bufferedWriter.newLine();
		bufferedWriter.close();
		return FileHelper.count(filePath);
	}

	public static int count(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			while ((readChars = is.read(c)) != -1) {
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n')
						++count;
				}

			}
			return count;
		} finally {
			is.close();
		}
	}
}
