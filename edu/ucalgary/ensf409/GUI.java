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
public class GUI implements ActionListener {

    public static JFrame frame = new JFrame("Order");
    private static int count = 0;
    private static boolean orderValidity = false;
    private static JLabel numOfHamperLabel;
    private static JButton addButton;
    private static JButton genOrderButton;
    private static JPanel hamperContainer;
    private static ArrayList<GUIHamperPanel> hamperPanelArrayList = new ArrayList<>();
    public static void main(String[] args) {
        GUI buttonListener = new GUI();

        hamperContainer = new JPanel();
        hamperContainer.setLayout(new BoxLayout(hamperContainer, BoxLayout.Y_AXIS));

        JScrollPane scroller = new JScrollPane(hamperContainer);
        scroller.setPreferredSize(new Dimension(600,200));

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
        frame.getContentPane().setLayout(new BorderLayout());
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
        if (e.getSource() == addButton) {
            // make 'Generate Order' button visible
            genOrderButton.setVisible(true);
            // increment numOfHamperLabel
            count++;
            numOfHamperLabel.setText("Number of Hampers: " + count);

            // add new Hamper JPanel
            GUIHamperPanel hamperObj = new GUIHamperPanel(count);
            hamperContainer.add(hamperObj.getHamperPanel());
            hamperPanelArrayList.add(hamperObj);
        }
        if (e.getSource() == genOrderButton) {
            if (hamperPanelArrayList.isEmpty()) {
                orderValidity = false;
            } else {
                Order order = new Order();
                for (GUIHamperPanel currentHamper : hamperPanelArrayList) {
                    Hamper hamper = new Hamper();
                    int j = 1;
                    for (GUIClientPanel currentClientPanel : GUIHamperPanel.getClientPanelArrayList()) {
                        if (currentClientPanel.getTextField() > 0) {
                            for (int i = 1; i <= currentClientPanel.getTextField(); i++) {
                                hamper.addClient(j);
                            }
                        }
                        j++;
                    }
                    order.addToOrder(hamper);
                }
                order.printOrder();
                frame.getContentPane().invalidate();
                frame.getContentPane().validate();
                frame.getContentPane().repaint();
            }
        }
    }

    /**
     * @return - JFrame frame, main window object
     */
    public static JFrame getMainFrame() {
        return frame;
    }

    /**
     *
     * @return - hamperContainer
     */
    public static JPanel getHamperContainer() {
        return hamperContainer;
    }

    public static ArrayList<GUIHamperPanel> getHamperArrayList() {
        return hamperPanelArrayList;
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

    public static void changeHamperID(GUIHamperPanel hamper) {
        hamperPanelArrayList.remove(hamper);
        for (int i = 0; i < hamperPanelArrayList.size(); i++) {
            hamperPanelArrayList.get(i).getHamperID().setText("Hamper #" + (i+1));
        }
    }

    public static void updateHamperCount() {
        numOfHamperLabel.setText("Number of Hampers:" + count);
    }
}