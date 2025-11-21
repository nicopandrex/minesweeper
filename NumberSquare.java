/**
 * Nico Lippiatt-Cook
 * CS2100A
 * Sami Connelly
 * Creates the NumberSquare, a non mine square that shows the number of neighboring mines.
 */


import java.awt.*;

public class NumberSquare extends Square{
   private int neighbors;
   private Color numberColor;
 /**
* Constructor for NumberSquare.
* @param neighbors the number of neighbors
* @param row the row index of the mine
* @param col the column index of the mine
 */
   public NumberSquare(int neighbors, int row, int col){
      super(col, row);
      this.neighbors = neighbors;
      this.numberColor = Color.BLUE;
      super.setBackgroundColor(Color.LIGHT_GRAY);
   
   }
   /**
   @return the number of neighbors
   
   */
   @Override
   public int getNeighbors(){
      return neighbors;
   
   
   }
   /**
   @return true if square is mine, false otherwise
   
   */
   @Override
   public boolean isMine(){
      return false;
   
   }
   
   /**
* Draws the number square with color and neighbor logic.
* @param g2 the graphics 
* @param size the size of the square
* @param leftMargin left margin offset
* @param topMargin top margin offset
*/
   
  @Override
public void draw(Graphics2D g2, int size, int leftMargin, int topMargin) {
    int x = (super.getColumn() * size) + leftMargin;
    int y = (super.getRow() * size) + topMargin;
    int borderWidth = size / 20;

    //  draw border first
    g2.setColor(super.getBorderColor());
    g2.fillRect(x, y, size, size);

    if (!super.isUncovered()) {
        // Covered square
        g2.setColor(super.getCoveredColor());
        g2.fillRect(x + borderWidth, y + borderWidth, size - 2 * borderWidth, size - 2 * borderWidth);

        if (super.isFlagged()) {
            g2.setColor(super.getFlagColor());
            g2.fillRect(x + size / 3, y + size / 3, size / 3, size / 3);
        }
    } else {
        // Uncovered square
        g2.setColor(super.getBackgroundColor()); 
        g2.fillRect(x + borderWidth, y + borderWidth, size - 2 * borderWidth, size - 2 * borderWidth);

        if (neighbors > 0) {
            if (neighbors == 1) {
       g2.setColor(Color.BLUE);
   } else if (neighbors == 2) {
       g2.setColor(Color.GREEN);
   } else if (neighbors == 3) {
       g2.setColor(Color.RED);
   } else if (neighbors == 4) {
       g2.setColor(new Color(128, 0, 128)); // purple
   } else if (neighbors == 5) {
       g2.setColor(new Color(128, 0, 0)); // maroon
   } else {
       g2.setColor(Color.BLACK); // 6+
      }
            g2.setFont(new Font("Serif", Font.BOLD, size / 2));
            g2.drawString(String.valueOf(neighbors), x + size / 3, y + (2 * size / 3));

        }
    }
}



}