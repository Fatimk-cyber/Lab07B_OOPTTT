
public class TTTBoard {

    private char[][] board;

    public TTTBoard() {
        resetBoard();
    }

    public void resetBoard() {
        board = new char[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col, char player) {

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        if (board[row][col] != ' ') {
            return false;
        }

        board[row][col] = player;
        return true;
    }

    public char checkWinner() {

        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != ' ' &&
                    board[row][0] == board[row][1] &&
                    board[row][1] == board[row][2]) {
                return board[row][0];
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != ' ' &&
                    board[0][col] == board[1][col] &&
                    board[1][col] == board[2][col]) {
                return board[0][col];
            }
        }

        // Check diagonal
        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return board[0][0];
        }

        // Check opposite diagonal
        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return board[0][2];
        }

        return ' ';
    }

    public boolean isFull() {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }
}

