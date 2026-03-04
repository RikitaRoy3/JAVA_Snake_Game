// import javax.swing.Timer;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.*;
// import java.io.File;
// import java.io.IOException;
// import javax.sound.sampled.*;

// public class Snake extends JPanel implements ActionListener, KeyListener {
//   int boardwidth, boardheight;
//   int tileSize = 25;
//   int points;
//   int levels = 1;
//   Tile snakeHead, food;
//   ArrayList<Tile> snakebody;
//   Image img;
//   Image frogimg;
//   Image snakeH;
//   Random random;
//   Timer t;
//   int xvelocity = 0;
//   int yvelocity = 0;

//   int snakeHeadPrevx;
//   int snakeHeadPrevy;

//   int a = snakeHeadPrevx;
//   int b = snakeHeadPrevy;

//   File file = new File("song.wav");
//   AudioInputStream audioInputStream1;
//   Clip clip1;

//   File f = new File("gameoversong.wav");
//   AudioInputStream audioInputStream2;
//   Clip clip2;

//   private class Tile {
//     int x, y;

//     Tile(int x, int y) {
//       this.x = x;
//       this.y = y;
//     }
//   }

//   Snake(int boardwidth, int boardheight) {
//     try {
//       audioInputStream1 = AudioSystem.getAudioInputStream(file);
//       clip1 = AudioSystem.getClip();
//       clip1.open(audioInputStream1);
//       clip1.loop(Clip.LOOP_CONTINUOUSLY);
//       clip1.start();
//     } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
//       System.out.println("Error opening audio file: " + e.getMessage());
//     }

//     this.boardwidth = boardwidth;
//     this.boardheight = boardheight;

//     this.setPreferredSize(new Dimension(boardwidth, boardheight));

//     this.setBackground(Color.BLACK);
//     this.setFocusable(true);

//     snakeHead = new Tile(0, 0);
//     food = new Tile(10, 10);
//     // img = new ImageIcon("backimg.png").getImage();
//     // frogimg = new ImageIcon("frog.png").getImage();
//     // snakeH = new ImageIcon("snakehead.png").getImage();
//     img = new ImageIcon(getClass().getResource("backimg.png")).getImage();
//     frogimg = new ImageIcon(getClass().getResource("frog.png")).getImage();
//     snakeH = new ImageIcon(getClass().getResource("snakeHead.png")).getImage();

//     snakebody = new ArrayList<>();
//     random = new Random();
//     food.x = random.nextInt(boardwidth / tileSize);
//     food.y = random.nextInt(boardheight / tileSize);
//     this.addKeyListener(this);

//     t = new Timer(100, this);
//     t.start();
//   }

//   public void paint(Graphics g) {
//     super.paint(g);
//     Graphics2D g2d = (Graphics2D) g;
//     g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
//     for (int i = 0; i <= boardheight / tileSize; i++) {
//       g2d.drawLine(0, i * tileSize, boardwidth, i * tileSize);// horizontal lines
//       g2d.drawLine(i * tileSize, 0, i * tileSize, boardheight);// vertical Lines
//     }
//     g2d.setColor(Color.white);
//     g2d.drawString("Points: " + points, boardwidth - 70, 20);
//     g2d.setColor(Color.blue);
//     g2d.fillRect(snakeHead.x, snakeHead.y, tileSize, tileSize);
//     for (int i = 0; i < snakebody.size(); i++) {// Displaying Snake's body
//       Tile tile = snakebody.get(i);
//       g2d.setColor(Color.blue);// Displaying Snake's Head
//       g2d.fillRect(tile.x, tile.y, tileSize, tileSize);
//     }

//     if ((snakeHead.x >= boardwidth) || (snakeHead.x < 0) || (snakeHead.y >= boardheight) || (snakeHead.y < 0)
//         || (hitself())) {

//       t.stop();
//       clip1.stop();
//       try {
//         audioInputStream2 = AudioSystem.getAudioInputStream(f);
//         clip2 = AudioSystem.getClip();
//         clip2.open(audioInputStream2);
//         clip2.start();
//       } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
//         System.out.println("Error opening audio file: " + e.getMessage());
//       }
//       g2d.setColor(Color.red);
//       g2d.setFont(new Font("Arial", Font.BOLD, 60));
//       String gameOverText = "GAME OVER  ! ";
//       String s = "Your Score: " + points;
//       // Drawing Game Over !
//       // Use FontMetrics to center the text
//       FontMetrics fm = g2d.getFontMetrics();
//       int textHeight = fm.getHeight();
//       int textWidth = fm.stringWidth(gameOverText);
//       int x = (boardwidth - textWidth) / 2;
//       int y = (boardheight - textHeight) / 2;
//       g2d.drawString(gameOverText, x, y);

