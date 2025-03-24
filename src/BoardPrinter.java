public class BoardPrinter {
    // Caractères de dessin de boîte - lignes épaisses (pour les limites des cellules)
    static String horizontal = "\u2550"; // ═ (double horizontal)
    static String vertical = "\u2551";   // ║ (double vertical)
    static String topLeft = "\u2554";    // ╔ (double down and right)
    static String topRight = "\u2557";   // ╗ (double down and left)
    static String bottomLeft = "\u255A"; // ╚ (double up and right)
    static String bottomRight = "\u255D";// ╝ (double up and left)
    static String leftT = "\u2560";      // ╠ (double vertical and right)
    static String rightT = "\u2563";     // ╣ (double vertical and left)
    static String topT = "\u2566";       // ╦ (double down and horizontal)
    static String bottomT = "\u2569";    // ╩ (double up and horizontal)
    static String cross = "\u256C";      // ╬ (double vertical and horizontal)
    
    // Lignes minces (pour les limites des cellules à l'intérieur des boîtes 3x3)
    static String verticalThin = "\u2502"; // │ (light vertical)
    static String horizontalThin = "\u2500"; // ─ (light horizontal)
    static String crossThin = "\u253C";     // ┼ (light vertical and horizontal)
    
    // Méthode pour afficher la grille
    public static void printBoard(int board[][]) {
        int size = board.length;
        int boxSize = (int) Math.sqrt(size);

        // Afficher la bordure supérieure
        System.out.print(topLeft);
        for (int i = 0; i < size; i++) {
            System.out.print(horizontal + horizontal + horizontal);
            if ((i + 1) % boxSize == 0 && i != size - 1) {
                System.out.print(topT);
            } else if (i != size - 1) {
                System.out.print(horizontal);
            }
        }
        System.out.println(topRight);

        // Afficher les lignes de chiffres avec des séparateurs verticaux
        for (int i = 0; i < size; i++) {
            System.out.print(vertical);
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    System.out.print("   ");
                } else {
                    System.out.printf(" %d ", board[i][j]);
                }
                if ((j + 1) % boxSize == 0 && j != size - 1) {
                    System.out.print(vertical);
                } else if (j != size - 1) {
                    System.out.print(verticalThin);
                }
            }
            System.out.println(vertical);

            // Afficher les séparateurs horizontaux
            if ((i + 1) % boxSize == 0 && i != size - 1) {
                // Afficher la ligne horizontale épaisse entre les boîtes
                System.out.print(leftT);
                for (int j = 0; j < size; j++) {
                    System.out.print(horizontal + horizontal + horizontal);
                    if ((j + 1) % boxSize == 0 && j != size - 1) {
                        System.out.print(cross);
                    } else if (j != size - 1) {
                        System.out.print(horizontal);
                    }
                }
                System.out.println(rightT);
            } else if (i != size - 1) {
                // Afficher la ligne horizontale mince entre les rangées de sous-grilles
                System.out.print(vertical);
                for (int j = 0; j < size; j++) {
                    System.out.print(horizontalThin + horizontalThin + horizontalThin);
                    if ((j + 1) % boxSize == 0 && j != size - 1) {
                        System.out.print(vertical);
                    } else if (j != size - 1) {
                        System.out.print(crossThin);
                    }
                }
                System.out.println(vertical);
            }
        }

        // Afficher la bordure inférieure
        System.out.print(bottomLeft);
        for (int i = 0; i < size; i++) {
            System.out.print(horizontal + horizontal + horizontal);
            if ((i + 1) % boxSize == 0 && i != size - 1) {
                System.out.print(bottomT);
            } else if (i != size - 1) {
                System.out.print(horizontal);
            }
        }
        System.out.println(bottomRight);
    }
}
