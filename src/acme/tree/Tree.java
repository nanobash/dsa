package acme.tree;

public class Tree {
    protected TreeNode root;

    public void insert(int data) {
        if (this.root == null) {
            this.root = new TreeNode(data);
        } else {
            this.root.insert(data);
        }
    }

    public TreeNode get(int value) {
        if (this.root != null) {
            return this.root.get(value);
        }

        return null;
    }

    public void delete(int value) {
        this.delete(this.root, value);
    }

    private TreeNode delete(TreeNode subTreeNode, int value) {
        if (subTreeNode == null) {
            return null;
        }

        if (value < subTreeNode.getData()) {
            subTreeNode.setLeftChild(this.delete(subTreeNode.getLeftChild(), value));
        } else if (value > subTreeNode.getData()) {
            subTreeNode.setRightChild(this.delete(subTreeNode.getRightChild(), value));
        } else {
            // Case 1 and 2: node either has 0 or 1 child
            if (subTreeNode.getLeftChild() == null) {
                return subTreeNode.getRightChild();
            } else if (subTreeNode.getRightChild() == null) {
                return subTreeNode.getLeftChild();
            }

            // Case 3: node to delete has 2 children

            // Replace the value in the subTreeRoot node with the smallest value from the right subTree
            subTreeNode.setData(subTreeNode.getRightChild().getMin().getData());

            // Delete the node that has the smallest value in the right subTree
            subTreeNode.setRightChild(this.delete(subTreeNode.getRightChild(), subTreeNode.getData()));
        }

        return subTreeNode;
    }

    public int getHeight() {
        return this.root.getHeight(this.root);
    }

    public TreeNode getMin() {
        if (this.root != null) {
            return this.root.getMin();
        }

        return null;
    }

    public TreeNode getMax() {
        if (this.root != null) {
            return this.root.getMax();
        }

        return null;
    }

    public void traverseLevel() {
        if (this.root != null) {
            this.root.traverseLevel(this.root);
        }
    }

    public void traversePreOrder() {
        if (this.root != null) {
            this.root.traversePreOrder();
        }
    }

    public void traverseInOrder() {
        if (this.root != null) {
            this.root.traverseInOrder();
        }
    }

    public void traversePostOrder() {
        if (this.root != null) {
            this.root.traversePostOrder();
        }
    }
}
