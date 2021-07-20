

public class Day19_LCAofBST {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public static TreeNode lowestCommonAncestor(
            TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr!=null){
            if(p.val<= curr.val&&q.val>=curr.val || q.val<= curr.val&&p.val>=curr.val)
                return curr;
            else if(p.val<= curr.val&&q.val<=curr.val)
                curr=curr.left;
            else
                curr=curr.right;
        }
        return null;
    }
}
