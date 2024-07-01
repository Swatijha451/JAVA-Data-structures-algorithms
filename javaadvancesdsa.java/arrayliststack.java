import java.util.*;

public class arrayliststack {
    //there is implicit stack in the memory whic is created by itself
    //the programmers make te explicut stack using push,pop,peek
    //arrayist and inkedlist can be used to make stack because there are of dynamic size;
    //stack usin g arraylist
     static class stack{
        static ArrayList<Integer> list=new ArrayList<>();
    
            public static boolean isEmpty(){
                return list.size()==0;
            }
            //push function
            public static void push(int data){
                list.add(data);
            }
            //pop function
            public static  int pop(){
                if(isEmpty()){
                    return -1;
                }
                int top= list.get(list.size()-1);
                list.remove(list.size()-1);
                return top;
            }
            //peek function
            public static int peek(){
                if(isEmpty()){
                    return -1;
                }
                return list.get(list.size()-1);
            }
        }
        
    
    public static void main(String[] args) {
     stack s= new stack();
     s.push(0);
     s.push(1);
     s.push(3);
     while (!s.isEmpty()) {
        System.out.println(s.peek());
        s.pop();
        
     }

     }

    }

