
public class WritingSQLException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8404636633064212951L;
	private static final int ERR_UNCORRECT_SQL = 1;
	private static final int ERR_NOTABLENAME = 2;
	private static final int ERR_NODESTINATION = 3;
	private static final int ERR_UNKNOWN_DOMAIN = 4;

	String errorMessage;

	public WritingSQLException() {
		super();
	}

	public WritingSQLException(int errorCode) {
		switch (errorCode) {
		case ERR_UNCORRECT_SQL:
			this.errorMessage = "Uncorrect SQL";
			break;
			// SQL문법이 틀림
		case ERR_NOTABLENAME:
			this.errorMessage = "No table name";
			break;
			// table이름이 입력되지않음
		case ERR_NODESTINATION:
			this.errorMessage = "No destination";
			break;
			// 대상이 없음
		case ERR_UNKNOWN_DOMAIN:
			this.errorMessage = "Unknown domain";
			break;
			// 모르는 도메인
		}
	}

	public String getMessage() {
		return errorMessage;
	}
}
