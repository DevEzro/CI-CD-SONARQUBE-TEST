import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Init data input

        System.out.println("Type your ID: ");
        String userId = scanner.nextLine();

        String query = "SELECT * FROM users WHERE id = ?"; //Query

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password"); //Connection to database
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace(); //Catch any error
        }
    }
}