/* File: Drawing.java
 * Author: Kevin Abrahams
 * Date: 25-03-2020
 * Purpose: Create a drawing canvas for the shapes the user dynamically creates.
 */
import java.awt.*;
import javax.swing.*;

public class Drawing extends JPanel {
    // instance variable representing the shape created by user that shall be drawn
    private Shape shape;
    
    // overrides the JPanel's paintComponent method (indirectly called via the drawShape() method)
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // displaying total number of shapes created/draw
        g.drawString(""+shape.getNoOfShapes(), 10, 30);
        
        // determining the kind of shape object to make the appropriate method call
        if (shape instanceof Oval)
            // finalizes the drawing process for the shape (last step)
            ((Oval)shape).draw(g);
        else if (shape instanceof Rectangular)
            // finalizes the drawing process for the shape (last step)
            ((Rectangular)shape).draw(g);
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
    
    // initiates the process to draw the shapes
    // first this method is called, then the repaint() method calls the paintComponent() method
    // which then leads to the draw method being called from one of the Shape classes
    public void drawShape(Shape shape) throws OutsideBounds {
        // determining if shape user wants to draw shall fit inside the drawing canvas 
        // (if not, throw an exception)
        if (shape.getWidth() > 200 || shape.getHeight() > 200 || shape.getWidth() + shape.getX() > 196 || shape.getHeight() + shape.getY() > 196 || shape.getX() < 3 || shape.getY() < 9)
            throw new OutsideBounds("ERROR: The shape you are trying to draw does not lie within the drawing canvas.");
        this.shape = shape;
        // resets/refreshes the canvas to enable the next shape to be drawn
        repaint();
        
    }
}
