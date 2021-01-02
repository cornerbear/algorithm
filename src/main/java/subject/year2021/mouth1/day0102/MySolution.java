package subject.year2021.mouth1.day0102;

import java.util.LinkedList;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/2
 */
public class MySolution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length < 2) return nums;

        LinkedList<Integer> queue = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            
            queue.addLast(i);
            
            if(queue.peek() <= i - k){
                queue.poll();
            }


            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        
        
        return new int[]{};

    }
}
