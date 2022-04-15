/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.7
    since: @1.0
 */
package edu.ucalgary.ensf409;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GUIHamperPanel class - Extends Frame, Implements ActionListener
 * Is a JPanel meant to represent a new hamper
 * Contains sub-JPanels containing text boxes for entering number of specific clients
 * Contains 'Remove Hamper' button to get rid of the hampers that users do not need.
 */

public class GUIHamperPanel extends Frame implements ActionListener{

    private JPanel hamperPanel = new JPanel();
    private static JButton removeHamperButton;

    // Constructor
    public GUIHamperPanel() {
        // formatting 
        hamperPanel = new JPanel(new BoxLayout(hamperPanel, BoxLayout.Y_AXIS));
        hamperPanel.setLayout(new GridLayout(5,1));
        hamperPanel.setBorder(BorderFactory.createLineBorder(Color.orange));

        // creating a GUIClientPanel for each client type
        GUIClientPanel adultMalePanel = new GUIClientPanel("Number of Adult Males: ");
        GUIClientPanel adultFemalePanel = new GUIClientPanel("Number of Adult Females: ");
        GUIClientPanel childOver8Panel = new GUIClientPanel("Number of Children Under 8: ");
        GUIClientPanel childUnder8Panel = new GUIClientPanel("Number of Children Over 8: ");

        // creating a 'Remove Hamper' JButton
        removeHamperButton = new JButton("Remove Hamper");
        removeHamperButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeHamperButton);

        // add all the sub-panels to main Hamper Panel
        hamperPanel.add(adultMalePanel.getClientPanel());
        hamperPanel.add(adultFemalePanel.getClientPanel());
        hamperPanel.add(childOver8Panel.getClientPanel());
        hamperPanel.add(childUnder8Panel.getClientPanel());
        hamperPanel.add(buttonPanel);
    }

    public JPanel getHamperPanel() {
        return this.hamperPanel;
    }
    
    /**
     * This method responds to actions performed in the GUI, such 
     * as the pressing of buttons.
     * @param e - Pressing button actions
     * 'Remove Hamper' button - part of GUIHamperPanel JPanel object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    // logic for when 'Remove Hamper' button is pressed
        // decrement current number of hampers - retrieved from GUI.java
        GUI.decrementCount();
        // removes the hamper
        GUI.getMainFrame().getContentPane().remove(hamperPanel);
        // sets numOfHamperLabel from GUI.java to new decremented value
        GUI.getNumOfHamperLabel().setText("Number of Hampers: " + GUI.getCount());
        // mandatory revalidation of main window
        GUI.getMainFrame().revalidate();
        GUI.getMainFrame().repaint();
    }
}

/**
 * GUIClientPanel class - Extends JPanel
 * Is a JPanel representing each client type
 * Each client type will have:
 *      - a JLabel denoting which client type it is
 *      - a JTextField for users to enter in the number of the client type
 */
class GUIClientPanel extends JPanel {
    private JPanel clientPanel;
    
    /**
     * Constructor for GUIClientPanel
     *   - Has FlowLayout as default formatting
     *   - JLabel clientLabel to identify client type
     *   - JTextField textField for users to enter in number of client type
     * @param labelName - Set clientLabel to this String argument
     */
    public GUIClientPanel(String labelName) {
        clientPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JLabel clientLabel = new JLabel(labelName);
        JTextField textField = new JTextField(1);
        
        clientPanel.add(clientLabel);
        clientPanel.add(textField);
    }

    /**
     * @return JPanel clientPanel
     */
    public JPanel getClientPanel() {
        return this.clientPanel;
    }
}