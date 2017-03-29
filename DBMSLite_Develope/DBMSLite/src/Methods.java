
public interface Methods {
	public void execSQL(String SQL) throws SQLException;

	// DDL
	public void CREATE(String C_SQL) throws SQLException;

	public void DROP();

	// DML
	public void INSERT(String C_SQL);

	public void DELETE();

	public String SELECT();

	public void CatchOverlap();
}
