package Transactions;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;

public class ReceiptFrame extends JFrame {
    private JTextArea textArea;

    public ReceiptFrame(String receiptText) {
        setTitle("Transaction Receipt");
        setSize(500, 600);
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        String formattedReceipt = formatReceipt(receiptText);

        textArea = new JTextArea(formattedReceipt);
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        textArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton printBtn = new JButton("🖨 Print Receipt");
        printBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        printBtn.addActionListener(e -> {
            try {
                if (textArea.print()) {
                    JOptionPane.showMessageDialog(this, "Receipt printed successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Printing canceled.");
                }
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Printing failed: " + ex.getMessage());
            }
        });

        JButton closeBtn = new JButton("❌ Close");
        closeBtn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        closeBtn.addActionListener(e -> this.dispose());

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnPanel.add(printBtn);
        btnPanel.add(closeBtn);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
    }

   private String formatReceipt(String raw) {
    return "--------------------------------------------\n" +
           "         SUPPLY TRANSACTION RECEIPT\n" +
           "--------------------------------------------\n\n" +
           raw + "\n\n" +
           "--------------------------------------------\n" +
           "This is a system-generated receipt.\n" +
           "For questions, contact the admin office.\n";
}


}
