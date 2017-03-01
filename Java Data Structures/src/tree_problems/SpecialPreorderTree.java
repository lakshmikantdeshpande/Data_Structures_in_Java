// 38. Given a preorder traversal of a tree represented by I and L where I is an internal node and
// L is a leaf node, build a tree. Note that each node has either 0 or 2 nodes. 
// n time n space                                         

/*-
 *                                 *********                                 
 *                                 *       *                                 
 *                                 *   I   *                                 
 *                                 *       *                                 
 *                                 *********                                
 *                                **        **                              
 *                              **            **                            
 *                            **                **                          
 *                          **                    **                        
 *                        **                        **                      
 *                   *********                       *********              
 *                   *       *                       *       *              
 *                   *   L   *                       *   I   *              
 *                   *       *                       *       *              
 *                   *********                       *********              
 *                                                     *     *              
 *                                                    *       **            
 *                                                    *         *           
 *                                                   *           *          
 *                                                   *            **        
 *                                                  *               *       
 *                                                  *           **********  
 *                                        **********            *        *  
 *                                        *        *            *   L    *  
 *                                        *   L    *            *        *  
 *                                        *        *            **********  
 *                                        **********                        
 */

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

class sTreeNode {
	char data;
	sTreeNode left, right;

	public sTreeNode(char c) {
		this.data = c;
	}
}

public class SpecialPreorderTree {

	public static void main(String[] args) {
		levelOrderPrint(buildTree(new char[] { 'I', 'L', 'I', 'L', 'L' }, 0));
	}

	private static sTreeNode buildTree(char[] array, int i) {
		if (array == null || i == array.length)
			return null;
		sTreeNode node = new sTreeNode(array[i]);
		if (array[i] == 'L')
			return node;
		node.left = buildTree(array, ++i);
		node.right = buildTree(array, ++i);
		return node;
	}

	private static void levelOrderPrint(sTreeNode root) {
		if (root == null)
			return;

		Queue<sTreeNode> queue = new LinkedList<sTreeNode>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			sTreeNode temp = queue.poll();

			if (temp != null) {
				System.out.print(temp.data + " ");
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			} else {
				System.out.println();
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
		System.out.println("************************");
	}

}
