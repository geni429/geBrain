
public class SQLHelper {
//	private static final int DDL_CREATE = 1;
//	private static final int DDL_DROP = 2;
//	private static final int DDL_ALTER = 3;
//	private static final int DML_INSERT = 4;
	
	public void CheckPurpose(String SQL) throws SQLException {
		DBHelper DBH = new DBHelper();
		if(SQL.contains("CREATE TABLE")){
			DBH.CREATE(SQL.substring(12).trim());
		} else if(SQL.contains("INSERT INTO")){
			DBH.INSERT(SQL.substring(11).trim());
		} else {
			throw new SQLException(1);
		}
	}

	public void Partitoning() {

	}

	public void DomainCheck() {

	}
}
