/* File: Project3.java
 * Author: Kevin Abrahams
 * Date: 25-03-2020
 * Purpose: Create a Java GUI application enabling the user to draw shapes based upon entered information.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;


public class Project3 extends JFrame {
    // Below are the components in the java gui
    private JComboBox shapeComboBox;
    private JComboBox fillComboBox;
    private JComboBox colorComboBox;
    private JLabel shapeLabel;
    private JLabel fillLabel;
    private JLabel colorLabel;
    private JLabel widthLabel;
    private JLabel heightLabel;
    private JLabel xLabel;
    private JLabel yLabel;
    private JTextField widthTextField;
    private JTextField heightTextField;
    private JTextField xTextField;
    private JTextField yTextField;
    private JButton btnDraw = new JButton("Draw");
    
    private Drawing drawingPanel = new Drawing();
    
    public Project3() {
        // Arrays representing options for each of the three JComboBoxes
        String[] shapeOptions = {"Rectangle", "Oval"};
        String[] fillOptions = {"Hollow", "Solid"};
        String[] colorOptions = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta"};

        // initializing the components in the java gui
        shapeComboBox = new JComboBox (shapeOptions);
        fillComboBox = new JComboBox (fillOptions);
        colorComboBox = new JComboBox (colorOptions);
        shapeLabel = new JLabel ("Shape Type");
        fillLabel = new JLabel ("Fill Type");
        colorLabel = new JLabel ("Color");
        widthLabel = new JLabel ("Width");
        heightLabel = new JLabel ("Height");
        xLabel = new JLabel ("x coordinate");
        yLabel = new JLabel ("y coordinate");
        widthTextField = new JTextField (5);
        heightTextField = new JTextField (5);
        xTextField = new JTextField (5);
        yTextField = new JTextField (5);

        
        setPreferredSize (new Dimension (600, 600));
        setLayout (null);

        // adding the components to the JFrame (or contentpane)
        add (shapeComboBox);
        add (fillComboBox);
        add (colorComboBox);
        add (shapeLabel);
        add (fillLabel);
        add (colorLabel);
        add (widthLabel);
        add (heightLabel);
        add (xLabel);
        add (yLabel);
        add (widthTextField);
        add (heightTextField);
        add (xTextField);
        add (yTextField);
        add (btnDraw);
        add (drawingPanel);
        
        // I used the setBounds method to decide upon the location and size of each component
        //setBounds(int x_position, int y_position, int width, int height)
        
        // First column in the java gui 
        // (each label has the same x coordinate, 40, so that they are aligned)
        // each label in this first column is separated by 30 pixels 
        //(the y coordinate increases by 30 for every new label)
        shapeLabel.setBounds (40, 40, 100, 25);
        fillLabel.setBounds (40, 70, 100, 25);
        colorLabel.setBounds (40, 100, 100, 25);
        widthLabel.setBounds (40, 130, 100, 25);
        heightLabel.setBounds (40, 160, 100, 25);
        xLabel.setBounds (40, 190, 100, 25);
        yLabel.setBounds (40, 220, 100, 25);
        
        // Second column in the java gui
        // (each component has the same x coordinate, 150, so that they are aligned)
        // each component is separated by 30 pixels (increase the y coordinate by 30 for each new component)
        shapeComboBox.setBounds (150, 40, 100, 25);
        fillComboBox.setBounds (150, 70, 100, 25);
        colorComboBox.setBounds (150, 100, 100, 25);
        widthTextField.setBounds (150, 130, 100, 25);
        heightTextField.setBounds (150, 160, 100, 25);
        xTextField.setBounds (150, 190, 100, 25);
        yTextField.setBounds (150, 220, 100, 25);
        
        // setting the location and size of the draw button and drawing panel
        // the draw button is placed beneath and in the approximate middle of all the other components 
        btnDraw.setBounds (210, 260, 100, 25);
        
        // the drawing panel is placed to the right of the first two columns 
        drawingPanel.setBounds (265, 35, 200, 200);
        
        // creating titled border for the drawing panel
        drawingPanel.setBorder(BorderFactory.createTitledBorder("Shape Drawing"));
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        // adding action listener to the draw button
        btnDraw.addActionListener(new DrawListener());
    }
    
    public static void main(String[] args) {
        Project3 frame = new Project3();
    }
    
    class DrawListener implements ActionListener {
        // creating appropriate shape object based upon information 
        // entered by the user from the various fields
        public void actionPerformed(ActionEvent e) {
            // shape variable contains each shape created from the user's entered information
            Shape shape;
            
            Color shapeColor = Color.BLACK;
            // these booleans indicate whether good values have been entered in each textfield requiring only integers
            boolean goodWidth, goodHeight, goodX, goodY;
            boolean solidFill = true;
            goodWidth = goodHeight = goodX = goodY = true;
            int width, height, x, y;
            width = height = x = y = 0;
            
            for (int i = 0; i < widthTextField.getText().length(); i++) {
                // error displayed if width textfield contains a character that isn't a digit/number
                if (!Character.isDigit(widthTextField.getText().charAt(i))){
                    // error message
                    JOptionPane.showMessageDialog(getContentPane(), "In the width text field, please only enter numbers - no letters, words, or any other kinds of symbols.");
                    // change value of boolean to false to signify shape object can't be created
                    goodWidth = false;
                }
            }
            
            for (int i = 0; i < heightTextField.getText().length(); i++) {
                // error displayed if height textfield contains a character that isn't a digit/number
                if (!Character.isDigit(heightTextField.getText().charAt(i))) {
                    // error message
                    JOptionPane.showMessageDialog(getContentPane(), "In the height text field, please only enter numbers - no letters, words, or any other kinds of symbols.");
                    // change value of boolean to false to signify shape object can't be created
                    goodHeight = false;
                }
            }
            
            for (int i = 0; i < xTextField.getText().length(); i++) {
                // error displayed if height textfield contains a character that isn't a digit/number
                if (!Character.isDigit(xTextField.getText().charAt(i))) {
                    // error message
                    JOptionPane.showMessageDialog(getContentPane(), "In the x coordinate text field, please only enter numbers - no letters, words, or any other kinds of symbols.");
                    // change value of boolean to false to signify shape object can't be created
                    goodX = false;
                }
            }
            
            for (int i = 0; i < yTextField.getText().length(); i++) {
                // error displayed if height textfield contains a character that isn't a digit/number
                if (!Character.isDigit(yTextField.getText().charAt(i))) {
                    // error message
                    JOptionPane.showMessageDialog(getContentPane(), "In the y coordinate text field, please only enter numbers - no letters, words, or any other kinds of symbols.");
                    // change value of boolean to false to signify shape object can't be created
                    goodY = false;
                }
            }
            // if valid data entered in each textfield, the values can be stored in their respective variables
            if (goodWidth)
                width = Integer.parseInt(widthTextField.getText());
            if (goodHeight)
                height = Integer.parseInt(heightTextField.getText());
            if (goodX)
                x = Integer.parseInt(xTextField.getText());
            if (goodY)
                y = Integer.parseInt(yTextField.getText());
            
            // color selected by user from the color JComboBox
            String selectedColor = colorComboBox.getSelectedItem().toString();
            
            // check to see which color user selected from the color JComboBox
            if (selectedColor.equals("Black"))
                shapeColor = Color.BLACK;
            else if (selectedColor.equals("Red"))
                shapeColor = Color.RED;
            else if (selectedColor.equals("Orange"))
                shapeColor = Color.ORANGE;
            else if (selectedColor.equals("Yellow"))
                shapeColor = Color.YELLOW;
            else if (selectedColor.equals("Green"))
                shapeColor = Color.GREEN;
            else if (selectedColor.equals("Blue"))
                shapeColor = Color.BLUE;
            else if (selectedColor.equals("Magenta"))
                shapeColor = Color.MAGENTA;
            
            // fill type (hollow/solid) user selected from the fill JComboBox
            String selectedFill = fillComboBox.getSelectedItem().toString();
            
            // check to see which fill type user selected from the fill JComboBox
            if (selectedFill.equals("Hollow"))
                solidFill = false;
            else
                solidFill = true;
            
            // if valid values entered for each textfield, create new shape object using this information
            if (goodWidth && goodHeight && goodX && goodY) {
                // create either a rectangular or oval shape based on item selected by user in the shape type JComboBox
                if (shapeComboBox.getSelectedItem().toString().equals("Rectangle"))
                    shape = new Rectangular(new Rectangle(x, y, width, height), shapeColor, solidFill);
                else
                    shape = new Oval(new Rectangle(x, y, width, height), shapeColor, solidFill);
                // attempt to draw shape (an custom exception is thrown to indicate shape doesn't fit inside drawning panel)
                try {
                    drawingPanel.drawShape(shape);
                } catch (OutsideBounds ex) {
                    JOptionPane.showMessageDialog(getContentPane(), "ERROR: The shape you tried to draw is does not lie within the drawing canvas.");
                }
            }
                
        }
    }
}
