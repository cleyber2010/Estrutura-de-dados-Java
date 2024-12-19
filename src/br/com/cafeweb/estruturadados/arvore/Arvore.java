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

    /**
     *         10
     *       5    20
     *      2       30
     *     1       25   31
     *
     * @param node
     *  10, 5, 2, 1, 20, 30, 25, 31
     */

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

    @Override
    public String toString() {
        return "Arvore{" +
                "root=" + root +
                '}';
    }
}
