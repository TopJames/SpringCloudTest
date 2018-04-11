package extendThread;

import datastructure.DoubleDirectionLinkedList;

/**
 * Created by Administrator on 2018/3/24.
 */
public class test13 {
    public static void main(String[] args) {
        DoubleDirectionLinkedList<String> dl=new DoubleDirectionLinkedList<>();
        dl.add("0");
        dl.add("1");
        dl.add("2");
        dl.add("3");
        dl.add("4");
        int size=dl.size();
        System.out.println(size);
        for(int i=0;i<size;i++){
            System.out.println(dl.get(i));
        }
        dl.turn();
        for(int i=0;i<size;i++){
            System.out.println(dl.get(i));
        }
        dl.linkFirst("linkFirst");
        size=dl.size();
        for(int i=0;i<size;i++){
            System.out.println(dl.get(i));
        }
        dl.linkLast("linkLast");
        size=dl.size();
        for(int i=0;i<size;i++){
            System.out.println(dl.get(i));
        }
        dl.add("insert",1);
        size=dl.size();
        for(int i=0;i<size;i++){
            System.out.println(dl.get(i));
        }
        dl.remove(3);
        size=dl.size();
        for(int i=0;i<size;i++){
            System.out.println(dl.get(i));
        }
        dl.remove(12);
    }
}
