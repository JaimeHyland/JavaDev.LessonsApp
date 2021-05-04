import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
// import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LessonTableGUI {
    JPanel LessonTablePanel;
    JScrollPane LessonTableScrollPane;
    JTable LessonExplorerTable;

    String lessonDriver = "com.mysql.jdbc.Driver";
    String URLString = "jdbc:mysql://localhost:3306/";
    String DBString = "englishexercises";
    Boolean autoReconnect = true;
    Boolean useSSL  = false;
    String userString = "root";
    String passwordString = "Zalewski#1";
    String connectionString = URLString + DBString + "?autoReconnect=" + autoReconnect + "&useSSL="
            + useSSL;


    public static void MakeLessonTableGUI() {
        JFrame Frame = new JFrame("Choose your poison");
        JPanel LessonTablePanel = new JPanel();
        String[] columnNames = {"Title", "Name", "Status", "Fun", "Sweetness", "Light"};
        Object[][] data = {{"Boobie", "doobie","movie", 6, 56, 99},
                {"Groovie", "smile","guttie", 45, 56, 99},
                {"Bestie", "Testie","Clonakilty", 88, 56, 99},
                {"Bestie", "Testie","Clonakilty", 88, 56, 99},
                {"Bestie", "Testie","Clonakilty", 88, 56, 99},
                {"Bestie", "Testie","Clonakilty", 88, 56, 99},
                {"Bestie", "Testie","Clonakilty", 88, 56, 99},
                {"Bestie", "Testie","Clonakilty", 88, 56, 99}};
        JTable LessonExplorerTable = new JTable(data, columnNames);
//        LessonExplorerTable.getColumn(1).setPreferredWidth(60);
        JScrollPane LessonTableScrollPane = new JScrollPane(LessonExplorerTable);

        LessonExplorerTable.setBounds(60, 80, 200, 300);

        Frame.add(LessonTablePanel);
        Frame.add(LessonTableScrollPane);
        Frame.setSize(150, 250);
        Frame.setVisible(true);
        LessonTableScrollPane.setBackground(Color.ORANGE);
        LessonExplorerTable.setSize(200, 300);
//        System.out.println(LessonExplorerTable.getValueAt(0,0));

//        LessonExplorerTable.getColumn(1).setPreferredWidth(60);
//        LessonExplorerTable.getColumn(1).setPreferredWidth(80);
//        LessonExplorerTable.getColumn(2).setPreferredWidth(60);
//        LessonExplorerTable.getColumn(3).setPreferredWidth(15);
//        LessonExplorerTable.getColumn(4).setPreferredWidth(15);
//        LessonExplorerTable.getColumn(5).setPreferredWidth(15);
//        LessonTableScrollPane.setVisible(true);
//        LessonExplorerTable.setVisible((true));

    }

    private void createUIComponents() {

    }

    public ResultSet MakeLessonRS (String lessonDriver,
                          String URLString,
                          String DBString,
                          Boolean autoReconnect,
                          Boolean useSSL,
                          String userString,
                          String passwordString) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String queryString = "Select * from Lesson;";


        connectionString = URLString + DBString + "?autoReconnect=" + autoReconnect + "&useSSL="
                + useSSL;
        try {
            conn = DriverManager.getConnection(connectionString, userString, passwordString);
            stmt = conn.prepareStatement(queryString);
            rs = stmt.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return rs;
    }

    ResultSet LessonRS = MakeLessonRS(lessonDriver, URLString, DBString, autoReconnect, useSSL, userString, passwordString);

}
