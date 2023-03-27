package pattern;


public interface SudokuCommand {
    void execute();

    void undo();
}
