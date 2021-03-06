package com.systems.ltd;

//importing necessary classes
import java.util.*;


class BinaryTree
{
    ListNode head;
    BinaryTreeNode root;
  
    // Function to insert a node at the beginning of
    // the Linked List
    void push(int new_data)
    {
        // allocate node and assign data
        ListNode new_node = new ListNode(new_data);
  
        // link the old list off the new node
        new_node.next = head;
  
        // move the head to point to the new node
        head = new_node;
    }
  
    // converts a given linked list representing a
    // complete binary tree into the linked
    // representation of binary tree.
    BinaryTreeNode convertList2Binary(BinaryTreeNode node)
    {
        // queue to store the parent nodes
        Queue<BinaryTreeNode> q =
                       new LinkedList<BinaryTreeNode>();
  
        // Base Case
        if (head == null)
        {
            node = null;
            return null;
        }
  
        // 1.) The first node is always the root node, and
        //     add it to the queue
        node = new BinaryTreeNode(head.data);
        q.add(node);
  
        // advance the pointer to the next node
        head = head.next;
  
        // until the end of linked list is reached, do the
        // following steps
        while (head != null)
        {
            // 2.a) take the parent node from the q and
            //      remove it from q
            BinaryTreeNode parent = q.peek();
            BinaryTreeNode pp = q.poll();
              
            // 2.c) take next two nodes from the linked list.
            // We will add them as children of the current
            // parent node in step 2.b. Push them into the
            // queue so that they will be parents to the
            // future nodes
            BinaryTreeNode leftChild = null, rightChild = null;
            leftChild = new BinaryTreeNode(head.data);
            q.add(leftChild);
            head = head.next;
            if (head != null)
            {
                rightChild = new BinaryTreeNode(head.data);
                q.add(rightChild);
                head = head.next;
            }
  
            // 2.b) assign the left and right children of
            //      parent
            parent.left = leftChild;
            parent.right = rightChild;
        }
          
        return node;
    }
  
    // Inorder traversal
    void inorderTraversal(BinaryTreeNode node)
    {
        if (node != null)
        {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }
    
    // preorder traversal
    void preorderTraversal(BinaryTreeNode node)
    {
        if (node != null)
        {
        	System.out.print(node.data + " ");
        	preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }
    // post order
    void postorderTraversal(BinaryTreeNode node)
    {
        if (node != null)
        {
        	postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
  
    // Driver program to test above functions
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.push(36); /* Last node of Linked List */
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10); /* First node of Linked List */
        BinaryTreeNode node = tree.convertList2Binary(tree.root);
  
        System.out.println("Inorder Traversal of the"+
                        " constructed Binary Tree is:");
        tree.inorderTraversal(node);
        
        System.out.println("\nPreorder Traversal of the"+
                " constructed Binary Tree is:");
		tree.preorderTraversal(node);
		
		System.out.println("\nPostorder Traversal of the"+
		        " constructed Binary Tree is:");
		tree.postorderTraversal(node);
    }
}
