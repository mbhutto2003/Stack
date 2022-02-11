package com.mbhutto;
import java.util.Stack;

public class exploringStackClass
{
    public static void main(String[] args)
    {
        Stack <String> stack = new Stack<String>();

        System.out.println("Stack is empty: " + stack.isEmpty());

        stack.push("Zero");
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Fourth");
        stack.push("Fifth");

        System.out.println("Total elements of stack are: " + stack.size());
        System.out.println("The top element is: " + stack.peek());
        System.out.println("Bottom or 'very first in' element is: " + stack.firstElement());
        System.out.println("2nd last or '2nd top' element is: " + stack.elementAt(stack.size()-2));

    }
}
