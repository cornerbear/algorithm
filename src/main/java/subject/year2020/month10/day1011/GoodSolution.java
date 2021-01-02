package subject.year2020.month10.day1011;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/11
 */
public class GoodSolution {
    public static boolean canPartition(int[] nums) {

        //数组的总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果不能被整除就说明不能平分开
        if (sum % 2 != 0) return false;
        //数组的一半,也就是背包的容量
        int capacity = sum / 2;
        boolean[] table = new boolean[capacity + 1];

        //临时的总和，【1】，【1,5】，【1,5,11】
        int tempSum = 0;
        
        System.out.print("   ");
        for (int i = 0; i <= capacity; i++) {
            System.out.print(i+"    "+"\t");
        }
        System.out.println();
        boolean[] tempTable = new boolean[capacity + 1];
        for (int i = 1; i <= nums.length; i++) {
            tempSum += nums[i-1];

            for (int j = capacity; j > 0; j--) {
                //如果临时总和大于j就不用再看了就是0
//                System.out.print(i+"--");
                if (tempSum >= j) {
                    //如果当前重量比背包的重量大，就不装
//                    System.out.print(j+"--");
                    if (nums[i-1] > j) {
//                        System.out.print(1+"--");
                        table[j] = table[j];
                    } else {
//                        System.out.print(2+"--");
                        table[j] = tempTable[j] || (nums[i-1] == j) || tempTable[j - nums[i-1]];
                    }
                }
//                System.out.println();
            }
            
            for (int j = 1; j <= capacity; j++) {
                tempTable[j] = table[j];
            }
            
            System.out.print(i+": ");
            for (int j = 0; j <= capacity; j++) {

                System.out.print(table[j]+"\t");
            }
            System.out.println();
        }

        return table[capacity];
    }

    public static void main(String[] args) {
        boolean b = GoodSolution.canPartition(new int[]{2,2,3,5});

        System.out.println(b);
    }
}
