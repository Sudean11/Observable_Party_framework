package com.miu.framework.main;

import com.miu.framework.bank.ui.BankFrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppLauncher extends JFrame implements ActionListener {

    public AppLauncher() {
        super("Application Launcher");

        // Create buttons
        JButton bankingButton = new JButton("Banking Application");
        JButton creditCardButton = new JButton("Credit Card App");

        // Add buttons to frame
        add(bankingButton);
        add(creditCardButton);

        // Set layout (optional, can be customized)
        setLayout(new FlowLayout());

        // Register action listener for buttons
        bankingButton.addActionListener(this);
        creditCardButton.addActionListener(this);

        // Set frame properties
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks based on the source
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            String buttonText = clickedButton.getText();
            System.out.println(buttonText);
            BankFrm bankFrm = new BankFrm();
            bankFrm.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AppLauncher();
    }
}