package sudoku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
   // private variables
   GameBoard board = new GameBoard();
   JButton btnNewGame = new JButton("New Game");
   JButton btnReset = new JButton("Reset");
   JPanel SubPanel = new JPanel();
   JPanel Panel = new JPanel();
   
   // Constructor
   public SudokuMain() {
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(SubPanel,BorderLayout.SOUTH);
      cp.add(board, BorderLayout.CENTER);
      
      
      // Add a button to the south to re-start the game
      SubPanel.add(btnNewGame, BorderLayout.SOUTH);
      SubPanel.add(btnReset, BorderLayout.SOUTH);
      
      
      btnNewGame.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent evt) {
    		  board.init();
    		  
    	  }
      });
      
      btnReset.addActionListener(new ActionListener() {
    	  @Override
    	  public void actionPerformed(ActionEvent evt) {
    	  for (int row = 0; row < GameBoard.GRID_SIZE; ++row) {
              for (int col = 0; col < GameBoard.GRID_SIZE; ++col) {
            	 board.Reset();
            	  }

          

         }

        }
      });
      
      
 

      board.init();

      pack();     // Pack the UI components, instead of setSize()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
      setTitle("Sudoku");
      setVisible(true);
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("Test Sound Clip");
      this.setSize(600, 600);
      this.setVisible(true);
   
      try {
         // Open an audio input stream.
        File soundFile = new File("Forest.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         // Get a sound clip resource.
        Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
         clip.loop(Clip.LOOP_CONTINUOUSLY);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
      
   }

   /** The entry main() entry method */
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable(){
    	 @Override
    	 public void run() {
    		 new SudokuMain();
    	 }
      });
   }
}