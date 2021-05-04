import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationGUI {
    private JButton CreateLessonButton;
    JPanel NavigationButtonsPanel;
    private JButton EditLessonBtn;

    public NavigationGUI() {
        CreateLessonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {

                        JFrame myFrame = new JFrame("Create a new lesson");
                        myFrame.setContentPane(new CreateLessonGUI().CreateLessonPanel);
                        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        myFrame.pack();
                        myFrame.setSize(400, 500);
                        myFrame.setVisible(true);
                    }
                });
            }
        });
        EditLessonBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {

//                        JFrame myFrame = new JFrame();
                        LessonTableGUI.MakeLessonTableGUI();

//                        myFrame.setContentPane(new LessonTableGUI().LessonTablePanel);
//                        myFrame.add(new LessonTableGUI().getScrollPane());
//                        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                        myFrame.pack();
//                        myFrame.setSize(400, 500);
//                        myFrame.setVisible(true);
//                        createUIComponents();
                    }
                });
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
