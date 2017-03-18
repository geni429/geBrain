import java.util.regex.Pattern;

public class DBHelper {
	tableUtil tableUtil = new tableUtil();
	String DBName;
	String getTableName;
	String getQuery;
	int i = 0;

	public DBHelper(String DBName) {
		this.DBName = DBName;
	}

	public void execSQL(String sql) throws WritingSQLException{
		this.getQuery = sql;
		if (getQuery.toUpperCase().contains("CREATE TABLE")) {
			createTable(getQuery.substring(12)); // create table
			getQuery = null;
		} else if (getQuery.toUpperCase().contains("INSERT INTO")) {
			insertData(getQuery.toUpperCase().substring(11));	// insert data
			getQuery = null;
		} else {
			throw new WritingSQLException(1);
		}
	}

	public void createTable(String tableAttributes) throws WritingSQLException{
		if (tableAttributes.length() == 0) {
			throw new WritingSQLException(2);
		} else {
			for (char c : tableAttributes.trim().toCharArray()) {
				if (c == ' ' || c == '(') {
					this.i = 0;
					break;
				} else {
					this.i++;
				}
			}
			this.getTableName = tableAttributes.trim().substring(0, i);
			// Set
			// table
			// name
			System.out.println("DBHelper/createTable/getTableName : " + getTableName);
			String Instance = tableAttributes.substring(i + 1).trim();
			System.out.println("DBHelper/createTable/Instance : " + Instance);
			int ColumnNum = 1;
			for (char c : Instance.toCharArray()) {
				if (c == ',') {
					ColumnNum++;
				}
			}
			if (Pattern.matches("\\(((((\\w|\\s)*)(\\(?([0-9][0-9]?)*\\)?))\\,*\\s?){" + ColumnNum + "}\\)",
					Instance)) {
				Instance = Instance.replaceAll("^\\(|\\)$", "");
				String[] divColumn = Instance.split(",");
				for (int i = 0; i < ColumnNum; i++) {
					tableUtil.New_TABLE(ColumnNum);
					String[] domain = divColumn[i].trim().split(" ");
					if (domain[0].toUpperCase().equals("TEXT")) {
						tableUtil.Set_TEXT(domain[1], i);
					} else if (domain[0].toUpperCase().equals("INTEGER")) {
						tableUtil.Set_INTEGER(domain[1], i);
					} else {
						System.out.println("Error");
					}
				}
			}
		}
	} // create table method end(2017.3.18.09:51)

	public void insertData(String insDataInfo) throws WritingSQLException {
		if(getTableName == null) throw new WritingSQLException(3);
		System.out.println(insDataInfo);
		for(char c : insDataInfo.trim().toCharArray()){
			if(c == ' ' || c == 'v' || c == 'V'){
				break;
			} else {
				this.i++;
			}
		}
		if(getTableName.equals(insDataInfo.trim().substring(0, i))){
			System.out.println(insDataInfo.trim().substring(0, i));
		}  else {
			throw new WritingSQLException(3);
		}
	}
}
