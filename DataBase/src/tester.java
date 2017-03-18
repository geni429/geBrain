import java.util.Scanner;

public class tester {
	static Scanner scan = new Scanner(System.in);
	private static DBHelper dbHelper = new DBHelper("testDB");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test_SQL;
		test_SQL = scan.nextLine();
		tester test = new tester();
		test.create(test_SQL);
		test_SQL = scan.nextLine();
		test.insert(test_SQL);
	}
	
	public void create(String test_SQL){
		try {
			dbHelper.execSQL(test_SQL);
		} catch (WritingSQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(String test_SQL){
		try {
			dbHelper.execSQL(test_SQL);
		} catch (WritingSQLException e) {
			e.printStackTrace();
		}
	}
}
