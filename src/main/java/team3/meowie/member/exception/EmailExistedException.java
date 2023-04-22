package team3.meowie.member.exception;

public class EmailExistedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailExistedException() {
	}

	public EmailExistedException(String message) {
		super(message);
	}

	public EmailExistedException(Throwable cause) {
		super(cause);
	}

	public EmailExistedException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailExistedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
