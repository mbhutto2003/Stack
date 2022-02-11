package com.mbhutto;
import java.util.Arrays;

public class ArrayStack implements Stack
{
    private int size;
    private Object[] a;

    public ArrayStack(int c)
    {
        a = new Object[c];
    }

    public Object[] getA()
    {
        return a;
    }

    public void setA(Object[] a)
    {
        this.a = a;
    }

    public  boolean Isempty()
    {
        return (size == 0);
    }

    public Object peek()
    {
        if (size == 0)  throw new IllegalStateException("Stack Empty");
        return a[size-1];
    }

    public Object pop()
    {
        if (size == 0)  throw new IllegalStateException("Stack Empty");

        Object obj = a[--size];
        a [size] = null;
        return obj;
    }

    public void push(Object obj)
    {
        if (size == a.length) 	reSize();
        a [size++] = obj;
    }

    public int size()
    {
        return size;
    }

    public void reSize()
    {
        Object extended[] = new Object[a.length + 1];
        for(int i=0; i<a.length; i++)
        {
            extended[i] = a[i];
        }
        a = extended;
    }

    public void getDetails()
    {
        System.out.print("Total length of a[] is " + this.a.length + ". ");
        System.out.println("Indexing is starting from zero & currenly stack has " + this.size() + " element(s) so the index of top element is " + (this.size()-1));
    }

    public String toString()
    {
        return "Stack.a[] = " + Arrays.toString(a);
    }

    public static  boolean equals(Object[] obj1, Object[] obj2)
    {
        boolean areEqual = true;

        if(obj1.length != obj2.length)
        {
            return false;
        }
        else
        {
            for(int index=0; index<obj1.length; index++)
            {
                if(obj1[index] == obj2[index]) {}
                else { areEqual = false;    break;     }
            }
        }

        if(areEqual)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public Object bottomElement()
    {
        return this.a[0];

    }

    public Object[] removeBottomElement()
    {
        for(int i=0; i<this.a.length-1; i++)
        {
            this.a[i] = this.a[i+1];
        }
        this.a[--size] = null;
        return this.a;
    }

    public Object secondBottomElement()
    {
        return this.a[1];
    }

    public Object[] removeSecondBottomElement()
    {
        for(int i=0; i<this.a.length-1; i++)
        {   if(i>0)
            this.a[i] = this.a[i+1];
        }
        this.a[--size] = null;
        return this.a;
    }

    public LinkedStack toLinkedStack()
    {
        LinkedStack temp = new LinkedStack();
        for(int i=0; i<this.a.length; i++)
        {
            temp.push(this.a[i]);
        }
        return temp;

    }





    /////////////////////////////////////////////             MAIN METHOD           //////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args)
    {
        ArrayStack stack1 = new ArrayStack(5);
        stack1.push("One");
        stack1.push("Two");
        stack1.push("Three");
        stack1.push("Four");
        stack1.push("Five");
        stack1.push("Six");

        ArrayStack stack2 = new ArrayStack(5);
        stack2.push("One");
        stack2.push("Two");
        stack2.push("Three");
        stack2.push("Four");
        stack2.push("Five");
        stack2.push("Six");

        System.out.println(stack1.toString());

        System.out.println("ArrayStacks are equal: " + ArrayStack.equals(stack1.getA(),stack2.getA()));

        System.out.println("Bottom or \"very first in\" element is: " + stack1.bottomElement());

        System.out.print("Printing stack2 before calling removeBottomElement() on it.     ");
        System.out.println(stack2.toString());
        stack2.removeBottomElement();
        System.out.print("Printing stack2 after  calling removeBottomElement() on it.     ");
        System.out.println(stack2.toString());

        System.out.println("Second bottom element is: " + stack1.secondBottomElement());

        System.out.print("Printing stack2 before calling removeSecondBottomElement() on it.     ");
        System.out.println(stack2.toString());
        stack2.removeSecondBottomElement();
        System.out.print("Printing stack2 after  calling removeSecondBottomElement() on it.     ");
        System.out.println(stack2.toString());

        System.out.println(stack1.toLinkedStack());


    }

}
