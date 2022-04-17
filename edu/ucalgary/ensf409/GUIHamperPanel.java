/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.7
    since: @1.0
 */
package edu.ucalgary.ensf409;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * GUIHamperPanel class - Extends Frame, Implements ActionListener
 * Is a JPanel meant to represent a new hamper
 * Contains sub-JPanels containing text boxes for entering number of specific clients
 * Contains 'Remove Hamper' button to get rid of the hampers that users do not need.
 */

 /**
  * to do: 
        - add hamperID that changes with every new hamper
  */
public class GUIHamperPanel extends Frame implements ActionListener{

    private JLabel hamperID;
    private JPanel hamperPanel = new JPanel();
    private static JButton removeHamperButton;
    private static GUIClientPanel adultMalePanel;
    private static GUIClientPanel adultFemalePanel;
    private static GUIClientPanel childOver8Panel;
    private static GUIClientPanel childUnder8Panel;
    private static GUIClientPanel quantityOfHamperPanel;
    private static ArrayList<GUIClientPanel> clientPanelArrayList = new ArrayList<>();

    // Constructor
    public GUIHamperPanel(int hamperCount) {
        // formatting 
        hamperPanel = new JPanel(new BoxLayout(hamperPanel, BoxLayout.Y_AXIS));
        hamperPanel.setLayout(new GridLayout(7,1));
        hamperPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // hamper ID number
        hamperID = new JLabel("Hamper #" + hamperCount);

        // creating a GUIClientPanel for each client type
        adultMalePanel = new GUIClientPanel("Number of Adult Males: ");
        adultFemalePanel = new GUIClientPanel("Number of Adult Females: ");
        childOver8Panel = new GUIClientPanel("Number of Children Under 8: ");
        childUnder8Panel = new GUIClientPanel("Number of Children Over 8: ");

        clientPanelArrayList.add(adultMalePanel);
        clientPanelArrayList.add(adultFemalePanel);
        clientPanelArrayList.add(childOver8Panel);
        clientPanelArrayList.add(childUnder8Panel);
        
        // creating a 'Remove Hamper' JButton
        removeHamperButton = new JButton("Remove Hamper");
        removeHamperButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeHamperButton);

        // add all the components to main Hamper Panel
        hamperPanel.add(hamperID);
        hamperPanel.add(adultMalePanel.getClientPanel());
        hamperPanel.add(adultFemalePanel.getClientPanel());
        hamperPanel.add(childOver8Panel.getClientPanel());
        hamperPanel.add(childUnder8Panel.getClientPanel());
        hamperPanel.add(buttonPanel);
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
        GUI.getHamperContainer().remove(hamperPanel);
        GUI.decrementCount();
        GUI.updateHamperCount();
        GUI.changeHamperID(this);
        GUI.getHamperArrayList().remove(this);
        GUI.getHamperContainer().revalidate();
        GUI.getHamperContainer().repaint();
    }

    public JPanel getHamperPanel() {
        return this.hamperPanel;
    }

    public JLabel getHamperID() {
        return hamperID;
    }

    public GUIClientPanel getAdultMalePanel() {
        return adultMalePanel;
    }

    public GUIClientPanel getAdultFemalePanel() {
        return adultFemalePanel;
    }

    public GUIClientPanel getChildOver8Panel() {
        return childOver8Panel;
    }
    
    public GUIClientPanel getChildUnder8Panel() {
        return childUnder8Panel;
    }

    public static ArrayList<GUIClientPanel> getClientPanelArrayList() {
        return clientPanelArrayList;
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
    private JTextField textField;
    
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
        textField = new JTextField(2);
        
        clientPanel.add(clientLabel);
        clientPanel.add(textField);
    }

    /**
     * @return User input into client textField
     */
    public int getTextField() {
        return Integer.valueOf(textField.getText());
    }

    /**
     * @return JPanel clientPanel
     */
    public JPanel getClientPanel() {
        return this.clientPanel;
    }
}