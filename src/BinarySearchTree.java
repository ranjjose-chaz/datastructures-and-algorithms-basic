import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {

    TreeNode root;


    public BinarySearchTree(int data){
        root = new TreeNode(data);
    }

    public void insert(int data){
        if( root == null)
            root = new TreeNode(data);
        else
            insertNode(root, data);
    }

    public void insertNode(TreeNode node, int data){

        if(data <= node.getData()){
            if (node.getLeft() != null)
                insertNode(node.getLeft(), data);
            else
                node.setLeft(new TreeNode(data));

        } else {
            if (node.getRight() != null)
                insertNode(node.getRight(), data);
            else
                node.setRight(new TreeNode(data));
        }


    }

    public void inorder(TreeNode node){
        if(node != null) {

            if (node.getLeft() != null)
                inorder(node.getLeft());

            System.out.print(node.getData() + ", ");

            if (node.getRight() != null)
                inorder(node.getRight());

        }
    }

    public void preorder(TreeNode node){

        if(node!= null) {

            System.out.print(node.getData()+", ");

            if (node.getLeft() != null)
                preorder(node.getLeft());
            if (node.getRight() != null)
                preorder(node.getRight());
        }
    }

    public void postorder(TreeNode node){

        if(node!= null) {

            if (node.getLeft() != null)
                postorder(node.getLeft());
            if (node.getRight() != null)
                postorder(node.getRight());

            System.out.print(node.getData()+", ");
        }
    }

    public void breadthFirstSearch(){
        if(root == null){
            return;
        }

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0) {
            queue = breadthFirstSearch(queue);
            System.out.println();
        }

    }

    private List<TreeNode> breadthFirstSearch(List<TreeNode> queue) {

        List<TreeNode> newQueue = new ArrayList<>();
        for(TreeNode node : queue) {
            System.out.print(node.getData() + " ");

            if (node.getLeft() != null)
                newQueue.add(node.getLeft());

            if (node.getRight() != null)
                newQueue.add(node.getRight());
        }

        return newQueue;


    }

    private TreeNode largest(){
        TreeNode node = root;
        return _largest(node);
    }

    private TreeNode _largest(TreeNode node) {

        TreeNode tmp = null;
        if(node.getRight() != null){
            tmp =  _largest(node.getRight());
            return tmp;
        }
        return node;

    }






    private TreeNode smallest_old(){
        TreeNode node = root;
        return _smallest(node);
    }

    private TreeNode _smallest(TreeNode node) {

        TreeNode tmp = null;
        if(node.getLeft() != null){
            tmp =  _smallest(node.getLeft());
            return tmp;
        }
        return node;

    }

    private TreeNode largestLeftChild(TreeNode node) {
        if (node.getLeft() != null){
            return _largest(node.getLeft());
        }
        return null;
    }

    private TreeNode[] find(int data) {
        System.out.println("\n\tFinding data -> "+data);
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (queue.size() != 0) {
            queue = customBfs(queue, data);
            if(queue.size()== 2 && queue.get(1).getData() == data){
                return new TreeNode[] {queue.get(0), queue.get(queue.size()-1)};
            }
        }
        return null;
    }

    private List<TreeNode> bfs(List<TreeNode> queue, int data) {
        List<TreeNode> newQueue = new ArrayList<>();
        for(TreeNode node: queue){

            TreeNode child = null;

            child = node.getLeft();
            if(child!= null) {
                newQueue.add(child);
                if (child.getData() == data)
                    return newQueue;
            }

            child = node.getRight();
            if(child != null) {
                newQueue.add(child);
                if (child.getData() == data)
                    return newQueue;
            }
        }

        return newQueue;
    }

    private List<TreeNode> customBfs(List<TreeNode> queue, int data) {
        List<TreeNode> newQueue = new ArrayList<>();
        for(TreeNode node: queue){

            if(node.getData() == data)
                return Arrays.asList(new TreeNode[] {null, node});

            TreeNode child = node.getLeft();
            if(child!= null) {
                if (child.getData() == data)
                    return Arrays.asList(new TreeNode[] {node, child});

                newQueue.add(child);
            }

            child = node.getRight();
            if(child != null) {
                if (child.getData() == data)
                    return Arrays.asList(new TreeNode[] {node, child});

                newQueue.add(child);
            }
        }

        return newQueue;
    }


    public void smallest(){
        System.out.println(smallest(root));
    }

    public TreeNode smallest(TreeNode node) {
        return (node.getLeft() != null)? smallest(node.getLeft()):node;

    }

    public TreeNode getNode(int data){
        System.out.println("finding node -> "+data);
        return getNode(root, data);
    }

    public TreeNode[] getNodeAndParent(int data){
        System.out.println("finding node -> "+data);
        return getNodeAndParent(root, data);
    }

    private TreeNode getNode(TreeNode node, int data) {
        System.out.print(" -- "+(node == null ? null : node.getData()));
        if(node == null)
            return null;
        else if(data < node.getData())
            return getNode(node.getLeft(), data);
        else if (data > node.getData())
            return getNode(node.getRight(), data);
        else
            return node;


    }

    private TreeNode[] getNodeAndParent(TreeNode node, int data) {
        if(node == null)
            return null;
        else if(data < node.getData()) {
            TreeNode[] tmp = getNodeAndParent(node.getLeft(), data);
            if(tmp!= null && tmp[0] == null)
                return new TreeNode[] {node, tmp[1]};
            return tmp;
        }
        else if (data > node.getData()) {
            TreeNode[] tmp = getNodeAndParent(node.getRight(), data);
            if(tmp!= null && tmp[0] == null)
                return new TreeNode[] {node, tmp[1]};
            return tmp;

        } else
            return new TreeNode[] {null, node};

    }

    public TreeNode getParent(int data){
        System.out.println("Parent of -> " + data);
        return getParent(root, data, null);

    }

    public TreeNode getParent(TreeNode node, int data, TreeNode parent) {
        if(node == null)
            return null;
        else if(data < node.getData()){
            return getParent(node.getLeft(), data, node);
        } else if(data > node.getData()){
            return getParent(node.getRight(), data, node);
        } else {
            return parent;
        }

    }


    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree(50);
        TreeNode root = tree.root;

         /*
        root.setLeft(new TreeNode(25));
        root.getLeft().setLeft(new TreeNode(13));
        root.getLeft().setRight(new TreeNode(38));

        root.setRight(new TreeNode(75));
        root.getRight().setLeft(new TreeNode(68));
        root.getRight().setRight(new TreeNode(88));
        root.getRight().getRight().setRight(new TreeNode(100));
        root.getRight().getRight().setLeft(new TreeNode(78));
        */


         tree.insert(25);
         tree.insert(13);
         tree.insert(38);
         tree.insert(40);
         tree.insert(45);
         tree.insert(49);
         tree.insert(78);
         tree.insert(68);
         tree.insert(88);
         tree.insert(100);
         tree.insert(75);
         tree.insert(70);
         tree.insert(69);
         tree.insert(10);
         tree.insert(8);
         tree.insert(5);
         tree.insert(3);
         tree.insert(47);
         tree.insert(46);
         tree.insert(48);


         /*
        tree.insert(75);
        //tree.insert(25);
        tree.insert(100);
        tree.insert(88);
        tree.insert(150);
        tree.insert(200);
        tree.insert(250);
        tree.insert(300);

        */
        System.out.println("\n\nIn order");
        tree.inorder(root);
        //System.out.println("\n\nPre order");
        //tree.preorder(root);
        //System.out.println("\n\nPost order");
        //tree.postorder(root);



        System.out.println("\n\nBFS traversal");
        tree.breadthFirstSearch();

         /*

        System.out.println(tree.largest());
        System.out.println(tree.smallest());*/

        System.out.println("\n\tLargest Left Child\n");
        System.out.println(tree.largestLeftChild(tree.root));

        System.out.println("\nSmallest Element");
        tree.smallest();

        /*System.out.println("\n"+tree.getNode(50));
        System.out.println("\n"+tree.getNode(8));
        System.out.println("\n"+tree.getNode(3));
        System.out.println("\n"+tree.getNode(49));
        System.out.println("\n"+tree.getNode(100));
        System.out.println("\n"+tree.getNode(78));
        System.out.println("\n"+tree.getNode(101));*/

        /*printNodeAndParent(tree.getNodeAndParent(50));
        printNodeAndParent(tree.getNodeAndParent(8));
        printNodeAndParent(tree.getNodeAndParent(3));
        printNodeAndParent(tree.getNodeAndParent(49));
        printNodeAndParent(tree.getNodeAndParent(100));
        printNodeAndParent(tree.getNodeAndParent(78));
        printNodeAndParent(tree.getNodeAndParent(101));
        */


        System.out.println(tree.getParent(50));
        System.out.println(tree.getParent(8));
        System.out.println(tree.getParent(3));
        System.out.println(tree.getParent(49));
        System.out.println(tree.getParent(100));
        System.out.println(tree.getParent(78));
        System.out.println(tree.getParent(101));


        /*tree.delete(50);
        System.out.println("\n");
        tree.breadthFirstSearch();

        System.out.println("\n\nIn order");
        tree.inorder(root);*/





    }

    private static void printNodeAndParent(TreeNode[] nodeAndParent) {
        if(nodeAndParent == null)
            System.out.println("No such node");
        else {
            System.out.println(nodeAndParent[0] + " -> "+nodeAndParent[1]);
        }
    }

    private void delete(int data){
        this.root = delete(root, data);
    }

    private TreeNode delete(TreeNode node, int data){
        if(node == null){
            return null;
        } else if(data < node.getData()){
            node.setLeft(delete(node.getLeft(), data));
        } else if (data > node.getData()){
            node.setRight(delete(node.getRight(), data));
        } else {
            if(node.getLeft() == null && node.getRight() == null){
                node = null;
            } else if(node.getLeft() == null){
                node = node.getRight();
            } else if(node.getRight() == null){
                node = node.getLeft();
            } else {
                TreeNode maxLeft = largestLeftChild(node);
                node.setData(maxLeft.getData());
                node.setLeft(delete(node.getLeft(), node.getData()));
            }
        }

        return node;
    }


    private void remove(int data) {
        TreeNode[] parentAndNode = find(data);
        if (parentAndNode == null)
            System.out.println("No item found with data -> " + data);
        else {
            boolean root = (parentAndNode[0] == null);
            TreeNode node = parentAndNode[1];
            TreeNode parent = parentAndNode[0];

            //leaf node
            if (node.getLeft() == null && node.getRight() == null) {

                //leaf node and root
                if (root)
                    this.root = null;
                else {
                    if (parent.getRight() == node)
                        parent.setRight(null);
                    else
                        parent.setLeft(null);
                }

                //node has only right subtree
            } else if (node.getLeft() == null) {

                if (root)
                    this.root = this.root.getRight();
                else {
                    if (parent.getRight() == node)
                        parent.setRight(node.getRight());
                    else
                        parent.setLeft(node.getRight());
                }
                //node has only left subtree
            } else if (node.getRight() == null) {

                if (root)
                    this.root = this.root.getLeft();
                else {
                    if (parent.getRight() == node)
                        parent.setRight(node.getLeft());
                    else
                        parent.setLeft(node.getLeft());
                }

                // node has both left and right subtrees. In this case take largestLeftchild
            } else {


                TreeNode leftLargest = largestLeftChild(node);


                    TreeNode[] nodes = find(leftLargest.getData());
                    if (nodes[0].getRight() == nodes[1])
                        nodes[0].setRight(nodes[1].getLeft());
                    else
                        nodes[0].setLeft(nodes[1].getLeft());


                if (root) {
                    leftLargest.setLeft(this.root.getLeft());
                    leftLargest.setRight(this.root.getRight());
                    this.root = leftLargest;
                }
            }
        }

    }

}


class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int data){
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return /*"TreeNode" +*/
                "{data=" + data +
                //", left=" + left +
                //", right=" + right +
                '}';
    }
}
