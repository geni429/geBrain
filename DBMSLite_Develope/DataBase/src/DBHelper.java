import java.util.regex.Pattern;

public class DBHelper {
	tableUtil tableUtil = new tableUtil();
	SQLConveter SQLC = new SQLConveter();
	String DBName;
	String getTableName;
	String getQuery;
	int ColumnNum = 1;
	int i = 0;

	public DBHelper(String DBName) {
		this.DBName = DBName;
	}

	public void execSQL(String sql) throws WritingSQLException {
		this.getQuery = sql;
		if (getQuery.toUpperCase().contains("CREATE TABLE")) {
			createTable(getQuery.substring(12).trim()); // create table
			getQuery = null;
		} else if (getQuery.toUpperCase().contains("INSERT INTO")) {
			insertData(getQuery.toUpperCase().substring(11).trim()); // insert data
			getQuery = null;
		} else {
			throw new WritingSQLException(1);
		}
	}

	public void createTable(String tableAttributes) throws WritingSQLException {
		if (tableAttributes.length() == 0 || Pattern.matches("\\)$", tableAttributes)) {
			throw new WritingSQLException(2);
		} else {
			for (char c : tableAttributes.trim().toCharArray()) {
				if (c == ' ' || c == '(') {
					break;
				} else {
					this.i++;
				}
			}
			this.getTableName = tableAttributes.trim().substring(0, i);
			// Set
			// table
			// name
			String Instance = tableAttributes.substring(i).trim();
			for (char c : Instance.toCharArray()) {
				if (c == ',') {
					ColumnNum++;
				}
			}
			this.i = 0;
			tableUtil.Set_TABLE(ColumnNum);
			if (Pattern.matches("\\(((((\\w|\\s)*)(\\(?([0-9][0-9]?)*\\)?))\\,*\\s?){" + ColumnNum + "}\\)",
					Instance)) {
				Instance = Instance.replaceAll("^\\(|\\)$", "");
				String[] divColumn = Instance.split(",");
				for (int i = 0; i < ColumnNum; i++) {
					String[] domain = divColumn[i].trim().split(" ");
					SQLC.domainDiscriminate(domain[0], domain[1], i);
				}
			}
		}
	} // create table method end(2017.3.18.09:51)

	public void insertData(String insDataInfo) throws WritingSQLException {
		if (getTableName == null)
			throw new WritingSQLException(3);
		for (char c : insDataInfo.toCharArray()) {
			if (c == ' ' || c == 'v' || c == 'V') {
				break;
			} else {
				this.i++;
			}
		}
		System.out.println(insDataInfo);
		if (getTableName.toUpperCase().equals(insDataInfo.substring(0, i))) {
			System.out.println(insDataInfo.substring(i).trim());
			String insValue = insDataInfo.substring(i).trim().replaceAll("\\s", "");
			if (Pattern.matches("(VALUE)(\\s|\\()", insValue)) {
				System.out.println("success");
			}
		} else {
			throw new WritingSQLException(3);
		}
	}
}
