/**
 * Class for di graph.
 */
class DiGraph {
    /**
     * num of vertices.
     */
    private int v;
    /**
     * num of edges.
     */
    private int e;
    /**
     * bag type array.
     */
    private Bag<Integer>[] adj;

    /**
     * Constructs the object.
     */
    DiGraph() {

    }

    /**
     * Constructs the object.
     *
     * @param      v1    The v 1
     */
    DiGraph(final int v1) {
        this.v = v1;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] =  new Bag<Integer>();
        }
    }

    /**
     * No.of vertices.
     *
     * @return     { description_of_the_return_value }
     */
    public int ver() {
        return v;
    }

    /**
     * No.of edges.
     *
     * @return     { description_of_the_return_value }
     */
    public int edg() {
        return e;
    }

    /**
     * Adds an edge.
     *
     * @param      ve     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int ve, final int w) {
        // if (ve == w) {
        //     return;
        // }
        if (!hasEdge(ve, w)) {
            e++;
            adj[ve].add(w);
        }
    }

    /**
     * Determines if it has edge.
     *
     * @param      ve     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int ve, final int w) {
        for (int each: adj[ve]) {
                if (each == w) {
                    return true;
                }
        }
        return false;
    }

    /**
     * Iterable bag elements.
     *
     * @param      ve     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int ve) {
        return adj[ve];
    }
}