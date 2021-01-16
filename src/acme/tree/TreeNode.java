package acme.tree;

public class TreeNode {
    protected int data;

    protected TreeNode leftChild;

    protected TreeNode rightChild;

    public void insert(int value) {
        if (this.data == value) {
            return;
        }

        if (value < this.data) {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(value);
            } else {
                this.leftChild.insert(value);
            }
        } else {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(value);
            } else {
                this.rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value) {
        if (this.data == value) {
            return this;
        }

        if (value < this.data) {
            if (this.leftChild != null) {
                return this.leftChild.get(value);
            }
        } else {
            if (this.rightChild != null) {
                return this.rightChild.get(value);
            }
        }

        return null;
    }

    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftHeight = this.getHeight(treeNode.leftChild);
        int rightHeight = this.getHeight(treeNode.rightChild);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    public TreeNode getMin() {
        if (this.leftChild != null) {
            return this.leftChild.getMin();
        }

        return this;
    }

    public TreeNode getMax() {
        if (this.rightChild != null) {
            return this.rightChild.getMax();
        }

        return this;
    }

    public void traversePreOrder() {
        System.out.print("Data = " + this.data + ", ");

        if (this.leftChild != null) {
            leftChild.traversePreOrder();
        }

        if (this.rightChild != null) {
            this.rightChild.traversePreOrder();
        }
    }

    public void traverseInOrder() {
        if (this.leftChild != null) {
            leftChild.traverseInOrder();
        }

        System.out.print("Data = " + this.data + ", ");

        if (this.rightChild != null) {
            this.rightChild.traverseInOrder();
        }
    }

    public void traversePostOrder() {
        if (this.leftChild != null) {
            leftChild.traversePostOrder();
        }

        if (this.rightChild != null) {
            this.rightChild.traversePostOrder();
        }

        System.out.print("Data = " + this.data + ", ");
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Data: " + this.data;
    }

    public void traverseLevel(TreeNode treeNode) {
        int treeHeight = this.getHeight(this);

        for (int i = 1; i <= treeHeight; ++i) {
            traverseLevel(treeNode, i);
        }
    }

    private void traverseLevel(TreeNode treeNode, int level) {
        if (treeNode == null) {
            return;
        }

        if (level == 1) {
            System.out.print("Data = " + treeNode.data + ", ");
        } else {
            this.traverseLevel(treeNode.leftChild, level - 1);
            this.traverseLevel(treeNode.rightChild, level - 1);
        }
    }
}