//       // Drawing the smaller text(Your score)
//       g2d.setColor(Color.white);
//       g2d.setFont(new Font("Arial", Font.BOLD, 30));
//       FontMetrics f = g2d.getFontMetrics();
//       int textw = f.stringWidth(s);
//       int x1 = (boardwidth - textw) / 2;
//       g2d.drawString(s, x1, y + 70);
//       return;
//     }
//     // Displaying Frog
//     g2d.setColor(Color.red);
//     g2d.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize);

//   }

//   boolean hitself() {
//     for (int i = 0; i < snakebody.size(); i++) {
//       if (snakeHead.x == snakebody.get(i).x && snakeHead.y == snakebody.get(i).y) {
//         return true;
//       }
//     }
//     return false;
//   }

//   boolean eatingfood() {
//     return (snakeHead.x == food.x * tileSize && snakeHead.y == food.y * tileSize);
//   }

//   void move() {
//     {// Giving Durection to the snake Head and storings it previous coordinates
//       snakeHeadPrevx = snakeHead.x;
//       snakeHeadPrevy = snakeHead.y;
//       snakeHead.x = snakeHead.x + xvelocity;
//       snakeHead.y = snakeHead.y + yvelocity;
//     }

//     {// Moving the Snake's Body
//       for (int i = snakebody.size() - 1; i > 0; i--) {
//         snakebody.get(i).x = snakebody.get(i - 1).x;
//         snakebody.get(i).y = snakebody.get(i - 1).y;
//       }
//       if (!snakebody.isEmpty()) {
//         snakebody.get(0).x = snakeHeadPrevx;
//         snakebody.get(0).y = snakeHeadPrevy;
//       }

//       if (!snakebody.isEmpty()) {
//         a = snakebody.get(snakebody.size() - 1).x;
//         b = snakebody.get(snakebody.size() - 1).y;
//       }

//     }
//   }

//   @Override
//   public void actionPerformed(ActionEvent e) {
//     move();
//     repaint();
//     if (eatingfood()) {
//       points++;

//       if (snakebody.isEmpty()) {
//         // First segment should start at the head's previous position
//         a = snakeHeadPrevx;
//         b = snakeHeadPrevy;
//       }

//       snakebody.add(new Tile(a, b));
//       food.x = random.nextInt(boardwidth / tileSize);
//       food.y = random.nextInt(boardheight / tileSize);
//     }
//   }

//   @Override
//   public void keyPressed(KeyEvent e) {
//     if ((e.getKeyCode() == KeyEvent.VK_UP) && (yvelocity != tileSize)) {
//       xvelocity = 0;
//       yvelocity = -tileSize;
//     } else if ((e.getKeyCode() == KeyEvent.VK_DOWN) && (yvelocity != -tileSize)) {
//       xvelocity = 0;
//       yvelocity = tileSize;
//     } else if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (xvelocity != tileSize)) {
//       xvelocity = -tileSize;
//       yvelocity = 0;
//     } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (xvelocity != -tileSize)) {
//       xvelocity = tileSize;
//       yvelocity = 0;
//     }

//   }

//   @Override
//   public void keyReleased(KeyEvent e) {
//     // Not used
//   }

//   @Override
//   public void keyTyped(KeyEvent e) {
//     // Not used
//   }

// }



