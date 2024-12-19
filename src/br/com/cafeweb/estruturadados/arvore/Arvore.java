package br.com.cafeweb.estruturadados.arvore;

public class Arvore<T> {

    private NoArvore<T> root;

    public Arvore() {
        this.root = null;
    }

    public void insert(NoArvore<T> node) {
        node.setLeftNode(null);
        node.setRightNode(null);
        if (this.root == null) {
            this.root = node;
        } else {
            this.insert(this.root, node);
        }
    }

    private void insert(NoArvore<T> node, NoArvore<T> newNode) {
        if (node.hash() < newNode.hash()) {
            if (node.getRightNode() == null) {
                node.setRightNode(newNode);
            } else {
                insert(node.getRightNode(), newNode);
            }
        } else {
            if (node.getLeftNode() == null) {
                node.setLeftNode(newNode);
            } else {
                insert(node.getLeftNode(), newNode);
            }
        }
    }

    public NoArvore<T> search(NoArvore<T> node) {
        return this.search(this.root, node);
    }

    private NoArvore<T> search(NoArvore<T> node, NoArvore<T> searchNode) {
        if (node.getValue().equals(searchNode.getValue())) {
            return node;
        }
        if (node.hash() < searchNode.hash()) {
            if (node.getRightNode() == null) {
                return null;
            } else {
                System.out.println(">>> Navegando a direita do nó " + node.getValue().toString());
                return search(node.getRightNode(), searchNode);
            }
        } else {
            if (node.getLeftNode() == null) {
               return null;
            } else {
                System.out.println("<<< Navegando a esquerda do nó " + node.getValue().toString());
                return search(node.getLeftNode(), searchNode);
            }
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
        return;
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    public void posOrder() {
        this.posOrder(this.root);
    }

    public int height() {
       return this.height(this.root);
    }

    private void inOrder(NoArvore<T> node) {
        if (node.getLeftNode() != null) {
            inOrder(node.getLeftNode());
            System.out.println(node.getValue());
            if (node.getRightNode() != null) {
                inOrder(node.getRightNode());
            }
        } else {
            System.out.println(node.getValue().toString());
            if (node.getRightNode() != null) {
                inOrder(node.getRightNode());
            }
        }
    }



    private void preOrder(NoArvore<T> node) {
        System.out.println(node.getValue());
        if (node.getLeftNode() != null) {
            preOrder(node.getLeftNode());
            if (node.getRightNode() != null) {
                preOrder(node.getRightNode());
            }
        } else {
            if (node.getRightNode() != null) {
                preOrder(node.getRightNode());
            }
        }
    }


    private void posOrder(NoArvore<T> node) {
        if (node.getLeftNode() != null) {
            posOrder(node.getLeftNode());
            if (node.getRightNode() != null) {
                posOrder(node.getRightNode());
            }
            System.out.println(node.getValue());
        } else {
            if (node.getRightNode() != null) {
                posOrder(node.getRightNode());
                System.out.println(node.getValue().toString());
            }else {
                System.out.println(node.getValue().toString());
            }
        }
    }


    private int height(NoArvore<T> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.getLeftNode());
        int rightHeight = height(node.getRightNode());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public String toString() {
        return "Arvore{" +
                "root=" + root +
                '}';
    }
}
