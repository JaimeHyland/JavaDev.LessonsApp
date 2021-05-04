import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CreateLessonGUI {
    String lessonQuery;
    JPanel CreateLessonPanel;
    private JTextArea LessonIntroTextArea;
    private JButton CreateLessonButton;
    private JButton CreateNewExercise;
    private JCheckBox ForLiveUseCheckBox;
    private JTextField LevelTxt;
    private JLabel LevelLbl;
    private JTextField TitleText;
    private JLabel TitleLbl;
    private JComboBox LanguageCombo;
    private JComboBox LevelCombo;
    private JLabel LangLbl;
    private JTextField SubchapterTxt;
    private JLabel SubchapterLbl;
    private JTextField SubtitleTxt;
    private JLabel SubtitleLbl;
    private JTextField HeadingTxt;
    private JLabel HeadingLbl;
    private JTextField TopicTxt;
    private JLabel TopicLbl;
    private JTextField QuoteTxt;
    private JLabel QuoteLbl;
    private JTextField QuoteAuthorTxt;
    private JLabel QuoteAuthorLbl;
    private JButton CreateNewExampleBtn;
    private JButton SaveLessonToDBBtn;


    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String DB = "englishexercises";
    private Boolean autoreconnect = true;
    private Boolean useSSL = false;
    private String user = "root";
    private String password = "Zalewski#1";

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString() {
        this.connectionString = url + DB + "?autoReconnect=" + autoreconnect + "&useSSL=" + useSSL;
    }

    private String connectionString;
    private String leadingQueryString = "Select * from ";
    private String trailingQueryString = ";";

    public void setSqlQueryForLangCombo(String lookupTable) {
        this.sqlQueryForLangCombo = this.leadingQueryString + lookupTable + this.trailingQueryString;
    }

    public void setSqlQueryForLevelCombo(String lookupTable) {
        this.sqlQueryForLevelCombo = this.leadingQueryString + lookupTable + this.trailingQueryString;
    }

    private String sqlQueryForLangCombo;
    private String sqlQueryForLevelCombo;

    public CreateLessonGUI() {
        setConnectionString();
        setSqlQueryForLangCombo("langname");
        setSqlQueryForLevelCombo("CEFRLevel");

        try {
            ArrayList<ArrayList<String>> LanguageOptions = ComboPopulator.getListForCombo(connectionString, user, password, sqlQueryForLangCombo);

            for (int i = 0; i < LanguageOptions.size(); i++) {
                String temp = LanguageOptions.get(i).get(0);
                if (LanguageOptions.get(i).get(0).equals("0")) {
                    LanguageCombo.addItem(LanguageOptions.get(i).get(1) + " --- "+ LanguageOptions.get(i).get(2));
                }
            }
        } catch (Exception f) {
            System.out.println(f);
        }

        try {
            ArrayList<ArrayList<String>> LevelOptions = ComboPopulator.getListForCombo(connectionString, user, password, sqlQueryForLevelCombo);
            for (int i = 0; i < LevelOptions.size(); i++) {
                LevelCombo.addItem(LevelOptions.get(i).get(0));
            }

        } catch (Exception f) {
            System.out.println(f);
        }

        SaveLessonToDBBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lessonQuery = "insert into lesson " + "values (Default, " +
                        LanguageCombo.getSelectedIndex() + ", \"" +
                        LevelCombo.getSelectedItem() + "\", \"" +
                        TitleText.getText() + "\", \"" +
                        SubchapterTxt.getText() + "\", \"" +
                        SubtitleTxt.getText() + "\", \"" +
                        HeadingTxt.getText() + "\", \"" +
                        TopicTxt.getText() + "\", \"" +
                        LessonIntroTextArea.getText() + "\", \"" +
                        QuoteTxt.getText() + "\", \"" +
                        QuoteAuthorTxt.getText() + "\", " +
                        ForLiveUseCheckBox.isSelected() + ");";

                DBLessonInserter();
            }
        });
    }

    public String getDriver () {
        return this.driver;
    }

    public void setDriver (String driver){
        this.driver = driver;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url){
        this.url = url;
    }

    public String getDB () {
        return DB;
    }

    public void setDB (String DB){
        this.DB = DB;
    }

    public void setAutoreconnect (Boolean autoreconnect){
        this.autoreconnect = autoreconnect;
    }

    public Boolean getAutoreconnect () {
        return autoreconnect;
    }

    public Boolean getUseSSL () {
        return useSSL;
    }

    public void setUseSSL (Boolean useSSL){
        this.useSSL = useSSL;
    }

    public String getUser () {
        return user;
    }

    public void setUser (String user){
        this.user = user;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password){
        this.password = password;
    }

    public void DBLessonInserter() {
        try {
            Connection conn = DriverManager.getConnection(connectionString, user, password);
            PreparedStatement stmt = conn.prepareStatement(lessonQuery);
            int rs = stmt.executeUpdate();

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }


}

