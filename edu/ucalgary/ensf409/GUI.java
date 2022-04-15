/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main window to create the hampers and orders
 */
public class GUI implements ActionListener {

    public static JFrame frame = new JFrame("Order");
    private static int count = 0;
    private static JLabel numOfHamperLabel;
    private static JButton addButton;
    public static void main(String[] args) {
        frame.getContentPane().setLayout(new FlowLayout());
        GUI buttonListener = new GUI();


        // button to add a new hamper JPanel
        addButton = new JButton("Add Hamper");
        addButton.addActionListener(buttonListener);

        numOfHamperLabel = new JLabel("Number of Hampers: 0");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(numOfHamperLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        frame.getContentPane().add(BorderLayout.NORTH, buttonPanel);
        frame.setVisible(true);
    }

    /**
     * This method responds to actions performed in the GUI, 
     * such as the pressing of buttons.
     * @param e - Pressing button actions
     * 'Add Hamper' button - Part of main 'Order' frame.
     * 'Remove Hamper' button - Part of HamperPanel objects.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // if "+" button is pressed, add hamper JPanel object
        if (e.getSource() == addButton) {
            count++;
            // increment numOfHamperLabel
            numOfHamperLabel.setText("Number of Hampers: " + count);

            // add new Hamper JPanel
            GUIHamperPanel hamperObj = new GUIHamperPanel();
            frame.add(hamperObj.getHamperPanel());
        }
    }

    public static JFrame getMainFrame() {
        return frame;
    }

    public static JLabel getNumOfHamperLabel() {
        return numOfHamperLabel;
    }

    public static int getCount() {
        return count;
    }

    public static void decrementCount() {
        count--;
    }
}