import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        Graph graph = new Graph(vertices);
        int edges = sc.nextInt();
        while (sc.hasNext()) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        Bipartite bp = new Bipartite(graph);
        if (bp.isBipartite()) {
            System.out.println("Graph is bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
    }
}
