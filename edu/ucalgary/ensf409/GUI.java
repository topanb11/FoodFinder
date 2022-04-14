///*
//    Group 2 edu.ucalgary.ensf409.Food Bank
//    Members: Topan Budiman, Maxwell Couture, Mark Ngu, Jason Nguyen
//    version: @1.3
//    since: @1.0
// */
//
//package edu.ucalgary.ensf409;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusListener;
//
///**
// * Main window to create the hampers and orders
// */
//public class GUI implements ActionListener {
//
//    private static JFrame frame = new JFrame("Order");
//    private int count = 0;
//    private static JLabel hamperNumLabel;
//    private static JButton addButton;
//    public static void main(String[] args) {
//        GUI buttonListener = new GUI();
//
//        // button to add a new hamper JPanel
//        addButton = new JButton("Add Hamper");
//        addButton.addActionListener(buttonListener);
//
//        hamperNumLabel = new JLabel("Number of Hampers: 0");
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(addButton);
//        buttonPanel.add(hamperNumLabel);
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600,600);
//
//        frame.getContentPane().add(BorderLayout.NORTH, buttonPanel);
//        frame.setVisible(true);
//    }
//
//    /**
//     * This method responds to actions performed in the GUI,
//     * such as the pressing of buttons.
//     * @param e - Pressing button actions
//     * 'Add Hamper' button - Part of main 'Order' frame.
//     * 'Remove Hamper' button - Part of HamperPanel objects.
//     */
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // if "+" button is pressed, add hamper JPanel object
//        if (e.getSource() == addButton) {
//            count++;
//            hamperNumLabel.setText("Number of Hampers: " + count);
//            HamperPanel hamperObj = new HamperPanel();
//            frame.add(hamperObj.getHamperPanel());
//
//        }
//    }
//}
//
///**
// * HamperPanel class - Extends JPanel
// * Is a JPanel meant to represent a new hamper
// * Contains sub-JPanels containing text boxes for entering number of specific clients
// * Should also have a 'Remove Hamper' button to get rid of the hampers that users do not need.
// */
//class HamperPanel extends JPanel {
//
//    private HamperPanel hamperPanel;
//    private static JPanel adultMale = new JPanel(new FlowLayout(FlowLayout.CENTER));
//    private static JPanel adultFemale = new JPanel(new FlowLayout(FlowLayout.CENTER));
//    private static JPanel childUnder8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//    private static JPanel childOver8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//    private static Dimension panelSize = new Dimension(50,50);
//
//    public HamperPanel() {
//        new GridLayout(4,1);
//        setLayout(new BoxLayout(hamperPanel, BoxLayout.Y_AXIS));
//        setBorder(BorderFactory.createLineBorder(Color.orange));
//        setPreferredSize(new Dimension(100, 50));
//
//        /* Want to be able to use a method (addClientPanel) to create these
//            client 'sub-panels' automatically instead of writing the same block
//            of code 4 times over for each client type.
//
//        adultMale.setPreferredSize(panelSize);
//        JLabel adultMaleLabel = new JLabel("Number of Adult Males: ");
//        JTextField adultMaleNum = new JTextField(2);
//        adultMale.add(adultMaleLabel);
//        adultMale.add(adultMaleNum);
//
//        adultFemale.setPreferredSize(panelSize);
//        JLabel adultFemaleLabel = new JLabel("Number of Adult Females: ");
//        JTextField adultFemaleNum = new JTextField(2);
//        adultFemale.add(adultFemaleLabel);
//        adultFemale.add(adultFemaleNum);
//
//        childUnder8.setPreferredSize(panelSize);
//        JLabel childUnder8Label = new JLabel("Number of Children Under 8: ");
//        JTextField childUnder8Num = new JTextField(2);
//        childUnder8.add(childUnder8Label);
//        childUnder8.add(childUnder8Num);
//
//        childOver8.setPreferredSize(panelSize);
//        JLabel childOver8Label = new JLabel("Number of Children Over 8: ");
//        JTextField childOver8Num = new JTextField(2);
//        childOver8.add(childOver8Label);
//        childOver8.add(childOver8Num);
//        */
//
//        hamperPanel.addClientPanel(adultMale, "Number of Adult Males: ");
//        hamperPanel.addClientPanel(adultFemale, "Number of Adult Females: ");
//        hamperPanel.addClientPanel(childUnder8, "Number of Children Under 8: ");
//        hamperPanel.addClientPanel(childOver8, "Number of Children Over 8: ");
//    }
//
//    /**
//     * This method creates a 'sub-JPanel' that is to be added to the hamperPanel.
//     * Each 'sub-panel' will correspond to each of the client types, containing:
//     *  a JLabel denoting the client type
//     *  a JTextField for users to enter in the number of the specified client type
//     * @param clientType
//     * @param labelName
//     * @return
//     */
//    public JPanel addClientPanel(JPanel clientType, String labelName) {
//        clientType.setPreferredSize(panelSize);
//        JLabel clientLabel = new JLabel(labelName);
//
//        // default text in JTextField is '0'
//        JTextField textField = new JTextField("0");
//
//        /* Want to have a listener so that when users click
//            the text-box, the default text disappears.
//            When users click out of the box without entering anything,
//            default text should
//
//        textField.addFocusListener(new FocusListener() {
//            public void focusGained(FocusEvent e) {
//                textField.setText("");
//            }
//            public void focusLost(FocusEvent e) {
//                //nothing
//            }
//        });
//        */
//
//        clientType.add(clientLabel);
//        clientType.add(textField);
//
//        return
//    }
//
//    public JPanel getHamperPanel() {
//        return this.hamperPanel;
//    }
//}
