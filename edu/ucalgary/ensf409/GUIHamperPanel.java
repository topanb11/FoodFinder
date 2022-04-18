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

public class GUIHamperPanel extends Frame implements FocusListener{

    private JLabel hamperID;
    private JPanel hamperPanel = new JPanel();

    public JTextField getAdultMaleTextField() {
        return adultMaleTextField;
    }

    public JTextField getAdultFemaleTextField() {
        return adultFemaleTextField;
    }

    public JTextField getChildOver8TextField() {
        return childOver8TextField;
    }

    public JTextField getChildUnder8TextField() {
        return childUnder8TextField;
    }

    private JTextField adultMaleTextField;
    private JTextField adultFemaleTextField;
    private JTextField childOver8TextField;
    private JTextField childUnder8TextField;

    // Constructor
    public GUIHamperPanel(int hamperCount) {
        // formatting
        hamperPanel = new JPanel(new BoxLayout(hamperPanel, BoxLayout.Y_AXIS));
        hamperPanel.setLayout(new GridLayout(5,1));
        hamperPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // hamper ID number
        hamperID = new JLabel("Hamper #" + hamperCount);

        // creating a GUIClientPanel for each client type
        JPanel adultMalePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel adultMaleLabel = new JLabel("Number of Adult Males: ");
        adultMaleTextField = new JTextField("0", 2);
        adultMaleTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                adultMaleTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (adultMaleTextField.getText().isEmpty()) {
                    adultMaleTextField.setText("0");
                }
            }
        });
        adultMalePanel.add(adultMaleLabel);
        adultMalePanel.add(adultMaleTextField);

        JPanel adultFemalePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel adultFemaleLabel = new JLabel("Number of Adult Females: ");
        adultFemaleTextField = new JTextField("0", 2);
        adultFemaleTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                adultFemaleTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (adultFemaleTextField.getText().isEmpty()) {
                    adultFemaleTextField.setText("0");
                }
            }
        });
        adultFemalePanel.add(adultFemaleLabel);
        adultFemalePanel.add(adultFemaleTextField);

        JPanel childOver8Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel childOver8Label = new JLabel("Number of Children Over 8: ");
        childOver8TextField = new JTextField("0", 2);
        childOver8TextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                childOver8TextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (childOver8TextField.getText().isEmpty()) {
                    childOver8TextField.setText("0");
                }
            }
        });
        childOver8Panel.add(childOver8Label);
        childOver8Panel.add(childOver8TextField);

        JPanel childUnder8Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel childUnder8Label = new JLabel("Number of Children Under 8: ");
        childUnder8TextField = new JTextField("0", 2);
        childUnder8TextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                childUnder8TextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (childUnder8TextField.getText().isEmpty()) {
                    childUnder8TextField.setText("0");
                }
            }
        });
        childUnder8Panel.add(childUnder8Label);
        childUnder8Panel.add(childUnder8TextField);

        // add all the components to main Hamper Panel
        hamperPanel.add(BorderLayout.NORTH, hamperID);
        hamperPanel.add(adultMalePanel);
        hamperPanel.add(adultFemalePanel);
        hamperPanel.add(childOver8Panel);
        hamperPanel.add(childUnder8Panel);

    }
    /**
     * @param e the event to be processed
     */
    @Override
    public void focusGained(FocusEvent e) {

    }
    /**
     * @param e the event to be processed
     */
    @Override
    public void focusLost(FocusEvent e) {

    }

    /**
     * @return - JPanel hamperPanel
     */
    public JPanel getHamperPanel() {
        return this.hamperPanel;
    }

    public int getAdultMaleCount() {
        return Integer.parseInt(adultMaleTextField.getText());
    }
    public int getAdultFemaleCount() {
        return Integer.parseInt(adultFemaleTextField.getText());
    }
    public int getChildOver8Count() {
        return Integer.parseInt(childOver8TextField.getText());
    }
    public int getChildUnder8Count() {
        return Integer.parseInt(childUnder8TextField.getText());
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