package com.szachnowicz.BTree;

public class BinaryTree<T extends Comparable<?>> {

    public Node root;
    int size = 0;


    public void addNode(T value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node focuseNode = root;
        Node parent;
        while (true) {
            parent = focuseNode;
            if ((Integer) value < (Integer) focuseNode.value) {
                focuseNode = focuseNode.left;
                if (focuseNode == null) {
                    parent.left = newNode;
                    size++;
                    return;
                }
            } else {
                focuseNode = focuseNode.right;
                if (focuseNode == null) {
                    size++;
                    parent.right = newNode;
                    return;
                }
            }

        }


    }

    public Node findNote(T value) {
        Node focuseNode = root;
        while (focuseNode.value != value) {
            if ((Integer) value < (Integer) focuseNode.value) {
                focuseNode = focuseNode.left;
            } else {
                focuseNode = focuseNode.right;
            }
            if (focuseNode == null) {
                return null;
            }

        }
        return focuseNode;
    }


    public void inOrderTraverseTree(Node focuseNode, BinaryTree newOne) {
        if (focuseNode != null) {
            inOrderTraverseTree(focuseNode.left, newOne);
            System.out.println(focuseNode);
            newOne.addNode(focuseNode.value);
            inOrderTraverseTree(focuseNode.right, newOne);
        }
    }

    public void inOrderTraverseTree(Node focuseNode) {
        if (focuseNode != null) {
            inOrderTraverseTree(focuseNode.left);
            System.out.println(focuseNode);
            inOrderTraverseTree(focuseNode.right);
        }
    }


    public void preOrderTraversTree(Node focuseNode) {
        if (focuseNode != null) {
            preOrderTraversTree(focuseNode.right);

            preOrderTraversTree(focuseNode.left);
        }

    }

    public boolean remove(T value) {

        // Start at the top of the tree

        Node focusNode = root;
        Node parent = root;

        // When searching for a Node this will
        // tell us whether to search to the
        // right or left

        boolean isItAleft = true;

        // While we haven't found the Node
        // keep looking

        while (focusNode.value != value) {

            parent = focusNode;

            // If we should search to the left

            if ((Integer) value < (Integer) focusNode.value) {

                isItAleft = true;

                // Shift the focus Node to the left child

                focusNode = focusNode.left;

            } else {

                // Greater than focus node so go to the right

                isItAleft = false;

                // Shift the focus Node to the right child

                focusNode = focusNode.right;

            }

            // The node wasn't found

            if (focusNode == null)
                return false;

        }

        // If Node doesn't have children deleteRoot it

        if (focusNode.left == null && focusNode.right == null) {

            // If root deleteRoot it

            if (focusNode == root)
                root = null;

                // If it was marked as a left child
                // of the parent deleteRoot it in its parent

            else if (isItAleft)
                parent.left = null;

                // Vice versa for the right child

            else
                parent.right = null;

        }

        // If no right child

        else if (focusNode.right == null) {

            if (focusNode == root)
                root = focusNode.left;

                // If focus Node was on the left of parent
                // move the focus Nodes left child up to the
                // parent node

            else if (isItAleft)
                parent.left = focusNode.left;

                // Vice versa for the right child

            else
                parent.right = focusNode.left;

        }

        // If no left child

        else if (focusNode.left == null) {

            if (focusNode == root)
                root = focusNode.right;

                // If focus Node was on the left of parent
                // move the focus Nodes right child up to the
                // parent node

            else if (isItAleft)
                parent.left = focusNode.right;

                // Vice versa for the left child

            else
                parent.right = focusNode.right;

        }

        // Two children so I need to find the deleted nodes
        // replacement

        else {

            Node replacement = getReplacementNode(focusNode);

            // If the focusNode is root replace root
            // with the replacement

            if (focusNode == root)
                root = replacement;

                // If the deleted node was a left child
                // make the replacement the left child

            else if (isItAleft)
                parent.left = replacement;

                // Vice versa if it was a right child

            else
                parent.right = replacement;

            replacement.left = focusNode.left;

        }
        size--;
        return true;

    }

    public boolean removeNode(T value) {
        Node focuseNode = root;
        Node parent = root;
        boolean isItAleft = true;
        while (focuseNode.left != value) {
            parent = focuseNode;
            if ((Integer) value < (Integer) focuseNode.value) {
                isItAleft = true;
                focuseNode = focuseNode.left;

            } else {
                isItAleft = false;
                focuseNode = focuseNode.right;
            }
            if (focuseNode == null) {
                return false;
            }
        }
        if (focuseNode.left == null && focuseNode.right == null) {
            if (focuseNode == root) {
                root = null;
            } else if (isItAleft) {
                parent.left = null;
            } else {
                parent.right = null;

            }
        } else if (focuseNode.right == null) {
            if (focuseNode == root) {
                root = focuseNode.left;

            } else if (isItAleft) {
                parent.left = focuseNode.left;
            } else {
                parent.right = focuseNode.left;
            }
        } else if (focuseNode.left == null) {
            if (focuseNode == root) {
                root = focuseNode.right;
            } else if (isItAleft) {
                parent.left = focuseNode.right;

            } else {
                parent.right = focuseNode.left;
            }


        } else {
            Node repelcment = getReplacementNode(focuseNode);

            if (focuseNode == root) {
                root = repelcment;
            } else if (isItAleft) {
                parent.left = repelcment;
            } else parent.right = repelcment;

            repelcment.left = focuseNode.left;
        }

        return true;
    }

    //
    public Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.right;

        // While there are no more left children

        while (focusNode != null) {

            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.left;
        }
        // If the replacement isn't the right child
        // move the replacement into the parents
        // leftChild slot and move the replaced nodes
        // right child into the replacements rightChild

        if (replacement != replacedNode.right) {

            replacementParent.left = replacement.right;
            replacement.right = replacedNode.right;

        }

        return replacement;

    }


}
