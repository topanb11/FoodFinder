/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.7
    since: @1.0
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * HamperPanel class - Extends JPanel
 * Is a JPanel meant to represent a new hamper
 * Contains sub-JPanels containing text boxes for entering number of specific clients
 * Should also have a 'Remove Hamper' button to get rid of the hampers that users do not need.
 */

 /*
 to-do:
    - add functional 'Remove Hamper' button
 */
public class GUIHamperPanel extends Frame implements ActionListener{

    private JPanel hamperPanel = new JPanel();
    private static JButton removeHamperButton;
    private static JLabel hamperNumLabel;

    public GUIHamperPanel() {
        hamperPanel = new JPanel(new BoxLayout(hamperPanel, BoxLayout.X_AXIS));
        hamperPanel.setLayout(new GridLayout(5,1));
        hamperPanel.setBorder(BorderFactory.createLineBorder(Color.orange));

        GUIClientPanel adultMalePanel = new GUIClientPanel("Number of Adult Males: ");
        GUIClientPanel adultFemalePanel = new GUIClientPanel("Number of Adult Females: ");
        GUIClientPanel childOver8Panel = new GUIClientPanel("Number of Children Under 8: ");
        GUIClientPanel childUnder8Panel = new GUIClientPanel("Number of Children Over 8: ");

        removeHamperButton = new JButton("Remove Hamper");
        removeHamperButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeHamperButton);

        hamperPanel.add(adultMalePanel.getClientPanel());
        hamperPanel.add(adultFemalePanel.getClientPanel());
        hamperPanel.add(childOver8Panel.getClientPanel());
        hamperPanel.add(childUnder8Panel.getClientPanel());
        hamperPanel.add(buttonPanel);
    }

    public JPanel getHamperPanel() {
        return this.hamperPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        GUI.decrementCount();
        GUI.getMainFrame().getContentPane().remove(hamperPanel);
        GUI.getNumOfHamperLabel().setText("Number of Hampers: " + GUI.getCount());
        GUI.getMainFrame().revalidate();
        GUI.getMainFrame().repaint();
    }
}

class GUIClientPanel extends JPanel {
    private JPanel clientPanel;
    private static Dimension panelSize = new Dimension(50, 50);

    public GUIClientPanel() {}

    public GUIClientPanel(String labelName) {
        clientPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JLabel clientLabel = new JLabel(labelName);
        JTextField textField = new JTextField(2);
        
        clientPanel.add(clientLabel);
        clientPanel.add(textField);
    }

    public JPanel getClientPanel() {
        return this.clientPanel;
    }
}