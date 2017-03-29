
public class SQLConveter {
	tableUtil tableUtil = new tableUtil();
	public void domainDiscriminate(String domain, String attName, int cnt) throws WritingSQLException {
		switch (domain.toUpperCase()) {
		case "TEXT":
			tableUtil.Set_TEXT(attName, cnt);
			break;
		case "INTEGER":
			tableUtil.Set_INTEGER(attName, cnt);
			break;
			default: throw new WritingSQLException();
		}
	}
}
