package com.mbhutto;
import java.util.NoSuchElementException;

public  class LinkedStack implements Stack
{
	private Node top;
	private int size;
	
	private class Node
	{
		Object object;
		Node next;
		
		public Node(Object object, Node next)  
		{
			this.object = object;
			this.next = next;
		}
	}
	
	public boolean isEmpty()
	{
		return (size==0);
	}

	public Object peek()
	{
		if(size==0) throw new NoSuchElementException();
		return top.object;
	}

	public void push(Object obj)
	{
		top = new Node(obj,top);
		++size;
	}

	public Object pop()
	{
		if(size==0) throw new NoSuchElementException();
		
		Object tempTop = top.object;
		top = top.next;
		--size;
		return tempTop;
	}

	public int size()
	{
		return size;
	}
	
	public String toString()
	 {
	    String result = "Stack size = " + size + "\n";
	    Node current = top;
        
	    while (current != null)
	    {
	      result =  result + current.object + "\n";
	      current = current.next;
	    }

	    return result;
	 }
	
	public static  boolean equals(LinkedStack extendedLinkedStackOne, LinkedStack extendedLinkedStackTwo)
	{   
		boolean areEqual = true;
		
		if(extendedLinkedStackOne.size != extendedLinkedStackTwo.size)
		{
			return false;
		}
		
		else 
		{
			for(Node s1=extendedLinkedStackOne.top, s2=extendedLinkedStackTwo.top; s1!=null; s1=s1.next, s2=s2.next)
			{
				if(s1.object != s2.object) areEqual  = false;
			}
		}
		return areEqual;
  
	}

	
	public Node reverse(LinkedStack stack)
	{
		LinkedStack temp = new LinkedStack();
		
		for(Node s=stack.top; s!=null; s=s.next)
		{  
			temp.push(s.object);
		}
		return temp.top;
	}

	public Object bottomElement() 
	{   
		if(this.top == null)  throw new NoSuchElementException();
		for(Node s=this.top; s!=null; s=s.next)
		if(s.next == null)    return s.object;
		return this;
	}
	
	public  Object removeBottomElement() 
	{   
		if(this.top == null)  throw new NoSuchElementException(); 
		
		else 
		{
			LinkedStack temp = new LinkedStack();
			for(Node s=this.top; s!=null; s=s.next)	
			if(s.next != null)  temp.push(s.object); 
			this.top = reverse(temp);
			--size;
		}
		 
		return this;
	}
	
	public Object secondBottomElement()
	{
		if(this.top == null || this.top.next == null)  throw new NoSuchElementException();
		
		else 
		{  
			for(Node s=this.top; s!=null; s=s.next)
			{
				if(s.next.next == null)  
				{  
					return s.object;
				}
			}
				
		}
		return this;	
	}
	
	public Object removeSecondBottomElement()
	{
		if(this.top == null || this.top.next == null)  throw new NoSuchElementException();
		
		else 
		{   
			LinkedStack temp = new LinkedStack();
			for(Node s=this.top; s.next!=null; s=s.next)
			if(s.next.next != null)  temp.push(s.object);
			else temp.push(s.next.object);
			this.top = reverse(temp);
			--size;	
		}
		return this;
	}

	public ArrayStack toArrayStack()
	{
		ArrayStack as = new ArrayStack(size);
		Object[] obj = new Object[size];

		int i=0;
		for(Node p=this.top; p!=null; p=p.next)
		{
			obj[i] = (p.object);
			i++;
		}
		for (int j=obj.length-1; j>0; j--)
		{
			as.push(obj[j]);
		}
		return as;
	}
}
