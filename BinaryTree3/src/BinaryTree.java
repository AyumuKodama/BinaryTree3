
public class BinaryTree {
	
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void insert(int newRecord) {
		root = subtreeInsert(root, newRecord);
	}
	
	private Node subtreeInsert(Node topNode, int newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (newRecord < topNode.record) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}
	
	public void inOrder() {
		inOrderSubtree(root);
	}
	
	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}
	
	public void preOrder() {
		preOrderSubtree(root);
	}
	
	private void preOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);
			preOrderSubtree(topNode.right);
		}
	}
	
	public void postOrder() {
		postOrderSubtree(root);
	}
	
	private void postOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			postOrderSubtree(topNode.left);
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
		}
	}
	
	public int size() {
		return subtreeSize(root);
	}
	
	private int subtreeSize(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			return 1 + subtreeSize(topNode.left) + subtreeSize(topNode.right);
		}

	}
	
	public int maxDepth() {
		return subtreeMaxDepth(root);
	}
	
	private int subtreeMaxDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			int left = subtreeMaxDepth(topNode.left);
			int right = subtreeMaxDepth(topNode.right);
			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}
	
	public int minDepth() {
		return subtreeMinDepth(root);
	}
	
	private int subtreeMinDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			int left = subtreeMaxDepth(topNode.left);
			int right = subtreeMaxDepth(topNode.right);
			if (left > right) {
				return right + 1;
			} else {
				return left + 1;
			}
		}
	}
	
	public int countMatches(int key) {
		return subtreeCountMatches(root, key);
	}
	
	private int subtreeCountMatches(Node topNode, int key) {
		if (topNode == null) {
			return 0;
		} else {
			int num = 0;
			if (topNode.record == key) {
				num++;
			}
			int left = subtreeCountMatches(topNode.left, key);
			int right = subtreeCountMatches(topNode.right, key);
			return num + left + right;
			
		}
	}
	
	public int maxRecord() {
		return subtreeMaxRecord(root);
	}
	
	private int subtreeMaxRecord(Node topNode) {
		int max;
		if (topNode == null) {
			return Integer.MIN_VALUE;
		} else {
			max = topNode.record;
			int left = subtreeMaxRecord(topNode.left);
			int right = subtreeMaxRecord(topNode.right);
			int maximum;
			if (left < right) {
				maximum = right;
			} else {
				maximum = left;
			}
			if (max < maximum) {
				return maximum;
			} else {
				return max;
			}
		}
	}
	
	public int minRecord() {
		return subtreeMinRecord(root);
	}
	
	private int subtreeMinRecord(Node topNode) {
		int min;
		if (topNode == null) {
			return Integer.MAX_VALUE;
		} else {
			min = topNode.record;
			int left = subtreeMinRecord(topNode.left);
			int right = subtreeMinRecord(topNode.right);
			int minimum;
			if (left < right) {
				minimum = left;
			} else {
				minimum = right;
			}
			if (min < minimum) {
				return min;
			} else {
				return minimum;
			}
		}
	}
	
	public void removeNode(int key) {
		root = subtreeRemoveNode(root, key);
	}
	
	private Node subtreeRemoveNode(Node topNode, int key) {
		if (topNode == null) {
			return null;
		} else {
			if (topNode.record > key) {
				topNode.left = subtreeRemoveNode(topNode.left, key);
			} else if (topNode.record < key) {
				topNode.right = subtreeRemoveNode(topNode.right, key);
			} else {
				if (topNode.left != null && topNode.right != null) {
					int rightMin = subtreeMaxRecord(topNode.right);
					topNode.record = rightMin;
					topNode.right = subtreeRemoveNode(topNode.right, key);
				} else if (topNode.left == null && topNode.right == null) {
					topNode = null;
				} else if (topNode.left != null || topNode.right != null) {
					if (topNode.left == null) {
						topNode = topNode.right;
					} else if (topNode.right == null) {
						topNode = topNode.left;
					}
				}
			}
			return topNode;
		}
	}
}