import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBLessonInserter {

    public DBLessonInserter(String connectionString, String userString, String passwordString, String sqlQuery) {

        try {
//            System.out.println(sqlQuery);
            Connection conn = DriverManager.getConnection(connectionString, userString, passwordString);
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            stmt.execute();

//                ResultSet rs = stmt.executeQuery()
        }
        catch (Exception e) {
            System.out.println("What a database mess! " + e);
        }
    }
}



