/*
    Group 2 edu.ucalgary.ensf409.Food Bank
    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
    version: @1.3
    since: @1.0
 */

package edu.ucalgary.ensf409;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private int count = 0;
    private static JLabel hamperNumLabel;
    private static JButton removeButton;
    private static JButton addButton;
    public static void main(String[] args) {
        JFrame frame = new JFrame("cock");
        GUI buttonListener = new GUI();

        removeButton = new JButton("-");
        addButton = new JButton("+");

        removeButton.addActionListener(buttonListener);
        addButton.addActionListener(buttonListener);

        hamperNumLabel = new JLabel("Number of Hampers: 0");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeButton);
        buttonPanel.add(addButton);
        buttonPanel.add(hamperNumLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,100);

        frame.getContentPane().add(BorderLayout.NORTH, buttonPanel);
        frame.setVisible(true);
    }

    /**
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // if "+" button is pressed
        if (e.getSource() == addButton) {
            count++;
            hamperNumLabel.setText("Number of Hampers: " + count);
        }
        // if "-" button is pressed
        if (e.getSource() == removeButton) {
            if (count == 0) {
                hamperNumLabel.setText("Number of Hampers: 0");
            } else {
                count--;
                hamperNumLabel.setText("Number of Hampers: " + count);
            }
        }
    }
}
