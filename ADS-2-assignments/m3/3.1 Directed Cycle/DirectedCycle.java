/**
 * Class for DirectedCycle.
 */
class DirectedCycle {
    /**
     * Boolean array for the vertices.
     */
    private boolean[] marked;
    /**
     * gives bool whether element is present or not in stack.
     */
    private boolean[] onStack;
    /**
     * Give the previous edge of the given vertex.
     */
    private int[] edgeTo;
    /**
     * Cycle is a stack to add cycle forming vertices.
     */
    private Stack<Integer> cycle;
    /**
     * Constructs the object.
     */
    DirectedCycle() {

    }

    /**
     * Constructs the object for DirectedCycle.
     *
     * @param      gr     { parameter_description }
     * @param      s     { parameter_description }
     */
    DirectedCycle(final DiGraph gr, final int s) {
        marked = new boolean[gr.ver()];
        onStack = new boolean[gr.ver()];
        edgeTo = new int[gr.ver()];
        validateVertex(s);
        // hasCycle =false;
        dfs(gr, s);
    }
    /**
     * performs DirectedCycle.
     *
     * @param      gr    { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final DiGraph gr, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : gr.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            // found new vertex, so recur
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(gr, w);
            } else if (onStack[w]) {

            // trace back directed cycle
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                // assert check();
            }
        }
        onStack[v] = false;
    }
    /**
     * Determines if it has cycle.
     *
     * @return     True if has cycle, False otherwise.
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**
     * to validate given vertex is in rangeor not.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int v1 = marked.length;
        if (v < 0 || v >= v1) {
            throw new IllegalArgumentException("vertex "
                + v + " is not between 0 and " + (v1 - 1));
        }
    }
}
