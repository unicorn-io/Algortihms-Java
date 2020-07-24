import java.util.Stack;

public class Paths {

    private UndirectedDFS obj;
    private DirectedDFS obj2;
    private int s;

    public Paths(UndirectedGraph G, int s) {
        this.s = s;
        obj = new UndirectedDFS(G, s);
    } 

    public Paths(DirectedGraph G, int s) {
        this.s = s;
        obj2 = new DirectedDFS(G, s);
    }
 
    public boolean hasPathTo(int v) {
        return obj == null ? obj2.isMarked(v) : obj.isMarked(v);
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stk = new Stack<>();
        for (int i = v; i != s; i = obj.edgeTo(i)) {
            stk.push(i);
        }
        stk.push(s);
        return stk;
    }
}