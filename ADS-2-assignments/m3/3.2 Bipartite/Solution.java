import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // Unused Constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int vertices = scan.nextInt();
        int edges = scan.nextInt();
        Graph g = new Graph(vertices);
        while (edges > 0) {
            String[] tokens = scan.nextLine().split(" ");
            g.addEdge(Integer.parseInt(tokens[0]),
            	Integer.parseInt(tokens[1]));
            edges--;
        }
        Bipartite bp = new Bipartite(g);
        if (bp.isBipartite()) {
            System.out.println("Graph is bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
    }
}
