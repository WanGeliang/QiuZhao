package Algorithm.src.Divider;

/**
 * @author 万葛亮
 * @Date 2020 08 06 16:35
 * @GIRL friend 江珊
 */
public class Hanot {
    public static void main(String[] args) {
        HanioTa(4, 'A', 'B', 'C');
    }

    public static void HanioTa(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘: " + a + "->" + c);
        } else {
            HanioTa(num - 1, a, c, b);
            System.out.println("第" + num + "个盘: " + a + "->" + c);
            HanioTa(num - 1, b, a, c);
        }
    }
}
