public class Sudoku {

    // Fonctions pour vérifier les conditions de validation du jeu, 3 conditions => 3 fonctions

    boolean isNotInRow(int board[][], int row, int number) {
        for (int i = 0; i < 9; i++)
            if (board[row][i] == number)
                return false;
        return true;
    }

    boolean isNotInCol(int board[][], int colonne, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][colonne] == number)
                return false;
        }
        return true;
    }

    
    boolean isNotInBox(int board[][], int row, int col, int number) {
        int _row = row - row % 3;
        int _col = col - col % 3;
        for (int i = _row; i < _row + 3; i++)
            for (int j = _col; j < _col + 3; j++)
                if (board[i][j] == number)
                    return false;
        return true;
    }

    boolean isValid(int board[][], int position) {
        if (position == 9 * 9) {
            return true;
        }
        int row = position / 9;
        int col = position % 9;

        if (board[row][col] != 0) {
            return isValid(board, position + 1);
        }
        // Implémentation de l'algorithme Backtracking

        for (int k = 1; k <= 9; k++) {
            // Vérifier si la valeur est présente, si oui donc on peut l'ajouter dans la
            // grille
            if (isNotInRow(board, row, k) && isNotInCol(board, col, k) && isNotInBox(board, row, col, k)) {
                // On enregistre k dans la grille
                board[row][col] = k;
                // On appelle récursivement la fonction isValid pour voir si ce choix est bon
                // par la suite
                if (isValid(board, position + 1)) {
                    return true; // Si le choix est bon, donc pas besoin de continuer, on retourne true
                }
                // Toutes les valeurs ont été testées et aucun n'est bon, donc on réinitialise
                // le tableau et puis on retourne false;
                board[row][col] = 0;
            }

        }
        return false;
    }

}
