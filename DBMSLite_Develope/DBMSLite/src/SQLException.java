
public class SQLException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1308774406597148486L;
	
	private static final int ERR_UNCORRECT_SQL = 1;
	private static final int ERR_NO_TABLE_NAME = 2;
	private static final int ERR_NO_DATABASE = 3;
	private static final int ERR_NO_DESTINATION = 4;
	private static final int ERR_NO_EXIST_DOMAIN = 5;
	private static final int ERR_OVERLAPPED = 6;

	String errMessage;

	public SQLException(int ERR_CODE) {
		switch (ERR_CODE) {
		case ERR_UNCORRECT_SQL:
			this.errMessage = "Uncorrect SQL";
			break; // SQL문법이 틀린 경우
		case ERR_NO_TABLE_NAME:
			this.errMessage = "No table name";
			break; // Table이름이 없는 경우
		case ERR_NO_DATABASE:
			this.errMessage = "No Database";
			break; // Database가 생성이 되지 않은 경우
		case ERR_NO_DESTINATION:
			this.errMessage = "No destination";
			break; // 대상이 선정되지 않은 경우
		case ERR_NO_EXIST_DOMAIN:
			this.errMessage = "No exist domain";
			break; // 없는 도메인
		case ERR_OVERLAPPED:
			this.errMessage = "Overlapped";
			break; // 중복되는 경우
		}
	}

	public String getMessage() {
		return errMessage;
	}
}
