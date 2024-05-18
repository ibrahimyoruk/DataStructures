import java.util.LinkedList;
import java.util.Queue;

public class binarySearchTree {
    binaryNode root;
    binarySearchTree() {
        root = null;
    }

    //insert
    private binaryNode insert(binaryNode currentNode, int value) {
        if (currentNode == null) {
            binaryNode newNode = new binaryNode();
            newNode.value = value;
            //System.out.println("the value inserted");
            return newNode;
        }else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left , value);
            return currentNode;
        }else{
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }

    }
    void insert(int value) {
        root = insert(root,value);
    }
    //preorder
     public void preOrder(binaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + "--");
        preOrder(node.left);
        preOrder(node.right);
    }
    //inorder
    public void inOrder(binaryNode node) {
        if (node==null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    //postOrder
    public void postOrder(binaryNode node) {
        if (node==null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
    //levelorder
    void levelOrder() {
        Queue<binaryNode> queue = new LinkedList<binaryNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            binaryNode presentNode = queue.remove();
            System.out.print(presentNode.value+ " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }
    binaryNode search(binaryNode node , int value) {
        if (node == null) {
            System.out.println("the value " + value+" is not found");
            return null;
        }else if (node.value == value) {
            System.out.println("the value " + value+" isfound");
            return node;
        } else if (value < node.value) {
            return search(node.left , value);
            
        }else {
            return search(node.right , value);
        }

    }

}
