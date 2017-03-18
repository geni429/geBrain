public class tableUtil {
	public int tableCount = 0;
	public int instanceCount = 0;
	static Object[][][] TABLE;

	public void New_TABLE(int ColumnNum) {
		TABLE = new Object[tableCount + 1][ColumnNum][];
	}

	public void Set_TEXT(String TEXT_domain, int cnt) {
		TABLE[tableCount][cnt] = new String[instanceCount + 1];
		TABLE[tableCount][cnt][instanceCount] = TEXT_domain;
		System.out.println(TABLE[tableCount][cnt][instanceCount]);
	}

	public void Set_INTEGER(String INTEGER_domain, int cnt) {
		TABLE[tableCount][cnt] = new String[instanceCount + 1];
		TABLE[tableCount][cnt][instanceCount] = INTEGER_domain;
		System.out.println(TABLE[tableCount][cnt][instanceCount]);
	}
}
