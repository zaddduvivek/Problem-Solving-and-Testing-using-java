mport java.util.*;

public class Solution {
    public static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length, n = matrix[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();
            int top = layer, left = layer, bottom = m - layer - 1, right = n - layer - 1;

            for (int j = left; j <= right; j++) elements.add(matrix[top][j]);
            for (int i = top + 1; i <= bottom; i++) elements.add(matrix[i][right]);
            for (int j = right - 1; j >= left; j--) elements.add(matrix[bottom][j]);
            for (int i = bottom - 1; i > top; i--) elements.add(matrix[i][left]);

            int len = elements.size();
            int rot = r % len;
            List<Integer> rotated = new ArrayList<>();
            rotated.addAll(elements.subList(rot, len));
            rotated.addAll(elements.subList(0, rot));

            int idx = 0;
            for (int j = left; j <= right; j++) matrix[top][j] = rotated.get(idx++);
            for (int i = top + 1; i <= bottom; i++) matrix[i][right] = rotated.get(idx++);
            for (int j = right - 1; j >= left; j--) matrix[bottom][j] = rotated.get(idx++);
            for (int i = bottom - 1; i > top; i--) matrix[i][left] = rotated.get(idx++);
        }

        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + (j == row.length - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), r = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        matrixRotation(matrix, r);
    }
}
