package tree;

public class ThreadedBinaryTreeNode {
    public ThreadedBinaryTreeNode left;
    public ThreadedBinaryTreeNode right;
    int LTag;
    int data;
    int RTag;
}

/*-
 * Difference between binary tree and threaded binary trees (inorder)
 *
 * 							Regular Binary Tree						Threaded Binary Tree
 * if LTag == 0						NULL						left points to inorder predecessor
 * if LTag == 1				left points to left child			left points to left child
 *
 * if RTag == 0						NULL						right points to inorder successor
 * if RTag == 1				right points to right child			right points to right child
 *
 *                                     >__________________________________<-\
 *                                    / |      |      |      |      |      |  \
 *                                   /  |	   |  0   |  --  |   1  |      |___\
 *                                  /___|	   |      |      |      |      |
 *                                      |______|______|______|______|______|
 *
 */