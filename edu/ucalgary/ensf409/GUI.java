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

/**
 * Main window to create the hampers and orders
 */
public class GUI implements ActionListener {

    public static JFrame frame = new JFrame("Order");
    private static int count = 0;
    private static JLabel numOfHamperLabel;
    private static JButton addButton;
    private static JButton genOrderButton;
    public static void main(String[] args) {
        frame.getContentPane().setLayout(new FlowLayout());
        GUI buttonListener = new GUI();

        // button to add a new Hamper JPanel object
        addButton = new JButton("Add Hamper");
        addButton.addActionListener(buttonListener);
        // label for number of hampers
        numOfHamperLabel = new JLabel("Number of Hampers: 0");

        // button that generates order
        genOrderButton = new JButton("Generate Order");
        genOrderButton.addActionListener(buttonListener);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        buttonPanel.add(addButton);
        buttonPanel.add(numOfHamperLabel);
        buttonPanel.add(genOrderButton);
        // set genOrderButton to not be visible initially
        genOrderButton.setVisible(false);
        
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
     * 'Generate Order' button - Part of main 'Order' frame.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // logic for when 'Add Hamper' button is pressed
        if (e.getSource() == addButton) {
            // make 'Generate Order' button visible
            genOrderButton.setVisible(true);
            count++;
            // increment numOfHamperLabel
            numOfHamperLabel.setText("Number of Hampers: " + count);

            // add new Hamper JPanel
            GUIHamperPanel hamperObj = new GUIHamperPanel();
            frame.add(hamperObj.getHamperPanel());
        }
    }

    /**
     * @return - JFrame frame, main window object
     */
    public static JFrame getMainFrame() {
        return frame;
    }

    public static JButton getGenOrderButton() {
        return genOrderButton;
    }

    /**
     * @return - JLabel numOfHamperLabel
     */
    public static JLabel getNumOfHamperLabel() {
        return numOfHamperLabel;
    }

    /**
     * Gets the count of hamper so that GUIHamperPanel can adjust
     * when hampers are removed
     * @return - int count
     */
    public static int getCount() {
        return count;
    }

    /**
     * Decrements the number of hampers by 1
     */
    public static void decrementCount() {
        count--;
    }
}