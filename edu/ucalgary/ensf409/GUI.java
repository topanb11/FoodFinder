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

/**
 * Main window to create the hampers and orders
 */
public class GUI implements ActionListener {

    private static JFrame frame = new JFrame("cock");
    private int count = 0;
    private static JLabel hamperNumLabel;
    private static JButton removeButton;
    private static JButton addButton;
    public static void main(String[] args) {
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
            HamperPanel hamperObj = new HamperPanel();
            frame.add(hamperObj.getHamperPanel());
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

class HamperPanel extends Frame {

    private JPanel hamperPanel;
    private static JPanel adultMale = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private static JPanel adultFemale = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private static JPanel childUnder8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private static JPanel chlidOver8 = new JPanel(new FlowLayout(FlowLayout.CENTER));

    public HamperPanel() {
        hamperPanel = new JPanel(new BoxLayout(hamperPanel, BoxLayout.X_AXIS));
        hamperPanel.setLayout(new GridLayout(5,1));

        JLabel adultMaleLabel = new JLabel("Number of Adult Males: ");
        JTextField adultMaleNum = new JTextField(2);
        adultMale.add(adultMaleLabel);
        adultMale.add(adultMaleNum);

        JLabel adultFemaleLabel = new JLabel("Number of Adult Females: ");
        JTextField adultFemaleNum = new JTextField(2);
        adultFemale.add(adultFemaleLabel);
        adultFemale.add(adultFemaleNum);

        JLabel childUnder8Label = new JLabel("Number of Children Under 8: ");
        JTextField childUnder8Num = new JTextField(2);
        childUnder8.add(childUnder8Label);
        childUnder8.add(childUnder8Num);

        JLabel childOver8Label = new JLabel("Number of Children Over 8: ");
        JTextField childOver8Num = new JTextField(2);
        chlidOver8.add(childOver8Label);
        chlidOver8.add(childOver8Num);

        hamperPanel.add(adultMale);
        hamperPanel.add(adultFemale);
        hamperPanel.add(childUnder8);
        hamperPanel.add(chlidOver8);
    }

    public JPanel getHamperPanel() {
        return this.hamperPanel;
    }
}
