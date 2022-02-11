import com.mbhutto.LinkedStack;

public class Main
{

    public static void main(String[] args)
    {

        LinkedStack linkedStack1 = new LinkedStack();
        linkedStack1.push("One");
        linkedStack1.push("Two");
        linkedStack1.push("Three");
        linkedStack1.push("Four");
        linkedStack1.push("Five");
        linkedStack1.push("Six");

        LinkedStack linkedStack2 = new LinkedStack();
        linkedStack2.push("One");
        linkedStack2.push("Two");
        linkedStack2.push("Three");
        linkedStack2.push("Four");
        linkedStack2.push("Five");
        linkedStack2.push("Six");

        System.out.println("ArrayStacks are equal: " + LinkedStack.equals(linkedStack1, linkedStack2));

        System.out.println("Bottom or \"very first in\" element is: " + linkedStack1.bottomElement());

        System.out.println("Printing stack before calling removeBottomElement() method\n" + linkedStack1.toString());
        System.out.println("Printing stack after calling removeBottomElement() method\n" + linkedStack1.removeBottomElement());

        System.out.println("Second bottom element is: " + linkedStack1.secondBottomElement());

        System.out.println("Printing stack before calling removeSecondBottomElement() method\n" + linkedStack1.toString());
        System.out.println("Printing stack after calling removeSecondBottomElement() method\n" + linkedStack1.removeSecondBottomElement());

        System.out.println(linkedStack1.toArrayStack());




    }
}
