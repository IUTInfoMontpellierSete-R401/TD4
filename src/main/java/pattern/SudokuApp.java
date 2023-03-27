package pattern;


public class SudokuApp {
    public static void main(String[] args) {
        SudokuModel model = new SudokuModel(9);
        SudokuView view = new SudokuView(model);
        SudokuSolver solver = new BacktrackingSolver();
        SudokuController controller = new SudokuController(model, view, solver);

        controller.startGame();
    }
}
