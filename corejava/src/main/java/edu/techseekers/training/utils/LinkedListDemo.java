package edu.techseekers.training.utils;

import java.util.LinkedList;
/**
 * used as a stack, queue, or double-ended queue.
 * Double-ended queue: which elements can be added to or removed from either the front (head) or back (tail).
 * 
 * A stack is a basic data structure that can be logically thought as linear structure represented by a real physical stack or pile, a structure where insertion and deletion of items takes place at one end called top of the stack.
 * @author lsamud001c
 */
public class LinkedListDemo {
    public static void main(String a[]){
         
        LinkedList<String> arrl = new LinkedList<String>();
        arrl.add("First");
        arrl.add("Second");
        arrl.add("Third");
        arrl.add("Random");
        System.out.println(arrl);
        arrl.push("push element");
        System.out.println("After push operation:");
        System.out.println(arrl);
        arrl.pop();
        System.out.println("After pop operation:");
        System.out.println(arrl);
        
        System.out.println("Last Element: "+arrl.peekLast());
    }
}
