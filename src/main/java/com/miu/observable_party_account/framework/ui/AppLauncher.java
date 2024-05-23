package com.miu.observable_party_account.framework.ui;

import com.miu.observable_party_account.bank.ui.BankFrm;
import com.miu.observable_party_account.framework.command.BankingButtonCommand;
import com.miu.observable_party_account.framework.command.Command;
import com.miu.observable_party_account.framework.command.CreditCardButtonCommand;
import com.miu.observable_party_account.creditCard.ui.CardFrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AppLauncher extends JFrame implements ActionListener {
    private Map<String, Command> commandMap;

    public AppLauncher() {
        super("Application Launcher");

        // Initialize command map
        commandMap = new HashMap<>();

        // Initialize commands
        BankingButtonCommand bankingButtonCommand = new BankingButtonCommand(new BankFrm());
        CreditCardButtonCommand creditCardButtonCommand = new CreditCardButtonCommand(new CardFrm());

        // Map commands to button labels
        commandMap.put("Banking Application", bankingButtonCommand);
        commandMap.put("Credit Card Application", creditCardButtonCommand);

        // Create buttons
        JButton bankingButton = new JButton("Banking Application");
        JButton creditCardButton = new JButton("Credit Card Application");

        // Set button properties for better look
        Dimension buttonSize = new Dimension(250, 60); // Larger button size
        bankingButton.setPreferredSize(buttonSize);
        creditCardButton.setPreferredSize(buttonSize);

        // Add buttons to panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 20, 20)); // Increased vertical and horizontal gaps
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Increased padding around panel
        buttonPanel.add(bankingButton);
        buttonPanel.add(creditCardButton);

        // Add panel to frame
        add(buttonPanel, BorderLayout.CENTER);

        // Register action listener for buttons
        bankingButton.addActionListener(this);
        creditCardButton.addActionListener(this);

        // Set frame properties
        setSize(600, 400); // Larger frame size
        setResizable(false); // Disable resizing to maintain layout integrity
        setLocationRelativeTo(null); // Center the window on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks based on the source
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            String buttonText = clickedButton.getText();
            System.out.println(buttonText);
            Command command = commandMap.get(buttonText);
            if (command != null) {
                command.execute();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppLauncher::new);
    }
}
