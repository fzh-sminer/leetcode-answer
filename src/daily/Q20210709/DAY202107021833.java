package daily.Q20210709;

import java.util.Arrays;

public class DAY202107021833 {

    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100001];

        for (int cost : costs) {
            freq[cost]++;
        }

        int count = 0;

        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curCount = Math.min(freq[i], coins / i);
                count += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(new DAY202107021833().maxIceCream(new int[] {1,3,2,4,1}, 7));
    }

}
