package 老虎证券;

/**
 * @author Geliang
 * @date 2021-08-15
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {

    public int computeN(int maxValue) {
        if (maxValue > Integer.MAX_VALUE) {
            while (maxValue > Integer.MAX_VALUE) {
                maxValue /= 10;
            }
        }
        int sum = 0;
        int f = 1;
        int e = 1;
        int bit = 1;
        while (maxValue > 0) {
            int now = maxValue % 10;
            maxValue /= 10;
            if (now > 1) {
                sum += (maxValue + 1) * bit;
            } else if (now == 1) {
                sum += maxValue * bit + e;
            } else {
                sum += maxValue * bit;
            }
            e += now * bit;
            bit *= 10;
        }
        return sum;
    }
}
