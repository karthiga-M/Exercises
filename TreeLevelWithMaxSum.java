import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelWithMaxSum
{   

    public static void main(String[] args)
    {
        TreeLevelWithMaxSum t1 = new TreeLevelWithMaxSum();
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

        int levelsum = t1.levelSum(head);
        System.out.println("Maximum sum per level: " + levelsum);
    }

    private int levelSum(TreeNode cur)
    {
        if (cur == null)
            return 0;

        int result = cur.value;

        Queue<TreeNode> treeList = new LinkedList<TreeNode>();
        treeList.add(cur);
        while (!treeList.isEmpty())
        {
            int count = treeList.size();
            int sum = 0;
            while (count-- != 0)
            {
                TreeNode node = treeList.poll();

                sum += node.value;

                if (node.leftChild != null)
                    treeList.add(node.leftChild);
                if (node.rightChild != null)
                    treeList.add(node.rightChild);
            }
            result = maxSum(result, sum);
        }
        return result;
    }

    private int maxSum(int result, int sum)
    {
        return result >= sum ? result : sum;
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

