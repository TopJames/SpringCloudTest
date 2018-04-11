package datastructure;

/**
 * Created by Administrator on 2018/3/24.
 */
public class DoubleDirectionLinkedList<A> {


    int size;
    Node<A> first;
    Node<A> last;

    public void linkLast(A value){
        Node<A> newNode=new Node<>(last,null,value);
        if(last==null){
            first=newNode;
        }else {
            last.next=newNode;
        }
        last=newNode;
        size++;
    }
    public void linkFirst(A value){
        Node<A> newNode=new Node<>(null,first,value);
        if(first==null){
            last=newNode;
        }
        first=newNode;
        size++;
    }

    public void linkBefore(A value,Node<A> node){
        Node<A> newNode;
        if(node==null){
            newNode=new Node<>(null,null,value);
            first=newNode;
            last=newNode;
        }else{
            Node<A> next=node.next;
            newNode=new Node<>(node,next,value);
            node.next=newNode;
            if(next==null){
                last=newNode;
            }else {
                next.prev=newNode;
            }
        }
        size++;
    }

    public void add(A value){
        linkLast(value);
    }

    public void add(A value,int index){
        checkBound(index);
        linkBefore(value, node(index));
    }

    public A get(int index){
        Node<A> node=node(index);
        return node.value;
    }

    public void remove(int index){
        Node<A> node=node(index);
        Node<A> next=node.next;
        Node<A> prev=node.prev;
        prev.next=next;
        next.prev=prev;
        size--;
    }

    public int size(){
        return size;
    }

    public void checkBound(int index){
        if(index<0||index>size){
            throw new RuntimeException("下标超出链表范围。");
        }
    }


    public Node<A> node(int index){
        checkBound(index);
        Node<A> node;
        if(index<=(size >> 1 )){
            node=first;
            for(int i=0;i<index;i++){
                node=node.next;
            }
        }else{
            node=last;
            for(int j=size-1;j>index;j--){
                node=node.prev;
            }
        }
        return node;
    }

    public void turn(){
        Node<A> node=first;

        if(node==null) return;

        while(true){
            Node<A> next=node.next;
            Node<A> prev=node.prev;
            node.prev=next;
            node.next=prev;
            if(next==null){
                break;
            }
            node=next;
        }
        Node<A> mid=first;
        first=last;
        last=mid;
    }


    private class Node<A>{
        Node<A> prev;
        Node<A> next;
        A value;

        Node(){

        }
        Node(Node<A> prev,Node<A> next,A value){
            this.prev=prev;
            this.next=next;
            this.value=value;
        }

    }
}
