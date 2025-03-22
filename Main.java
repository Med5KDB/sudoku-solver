import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int mat [][] = FileReader.readBoardFromFile("grille.txt");
        Sudoku sudoku = new Sudoku();
        if (sudoku.isValid(mat, 0)) {
            System.out.println("Solution trouvée :");
            sudoku.printBoard(mat);
        } else {
            System.out.println("Pas de solution possible !");
        }
    }
}
