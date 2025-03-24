import java.util.Scanner;

public class UserInputReader {
    public static int[][] readBoardFromUser(Scanner scanner) {
        int[][] board = new int[9][9];
        System.out.println("Veuillez saisir chaque ligne de la grille (9 chiffres séparés par des espaces)");

        for (int row = 0; row < 9; row++) {
            while (true) {
                System.out.println("Ligne " + (row + 1) + " : ");
                String line = scanner.nextLine().trim();

                String[] values = line.split(" ");
                if (values.length != 9) {
                    System.out.println("Erreur: La ligne doit contenir exactement 9 chiffres séparés par des espaces");
                    continue;
                }
                boolean validLine = true;
                for (int col = 0; col < 9; col++) {
                    if (values[col].length() != 1 || !Character.isDigit(values[col].charAt(0))) {
                        System.out.println("Erreur: Chaque valeur doit être un seul chiffre");
                        validLine = false;
                        break;
                    }
                    board[row][col] = Integer.parseInt(values[col]);
                }
                if (validLine) {
                    break; // Exit the loop if the line is valid
                }
            }
        }
        return board;
    }
}
