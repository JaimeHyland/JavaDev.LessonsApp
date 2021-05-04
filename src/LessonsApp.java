import javax.swing.*;

public class LessonsApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //NavigationGUI NavForm = new NavigationGUI();
                JFrame frame = new JFrame();
                frame.setContentPane(new NavigationGUI().NavigationButtonsPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(200, 300);
                frame.setVisible(true);
            }
        });
    }
}
