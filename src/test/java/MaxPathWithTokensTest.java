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
    public void givenNullArray_shouldReturnWithMinusOne() {
        int[][] orchard = null;

        int result = maxPath.solveWithTwoToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(-1);
    }

    @Test
    public void given1kSizeMatrix_shouldNotStuckTheProcessTime() {
        int[][] array = MatrixGenerator.generateMatrix(1000, 1000);

        int oneTokenSolution = maxPath.solveWithTwoToken(array);
        System.out.println(oneTokenSolution);
    }

    @Test
    public void given1x1Array_shouldRestunrWithDoubleResult() {
        String input = "1 1\n" + "4\n";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithTwoToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(8);
    }

    @Test
    public void givenTheExample_ShouldWork() {
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

    @Test
    public void oneHeightRectangle_shouldReturnWithTheRightAmount() {
        String input = "1 4\n" + "5 20 6 9";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithTwoToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(69);
    }

    @Test
    public void oneWidthRectangle_shouldReturnWithTheRightAmount() {
        String input = "4 1\n" + "9\n" + "6\n" + "20\n" + "5";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithTwoToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(69);
    }
}