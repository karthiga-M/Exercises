public class TreeMaxSumOfNonAdjusantNodes
{
    int sum = 0;

    public static void main(String[] args)
    {
        TreeMaxSumOfNonAdjusantNodes t1 = new TreeMaxSumOfNonAdjusantNodes();
        TreeNode head = t1.createNode(1);
        head.leftChild = t1.createNode(2);
        head.leftChild.parent = head;
        head.rightChild = t1.createNode(3);
        head.rightChild.parent = head;
        head.leftChild.leftChild = t1.createNode(1);
        head.leftChild.leftChild.parent = head.leftChild;
        head.rightChild.leftChild = t1.createNode(4);
        head.rightChild.leftChild.parent = head.rightChild;
        head.rightChild.rightChild = t1.createNode(5);
        head.rightChild.rightChild.parent = head.rightChild;
        t1.sum = 1;
        t1.maximunsum(head, head);
        int sumWithHead = t1.sum;
        t1.sum = 0;
        t1.maximunsum(head, null);
        System.out.println("Sum of nodes without head :" + t1.sum);
        System.out.println("Sum of nodes with head :" + sumWithHead);
        t1.sum = sumWithHead >= t1.sum ? sumWithHead : t1.sum;
        System.out.println("Maximum sum : " + t1.sum);

    }

    private void maximunsum(TreeNode cur, TreeNode lastAdded)
    {
        if (cur == null)
            return;
        if (cur.parent != null && (lastAdded == null || !cur.parent.equals(lastAdded)))
        {
            sum += cur.value;
            lastAdded = cur;
        }
        if (cur.leftChild != null)
            maximunsum(cur.leftChild, lastAdded);
        if (cur.rightChild != null)
            maximunsum(cur.rightChild, lastAdded);

    }

    public TreeNode createNode(int data)
    {
        TreeNode treeNode = new TreeNode();
        treeNode.value = data;
        treeNode.leftChild = null;
        treeNode.rightChild = null;
        treeNode.parent = null;
        return treeNode;
    }
}

class TreeNode
{
    int value;
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode parent;
}
