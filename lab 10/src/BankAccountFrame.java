/**
 * Created by amanda on 4/28/2016.
 * lab 10 GUI Bank Account
 */
import javax.swing.*;
import java.awt.*;

public class BankAccountFrame extends JFrame {

    public BankAccountFrame(BankAccount account)
    {
        setSize(400, 100);
        centerWindow(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new BankAccountPanel(account);
        this.add(panel);
    }
    private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
}
