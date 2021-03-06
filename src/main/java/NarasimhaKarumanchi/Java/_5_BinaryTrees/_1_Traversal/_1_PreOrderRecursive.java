package NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class _1_PreOrderRecursive {

	public static void preOrder(BinaryTreeNode root) {
		if(root != null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode binaryTree = new BinaryTreeNode(50);
		binaryTree.left = new BinaryTreeNode(25);
		binaryTree.right = new BinaryTreeNode(75);
		
		binaryTree.left.left = new BinaryTreeNode(20);
		binaryTree.left.right = new BinaryTreeNode(35);
		
		binaryTree.right.left = new BinaryTreeNode(70);
		binaryTree.right.right = new BinaryTreeNode(80);
		
		binaryTree.left.left.left = new BinaryTreeNode(15);
		
		binaryTree.left.right.left = new BinaryTreeNode(30);
		binaryTree.left.right.right = new BinaryTreeNode(40);
		
		binaryTree.right.left = new BinaryTreeNode(70);
		binaryTree.right.right = new BinaryTreeNode(80);
		
		binaryTree.right.left.left = new BinaryTreeNode(60);
		binaryTree.right.left.right = new BinaryTreeNode(72);
		
		preOrder(binaryTree);
	}
}
