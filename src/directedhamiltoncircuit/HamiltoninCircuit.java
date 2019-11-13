package directedhamiltoncircuit;

public class HamiltoninCircuit {

    public Graph graph;

    public HamiltoninCircuit(Graph graph) {
        this.graph = graph;
    }

    static void hamCircuit(Graph g) {
        // vertex count
        int V = g.getvCount();

        // path matrix
        int path[] = new int[V];
        // initialize to -1 except starting Vertex
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }
        path[0] = 0;

        if (solveHamCircuit(V, g, path, 1) == false) {
            System.out.println("Solution does not exist!");
        } else {
            System.out.println("Solution exists! The following is one of the solutions:");
            for (int i = 0; i < V; i++) {
                System.out.print(" " + path[i] + " ");
            }
        }

    }

    static boolean canBeAdded(int v, Graph g, int path[], int pos) {
        // if vertex is already adjacent of previously added vertex
        if (g.getAdj()[pos - 1][v] == 0) {
            return false;
        }

        // check if vertex already included
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) return false;
        }

        // in any other case return true
        return true;
    }

    static boolean solveHamCircuit(int V, Graph g, int path[], int pos) {
        // check if all are included and if it makes a circle
        if (pos == V) {
            if (g.getAdj()[path[pos - 1]][path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        // try adding different vertices
        for (int v = 1; v < V; v++) {
            // check if it can be added
            if (canBeAdded(v, g, path, pos)) {
                path[pos] = v;

                // call function again recursively to build the path
                if (solveHamCircuit(V, g, path, pos + 1) == true) {
                    return true;
                }

                // backtracking part
                // we go back if adding v doesn't give us a solution
                path[pos] = -1;
            }
        }

        // if no vertex can be added | circle can't be created
        return false;
    }

}
