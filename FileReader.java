import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class FileReader {
    public static int[][] readBoardFromFile(String filename) throws IOException {
        int board[][] = new int[9][9];
        try {
            File file = new File(filename);
            Scanner fileIn = new Scanner(file);
            int row = 0;
            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();
                System.out.println(line);
                for (int col = 0; col < 9; col++) {
                    board[row][col] = Character.getNumericValue(line.charAt(col));
                }
                row++;
            }
            fileIn.close();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("File not found" + e);
            throw e;
        }
        return board;
    }
}
