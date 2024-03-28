package CodingProblems;

//An island is in the form of a square matrix, and the person is standing inside the matrix.
// The person can move one step in any direction, left, right, top, and down in the matrix.
// Write a method which calculates the probability that the person is alive after walking n steps
// on the island, provided that the person dies on stepping outside the matrix. The probability is
// equal to the number of routes where the person is still alive at the end, divided by the total
// number of routes.
public class IslandProbability {

    public static double calculateSurvivalProbability(int n, int[][] island, int row, int col) {
        if (row < 0 || col < 0 || row >= island.length || col >= island[0].length) {
            return 0.0;
        }
        if (n == 0) {
            return 1.0;
        }

        double probability = 0.0;
        probability += 0.25 * calculateSurvivalProbability(n - 1, island, row - 1, col); //up
        probability += 0.25 * calculateSurvivalProbability(n - 1, island, row + 1, col); // Down
        probability += 0.25 * calculateSurvivalProbability(n - 1, island, row, col - 1); // Left
        probability += 0.25 * calculateSurvivalProbability(n - 1, island, row, col + 1); // Right

        return probability;
    }

    public static void main(String[] args) {
        //for a 2x2 matrix; the starting coordinates is (0,0) with total nr of steps : 1
        int[][] island = {
                {1, 1},
                {1, 1}
        };

        // island.length will return 2 since we have two rows
        // island[0].length will return 2 since on the first row [0] we have two elements

        int startRow = 0;
        int startCol = 0;
        int steps = 1;

        double probability = calculateSurvivalProbability(steps, island, startRow, startCol);
    }

}
