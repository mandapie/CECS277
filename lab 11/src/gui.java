/**
 * Created by amanda on 5/1/2016.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class gui extends JFrame {

    // Declare check boxes
    private JCheckBox jchkCentered = new JCheckBox();
    private JCheckBox jchkBold  = new JCheckBox();
    private JCheckBox jchkItalic  = new JCheckBox();
    private JComboBox jcboFontName = new JComboBox(); // Declare a combo box to hold font names,
    private JComboBox jcboFontSize = new JComboBox(); // Declare a combo box to hold font sizes
    private String fontName = "SansSerif";  // Font name
    private int fontStyle = Font.PLAIN;     // Font style
    private int fontSize = 12;               // Font size
    private MessagePanel messagePanel = new MessagePanel("Java is Cool"); // Declare a panel for displaying message

    /** Main method */
    public static void main(String[] args) {
        gui frame = new gui();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    /** Default constructor */
    public gui() {
        setTitle("Message Center");
        messagePanel.setBackground(Color.yellow); // Set the background color of messagePanel
        // Find all available font names
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontnames = e.getAvailableFontFamilyNames();
        for(int i=0; i<fontnames.length; i++) {
            jcboFontName.addItem(fontnames[i]); // Add fonts to the combo box
        }
        jcboFontName.setSelectedItem(fontName); //set default font to SanSerif
        for(int i=8; i < 73; i++) {
            jcboFontSize.addItem(i); // Add font sizes to the combo box
        }
        jcboFontSize.setSelectedItem(fontSize); //set default font size to 12
        // Design the gui layout using Panel containers
        JPanel panelfont = new JPanel(new BorderLayout(10,10));
        panelfont.add(new JLabel("Font Name"), BorderLayout.WEST);
        panelfont.add(jcboFontName,BorderLayout.CENTER);
        JPanel panelsize = new JPanel(new BorderLayout(10,10));
        panelsize.add(new JLabel("Font Size"), BorderLayout.WEST);
        panelsize.add(jcboFontSize,BorderLayout.CENTER);
        JPanel panelborder = new JPanel(new BorderLayout(10,10));
        panelborder.setBorder(new EmptyBorder(10,10,10,10));
        panelborder.add(panelfont, BorderLayout.CENTER);
        panelborder.add(panelsize, BorderLayout.EAST);
        JPanel panelfontstyle = new JPanel();
        panelfontstyle.add(jchkBold = new JCheckBox("Bold"));
        panelfontstyle.add(jchkCentered = new JCheckBox("Centered"));
        panelfontstyle.add(jchkItalic = new JCheckBox("Italics"));
        setLayout(new BorderLayout());
        add(messagePanel, BorderLayout.CENTER);
        add(panelborder, BorderLayout.NORTH);
        add(panelfontstyle, BorderLayout.SOUTH);
        // Register listeners on the combo box with an event class
        jcboFontName.addItemListener(new Listener());
        jcboFontSize.addItemListener(new Listener());
        // Register listeners on jchkCentered, jchkBold, and jchkItalic
        jchkCentered.addItemListener(new Listener());
        jchkBold.addItemListener(new Listener());
        jchkItalic.addItemListener(new Listener());
    }

    //Create the class Listener that implements ItemListener
    class Listener implements ItemListener {
        /**
         * Handle check box selection
         */
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == jcboFontName) {
                fontName = (String) (jcboFontName.getSelectedItem());
                messagePanel.setFont(new Font(fontName, fontStyle, fontSize)); // Set font for the message
            } else if (e.getSource() == jcboFontSize) {
                fontSize = (int)jcboFontSize.getSelectedItem();
                messagePanel.setFont(new Font(fontName, fontStyle, fontSize));  // Set font for the message (Font.ITALIC, Font.BOLD, or FONT.PLAIN)
            } else if ((e.getSource() == jchkBold) || (e.getSource() == jchkItalic) || (e.getSource() == jchkCentered)) {
                fontStyle = Font.PLAIN;
                if (jchkBold.isSelected())
                    fontStyle = fontStyle + Font.BOLD;
                if (jchkItalic.isSelected())
                    fontStyle = fontStyle + Font.ITALIC;
                if (jchkCentered.isSelected())
                    messagePanel.setCentered(true);
                messagePanel.setFont(new Font(fontName, fontStyle, fontSize)); // Set font for the message
            } else {
                messagePanel.setCentered(false);
                messagePanel.setXCoordinate(20);
                messagePanel.setYCoordinate(20);
            }
        }
    }
}