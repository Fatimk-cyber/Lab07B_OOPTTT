
import javax.swing.JButton;
import java.awt.Font;

public class TTTTileButton extends JButton {

    private int row;
    private int col;

    public TTTTileButton(int row, int col) {

        this.row = row;
        this.col = col;

        setFont(new Font("Arial", Font.BOLD, 40));
        setFocusPainted(false);
        setText("");
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setMark(char mark) {
        setText(String.valueOf(mark));
    }

    public void reset() {
        setText("");
    }
}
