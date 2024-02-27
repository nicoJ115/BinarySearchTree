class TreeNode {
    int item;
    TreeNode left, right;

    public TreeNode(int item) {
        this.item = item;
        this.left = null;
        this.right = null;
    }
}

class BSTree {
    private TreeNode root;

    public BSTree() {
        this.root = null;
    }

    public void insert(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
        } else {
            this._insert(value, this.root);
        }
    }

    private void _insert(int value, TreeNode currNode) {
        if (value < currNode.item) {
            if (currNode.left == null) {
                currNode.left = new TreeNode(value);
            } else {
                this._insert(value, currNode.left);
            }
        } else if (value > currNode.item) {
            if (currNode.right == null) {
                currNode.right = new TreeNode(value);
            } else {
                this._insert(value, currNode.right);
            }
        } // Assuming no else case for duplicate values as per your code
    }

    public boolean find(int value) {
        return this._find(value, this.root) != null;
    }

    private TreeNode _find(int value, TreeNode currNode) {
        if (currNode == null) {
            return null;
        }
        if (value == currNode.item) {
            return currNode;
        } else if (value < currNode.item) {
            return this._find(value, currNode.left);
        } else {
            return this._find(value, currNode.right);
        }
    }

    public boolean search(int value) {
        return this._search(value, this.root) != null;
    }

    private TreeNode _search(int value, TreeNode currNode) {
        if (currNode == null) {
            return null;
        }
        if (value == currNode.item) {
            return currNode;
        } else if (value < currNode.item) {
            return this._search(value, currNode.left);
        } else {
            return this._search(value, currNode.right);
        }
    }
}

// Main class to test BSTree functionality
public class Main {
    public static void main(String[] args) {
        BSTree bst = new BSTree();

        // Inserting values
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Finding values
        System.out.println("Find 30: " + bst.find(30)); // Should return true
        System.out.println("Find 70: " + bst.find(70)); // Should return true
        System.out.println("Find 100: " + bst.find(100)); // Should return false

        // Searching values
        System.out.println("Search 60: " + bst.search(60)); // Should return true
        System.out.println("Search 80: " + bst.search(80)); // Should return true
        System.out.println("Search 15: " + bst.search(15)); // Should return false

        // Trying to insert a value that already exists
        System.out.println("Inserting 30 again:");
        bst.insert(30); // Depending on implementation, might print "Value already in tree!"
    }
}


