import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Christina on 1/16/16.
 */
public class PopulatingNextRightPointersinEachNode {
    /**
     * 不指向下一行
     * */
    //level
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeLinkNode temp = que.poll();
                if (temp.left != null) que.add(temp.left);
                if (temp.right != null) que.add(temp.right);
                temp.next = size == 0 ? null : que.peek();
            }
        }
    }

    public static void main(String[] arg) {
        PopulatingNextRightPointersinEachNode a = new PopulatingNextRightPointersinEachNode();
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.right = new TreeLinkNode(3);
        a.connect(treeLinkNode);
        System.out.println();
    }


}
