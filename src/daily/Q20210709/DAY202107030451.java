package daily.Q20210709;

import java.util.*;

public class DAY202107030451 {

    public String frequencySort(String s) {
        int n = s.length();
        int[] map = new int[127];
        byte x;
        byte[] bs = s.getBytes();

        for (int i = 0; i < n; ) {
            x = bs[i++];
            map[x] += 256;
        }

        n = 0;
        for (int i = 32; i < 127; ++i) {
            if (map[i] != 0) {
                map[n++] = i + map[i];
            }
        }

        Arrays.sort(map, 0, n);

        for (int i, j = 0; 0 != n--; ) {
            for (x = (byte) map[n], i = map[n] >> 8; 0 != i--; ) {
                bs[j++] = x;
            }
        }
        return new String(bs);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("aAtree".getBytes()));
    }
}
