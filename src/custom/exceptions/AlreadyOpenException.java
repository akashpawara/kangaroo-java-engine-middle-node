package custom.exceptions;

@SuppressWarnings("serial")
public class AlreadyOpenException extends Exception {
	public AlreadyOpenException(String message) {
		super(message);
	}
}
