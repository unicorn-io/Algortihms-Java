import java.util.Stack;

public class Paths {

    private UndirectedDFS obj;
    private int s;

    public Paths(UndirectedGraph G, int s) {
        this.s = s;
        obj = new UndirectedDFS(G, s);
    } 
 
    public boolean hasPathTo(int v) {
        return obj.isMarked(v);
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