
public class Game {

    private TTTBoard board;
    private char currentPlayer;
    private boolean gameOver;

    public Game() {
        board = new TTTBoard();
        currentPlayer = 'X';
        gameOver = false;
    }

    public void startNewGame() {
        board.resetBoard();
        currentPlayer = 'X';
        gameOver = false;
    }

    public boolean makeMove(int row, int col) {

        if (gameOver) {
            return false;
        }

        boolean validMove = board.makeMove(row, col, currentPlayer);

        if (!validMove) {
            return false;
        }

        if (board.checkWinner() != ' ') {
            gameOver = true;
        } else if (board.isFull()) {
            gameOver = true;
        } else {
            switchPlayer();
        }

        return true;
    }

    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public char getWinner() {
        return board.checkWinner();
    }

    public boolean isTie() {
        return gameOver && board.checkWinner() == ' ' && board.isFull();
    }

    public char getCell(int row, int col) {
        return board.getCell(row, col);
    }
}
