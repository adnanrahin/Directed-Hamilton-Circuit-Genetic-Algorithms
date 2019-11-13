package directedhamiltoncircuit;

public class HamiltoninCircuit {

    public Graph graph;

    public HamiltoninCircuit(Graph graph) {
        this.graph = graph;
    }

    public String hamCircuit() {
        // vertex count
        String str = new String();
        int V = this.graph.getvCount();

        // path matrix
        int path[] = new int[V];
        // initialize to -1 except starting Vertex
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }
        path[0] = 0;

        if (solveHamCircuit(V, path, 1) == false) {
            str = new String("Solution does not exist!");
        } else {
            str = str + "Solution exists! The following is one of the solutions:\n";
            for (int i = 0; i < V; i++) {
                str = str + Integer.toString(path[i]) + " ";
            }
        }
        return str;
    }

    public boolean canBeAdded(int v, int path[], int pos) {
        // if vertex is already adjacent of previously added vertex
        if (this.graph.getAdj()[pos - 1][v] == 0) {
            return false;
        }

        // check if vertex already included
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) return false;
        }

        // in any other case return true
        return true;
    }

    public boolean solveHamCircuit(int V, int path[], int pos) {
        // check if all are included and if it makes a circle
        if (pos == V) {
            if (this.graph.getAdj()[path[pos - 1]][path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        // try adding different vertices
        for (int v = 1; v < V; v++) {
            // check if it can be added
            if (canBeAdded(v, path, pos)) {
                path[pos] = v;

                // call function again recursively to build the path
                if (solveHamCircuit(V, path, pos + 1) == true) {
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
