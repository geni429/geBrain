
public class DBHelper implements Methods {
	SQLHelper SQLHelper = new SQLHelper();
	private String getSQL;
	
	@Override
	public void execSQL(String SQL) throws SQLException {
		// TODO Auto-generated method stub
		this.getSQL = SQL.toUpperCase();
		SQLHelper.CheckPurpose(getSQL);
	}

	@Override
	public void CREATE(String C_SQL) throws SQLException {
		// TODO Auto-generated method stub
		if(C_SQL.length() == 0){
			throw new SQLException(2);
		}
		System.out.println(C_SQL);
	}

	@Override
	public void DROP() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void INSERT(String C_SQL) {
		// TODO Auto-generated method stub
		System.out.println(C_SQL);
	}

	@Override
	public void DELETE() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String SELECT() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CatchOverlap() {
		// TODO Auto-generated method stub
		
	}

}
