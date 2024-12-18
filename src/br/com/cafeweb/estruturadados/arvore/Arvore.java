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

    @Override
    public String toString() {
        return "Arvore{" +
                "root=" + root +
                '}';
    }
}
