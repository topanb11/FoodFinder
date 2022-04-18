/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.4
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
public class GUI implements ActionListener, FocusListener {
    private static int click = 0;
    public static JFrame frame = new JFrame("Order");
    private static int count = 0;
    private static boolean orderValidity = false;
    private static JTextField hamperNumTextField;
    private static JButton submitButton;
    private static JButton genOrderButton;
    private static JPanel hamperContainer;
    private static JPanel buttonPanel = new JPanel();
    private static ArrayList<GUIHamperPanel> hamperPanelArrayList = new ArrayList<>();
    private static GUI focusListener = new GUI();
    private Order order = new Order();

    public static void main(String[] args) {
        GUI buttonListener = new GUI();

        // label for number of hampers
        JLabel numOfHamperLabel = new JLabel("Number of Hampers: ");
        hamperNumTextField = new JTextField("0", 2);
        hamperNumTextField.addFocusListener(focusListener);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(buttonListener);

        // button that generates order
        genOrderButton = new JButton("Generate Order");
        genOrderButton.addActionListener(buttonListener);

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
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,700);
        frame.getContentPane().setLayout(new FlowLayout());

        frame.getContentPane().add(BorderLayout.NORTH, buttonPanel);
        frame.add(scroller);
        frame.setVisible(true);
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
                JOptionPane.showMessageDialog(frame, "Value for number of hampers is invalid.\n(Must be a positive integer)", "Submit Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // make 'Generate Order' button visible
                genOrderButton.setVisible(true);
                // can't edit textField and can't press submit button again once clicked
                submitButton.removeFocusListener(focusListener);
                submitButton.setEnabled(false);
                hamperNumTextField.setEditable(false);
                for (int i = 0; i < count; i++) {
                    Hamper hamper = new Hamper();
                    order.addToOrder(hamper);

                    GUIHamperPanel hamperPanelObj = new GUIHamperPanel(i + 1);
                    hamperContainer.add(hamperPanelObj.getHamperPanel());
                    hamperPanelArrayList.add(hamperPanelObj);
                }
            }
        }
    // logic for when 'Generate Order' button is pressed
        if (e.getSource() == genOrderButton) {
            click++;
            if (order.getHamperItems().isEmpty()) {
                orderValidity = false;
            } else {
                for (Hamper hamper : order.getHamperItems()) {
                    // Hamper hamper = new Hamper();
                    int j = 1;
                    for (GUIClientPanel currentClientPanel : GUIHamperPanel.getClientPanelArrayList()) {
                        if (currentClientPanel.getTextField() > 0) {
                            for (int i = 1; i <= currentClientPanel.getTextField(); i++) {
                                hamper.addClient(j);
                            }
                            orderValidity = true;
                        }
                        j++;
                    }
                }
            }
            if (!orderValidity) {
                click = 0;
                JOptionPane.showMessageDialog(frame, "Ensure that the order is valid\n(i.e. At least one hamper exists, and for every hamper, the values entered are positive integers)", "Order Invalid", JOptionPane.ERROR_MESSAGE);
            } else {
                order.printOrder();
                JOptionPane.showMessageDialog(frame, "Order Created Successfully!", "Success", JOptionPane.PLAIN_MESSAGE);
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
     * @return - JFrame frame, main window object
     */
    public static JFrame getMainFrame() {
        return frame;
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

    /**
     * @return - int count, number of hampers
     */
    public static int getCount() {
        return count;
    }

}