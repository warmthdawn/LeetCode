package exam2;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    @FunctionalInterface
    public interface DirectionFunc {
        int apply(int v);
    }

    public static char reverse(char ch) {
        switch (ch) {
            case 'w':
                return 'b';
            case 'b':
                return 'w';
            case '-':
                return '-';
            default:
                throw new IllegalArgumentException("Invalid char");
        }
    }


    public static void searchAndReverse(boolean[][] lastReverse, boolean[][] currentReverse, char[][] chestBoard, int n, char next, int x, int y, DirectionFunc xFunc, DirectionFunc yFunc) {
        int i = xFunc.apply(xFunc.apply(x));
        int j = yFunc.apply(yFunc.apply(y));
        int len = 1;
        int further = 0;
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (chestBoard[i][j] == next) {
                further = len;
            }
            i = xFunc.apply(i);
            j = yFunc.apply(j);
            len++;
        }
        if (further == 0) {
            return;
        }

        reverse(lastReverse, currentReverse, chestBoard, x, y, further, xFunc, yFunc);
    }

    public static void reverse(boolean[][] lastReverse, boolean[][] currentReverse, char[][] chestBoard, int x, int y, int len, DirectionFunc xFunc, DirectionFunc yFunc) {
        for (int i = 0; i < len; i++) {
            x = xFunc.apply(x);
            y = yFunc.apply(y);
            if (!lastReverse[x][y]) {
                chestBoard[x][y] = reverse(chestBoard[x][y]);
                currentReverse[x][y] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int q = 0; q < T; q++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] chestBoard = new char[n][];
            for (int i = 0; i < n; i++) {
                String row = sc.next();
                chestBoard[i] = row.toCharArray();
            }

            boolean[][] lastReverse = new boolean[n][n];
            boolean[][] currentReverse = new boolean[n][n];
            char current = 'w';
            for (int r = 0; r < m; r++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                if (chestBoard[x][y] != '-') {
                    throw new IllegalArgumentException("Has placed!");
                }

                char next = reverse(current);

                chestBoard[x][y] = current;

                searchAndReverse(lastReverse, currentReverse, chestBoard, n, next, x, y, a -> a + 1, b -> b);
                searchAndReverse(lastReverse, currentReverse, chestBoard, n, next, x, y, a -> a - 1, b -> b);
                searchAndReverse(lastReverse, currentReverse, chestBoard, n, next, x, y, a -> a, b -> b + 1);
                searchAndReverse(lastReverse, currentReverse, chestBoard, n, next, x, y, a -> a, b -> b + 1);
                searchAndReverse(lastReverse, currentReverse, chestBoard, n, next, x, y, a -> a + 1, b -> b + 1);
                searchAndReverse(lastReverse, currentReverse, chestBoard, n, next, x, y, a -> a + 1, b -> b - 1);
                searchAndReverse(lastReverse, currentReverse, chestBoard, n, next, x, y, a -> a - 1, b -> b + 1);
                searchAndReverse(lastReverse, currentReverse, chestBoard, n, next, x, y, a -> a - 1, b -> b - 1);

                boolean[][] tmp = lastReverse;
                lastReverse = currentReverse;
                currentReverse = tmp;
                for (boolean[] booleans : currentReverse) {
                    Arrays.fill(booleans, false);
                }
                current = next;

            }

            for (char[] chars : chestBoard) {
                for (char ch : chars) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            System.out.println("END");

        }
    }
}
