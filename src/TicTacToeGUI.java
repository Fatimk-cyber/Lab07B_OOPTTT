
import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI extends JFrame {

    private Game game;
    private TTTTileButton[][] tiles;
    private JLabel statusLabel;

    public TicTacToeGUI() {

        game = new Game();
        tiles = new TTTTileButton[3][3];

        setTitle("Tic Tac Toe");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();
    }

    private void createGUI() {

        setLayout(new BorderLayout(10, 10));

        // Status label
        statusLabel = new JLabel("Player X's Turn", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));

        add(statusLabel, BorderLayout.NORTH);

        // Game board
        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                tiles[row][col] = new TTTTileButton(row, col);

                tiles[row][col].addActionListener(e ->
                        handleTileClick(
                                ((TTTTileButton) e.getSource()).getRow(),
                                ((TTTTileButton) e.getSource()).getCol()
                        )
                );

                boardPanel.add(tiles[row][col]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        // New Game button
        JButton newGameButton = new JButton("New Game");

        newGameButton.addActionListener(e -> resetGame());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(newGameButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void handleTileClick(int row, int col) {

        boolean validMove = game.makeMove(row, col);

        if (!validMove) {
            return;
        }

        updateBoard();

        if (game.getWinner() != ' ') {

            statusLabel.setText(
                    "Player " + game.getWinner() + " Wins!"
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Player " + game.getWinner() + " Wins!"
            );

        } else if (game.isTie()) {

            statusLabel.setText("It's a Tie!");

            JOptionPane.showMessageDialog(
                    this,
                    "It's a Tie!"
            );

        } else {

            updateStatus();
        }
    }

    private void updateBoard() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                char mark = game.getCell(row, col);

                if (mark != ' ') {
                    tiles[row][col].setMark(mark);
                }
            }
        }
    }

    private void updateStatus() {

        statusLabel.setText(
                "Player " + game.getCurrentPlayer() + "'s Turn"
        );
    }

    private void resetGame() {

        game.startNewGame();

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                tiles[row][col].reset();
            }
        }

        updateStatus();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TicTacToeGUI gui = new TicTacToeGUI();

            gui.setVisible(true);
        });
    }
}

