/* File: Drawing.java
 * Author: Kevin Abrahams
 * Date: 25-03-2020
 * Purpose: Create an exception indicating that a shape the user wants to create does not fit inside the drawing canvas.
 */
public class OutsideBounds extends Exception {
    public OutsideBounds(String errorMessage) {
        super(errorMessage);
    }
}
