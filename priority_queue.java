package Priority_queue;

public class priority_queue {
    private class Node{
        int data;
        int priority;
        Node next;
        Node(int data,int priority){
            this.data=data;
            this.priority=priority;
            this.next=null;
        }
    }
    private Node front;
    priority_queue(){
        this.front=null;
    }

    public void enqueue(int data,int priority){
        Node new_node=new Node(data,priority);
        if(front==null || front.priority<priority){
            new_node.next=front;
            front=new_node;
        }else{
            Node current=front;
            while(current.next!=null && current.next.priority>=priority){
                current=current.next;
            }
            new_node.next=current.next;
            current.next=new_node;
        }
    }

    public void dequeue(){
        if(front==null){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Deleted Element:"+front.data);
        front=front.next;

    }

    public void peek(){
        if(front==null){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(front.data);
    }

    public void display(){
        Node curr=front;
        if(curr==null){
            System.out.println("Queue is empty");
        }

        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        priority_queue pq=new priority_queue();
        pq.enqueue(20,3);
        pq.enqueue(5,1);
        pq.enqueue(16,2);
        pq.display();
        pq.peek();
        pq.dequeue();
        pq.display();
    }

}
