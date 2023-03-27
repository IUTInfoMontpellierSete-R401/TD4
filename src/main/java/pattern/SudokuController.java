package pattern;

import java.util.ArrayList;
import java.util.List;

public class SudokuController {
    private final SudokuView view;
    private SudokuModel model;

    private SudokuSolver solver;
    private List<SudokuCommand> commands = new ArrayList<SudokuCommand>();

    public SudokuController(SudokuModel model, SudokuView view, SudokuSolver solver) {
        this.model = model; this.view= view; this.solver= solver;
    }

    public void setValue(int row, int col, int value) {
        SudokuCommand command = new SetValueCommand(model, row, col, value);
        command.execute();
        commands.add(command);
    }

    public void undo() {
        if (commands.size() > 0) {
            SudokuCommand command = commands.remove(commands.size() - 1);
            command.undo();
        }
    }

    public void startGame() {
        view.displayWelcomeMessage();
        solver.solve(model);
        view.display();

        while (!model.isGameFinished()) {
            int[] userCoords = view.askUserForCoords();
            int userValue = view.askUserForValue();

            SudokuCommand command = new SetValueCommand(model, userCoords[0], userCoords[1], userValue);
            command.execute();
        }
        view.displayVictoryMessage();
    }

}
