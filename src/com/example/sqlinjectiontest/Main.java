import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Init data input

        System.out.println("Type your ID: ");
        String userId = scanner.nextLine();

        String query = "SELECT * FROM users WHERE id = " + userId; //Query

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password"); //Connection to database
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (Exception e) {
            e.printStackTrace(); //Catch any error
        }
    }
}