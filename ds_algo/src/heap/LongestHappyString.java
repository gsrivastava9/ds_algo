package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String args[]){
        int a=1;
        int b=1;
        int c=8;
        LongestHappyString ob=new LongestHappyString();
        System.out.println(ob.longestDiverseString(a,b,c));

        a=7;
        b=1;
        c=0;
        System.out.println(ob.longestDiverseString(a,b,c));

    }

    public  String longestDiverseString(int a, int b, int c) {
        Node n1= new Node('a', a);
        Node n2= new Node('b', b);
        Node n3= new Node('c', c);
        String genString="";
        PriorityQueue<Node> q= new PriorityQueue<Node>(3, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return -1 * (o1.count-o2.count);
            }
        });

        q.add(n1);
        q.add(n2);
        q.add(n3);

        while (!q.isEmpty()){
            Node x=q.remove();
            if (genString.length()>=2){
                char ch1 = genString.charAt(genString.length()-1);
                char ch2 = genString.charAt(genString.length()-2);
                if(x.ch==ch1 && x.ch==ch2) {
                    if (!q.isEmpty()){
                        Node y = q.remove();
                        q.add(x);
                        x = y;
                    }else {
                        break;
                    }

                }
            }
            if (x.count>0){
                genString = genString + x.ch;
                x.count = x.count-1;
            }

            if (x.count>0){
                q.add(x);
            }
        }
        return genString;
    }

    class  Node{
        char ch;
        int count;
        Node(char ch, int count){
            this.ch=ch;
            this.count=count;
        }
    }
}

