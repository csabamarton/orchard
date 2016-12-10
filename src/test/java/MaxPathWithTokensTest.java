import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class MaxPathWithTokensTest {

    private MaxPathWithTokens maxPath;

    @Before
    public void setUp() throws Exception {

        maxPath = new MaxPathWithTokens();
    }

    @Test
    public void check1kSizeMatrixProcessTime() {
        int[][] array = MatrixGenerator.generateMatrix(1000, 1000);

        int oneTokenSolution = maxPath.solveWithTwoToken(array);
        System.out.println(oneTokenSolution);
    }

    @Test
    public void testExampleShouldWork() {
        String input = "3 3\n" + "4 0 1\n" + "1 0 0\n" + "0 4 0";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithTwoToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(11);
    }

    @Test
    public void squareRectangle_shouldReturnWithTheRightAmount() {
        String input = "4 4\n" + "5 20 6 9\n" + "8 1 1 7\n" + "2 5 3 3\n" + "11 2 22 0";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithTwoToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(92);
    }

    @Test
    public void nonSquareRectangle_shouldReturnWithTheRightAmount() {
        String input = "4 3\n" + "4 2 1\n" + "1 4 1\n" + "6 10 8\n" + "0 4 0";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithTwoToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(44);
    }
}