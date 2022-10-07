public class LinkedList {
    public Node headNode;

    public void addHeadNode(int x, int y){
        Node oNode = new Node(); // New Node
        oNode.xPosition = x; // Filling new node with data
        oNode.yPosition = y; // Filling new node with data

        oNode.nextNode = headNode; // Setting the nextNode to the head node

        headNode = oNode; // Setting the head to the new node
    }

    public Node removeHeadNode(){
        Node tempHead = headNode;

        if(headNode != null){
            headNode = headNode.nextNode;
        }
        return tempHead;

    }
}
