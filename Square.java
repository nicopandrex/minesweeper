/**
 * Nico Lippiatt-Cook  
 * CS2100A  
 * Sami Connelly  
 * class for a square in the Minesweeper grid. Stores position, color, and uncover/flag state.
 */


import java.awt.*;

public abstract class Square {

private int row = 0;
private int col = 0;
private boolean uncovered;
private boolean flagged;
private Color backgroundColor;
private Color coveredColor;
private Color borderColor;
private Color flagColor;

/**
 * Constructor for a square.
 * @param col the column index
 * @param row the row index
 */
public Square(int col, int row){
   this.col = col;
   this.row = row;
   uncovered = false;
   flagged = false;
   coveredColor = Color.GREEN;
   borderColor = Color.WHITE;
   flagColor = Color.RED;

}

/**
 * @return row index of the square
 */
public int getRow(){
   return row;

}
/**
 * @return column index of the square
 */
public int getColumn(){
   return col;

}
/**
 * @return true if the square is flagged
 */
public boolean isFlagged(){
   return flagged;

}
/**
 * @return true if the square is uncovered
 */
public boolean isUncovered(){
   return uncovered;

}
/**
 * @return the background color (for uncovered state)
 */
public Color getBackgroundColor() {
    return backgroundColor;
}
/**
 * Sets the background color (for uncovered state)
 * @param backgroundColor the color to set
 */
public void setBackgroundColor(Color backgroundColor) {
    this.backgroundColor = backgroundColor;
}
/**
 * @return the covered color (used before uncovering)
 */
public Color getCoveredColor() {
    return coveredColor;
}
/**
 * Sets the color used for covered squares.
 * @param coveredColor the color to set
 */
public void setCoveredColor(Color coveredColor) {
    this.coveredColor = coveredColor;
}
/**
 * @return border color of the square
 */
public Color getBorderColor() {
    return borderColor;
}
/**
 * Sets the border color.
 * @param borderColor the color to set
 */
public void setBorderColor(Color borderColor) {
    this.borderColor = borderColor;
}
/**
 * @return flag color
  */
public Color getFlagColor() {
    return flagColor;
}
/**
 * Sets the color used for flagging.
 * @param flagColor the color to set
 */
public void setFlagColor(Color flagColor) {
    this.flagColor = flagColor;
}

/**
 * Toggles the flagged status of the square.
 */
public void toggleFlag(){
   this.flagged = !flagged;

}
/**
 * Marks the square as uncovered (if not flagged).
 */
public void uncover(){
   if (flagged != true){
      this.uncovered = true;
   
   }

}
/**
 * Abstract method: returns number of neighbors (or -1 if mine).
 * @return number of neighboring mines or -1
 */
abstract int getNeighbors();
/**
 * Abstract method: returns true if this is a mine.
 * @return true if mine, false otherwise
 */
abstract boolean isMine();
/**
 * Abstract method: draws the square on screen.
 * @param g2 graphics context
 * @param size square size in pixels
 * @param leftMargin horizontal  offset
 * @param topMargin vertical offset
 */
abstract void draw(Graphics2D g2, int size, int leftMargin, int topMargin);



}