import java.util.LinkedList;
import java.util.Queue;

public class DirectedBFS {
    
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public DirectedBFS(DirectedGraph G, int s) {
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(DirectedGraph G, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        marked[v] = true;
        distTo[v] = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int w : G.adj(tmp)) {
                if (!marked[w]) {
                    q.offer(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[tmp] + 1;
                }
            }
        }
        
    }

    public boolean isMarked(int v) {
        return marked[v];
    }

    public int edgeTo(int v) {
        return edgeTo[v];
    }

    public int distTo(int v) {
        return distTo[v];
    }

}