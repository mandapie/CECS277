/**
 * Created by amanda on 4/28/2016.
 * lab 10 GUI Bank Account
 */

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class BankAccountPanel extends JPanel implements ActionListener {

    BankAccount account;
    public JTextField amountField;
    public JLabel amountLabel, balanceLabel;
    public JButton withdrawButton, depositButton;

    public BankAccountPanel(BankAccount accnt) {


        System.out.println("Implementation:\n" +
                "1. From panel itself\n" +
                "2. from separate class\n" +
                "3. from inner class\n" +
                "4. from anonymous class\n" +
                "0. Exit");
        Scanner in = new Scanner(System.in);

        account = accnt;

        amountLabel = new JLabel("Amount: ");
        this.add(amountLabel);

        amountField = new JTextField(10);
        this.add(amountField);

        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        //boolean done = true;


        switch (in.nextInt()) {
            //From Panel
            case 1:
                withdrawButton.addActionListener(this);
                depositButton.addActionListener(this);
                break;
            //From Separate class
            case 2:
                ActionListener separateClass = new BankAccountActionListener(this, account);
                withdrawButton.addActionListener(separateClass);
                depositButton.addActionListener(separateClass);
                break;
            //From Inner class
            case 3:
                depositButton.addActionListener(new AmountListener());
                withdrawButton.addActionListener(new AmountListener());
                break;

            case 4:
                /**
                 * Anonymous
                 */
                withdrawButton.addActionListener(new ActionListener() {
                                                     @Override
                                                     public void actionPerformed(ActionEvent e) {
                                                         account.withdraw(Double.parseDouble(amountField.getText()));
                                                         balanceLabel.setText("Balance = " + account.getBalance());
                                                     }
                                                 }
                );

                /**
                 * Anonymous
                 */
                depositButton.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        account.deposit(Double.parseDouble(amountField.getText()));
                                                        balanceLabel.setText("Balance = " + account.getBalance());
                                                    }
                                                }
                );
                break;
        }

        balanceLabel = new JLabel("Balance = " + account.getBalance());

        this.add(withdrawButton);
        this.add(depositButton);
        this.add(balanceLabel);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            double amt = Double.parseDouble(amountField.getText());
            if (source == depositButton)
                account.deposit(amt);
            else if (source == withdrawButton)
                account.withdraw(amt);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Input Must be A double");
        } finally {
            balanceLabel.setText("Balance = " + account.getBalance());
        }
    }

    /**
     * Inner Class
     */
    class AmountListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == depositButton)
                account.deposit(Double.parseDouble(amountField.getText()));
            if (source == withdrawButton)
                account.withdraw(Double.parseDouble(amountField.getText()));
            balanceLabel.setText("Balance = " + account.getBalance());
        }
    }
}
