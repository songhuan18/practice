import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Author sh
 * Date 2019-08-11 16:27
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[]  val = in.nextLine().split(",");
            int[] x = new int[val.length];
            for (int i = 0; i < val.length; i++) {
                x[i] = Integer.parseInt(val[i]);
            }
            System.out.println(maximumGap(x));
        }

    }

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            list.add(nums[i]);
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        int max = 0;
        for (int i = 0,len = collect.size(); i < len; i++) {
            if (i < len - 1) {
                int f = collect.get(i);
                int s = collect.get(i + 1);
                int c = s - f;
                if (max < c) {
                    max = c;
                }
            }

        }
        return max;
    }
}
