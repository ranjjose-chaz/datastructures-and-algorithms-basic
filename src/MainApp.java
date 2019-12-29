import java.sql.SQLOutput;

public class MainApp {
    public static void main(String[] args){

        System.out.println("Hello, Fuckn world!!");

        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println(linkedList.length());

        //System.out.println(linkedList.remove(1));
        linkedList.traverse();
        System.out.print("\nPrinting reverse:");
        linkedList.printReverse();
        linkedList.reverse();
        linkedList.traverse();




    }

}

