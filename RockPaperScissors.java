import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class RockPaperScissorsGUI extends JFrame implements ActionListener {

  private JButton rockButton, paperButton, scissorsButton;
  private JLabel computerMoveLabel, resultLabel;

  public RockPaperScissorsGUI() {
    super("Rock Paper Scissors");
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    JPanel buttonPanel = new JPanel();
    rockButton = new JButton("Rock");
    paperButton = new JButton("Paper");
    scissorsButton = new JButton("Scissors");
    buttonPanel.add(rockButton);
    buttonPanel.add(paperButton);
    buttonPanel.add(scissorsButton);

    computerMoveLabel = new JLabel("Computer Move:");
    resultLabel = new JLabel("");

    add(buttonPanel);
    add(computerMoveLabel);
    add(resultLabel);

    rockButton.addActionListener(this);
    paperButton.addActionListener(this);
    scissorsButton.addActionListener(this);

    pack();
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String userMove = ((JButton) e.getSource()).getText().toLowerCase();
    String computerMove = generateComputerMove();
    String result = determineWinner(userMove, computerMove);

    computerMoveLabel.setText("Computer Move: " + computerMove);
    resultLabel.setText(result);
  }

  public String generateComputerMove() {
    String[] moves = {"rock", "paper", "scissors"};
    Random random = new Random();
    int index = random.nextInt(moves.length);
    return moves[index];
  }

  public String determineWinner(String userMove, String computerMove) {
    if (userMove.equals(computerMove)) {
      return "It's a tie!";
    } else if ((userMove.equals("rock") && computerMove.equals("scissors")) ||
               (userMove.equals("paper") && computerMove.equals("rock")) ||
               (userMove.equals("scissors") && computerMove.equals("paper"))) {
      return "You win!";
    } else {
      return "You lose!";
    }
  }

  public static void main(String[] args) {
    new RockPaperScissorsGUI();
  }
}
