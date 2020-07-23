import java.util.Queue;
import java.util.LinkedList;

public class UndirectedBFS {
    private int[] edgeTo;
    private boolean[] marked;
    private int[] distTo;
    

    public UndirectedBFS(UndirectedGraph G, int s) {
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(UndirectedGraph G, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int dist = 0;
        distTo[s] = dist;
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            dist++;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.offer(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = dist;
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
}