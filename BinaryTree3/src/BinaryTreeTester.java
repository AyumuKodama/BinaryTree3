
/**
 * This is a tester program for the BinaryTree class
 * @author Michael Ida
 *
 */
public class BinaryTreeTester {
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		int[] inputData = {20, 15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
		
		for (int elem : inputData) {
			tree.insert(elem);
		}
		
		System.out.println("In-Order Traversal");
		tree.inOrder();
		System.out.println();
		// should be: -150, -5, 0, 12, 15, 20, 20, 25, 100, 126, 200, 1000
		
		System.out.println("Pre-Order Traversal");
		tree.preOrder();
		System.out.println();
		// should be: 20, 15, -5, -150, 0, 12, 200, 25, 20, 100, 126, 1000
		
		System.out.println("Post-Order Traversal");
		tree.postOrder();
		System.out.println();
		// should be: -150, 12, 0, -5, 15, 20, 126, 100, 25, 1000, 200, 20
		
		System.out.println("Size: " + tree.size());
		// should be: 12
		
		System.out.println();
		//should be: 5
		
		BinaryTree tree1 = new BinaryTree();
		int[] inputData1 = {3, 0, 7, 4, 4, 10, 29, 54, -32, 4, -3};
		
		for (int elem : inputData1) {
			tree1.insert(elem);
		}
			
			System.out.println("In-Order Traversal");
			tree1.inOrder();
			System.out.println();
			// should be: -32, -3, 0, 3, 4, 4, 4, 7, 10, 29, 54
			
			System.out.println("Pre-Order Traversal");
			tree1.preOrder();
			System.out.println();
			// should be: 3, 0, -32, -3, 7, 4, 4, 4, 10, 29, 54
			
			System.out.println("Post-Order Traversal");
			tree1.postOrder();
			System.out.println();
			// should be: -3, -32, 0, 4, 4, 4, 54, 29, 10, 7, 3
			
			System.out.println("Size: " + tree1.size());
			System.out.println();
			// should be: 11
			
			System.out.println("Maximum Depth: " + tree1.maxDepth());
			System.out.println();
			//should be: 5
			
			System.out.println("Minimum Depth: " + tree1.minDepth());
			System.out.println();
			//should be: 4
			
			System.out.println("Largest number: " + tree1.maxRecord());
			System.out.println();
			//should be: 54
			
			System.out.println("Smallest number: " + tree1.minRecord());
			System.out.println();
			//should be: -32
			
			System.out.println("Number of 4s: " + tree1.countMatches(4));
			tree1.removeNode(7);
			System.out.println();
			//should be: 3
			
			System.out.println("The number 7 has been removed from the table.");
			System.out.println();
			
			System.out.println("In-Order Traversal (after removal)");
			tree1.inOrder();
			System.out.println();
			// should be: -32, -3, 0, 3, 4, 4, 4, 10, 29, 54
			
			System.out.println("Pre-Order Traversal (after removal)");
			tree1.preOrder();
			System.out.println();
			// should be: 3, 0, -32, -3, 4, 4, 4, 10, 29, 54
			
			System.out.println("Post-Order Traversal (after removal)");
			tree1.postOrder();
			System.out.println();
			// should be: -3, -32, 0, 4, 4, 4, 54, 29, 10, 3
			
			
	}
}