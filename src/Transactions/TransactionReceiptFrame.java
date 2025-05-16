package Transactions;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;

public class TransactionReceiptFrame extends JFrame {
    private JTextArea textArea;

    public TransactionReceiptFrame(String receiptText) {
        setTitle("Transaction Receipt");
        setSize(500, 500);
        setLocationRelativeTo(null); // Center window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea(receiptText);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton printBtn = new JButton("Print");
        printBtn.addActionListener(e -> {
            try {
                if (textArea.print()) {
                    JOptionPane.showMessageDialog(this, "Receipt printed successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Printing was canceled.");
                }
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Printing failed: " + ex.getMessage());
            }
        });

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> this.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(printBtn);
        buttonPanel.add(closeBtn);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