import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Snake extends JPanel implements ActionListener, KeyListener {
  int boardwidth, boardheight;
  int tileSize = 35;
  int points;
  int levels = 1;
  Tile snakeHead, food;
  ArrayList<Tile> snakebody;
  Image img;
  Image frogimg;
  // Image snakeH;
  Random random;
  Timer t;
  int xvelocity = 0;
  int yvelocity = 0;

  int snakeHeadPrevx;
  int snakeHeadPrevy;

  int a = snakeHeadPrevx;
  int b = snakeHeadPrevy;

  File file = new File("song.wav");
  AudioInputStream audioInputStream1;
  Clip clip1;

  File f = new File("gameoversong.wav");
  AudioInputStream audioInputStream2;
  Clip clip2;

  private class Tile {
    int x, y;

    Tile(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  Snake(int boardwidth, int boardheight) {
    try {
      audioInputStream1 = AudioSystem.getAudioInputStream(file);
      clip1 = AudioSystem.getClip();
      clip1.open(audioInputStream1);
      clip1.loop(Clip.LOOP_CONTINUOUSLY);
      clip1.start();
    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
      System.out.println("Error opening audio file: " + e.getMessage());
    }

    this.boardwidth = boardwidth;
    this.boardheight = boardheight;

    this.setPreferredSize(new Dimension(boardwidth, boardheight));

    this.setBackground(Color.BLACK);
    this.setFocusable(true);

    snakeHead = new Tile(0, 0);
    food = new Tile(10, 10);
    img = new ImageIcon("backimg.png").getImage();
    frogimg = new ImageIcon("frog.png").getImage();
    // snakeH = new ImageIcon("snakehead.png").getImage();
    snakebody = new ArrayList<>();
    random = new Random();
    food.x = random.nextInt(boardwidth / tileSize);
    food.y = random.nextInt(boardheight / tileSize);
    this.addKeyListener(this);

    t = new Timer(100, this);
    t.start();
  }

  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    for (int i = 0; i <= boardheight / tileSize; i++) {
      g2d.drawLine(0, i * tileSize, boardwidth, i * tileSize);// horizontal lines
      g2d.drawLine(i * tileSize, 0, i * tileSize, boardheight);// vertical Lines
    }
    g2d.setColor(Color.white);
    g2d.drawString("Points: " + points, boardwidth - 70, 20);
    g2d.setColor(Color.blue);
    g2d.fillRect(snakeHead.x, snakeHead.y, tileSize, tileSize);
    for (int i = 0; i < snakebody.size(); i++) {// Displaying Snake's body
      Tile tile = snakebody.get(i);
      g2d.setColor(Color.blue);// Displaying Snake's Head
      g2d.fillRect(tile.x, tile.y, tileSize, tileSize);
    }

    if ((snakeHead.x >= boardwidth) || (snakeHead.x < 0) || (snakeHead.y >= boardheight) || (snakeHead.y < 0)
        || (hitself())) {
      t.stop();
      clip1.stop();
      try {
        audioInputStream2 = AudioSystem.getAudioInputStream(f);
        clip2 = AudioSystem.getClip();
        clip2.open(audioInputStream2);
        clip2.start();
      } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
        System.out.println("Error opening audio file: " + e.getMessage());
      }
      g2d.setColor(Color.red);
      g2d.setFont(new Font("Arial", Font.BOLD, 60));
      String gameOverText = "GAME OVER  ! ";
      String s = "Your Score: " + points;
      // Drawing Game Over !
      // Use FontMetrics to center the text
      FontMetrics fm = g2d.getFontMetrics();
      int textHeight = fm.getHeight();
      int textWidth = fm.stringWidth(gameOverText);
      int x = (boardwidth - textWidth) / 2;
      int y = (boardheight - textHeight) / 2;
      g2d.drawString(gameOverText, x, y);

      // Drawing the smaller text(Your score)
      g2d.setColor(Color.white);
      g2d.setFont(new Font("Arial", Font.BOLD, 30));
      FontMetrics f = g2d.getFontMetrics();
      int textw = f.stringWidth(s);
      int x1 = (boardwidth - textw) / 2;
      g2d.drawString(s, x1, y + 70);
      return;
    }
    // Displaying Frog

    // g2d.setColor(Color.red);
    // g2d.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize);
    g2d.drawImage(frogimg, food.x * tileSize, food.y * tileSize, tileSize, tileSize, this);

  }

  boolean hitself() {
    for (int i = 0; i < snakebody.size(); i++) {
      if (snakeHead.x == snakebody.get(i).x && snakeHead.y == snakebody.get(i).y) {
        return true;
      }
    }
    return false;
  }

  boolean eatingfood() {
    return (snakeHead.x == food.x * tileSize && snakeHead.y == food.y * tileSize);
  }

  void move() {
    {// Giving Durection to the snake Head and storings it previous coordinates
      snakeHeadPrevx = snakeHead.x;
      snakeHeadPrevy = snakeHead.y;
      snakeHead.x = snakeHead.x + xvelocity;
      snakeHead.y = snakeHead.y + yvelocity;
    }

    {// Moving the Snake's Body
      for (int i = snakebody.size() - 1; i > 0; i--) {
        snakebody.get(i).x = snakebody.get(i - 1).x;
        snakebody.get(i).y = snakebody.get(i - 1).y;
      }
      if (!snakebody.isEmpty()) {
        snakebody.get(0).x = snakeHeadPrevx;
        snakebody.get(0).y = snakeHeadPrevy;
      }

      if (!snakebody.isEmpty()) {
        a = snakebody.get(snakebody.size() - 1).x;
        b = snakebody.get(snakebody.size() - 1).y;
      }

    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    move();
    repaint();
    if (eatingfood()) {
      points++;

      if (snakebody.isEmpty()) {
        // First segment should start at the head's previous position
        a = snakeHeadPrevx;
        b = snakeHeadPrevy;
      }

      snakebody.add(new Tile(a, b));
      food.x = random.nextInt(boardwidth / tileSize);
      food.y = random.nextInt(boardheight / tileSize);
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if ((e.getKeyCode() == KeyEvent.VK_UP) && (yvelocity != tileSize)) {
      xvelocity = 0;
      yvelocity = -tileSize;
    } else if ((e.getKeyCode() == KeyEvent.VK_DOWN) && (yvelocity != -tileSize)) {
      xvelocity = 0;
      yvelocity = tileSize;
    } else if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (xvelocity != tileSize)) {
      xvelocity = -tileSize;
      yvelocity = 0;
    } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (xvelocity != -tileSize)) {
      xvelocity = tileSize;
      yvelocity = 0;
    }

  }

  @Override
  public void keyReleased(KeyEvent e) {
    // Not used
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // Not used
  }

}