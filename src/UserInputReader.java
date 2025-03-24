import java.util.Scanner;

// Cette classe est utilisée pour lire une grille de Sudoku à partir de l'entrée utilisateur
public class UserInputReader {
    public static int[][] readBoardFromUser(Scanner scanner) {
        int[][] board = new int[9][9];
        System.out.println("Veuillez saisir chaque ligne de la grille (9 chiffres séparés par des espaces)");

        // Pour chaque ligne de la grille
        for (int row = 0; row < 9; row++) {
            // Tant que la ligne n'est pas valide
            while (true) {
                System.out.println("Ligne " + (row + 1) + " : ");
                String line = scanner.nextLine().trim();

                String[] values = line.split(" ");
                if (values.length != 9) {
                    System.out.println("Erreur: La ligne doit contenir exactement 9 chiffres séparés par des espaces");
                    continue;
                }
                // Initialise un drapeau pour vérifier si la ligne est valide
                boolean validLine = true;
                for (int col = 0; col < 9; col++) {
                    if (values[col].length() != 1 || !Character.isDigit(values[col].charAt(0))) {
                        System.out.println("Erreur: Chaque valeur doit être un seul chiffre");
                        validLine = false;
                        break;
                    }
                    // Convertit la valeur en entier et l'ajoute à la grille
                    board[row][col] = Integer.parseInt(values[col]);
                }
                // Si la ligne est valide, sort de la boucle
                if (validLine) {
                    break;
                }
            }
        }
        System.out.println("\nVoici la grille que vous avez saisie :");
        BoardPrinter.printBoard(board);
        
        return board;
    }
}
