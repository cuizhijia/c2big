package com.czj.sof.c2big.structures;

import java.util.Stack;

public class LinkedListOnePoint {

	private Node head;
	
	private int size;
	
	public LinkedListOnePoint(){
        head = null;
        size = 0;
    }
	
	
	public int size(){
        return size;
    }
	
	
	
	//私有内部类，代表链表每个结点
    private class Node{
        private Object data;  //链表结点的值
        private Node next;  //指向的下一个结点
        public Node(Object data){
            this.data = data;
        }
    }
	
    public boolean isEmpty(){
        return size==0?true:false;
    }
    
    public Object headNode(){
        if(size == 0) return null;
        return head.data;
    }
    
    
    public void insertInHead(Object obj){
        Node newNode = new Node(obj);
        if(size == 0){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    
    public Object deleteHeadNode(){
        if(size == 0) return null;
        Object obj = head.data;
        if(head.next == null){
            head = null;  //只有一个结点
        }else{
            head = head.next;
        }
        size--;
        return obj;
    }
    
    public boolean containObject(Object obj){
        if(size == 0) return false;
        Node n = head;
        while(n != null){
            if(n.data == obj) return true;
            else n = n.next;
        }
        return false;
    }
    
    public boolean deleteNode(Object obj){
        if(size == 0){
            System.out.println("链表为空！");
            return false;
        }
        //先在链表中查询是否包含该结点，找到之后获取该结点和其前一个结点
        Node previous = null;  //前一个结点
        Node current = head;  //当前结点
        while(current.data != obj){
            if(current.next == null){
                System.out.println("没有找到该结点！");
                return false;
            }
            previous = current;
            current = current.next;
        }
        if(current == head){
            this.deleteHeadNode();
        }else{
            previous.next = current.next;
            size--;
        }
        return true;
    }
    
    
    public void display(){
        if(size == 0) System.out.println("链表为空！");
        Node n = head;
        while(n != null){
            System.out.print("<-"+n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public void printListFromTailToHead(Node node){
        if(node == null) System.out.println("链表为空！");
        Stack<Integer> sta = new Stack<Integer>();
        while(node != null){
            sta.push((Integer) node.data);  //先将链表压入栈中
            node = node.next;
        }
        while(!sta.empty()){
            System.out.print(sta.pop()+"<-");  //出栈
        }
        System.out.println();
    }
    
    public void printListFromTailToHeadDiGui(Node node){
        if(node == null){
            System.out.println("链表为空！");
        }else{
            if(node.next != null){
                printListFromTailToHeadDiGui(node.next);
            }
            System.out.print(node.data+"<-");
        }
    }
    
    
    public static void main(String[] args) {
//    	LinkedListOnePoint list = new LinkedListOnePoint();
//        System.out.println(list.isEmpty());            //true
//        System.out.println(list.size());               //0
//        list.display();                                //链表为空！
//        list.printListFromTailToHead(list.head);       //链表为空！
//        
//        list.insertInHead(0);
//        list.insertInHead(1);
//        list.insertInHead(2);
//        list.insertInHead(3);        
//        list.display();                                //<-3<-2<-1<-0
//        list.printListFromTailToHead(list.head);       //0<-1<-2<-3<-
//        list.printListFromTailToHeadDiGui(list.head);  //0<-1<-2<-3<-
//        System.out.println(list.isEmpty());            //false
//        System.out.println(list.size());               //4
//        System.out.println(list.containObject(1));     //true
    	
    	String a = "123"; String b = "123";
    	
    	System.out.println(a==b);
    	
	}
    
}
