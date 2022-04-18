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
 * Contains a hamperID that changes dynamically when removing and adding hampers
 * Contains sub-JPanels containing text boxes for entering number of specific clients
 * Contains 'Remove Hamper' button to get rid of the hampers that users do not need.
 */

public class GUIHamperPanel extends Frame {

    private JLabel hamperID;
    private JPanel hamperPanel = new JPanel();
    private static ArrayList<GUIClientPanel> clientPanelArrayList;

    // Constructor
    public GUIHamperPanel(int hamperCount) {
        // formatting
        hamperPanel = new JPanel(new BoxLayout(hamperPanel, BoxLayout.Y_AXIS));
        hamperPanel.setLayout(new GridLayout(7,1));
        hamperPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // hamper ID number
        hamperID = new JLabel("Hamper #" + hamperCount);

        // creating a GUIClientPanel for each client type
        GUIClientPanel adultMalePanel = new GUIClientPanel("Number of Adult Males: ");
        GUIClientPanel adultFemalePanel = new GUIClientPanel("Number of Adult Females: ");
        GUIClientPanel childOver8Panel = new GUIClientPanel("Number of Children Over 8: ");
        GUIClientPanel childUnder8Panel = new GUIClientPanel("Number of Children Under 8: ");

        // ArrayList of GUIClientPanels
        clientPanelArrayList = new ArrayList<>();
        clientPanelArrayList.add(adultMalePanel);
        clientPanelArrayList.add(adultFemalePanel);
        clientPanelArrayList.add(childOver8Panel);
        clientPanelArrayList.add(childUnder8Panel);

        // add all the components to main Hamper Panel
        hamperPanel.add(hamperID);
        hamperPanel.add(adultMalePanel.getClientPanel());
        hamperPanel.add(adultFemalePanel.getClientPanel());
        hamperPanel.add(childOver8Panel.getClientPanel());
        hamperPanel.add(childUnder8Panel.getClientPanel());
    }

    /**
     * @return - JPanel hamperPanel
     */
    public JPanel getHamperPanel() {
        return this.hamperPanel;
    }

    /**
     * @return - ArrayList<GUIClientPanel> clientPanelArrayList
     */
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
class GUIClientPanel extends JPanel implements FocusListener{
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
        // textField has default text of "0"
        textField = new JTextField("0",2);
        // focus listener for when users click on JTextField
        textField.addFocusListener(new FocusListener() {
            // textField set to blank when focused
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }
            // if textField isn't changed before losing focus setText to "0"
            // otherwise nothing
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("0");
                } else {
                    // nothing
                }
            }
        });
        clientPanel.add(clientLabel);
        clientPanel.add(textField);
    }

    /**
     * @return User input into client textField
     */
    public int getTextField() {
        return Integer.parseInt(textField.getText());
    }

    /**
     * @return JPanel clientPanel
     */
    public JPanel getClientPanel() {
        return this.clientPanel;
    }

    /**
     * textField set to blank when focused
     */
    @Override
    public void focusGained(FocusEvent e) {
        textField.setText("");
    }

    /**
     * if textField isn't changed before losing focus setText to "0"
     * otherwise nothing
     */
    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().isEmpty()) {
            textField.setText("0");
        } else {
            // nothing
        }
    }
}