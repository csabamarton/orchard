import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MatrixGenerator {
    protected static int[][] generateMatrix(int height, int width) {
        int[][] apples = new int[height][width];

        Random random = new Random();

        IntStream.range(0, height).forEach(row -> {
            IntStream.range(0, width).forEach(column -> {
                apples[row][column] = random.nextInt(1000);
            });
        });

        return apples;
    }

    protected static int[][] createMatrix(String input) {
        Scanner in = new Scanner(input);

        int height = in.nextInt();
        int width = in.nextInt();

        int[][] apples = new int[height][width];

        IntStream.range(0, height).forEach(row -> {
            IntStream.range(0, width).forEach(column -> {
                apples[row][column] = in.nextInt();
            });
        });

        return apples;
    }
}
