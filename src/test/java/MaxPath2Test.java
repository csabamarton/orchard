import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class MaxPath2Test {

    private MaxPath maxPath;

    @Before
    public void setUp() throws Exception {
        maxPath = new MaxPath();
    }

    @Test
    public void given1kSizeMatrix_shouldNotStuckTheProcessTime() {
        int[][] array = MatrixGenerator.generateMatrix(1000, 1000);

        int oneTokenSolution = maxPath.solveWithOneToken(array);
        System.out.println(oneTokenSolution);
    }

    @Test
    public void givenTheExample_ShouldWork() {
        String input = "3 3\n" + "4 0 1\n" + "1 0 0\n" + "0 4 0";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithOneToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(6);
    }

    @Test
    public void squareRectangle_shouldReturnWithTheRightAmount() {
        String input = "4 4\n" + "5 20 6 9\n" + "8 1 1 7\n" + "2 5 3 3\n" + "11 2 22 0";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithOneToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(61);
    }

    @Test
    public void nonSquareRectangle_shouldReturnWithTheRightAmount() {
        String input = "4 3\n" + "4 2 1\n" + "1 4 1\n" + "6 10 8\n" + "0 4 0";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithOneToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(26);
    }

    @Test
    public void oneHeightRectangle_shouldReturnWithTheRightAmount() {
        String input = "1 4\n" + "5 20 6 9";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithOneToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(40);
    }

    @Test
    public void oneWidthRectangle_shouldReturnWithTheRightAmount() {
        String input = "4 1\n" + "9\n" + "6\n" + "20\n" + "5";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithOneToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(40);
    }

    @Test
    public void givenNullArray_shouldReturnWithMinusOne() {
        int[][] orchard = null;

        int result = maxPath.solveWithOneToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(-1);
    }

    @Test
    public void given1x1Array_shouldRestunrWithValidResult() {
        String input = "1 1\n" + "4\n";

        int[][] orchard = MatrixGenerator.createMatrix(input);

        int result = maxPath.solveWithOneToken(orchard);

        assertWithMessage("We have expected more apples").that(result).isEqualTo(4);
    }

}