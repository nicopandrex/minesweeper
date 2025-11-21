/**
 * Nico Lippiatt-Cook
 * CS2100A
 * Sami Connelly
 * Manages the Minesweeper game grid, places mines, win loss etc.
 */



import java.awt.*;
import java.util.Random;

public class Grid {

private Square[][] grid;
private int width;
private int height;
private int numMines;
private int topMargin;
private int leftMargin;
private int squareSize;
private int numFlaggedSquares;
private boolean mineUncovered;

/**
 * Constructs the grid and populates it with squares and mines.
 * @param height number of rows
 * @param width number of columns
 * @param numMines number of mines to place
 * @param topMargin  offset from top
 * @param leftMargin  offset from left
 */
public Grid(int height, int width, int numMines, int topMargin, int leftMargin){
   this.squareSize = 30; // fixed square size
   this.numFlaggedSquares = 0;
   this.mineUncovered = false;
   this.height = height;
   this.width = width;
   this.numMines = numMines;
   this.topMargin = topMargin;
   this.leftMargin = leftMargin;


   grid = new Square[height][width]; 
   createGrid(); // fill grid w/ mines and numbers
   
}
/**
 * Flags or unflags a square if it's not uncovered.
 * @param r row index
 * @param c column index
 */
private void flag(int r, int c){
   Square sq = grid[r][c];

   if(sq.isUncovered() == false){ // only toggle if covered
      sq.toggleFlag();
      if(sq.isFlagged()) {
         numFlaggedSquares++; // add to count
      }
      else{
         numFlaggedSquares--; // remove from count
      }
   }
}
/**
 * Uncovers the square at (r, c). If it has 0 neighbors, recurses on adjacent squares.
 * @param r row index
 * @param c column index
 * @return -1 if mine, 0 if uncovered or flagged, else number of neighbors
 */
private int uncoverSquare(int r, int c){
   Square sq = grid[r][c];

   if (sq.isFlagged() || sq.isUncovered()){ 
      return 0; 
   } // skip if flagged or already open

   sq.uncover(); // uncover it
   int neighbors = sq.getNeighbors();

   if (sq.isMine()){
      

      // reveal entire grid
      for(int i = 0; i < height; i++){
         for(int j = 0; j < width; j++){
            Square current = grid[i][j];
            if (current.isFlagged()){
               current.toggleFlag(); // remove flag
            }
            current.uncover(); // show everything
         }
      }
      return -1;
   }

    if (neighbors == 0){
      for (int i = -1; i <= 1; i++){
         for(int j = -1; j <= 1; j++){
            int newRow = r + i;
            int newCol = c + j;
            if(newRow >= 0 && newRow < height && newCol >= 0 && newCol < width){
               Square neighborSq = grid[newRow][newCol];
               if(neighborSq.isFlagged() == false && neighborSq.isUncovered() == false && neighborSq.isMine() == false){
                  uncoverSquare(newRow,newCol);
               }
            }
         }
      }
   }
   return neighbors;
}
/**
 * Creates the grid, places mines randomly, then fills in number squares.
 */
private void createGrid(){
   Random ran = new Random();

   // place mines randomly
   for(int i = 0; i < numMines;){
      int r = ran.nextInt(height);
      int c = ran.nextInt(width);
      if (grid[r][c] == null) {
         grid[r][c] = new MineSquare(r, c); // set mine
         i++; // only count placed mine
      }
   }

   // fill rest of grid with number squares
   for(int i = 0; i < height; i++){
      for(int j = 0; j < width; j++){
         if(grid[i][j] == null){
            int mines = 0;

            // check all 8 neighbors
            for (int x = -1; x <= 1; x++){
               for(int y = -1; y <= 1; y++){
                  int newRow = i + x;
                  int newCol = j + y;
                  if(newRow >= 0 && newRow < height && newCol >= 0 && newCol < width){
                     Square neighbor = grid[newRow][newCol];
                     if(neighbor != null && neighbor.isMine()){
                        mines++; // count neighbor mine
                     }
                  }
               }
            }

            grid[i][j] = new NumberSquare(mines, i, j); // create number square
         }
      }
   }
}

/**
 * Processes a user move based on mouse clicks
 * @param mouseX x  location
 * @param mouseY y  location
 * @param action "uncover" or "flag"
 * @param started whether the game has already started
 * @return updated started status
 */
public boolean userMove(int mouseX,int mouseY,String action,boolean started){
   if (mouseX >= leftMargin && mouseX < leftMargin + (width*squareSize) &&
         mouseY >= topMargin && mouseY < topMargin + (height * squareSize)){
         
         //converting mouse x y to col row position   
         int col = (mouseX-leftMargin)/squareSize;
         int row = (mouseY-topMargin)/squareSize;
         

         if(action.equals("uncover")){
            if(started == false){
               started = true;
            }
           if (uncoverSquare(row,col) == -1){
               mineUncovered = true;
            
            }
            }
           if(action.equals("flag")){
             flag(row,col);
            
            
            }
         
         
         }


 return started;

}


/**
 * Checks if the user has won the game.
 * @return true if all mines are flagged and all other squares uncovered else false
 */

public boolean hasWon(){
   for(int i = 0; i < height; i++){
         for(int j = 0; j < width; j++){//iterating thru whole board
         Square current = grid[i][j];
         
         if(current.isMine() && !current.isFlagged()){ // if mine and not flagged u didnt win
            return false;
         }
         
         else if (current.isMine() == false){ // if number square isnt uncovered u didnt win
            if(current.isUncovered() == false){
               return false;
            
            
            }
         
         
         }



}

}

return true;

}
/**
 * Draws the entire grid using each square's draw() method.
 * @param g2 the graphics
 */
public void draw(Graphics2D g2){
   for(int i = 0; i < height; i++){
         for(int j = 0; j < width; j++){
            Square sq = grid[i][j];
            sq.draw(g2,squareSize,leftMargin,topMargin);

}
}
}

//getters

/**
 * @return number of flagged squares
 */
public int getNumFlaggedSquares() {
    return numFlaggedSquares;
}

/**
 * @return true if a mine has been uncovered
 */
public boolean hasMineBeenUncovered() {
    return mineUncovered;
}
/**
 * @return total number of mines on the grid
 */
public int getNumMines() {
    return numMines;
}


}
