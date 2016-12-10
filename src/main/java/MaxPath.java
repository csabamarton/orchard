import java.util.stream.IntStream;

public class MaxPath {

	private int[][] array;
	private int[][] sumArray;
	private int height;
	private int width;

	int[] startPos;

	public int solveWithOneToken(int[][] apples)
	{
		initGlobalFields(apples);

		findMaxRoute();

		return sumArray[0][width - 1];
	}

	private void initGlobalFields(int[][] apples)
	{
		array = apples;
		width = array[0].length;
		height = array.length;

		startPos = new int[] { height - 2, 1 };
		sumArray = new int[height][width];
	}

	private void findMaxRoute()
	{
		sumArray = new int[height][width];

		sumArray[height - 1][0] += array[height - 1][0];

		IntStream.range(1, width).forEach(
				i -> sumArray[height - 1][i] = sumArray[height - 1][i - 1] + array[height - 1][i]);

		IntStream.range(1, height)
				.forEach(i -> sumArray[height - i - 1][0] = sumArray[height - i][0]
						+ array[height - i - 1][0]);

		while (startPos[1] < width) {
			updateSumValues();
			startPos[1] += 1;
		}
	}

	private void updateSumValues()
	{
		int xPos = startPos[1];
		int yPos = startPos[0];

		while (yPos >= 0) {
			updateInnerCells(xPos, yPos);
			yPos--;
		}
	}

	private void updateInnerCells(int xPos, int yPos)
	{
		int leftValue = sumArray[yPos][xPos - 1];
		int downValue = sumArray[yPos + 1][xPos];

		if (leftValue > downValue) {
			sumArray[yPos][xPos] = leftValue + array[yPos][xPos];
		} else {
			sumArray[yPos][xPos] = downValue + array[yPos][xPos];
		}
	}
}
