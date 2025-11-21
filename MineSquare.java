/**
 * Nico Lippiatt-Cook
 * CS2100A
 * Sami Connelly
 * Represents a mine square in Minesweeper. Red when uncovered.
 */


import java.awt.*;

public class MineSquare extends Square {
 /**
     * Constructor for MineSquare. Sets background to red.
     * @param row the row index of the mine
     * @param col the column index of the mine
     */
public MineSquare(int row, int col){
   
   super(col,row);
   super.setBackgroundColor(Color.RED);
   
   
   
   
   }
/**
* Returns -1 to indicate a mine.
* @return always -1
*/
@Override

public int getNeighbors(){
   return -1;


}
/**
* Returns true since this square is a mine.
* @return true
*/

@Override 
public boolean isMine(){
   return true;

}

/**
* Draws the mine square with color and flag logic.
* @param g2 the graphics 
* @param size the size of the square
* @param leftMargin left margin offset
* @param topMargin top margin offset
*/
@Override
public void draw(Graphics2D g2, int size, int leftMargin, int topMargin){

   int x = (super.getColumn() * size) + leftMargin;
   int y = (super.getRow() * size) + topMargin;
   int borderWidth = size/20;
   g2.setColor(super.getBorderColor());
   g2.fillRect(x,y,size,size);
   
   if (super.isUncovered()){
      g2.setColor(super.getBackgroundColor());
      g2.fillRect(x+borderWidth,y+borderWidth,size-2*borderWidth,size-2*borderWidth);
      
      if(super.isFlagged()){
      g2.setColor(super.getFlagColor());
      g2.fillRect(x+size/3,y+size/3,size/3,size/3);
   }
      }
   
   else{
   g2.setColor(super.getCoveredColor());
   g2.fillRect(x+borderWidth,y+borderWidth,size-2*borderWidth,size-2*borderWidth);
   if (super.isFlagged()) {
            g2.setColor(super.getFlagColor());
            g2.fillRect(x + size / 3, y + size / 3, size / 3, size / 3);
        }
   
   }
   
   }

}