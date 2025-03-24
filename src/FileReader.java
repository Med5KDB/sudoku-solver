import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

// Cette classe est utilisée pour lire une grille de Sudoku à partir d'un fichier
public class FileReader {
    public static int[][] readBoardFromFile(String filename) throws IOException, FileNotFoundException {
        int board[][] = new int[9][9];
        // Création d'un objet File à partir du nom de fichier fourni
        File file = new File(filename);
        // Vérification si le fichier existe, sinon une exception est levée
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        // Utilisation de try-with-resources pour s'assurer que le Scanner est fermé après utilisation
        try (Scanner fileIn = new Scanner(file)) {
            int row = 0;
            // Tant qu'il y a une ligne à lire dans le fichier
            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();
                // Pour chaque caractère dans la ligne
                for (int col = 0; col < 9; col++) {
                    board[row][col] = Character.getNumericValue(line.charAt(col));
                }
                row++;
            }
            BoardPrinter.printBoard(board);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e);
            throw e;
        }
        return board;
    }
}