import java.util.Arrays;

public class Problem3 {
    // TC : O(n)
    // SC : O(n)
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        int sum = result[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
            sum = sum + result[i];
        }
        return sum;
    }
}
