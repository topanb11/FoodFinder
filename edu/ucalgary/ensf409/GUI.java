/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @7.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Main window to create the hampers and orders
 */
public class GUI extends JFrame implements ActionListener, FocusListener {
    private static GUI mainFrame;
    private static int click = 0;
    private static int count = 0;
    private static boolean orderValidity = false;
    private static JTextField hamperNumTextField;
    private static JButton submitButton;
    private static JButton genOrderButton;
    private static JPanel hamperContainer;
    private static JPanel buttonPanel = new JPanel();
    private static ArrayList<GUIHamperPanel> hamperPanelArrayList = new ArrayList<>();

    private Order order;

    /**
     * main window constructor
     */
    public GUI() {
        order = new Order();
        // label for number of hampers
        JLabel numOfHamperLabel = new JLabel("Number of Hampers: ");
        hamperNumTextField = new JTextField("0", 2);
        hamperNumTextField.addFocusListener(this);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // button that generates order
        genOrderButton = new JButton("Generate Order");
        genOrderButton.addActionListener(this);

        JPanel hamperNumberPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        hamperNumberPanel.add(numOfHamperLabel);
        hamperNumberPanel.add(hamperNumTextField);
        hamperNumberPanel.add(submitButton);

        buttonPanel = new JPanel(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new GridLayout(2,1));
        buttonPanel.add(hamperNumberPanel);
        buttonPanel.add(genOrderButton);

        // Panel consisting of GUIHamperPanels
        hamperContainer = new JPanel();
        hamperContainer.setLayout(new BoxLayout(hamperContainer, BoxLayout.Y_AXIS));
        JScrollPane scroller = new JScrollPane(hamperContainer);
        scroller.setPreferredSize(new Dimension(500,500));

        // set genOrderButton to not be visible initially
        genOrderButton.setVisible(false);

        JFrame frame = new JFrame("Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,700);
        frame.getContentPane().setLayout(new FlowLayout());

        frame.getContentPane().add(BorderLayout.NORTH, buttonPanel);
        frame.add(scroller);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        mainFrame = new GUI();
    }

    /**
     * This method responds to actions performed in the GUI, 
     * such as the pressing of buttons.
     * @param e - Pressing button actions
     * 'Add Hamper' button - Part of main 'Order' frame.
     * 'Generate Order' button - Part of main 'Order' frame.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    // logic for when 'Add Hamper' button is pressed
        if (e.getSource() == submitButton) {
            // add new Hamper JPanel
            count = Integer.parseInt(hamperNumTextField.getText());
            if (count <= 0 || hamperNumTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Value for number of hampers is invalid.\n(Must be a positive integer)", "Submit Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // make 'Generate Order' button visible
                genOrderButton.setVisible(true);
                // can't edit textField and can't press submit button again once clicked
                submitButton.removeFocusListener(this);
                submitButton.setEnabled(false);
                hamperNumTextField.setEditable(false);
                for (int i = 0; i < count; i++) {
                    GUIHamperPanel hamperPanelObj = new GUIHamperPanel(i + 1);
                    hamperContainer.add(hamperPanelObj.getHamperPanel());
                    hamperPanelArrayList.add(hamperPanelObj);
                }
            }
        }
    // logic for when 'Generate Order' button is pressed
        if (e.getSource() == genOrderButton) {
            click++;
            if (hamperPanelArrayList.isEmpty()) {
                orderValidity = false;
            } else {
                for (GUIHamperPanel hamperPanel : hamperPanelArrayList) {
                    Hamper hamper = new Hamper();
                    if (hamperPanel.getAdultMaleCount() <= 0 &&
                            hamperPanel.getAdultFemaleCount() <= 0 &&
                            hamperPanel.getChildOver8Count() <= 0 &&
                            hamperPanel.getChildUnder8Count() <= 0) {
                        orderValidity = false;
                        break;
                    }
                    order.addToOrder(hamper);
                    if (hamperPanel.getAdultMaleCount() > 0) {
                        orderValidity = true;
                        for (int i = 1; i <= hamperPanel.getAdultMaleCount(); i++) {
                            hamper.addClient(1);
                        }
                    }
                    hamperPanel.getAdultMaleTextField().setText("0");
                    if (hamperPanel.getAdultFemaleCount() > 0) {
                        orderValidity = true;
                        for (int i = 1; i <= hamperPanel.getAdultFemaleCount(); i++) {
                            hamper.addClient(2);
                        }
                    }
                    hamperPanel.getAdultFemaleTextField().setText("0");
                    if (hamperPanel.getChildOver8Count() > 0) {
                        orderValidity = true;
                        for (int i = 1; i <= hamperPanel.getChildOver8Count(); i++) {
                            hamper.addClient(3);
                        }
                    }
                    hamperPanel.getChildOver8TextField().setText("0");
                    if (hamperPanel.getChildUnder8Count() > 0) {
                        orderValidity = true;
                        for (int i = 1; i <= hamperPanel.getChildUnder8Count(); i++) {
                            hamper.addClient(4);
                        }
                    }
                    hamperPanel.getChildUnder8TextField().setText("0");
                }
            }
            if (!orderValidity) {
                click = 0;
                order.getHamperItems().clear();
                hamperPanelArrayList.clear();
                JOptionPane.showMessageDialog(mainFrame, "Ensure that the order is valid\n(i.e. At least one hamper exists, and for every hamper, the values entered are positive integers)", "Order Invalid", JOptionPane.ERROR_MESSAGE);
                mainFrame.dispose();
                GUI newFrame = new GUI();
            } else {
                try {
                    order.printOrder();
                    order.getHamperItems().clear();
                    hamperPanelArrayList.clear();
                    JOptionPane.showMessageDialog(mainFrame, "Order Created Successfully!", "Success", JOptionPane.PLAIN_MESSAGE);
                    mainFrame.dispose();
                    GUI newFrame = new GUI();
                } catch (NullPointerException b) {
                    JOptionPane.showMessageDialog(mainFrame, "There is an insufficient amount of food in the current inventory ", "cock", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * textField set to blank when focused
     * @param e the event to be processed
     */
    @Override
    public void focusGained(FocusEvent e) { hamperNumTextField.setText(""); }

    /**
     * textField set to "0" if user doesn't change text before losing focus
     * otherwise nothing
     * @param e the event to be processed
     */
    @Override
    public void focusLost(FocusEvent e) {
        if (hamperNumTextField.getText().isEmpty()) {
            hamperNumTextField.setText("0");
        } else {
            //nothing
        }
    }

    /**
     * @return - return int click
     */
    public static int getClick() {
        return click;
    }

    /**
     * @return - boolean orderValidity
     */
    public static boolean getOrderValidity() {
        return orderValidity;
    }

    /**
     * @return - JPanel hamperContainer, panel consisting of GUIHamperPanels
     */
    public static JPanel getHamperContainer() {
        return hamperContainer;
    }

    /**
     * @return - ArrayList<GUIHamperPanel> hamperPanelArrayList
     */
    public static ArrayList<GUIHamperPanel> getHamperArrayList() {
        return hamperPanelArrayList;
    }


}