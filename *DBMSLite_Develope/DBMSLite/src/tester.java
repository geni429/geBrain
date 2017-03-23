import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBHelper DBH = new DBHelper();
		Scanner scan = new Scanner(System.in);
		String testSQL = scan.nextLine();
		try {
			DBH.execSQL(testSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
