/**
 * Created by amanda on 4/28/2016
 * lab 10 GUI Bank Account
 */
import javax.swing.*;
import java.awt.event.*;

public class BankAccountActionListener implements ActionListener{

    private BankAccountPanel panel;
    private BankAccount account;

    public BankAccountActionListener(BankAccountPanel p, BankAccount acct)
    {
        this.panel = p;
        this.account = acct;
    }

    public void actionPerformed(ActionEvent e1)
    {
        try
        {
            Object source = e1.getSource();
            double amount = Double.parseDouble(panel.amountField.getText());
            if (source == panel.depositButton)
                account.deposit(amount);
            else if (source == panel.withdrawButton)
                account.withdraw(amount);
        }
        catch (NumberFormatException e2)
        {
            JOptionPane.showMessageDialog(null,"Input Must be A double");
        }
        finally
        {
            panel.balanceLabel.setText("Balance = " + account.getBalance());
        }
    }
}
