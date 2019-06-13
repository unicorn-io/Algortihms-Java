/**
 *               The Following is the Generic Implementation of a Stack
 *               A stack is a  datatype that works like LIFO(last in first out)
 *               That means the last value added will be the first to be out
 *               It is just the the trays in a Mess/FoodCourt
 *
 * @param <T>    The generic Parameter may be COMPARABLE!
 */
import java.util.ArrayList;
public class stack<T> {

    private T[] stk;
    /*tracker tracks the index to be filled and
      allows exception handling in Overflow and Underflow conditions*/
    private int tracker = 0;
    private int size;
  
    /**
     *                This constructor sets a stack size
     *
     * @param size    The size of the stack required
     */
    @SuppressWarnings(value = "unchecked")
    public stack(int size) {
      stk = (T[]) new Object[size];
      this.size = size;
    }
  
    /**
     * This constructor Sets the Stack MAX_SIZE=1000
     */
    @SuppressWarnings(value = "unchecked")
    public stack() {
      stk = (T[]) new Object[1000];
      size = 1000;
    }
  
    /**
     *              push method add a value at the LAST in the STACK
     *
     * @param key   The element that is supposed to be pushed
     */
    public void push(T key) {
      if (tracker >= size) throw new IllegalArgumentException("Stack OVERFLOW!!");
      stk[tracker + 1] = key;
      tracker++;
    }
  
    /**
     *  Pops the top most element
     */
    public T pop() {
      tracker--;
      return stk[tracker + 1];
    }
  
    /**
     *            Gives the Top most element to EXPERIMENT :))
     *
     * @return    The top most Element
     */
    public T peek() {
      return stk[tracker];
    }
  
    /**
     *           Checks the Whether the Stack in Empty
     *
     * @return   A bool of stack's Emptiness
     */
    public boolean isEmpty() {
      return size() == 1 && peek() == null;
    }
  
    /**
     *            Calculates the size of the Stack
     *
     * @return    The size of the Stack
     */
    public int size() {
      return tracker + 1;
    }
  
    public static void main(String[] args) {
      stack<Integer> stk = new stack<Integer>();
      System.out.println(stk.isEmpty());
      System.out.println(stk.peek());
      stk.push(2);
      System.out.println(stk.size());
      stk.pop();
      System.out.println(stk.size());
    }
  }