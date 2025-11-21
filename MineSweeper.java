/**
 * Nico Lippiatt-Cook
 * CS2100A
 * Sami Connelly
 * Runs the minesweeper game
 * Please Evaluate For: 
 * Recursion, Colored Numbers
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MineSweeper{

/**
 * Main method sets up and launches the game window.
 * @param args 
 */
public static void main(String[] args) {
    JFrame window = new JFrame("Minesweeper");
    GameComponent game = new GameComponent();

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(1000, 800); 
    window.add(game);
    window.setVisible(true);

    game.start(); // start the game
}

}