import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfvertices = Integer.parseInt(sc.nextLine());
        int numberOfedges = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(numberOfvertices);
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(" ");
            Edge e = new Edge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
            ewgraph.addEdge(e);
        }
        KruskalMST mst = new KruskalMST(ewgraph);
        System.out.format("%.5f", mst.weight());
    }
}
