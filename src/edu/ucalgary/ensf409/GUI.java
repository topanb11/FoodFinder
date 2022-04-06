package edu.ucalgary.ensf409;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("cock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        GUI buttonListener = new GUI();
        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("weiner");
        button.addActionListener(buttonListener);
        buttonPanel.add(button);

        frame.getContentPane().add(BorderLayout.NORTH, buttonPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "COCKK AND BALLS");
    }
}
