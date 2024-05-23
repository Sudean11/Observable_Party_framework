package com.miu.framework.bank.ui;

import javax.swing.*;
import java.awt.*;


public class JDialog_TransactionHistory extends JDialog {

    public JDialog_TransactionHistory(Frame parent, String transactionHistory) {
        super(parent, "Transaction History", true);
        JTextArea textArea = new JTextArea();

        textArea.setText(transactionHistory);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        add(scrollPane);

        setSize(450, 350);
        setLocationRelativeTo(parent);
    }
}
