package pattern;
public class BacktrackingSolver implements SudokuSolver {

    @Override
    public boolean solve(SudokuModel model) {
        return solveCell(0, 0, model);
    }

    private boolean solveCell(int row, int column, SudokuModel model) {
        // Si on a parcouru toutes les cellules, la grille est résolue
        if (row == 9) {
            return true;
        }

        // Calcul de la prochaine cellule à traiter
        int nextRow = column == 8 ? row + 1 : row;
        int nextColumn = (column + 1) % 9;

        // Si la cellule actuelle est déjà remplie, passer à la suivante
        if (model.getValueAt(row, column) != 0) {
            return solveCell(nextRow, nextColumn, model);
        }

        // Essayer toutes les valeurs possibles pour la cellule actuelle
        for (int value = 1; value <= 9; value++) {
            if (model.isValueValid(row, column, value)) {
                // Assigner la valeur à la cellule
                model.setValueAt(row, column, value);

                // Récursivement résoudre la grille à partir de la cellule suivante
                if (solveCell(nextRow, nextColumn, model)) {
                    return true;
                }

                // Si la résolution a échoué, retirer la valeur de la cellule
                model.setValueAt(row, column, 0);
            }
        }

        // Si aucune valeur n'a fonctionné, revenir en arrière
        return false;
    }
}
