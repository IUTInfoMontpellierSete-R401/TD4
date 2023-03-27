package pattern;


public interface SudokuObserver {

    // Méthode appelée lorsque le modèle a été mis à jour
    void update(int row, int column, int value);
}
