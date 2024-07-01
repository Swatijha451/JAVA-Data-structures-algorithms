public class circularlinkedlist {
    //singly circular inked list
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;

        }
    }
       public static Node addToEmpty(Node last,int data){
            if(last!=null){
                return last;

            }
            Node newnode= new Node(data);
            last=newnode;
            newnode.next=last;
            return last;
        }
        public static Node addtofirst(Node last,int data){
            if(last==null){
                return addToEmpty(last, data);
            }
            Node newnode= new Node(data);
            newnode.next=last.next;
            last.next=newnode;
            return last;
        }
        public static Node addatEnd(Node last, int data){
            if(last==null){
                return addToEmpty(last, data);

            }
            Node newnode= new Node(data);
            newnode.next= last.next;
            last.next= newnode;
            last=newnode;
            return last;
            
        }
        public static Node adAfter(Node last,int data, int item){
            if(last==null){
                return null;
            }
            Node newnode,p;
            p=last.next;
            do{
                if(p.data==item){
                    newnode= new Node(data);
                    newnode.next=p.next;
                    p.next=newnode;
                    if(p==last){
                        last=newnode;
                        return last;
                    }
                }
                    p= p.next;       
            } while(p!=last.next);{
                System.out.println(item+ " the given node is not present in the list");
                return last;
            }
        }
        public static Node deletenode(Node last,int key){
            if(last==null){
                return null;
            }
            if(last.data==key&& last.next==last){
                last=null;
                return last;
            }
            Node temp=last;
            Node d;
            if (last.data==key) {
                while (temp.next!=last) {
                    temp=temp.next;   
                }
                temp.next=last.next;
                last= temp.next;
            }
                if (temp.next.data==key) {
                    d=temp.next;
                    temp.next=d.next;    
                }
                return last;
                
            

        }
        public static void traverseandprint(Node last){
            Node p;
            if(last==null){
                System.out.println("list is empty");
                return;
            }
            p=last.next;
            do{
                System.out.print(p.data+" ");
                p=p.next;
            } while(p!=last.next);
            System.out.println();
        }
       
        public static void main(String[] args) {
            Node last=null;
            last=addToEmpty(last, 0);
            last=addatEnd(last, 1);
            last=addtofirst(last, 2);
            last=adAfter(last, 10, 2);
            traverseandprint(last);
            deletenode(last, 0);
            traverseandprint(last);
        }


    
    
}
