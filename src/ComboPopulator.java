import java.sql.*;
import java.util.ArrayList;

public class ComboPopulator {


    public static ArrayList<ArrayList<String>> getListForCombo (String connectionString, String userString,
                                                                String passwordString, String sqlQuery) {

        ArrayList<ArrayList<String>> options = new ArrayList<>(0);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(connectionString, userString, passwordString);
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            ResultSetMetaData resultSetMD = rs.getMetaData();
            int columnCount = resultSetMD.getColumnCount();


            while (rs.next()) {
                ArrayList<String> optionsLine = new ArrayList<>(0);
                for (int i = 1; i <= columnCount; i++) {
                    optionsLine.add(rs.getString(i));
                }
                options.add(optionsLine);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return options;
    }
}

