package subject.year2020.month11.day1124;

import year2020.MyClass.TreeNode;

/**
 * Author : zhangxiaojian
 * Date : 2020/11/24
 */
public class Solution {
    public int countNodes(TreeNode root) {
        return countFun(root,0);
    }
    public int countFun(TreeNode root,int num){
        if(null == root)
            return num;
        int leftCount = countFun(root.left,num);
        int rightCount = countFun(root.right, num);
        return leftCount + rightCount;
    }
    
}
