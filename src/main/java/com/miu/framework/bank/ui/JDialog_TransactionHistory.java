package com.miu.framework.bank.ui;

import com.miu.framework.bank.entities.Transaction;

import javax.swing.*;
import java.awt.*;

import java.util.List;

public class JDialog_TransactionHistory extends JDialog {

    public JDialog_TransactionHistory(Frame parent, List<Transaction> transactions) {
        super(parent, "Transaction History", true);
        JTextArea textArea = new JTextArea();
        StringBuilder transactionHistory = new StringBuilder();
        for (Transaction transaction : transactions) {
            transactionHistory.append(transaction.toString()).append("\n");
        }
        textArea.setText(transactionHistory.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        add(scrollPane);

        setSize(450, 350);
        setLocationRelativeTo(parent);
    }
}
