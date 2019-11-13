package directedhamiltoncircuit;

import java.util.List;
import java.util.ArrayList;

public class Graph {
    private int vCount;
    private int[][] adj;

    public int getvCount() {
        return vCount;
    }

    public int[][] getAdj() {
        return adj;
    }

    public Graph(int vCount) {
        this.vCount = vCount;
        adj = new int[vCount][vCount];
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                if (i != j) {
                    adj[i][j] = 0;
                }

            }
        }
    }

    public void addEdge(int i, int j) {
        adj[i][j] = 1;
    }

    public void removeEdge(int i, int j) {
        adj[i][j] = 0;
    }

    public boolean hasEdge(int i, int j) {
        if (adj[i][j] != 0) {
            return true;
        }
        return false;
    }

    public List<Integer> neighbours(int vertex) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int i = 0; i < vCount; i++)
            if (hasEdge(vertex, i))
                edges.add(i);
        return edges;
    }

    public String printGraph() {
        String str = new String();
        for (int i = 0; i < vCount; i++) {
            List<Integer> edges = neighbours(i);
            str = str + Integer.toString(i) +  ": ";
            for (int j = 0; j < edges.size(); j++) {
                str = str + Integer.toString(edges.get(j)) + " ";
            }
            str = str + "\n";
        }
        return str;
    }
}