import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardwidth = 625;
        int boardheight = 625;

        JFrame frame = new JFrame("Snake Game");
        frame.setSize(boardwidth, boardheight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Snake snake = new Snake(boardwidth, boardheight);

        frame.add(snake);
        frame.setContentPane(snake);
        frame.pack();
        frame.setVisible(true);
        snake.requestFocus();
    }
}