package subject.year2023.month2.day0206;

import subject.MyClass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/06
 * Subject : 662. 二叉树最大宽度
 * Label :中等 ：树 ： 二叉树
 * Describe ：
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * <p>
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * <p>
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution5 {
    private int maxWidth;

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> levelHeads = new ArrayList<>(); // first nodes at each level;
        dfs(root, 1, 0, levelHeads);
        return maxWidth;
    }

    private void dfs(TreeNode node, int id, int depth, List<Integer> levelHeads) {
        if (depth >= levelHeads.size()) levelHeads.add(id);   // add first node
        maxWidth = Math.max(maxWidth, id - levelHeads.get(depth) + 1);

        if (node.left != null)
            dfs(node.left, id * 2, depth + 1, levelHeads);
        if (node.right != null)
            dfs(node.right, id * 2 + 1, depth + 1, levelHeads);
    }
}