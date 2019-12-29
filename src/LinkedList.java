public class LinkedList {

    private Node head;
    private Node tail;


    public LinkedList(){}
    public LinkedList(int startValue){
        head = new Node(startValue);
        tail = head;
        String s = "Ranjith";
    }


    public void traverse(){
        System.out.println();
        if(head == null)
            return;

        for(Node temp=head; temp!=null; temp=temp.getNext())
        System.out.print(temp.getData()+ " ");
    }


    public void add(int data){

        if(head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        for(;temp.getNext()!=null; temp=temp.getNext());
        temp.setNext(new Node(data));
        tail = temp.getNext();
    }

    public int length(){

        if (head == null)
            return 0;

        int len = 1;
        for(Node temp=head; temp.getNext()!=null; temp=temp.getNext(), ++len);

        return len;
    }


    public boolean remove(int data){

        //Empty case
        if(head == null)
            return false;

        Node temp = head;

        //1st Elt case
        if(temp.getData() == data){

            //Only 1 elt in the list
            if(temp.getNext() == null) {
                head = null;
                return true;
            }
            //More than 1 elt in the list
            head = head.getNext();

            return true;

        }

        //All other cases:
        //Match item from 2nd pos onwards
        while (temp.getNext() != null){

            if(temp.getNext().getData() == data) {
                temp.setNext(temp.getNext().getNext());
                return true;
            }

            temp = temp.getNext();
        }

        return false;

    }

    public void printReverse(){
        printReverse(head);
    }

    private void printReverse(Node tmp) {
        if(tmp.getNext() != null)
            printReverse(tmp.getNext());
        System.out.print(tmp.getData()+" ");
    }

    public void reverse(){
        rev(head);
    }

    private Node rev(Node tmp) {
        if(tmp.getNext() != null){
            Node next_node = rev(tmp.getNext());
            next_node.setNext(tmp);
            tmp.setNext(null);

        } else {
            head = tmp;
        }

        return tmp;



    }




}

class Node {
    private int data;
    private Node next;

    public Node(){

    }
    public Node(int data){
        this.setData(data);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
