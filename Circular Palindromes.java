import java.io.*;
import java.util.*;

public class Main {

    static int[] manacherOdd(String s) {
        int n = s.length();
        int[] d1 = new int[n];

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);

            while (i - k >= 0 && i + k < n &&
                    s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }

            d1[i] = k--;

            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }

        return d1;
    }

    
    static int[] manacherEven(String s) {
        int n = s.length();
        int[] d2 = new int[n];

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);

            while (i - k - 1 >= 0 && i + k < n &&
                    s.charAt(i - k - 1) == s.charAt(i + k)) {
                k++;
            }

            d2[i] = k--;

            if (i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }

        return d2;
    }

    static class SparseTable {
        int[][] st;
        int[] log;

        SparseTable(int[] a) {
            int n = a.length;

            log = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }

            int levels = log[n] + 1;
            st = new int[levels][n];

            System.arraycopy(a, 0, st[0], 0, n);

            for (int k = 1; k < levels; k++) {
                int len = 1 << k;
                int half = len >> 1;

                for (int i = 0; i + len <= n; i++) {
                    st[k][i] = Math.max(
                            st[k - 1][i],
                            st[k - 1][i + half]
                    );
                }
            }
        }

        int query(int l, int r) {
            if (l > r) return 0;

            int k = log[r - l + 1];

            return Math.max(
                    st[k][l],
                    st[k][r - (1 << k) + 1]
            );
        }
    }

    
    static boolean existsOdd(
            SparseTable sparse,
            int L,
            int R,
            int radius
    ) {
        int leftCenter = L + radius - 1;
        int rightCenter = R - radius + 1;

        if (leftCenter > rightCenter) {
            return false;
        }

        return sparse.query(leftCenter, rightCenter) >= radius;
    }

   
    static boolean existsEven(
            SparseTable sparse,
            int L,
            int R,
            int radius
    ) {
        if (radius == 0) {
            return true;
        }

        int leftCenter = L + radius;
        int rightCenter = R - radius + 1;

        if (leftCenter > rightCenter) {
            return false;
        }

        return sparse.query(leftCenter, rightCenter) >= radius;
    }

    static int[] solve(String s) {
        int n = s.length();

        String doubled = s + s;

        int[] odd = manacherOdd(doubled);
        int[] even = manacherEven(doubled);

        
        SparseTable oddTable = new SparseTable(odd);
        SparseTable evenTable = new SparseTable(even);

        int[] answer = new int[n];

        for (int start = 0; start < n; start++) {
            int L = start;
            int R = start + n - 1;

           
            int lo = 1;
            int hi = (n + 1) / 2;

            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;

                if (existsOdd(oddTable, L, R, mid)) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }

            int best = 2 * lo - 1;

            
            lo = 0;
            hi = n / 2;

            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;

                if (existsEven(evenTable, L, R, mid)) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }

            best = Math.max(best, 2 * lo);

            answer[start] = best;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        int[] answer = solve(s);

        StringBuilder out = new StringBuilder();

        for (int x : answer) {
            out.append(x).append('\n');
        }

        System.out.print(out);
    }
}
