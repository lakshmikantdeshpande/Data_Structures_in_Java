package tree;

public class Driver {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // expected pre order output: 1, 2, 4, 5, 3
        System.out.println("Pre Order");
        Preorder preo = new Preorder();
        preo.doPreorder(root);
        System.out.println(preo.doPreorderInterative(root));

        // expected inorder output: 4, 2, 5, 1, 3
        System.out.println("In Order");
        Inorder ino = new Inorder();
        ino.doInorder(root);
        System.out.println(ino.doInorderIterative(root));

        // expected post order output: 4, 5, 2, 3, 1
        System.out.println("Post Order");
        Postorder posto = new Postorder();
        posto.doPostorder(root);
        System.out.println(posto.doPostorderIterative(root));

        System.out.println("Level Order");
        Levelorder lo = new Levelorder();
        System.out.println(lo.levelOrder(root));

        System.out.println("************************");
        Levelorder.levelOrderPrint(root);
    }

}
