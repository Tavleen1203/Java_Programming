package hc;

class HuffmanNode {
    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int data, char c) {
        this.data = data;
        this.c = c;
        this.left = null;
        this.right = null;
    }
}

