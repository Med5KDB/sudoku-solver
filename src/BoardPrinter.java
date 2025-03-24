public class BoardPrinter {
    // Box drawing characters - thick lines (for cell boundaries)
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
    
    // Thin lines (for cell boundaries within 3x3 boxes)
    static String verticalThin = "\u2502"; // │ (light vertical)
    static String horizontalThin = "\u2500"; // ─ (light horizontal)
    static String crossThin = "\u253C";     // ┼ (light vertical and horizontal)
    
    public static void printBoard(int board[][]) {
        int size = board.length;
        int boxSize = (int) Math.sqrt(size);

        // Print top border
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

        // Print rows of numbers with vertical separators
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

            // Print horizontal separators
            if ((i + 1) % boxSize == 0 && i != size - 1) {
                // Print thick horizontal line between boxes
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
                // Print thin horizontal line between sub grid rows
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

        // Print bottom border
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
