/* File: Shape.java
 * Author: Kevin Abrahams
 * Date: 25-03-2020
 * Purpose: Create a Java GUI application enabling the user to draw shapes based upon entered information.
 */
import java.awt.*;
abstract class Shape extends Rectangle {
    // instance variables of the Shape class (when isSolid is true the shape is solid 
    // and when it is false the shape is hollow)
    private Color color;
    private boolean isSolid;
    // tracks number of shapes created/drawn
    private static int noOfShapes = 0;
    
    // constructor of the shape superclass (initializes instance variables)
    public Shape(Rectangle rectangle, Color color, boolean isSolid) {
        super((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
        this.color = color;
        this.isSolid = isSolid;
        noOfShapes++;
    }
    
    // sets the color for the next draw operation to the color of the shape
    public void setColor(Graphics g) {
        g.setColor(this.color);
    }
    
    // returns fill type of shape (true if solid, false if hollow)
    public boolean getSolid() {
        return isSolid;
    }
    
    // returns total number of shapes created/drawn
    public static int getNoOfShapes() {
        return noOfShapes;
    }
    
    // abstract method which subclasses override/implement
    public abstract void draw(Graphics g);
}

 class Oval extends Shape {
        // subclass Oval's constructor 
        public Oval(Rectangle rectangle, Color color, boolean isSolid) {
            // call superclass's constructor to initialize instance variables inherited from superclass
            super(rectangle, color, isSolid);
        }
        
        // draws the shape
        public void draw(Graphics g) {
            Graphics2D graphics = (Graphics2D)g;
            this.setColor(graphics);
            // if fill type is solid, then call the fill method (else, call the draw method)
            if (getSolid())
                graphics.fillOval((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
            else
                graphics.drawOval((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
        }
    }
    
    class Rectangular extends Shape {
        // subclass Rectangular's constructor
        public Rectangular(Rectangle rectangle, Color color, boolean isSolid) {
            // call superclass's constructor to initialize instance variables inherited from superclass
            super(rectangle, color, isSolid);
        }
        
        // draws the shape
        public void draw(Graphics g) {
            Graphics2D graphics = (Graphics2D)g;
            this.setColor(graphics);
            // if fill type is solid, then call the fill method (else, call the draw method)
            if (getSolid())
                g.fillRect((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
            else
                g.drawRect((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
        }
    }



