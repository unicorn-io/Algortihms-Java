public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int c) {
        if (this.v == c) return this.w;
        return v;
    }

    public double weight() {
        return weight;
    }
    
    public int compareTo(Edge that) {
        if (this.weight < that.weight) return -1;
        else if (this.weight > that.weight) return 1;
        else return 0;
    } 

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(v);
        str.append(" -> ");
        str.append(w);
        return str.toString();
    }
}