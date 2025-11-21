/**
 * Nico Lippiatt-Cook
 * CS2100A
 * Sami Connelly
 * Handles the Minesweeper GUI and game loop: user input, win/loss status.
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameComponent extends JComponent implements MouseListener {


private Grid gameGrid;
private String message;
private String userProgress;
private Color textColor;
private boolean started;
private boolean gameOver;



/**
 * Constructor for game and GUI.
 */
public GameComponent(){
   gameGrid = new Grid(10, 12, 10, 350, 350);
   message = "Click any tile to start!";
   userProgress = String.format("%d/%d",gameGrid.getNumFlaggedSquares(),gameGrid.getNumMines());
   textColor = Color.BLACK;
   started = false;
   gameOver = false;
   setFocusable(true);
   requestFocusInWindow();
   addMouseListener(this);

}
/**
 * Checks win condition and updates game state.
 */
private void checkWin(){
   if(gameGrid.hasWon()){
      gameOver = true;
      message = "You Win!";
}
}
/**
 * Renders the grid and text to the screen.
 * @param g graphics
 */
@Override
public void paintComponent(Graphics g){
   super.paintComponent(g);
   Graphics2D g2 = (Graphics2D) g;
   gameGrid.draw(g2);
   g2.setFont(new Font("Serif", Font.BOLD, 24));    
   g.setColor(textColor);
   g.drawString(message,100,200);
   g.drawString(userProgress,100,250);

}
/**
 * Runs the game loop — continuously checks win/loss and repaints.
 */
public void start(){
   while (true){
      checkWin();
      repaint();
      }
      }
      
/**
 * left/right mouse clicks to uncover or flag squares.
 * @param e mouse event
 */
@Override
public void mouseReleased(MouseEvent e){
  if (e.getButton() == MouseEvent.BUTTON1){
   started = gameGrid.userMove(e.getX(),e.getY(),"uncover",started);

}
  else{
   started = gameGrid.userMove(e.getX(),e.getY(),"flag",started);
  
  }
 if (started  && gameGrid.hasMineBeenUncovered() == false){
   message = "Find the mines!";
   }
 else if (gameGrid.hasMineBeenUncovered()){
   gameOver = true;
   message = "You lost!";

}
userProgress = String.format("%d/%d",gameGrid.getNumFlaggedSquares(),gameGrid.getNumMines());

}

@Override
   public void mouseClicked(MouseEvent e)
   {
       // unused
   }
 @Override
   public void mousePressed(MouseEvent e)
   {  
   
}
@Override
    public void mouseEntered(MouseEvent e)
   {
       // unused
   }
   
@Override
    public void mouseExited(MouseEvent e)
   {
       // unused
   }
}