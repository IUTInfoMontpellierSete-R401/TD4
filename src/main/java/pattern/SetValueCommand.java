package pattern;
public class SetValueCommand implements SudokuCommand {
    private SudokuModel model;
    private int row;
    private int col;
    private int oldValue;
    private int newValue;

    public SetValueCommand(SudokuModel model, int row, int col, int value) {
        this.model = model;
        this.row = row;
        this.col = col;
        this.newValue = value;
        this.oldValue = model.getValueAt(row, col);
    }

    public void execute() {
        model.setValueAt(row, col, newValue);
    }

    public void undo() {
        model.setValueAt(row, col, oldValue);
    }
}
