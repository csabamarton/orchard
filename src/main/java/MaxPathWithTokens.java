import java.util.stream.IntStream;

public class MaxPathWithTokens {
    private int[][] array;
    private int[][] sumArray;
    private int[][] tokenColumn;
    private int width;
    private int height;
    private int[] startPos;

    public int solveWithTwoToken(int[][] apples)
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

        startPos = new int[] { height - 1, 0};
        sumArray = new int[height][width];

        tokenColumn = new int[height][2];

        IntStream.range(0, height).forEach(row -> tokenColumn[row] = new int[]{-1, -1});
    }

    private void findMaxRoute()
    {
        sumArray = new int[height][width];

        sumArray[height - 1][0] += array[height - 1][0] * 2;

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
        int value = array[yPos][xPos];
        int[] tokens;
        if(xPos == 0 && yPos == height - 1) {
            tokenColumn[yPos] = new int[]{-1, value};
            sumArray[0][0] = value * 2;

            return;
        }

        int[] newLeftTokens = new int[2];

        int newValueFromLeft = 0;
        if(xPos > 0) {
            tokens = tokenColumn[yPos];
            int leftMinToken;

            if(Math.min(tokens[0], tokens[1]) == -1) {
                leftMinToken = 0;
            } else {
                leftMinToken = tokens[0];
            }

            if (value > leftMinToken) {
                newValueFromLeft = value * 2 + sumArray[yPos][xPos - 1] - leftMinToken;
                if (value > tokens[1]) {
                    newLeftTokens[0] = tokens[1];
                    newLeftTokens[1] = value;
                } else {
                    newLeftTokens[0] = value;
                    newLeftTokens[1] = tokens[1];
                }
            } else {
                newValueFromLeft = value + sumArray[yPos][xPos - 1];
                newLeftTokens = new int[]{tokens[0], tokens[1]};
            }
        }

        int[] newDownTokens = new int[2];
        int newValueFromDown = 0;

        if (yPos < height - 1) {
            tokens = tokenColumn[yPos + 1];
            int downMinToken;

            if(Math.min(tokens[0], tokens[1]) == -1) {
                downMinToken = 0;
            } else {
                downMinToken = tokens[0];
            }
            if (value > downMinToken) {
                newValueFromDown = value * 2 + sumArray[yPos + 1][xPos] - downMinToken;
                if (value > tokens[1]) {
                    newDownTokens[0] = tokens[1];
                    newDownTokens[1] = value;
                } else {
                    newDownTokens[0] = value;
                    newDownTokens[1] = tokens[1];
                }
            } else {
                newValueFromDown = value + sumArray[yPos + 1][xPos];

                newDownTokens = new int[]{tokens[0], tokens[1]};
            }
        }

        if(newValueFromLeft > newValueFromDown) {
            tokenColumn[yPos] = newLeftTokens;
            sumArray[yPos][xPos] = newValueFromLeft;
        } else {
            tokenColumn[yPos] = newDownTokens;
            sumArray[yPos][xPos] = newValueFromDown;
        }
    }
}
