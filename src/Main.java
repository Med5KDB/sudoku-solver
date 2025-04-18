import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] mat;
        Scanner scanner = new Scanner(System.in);

        try {
            if (args.length > 0) {
                String filename = args[0];
                mat = FileReader.readBoardFromFile(filename);
            } else {
                System.out.println("Aucun fichier fourni en argument. Veuillez saisir la grille manuellement");
                mat = UserInputReader.readBoardFromUser(scanner);
            }

            Sudoku sudoku = new Sudoku();
            if (sudoku.isValid(mat, 0)) {
                System.out.println("Solution trouvée :");
                BoardPrinter.printBoard(mat);
            } else {
                System.out.println("Pas de solution possible !");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erreur: Fichier introuvable.");
        }catch (IOException e) {
            System.err.println("Erreur de lecture du fichier: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
