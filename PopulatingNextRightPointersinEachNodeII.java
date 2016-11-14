import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Christina on 2/14/16.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null && root.right == null) return;
        Queue<TreeLinkNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeLinkNode node = que.poll();
            if (node.left != null) {
                que.add(node.left);
            }
            if (node.right != null) {
                que.add(node.right);
            }
            node.next = que.isEmpty() ? null : que.peek();

        }
        return;
    }

    public static void main(String[] arg) {
        PopulatingNextRightPointersinEachNodeII a = new PopulatingNextRightPointersinEachNodeII();
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.right = new TreeLinkNode(3);
        treeLinkNode.left.left = new TreeLinkNode(4);
        treeLinkNode.left.right = new TreeLinkNode(5);
        treeLinkNode.right.right = new TreeLinkNode(6);
        treeLinkNode.left.right.right = new TreeLinkNode(7);
        a.connect(treeLinkNode);
        while (treeLinkNode != null) {
            System.out.println(treeLinkNode.val);
            treeLinkNode = treeLinkNode.next;
        }
    }
}
