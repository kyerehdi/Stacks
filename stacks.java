/****
 * Derrick Kyereh, 10/22/2021, cmsc 256 Fall 2021
 */



package cmsc256;
import bridges.base.SLelement;

import bridges.connect.Bridges;
import bridges.validation.RateLimitException;


import java.io.IOException;
import java.util.EmptyStackException;


public class CustomStack<E> implements StackInterface {
private SLelement<E> Top;



public CustomStack(){
    this.Top = null;


}

public void display() {

        if(isEmpty()) {

            System.out.println("The stack is empty");

        }

        else {

            SLelement<E> current = Top;

            StringBuffer output = new StringBuffer();

            output.append("Top of stack: " + current.getValue() + "\n");



            while(current.getNext() != null) {

                current = current.getNext();



                if(current.getNext() == null)

                    output.append("Stack bottom: ");

                else

                    output.append("              ");



                output.append(current.getValue() + "\n");

            }

            System.out.println(output.toString());

        }

    }


    @Override
    public void push(Object newEntry) {
    if(Top ==null) {


        Top = new SLelement<E>((E) newEntry);
        Top.setLabel(newEntry.toString());
    }
else {

        SLelement K = new SLelement<E>((E) newEntry);
        K.setNext(Top);
        K.setLabel(newEntry.toString());
        Top=K;

    }

    }

    @Override
    public Object pop() {
    Object e;
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        SLelement temp = Top;
        Top = Top.getNext();
       e=temp.getValue();
       return e;
    }

    @Override
    public Object peek() {
       if(!isEmpty()){
           return Top.getValue();

       }
       else
throw new EmptyStackException();

    }

    @Override
    public boolean isEmpty() {
      return Top == null;
    }

    @Override
    public void clear() {
Top =null;

    }


    public  boolean isBalanced(String expression) {

        CustomStack<Character> C = new CustomStack<Character>();

        for(int i=0; i<expression.length(); i++) {
            char d = expression.charAt(i);
            if (d == '(' || d == '{' || d == '[') {
                C.push(d);
            } else if (d == ')'&&C.Top.getValue()=='(') {
                C.pop();

            }
            else if (d == '}'&&C.Top.getValue()=='{') {
                C.pop();

            }
            else if (d == ']'&&C.Top.getValue()=='[') {
                C.pop();

            }

        }



if(C.isEmpty())
    return true;

else return false;










    }
    public static void main(String[] args) {
        CustomStack tk=new CustomStack<>();
        int F=1;
        int J=2;
        int fJ=3;
        int sJ=5;

        tk.push(F);
        tk.push(J);
        tk.push(fJ);
        tk.push(sJ);





        String j= "{[()()]()}";
       tk.display();



        String expression = "()()sasadsa( )()()sadsadaa()()()()";
boolean isBalancedExpression = tk.isBalanced(expression);

       if (isBalancedExpression)

           System.out.println(expression + " is balanced");

        else {

           System.out.println(expression + " is not balanced");
       }
        Bridges bridges = new Bridges(3,"kyerehdi","865795350400");
           CustomStack<Integer> stack = new CustomStack<>();
           stack.push(256);
           stack.push(001);
           stack.push(9);
           stack.push(20);
           stack.push(2018);
           System.out.println("Pushed 256, 1, 9, 20, and 2018");
           stack.display();
           bridges.setDataStructure(stack.Top);
           bridges.setTitle("CMSC 256 Project 2 Derrick Kyereh");
        try {
            bridges.visualize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RateLimitException e) {
            e.printStackTrace();
        }



       }
    }

