/**
 * to import scanner class.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
/**
 * function for main }.
 *
 * @param      args  The arguments
 */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        sc.nextLine();
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        EdgeWeightedGraph eWG = new EdgeWeightedGraph(vertices);
        for (int i = 0; i < edges; i++) {
            String[] tokens = sc.nextLine().split(" ");
            Edge e = new Edge(Integer.parseInt(tokens[0]),
                              Integer.parseInt(tokens[1]),
                               Double.parseDouble(tokens[2]));
            eWG.addEdge(e);
        }
        // Take the Graph input here...

        String caseToGo = sc.nextLine();
        switch (caseToGo) {
        case "Graph":
        System.out.println(eWG);
            //Print the Graph Object.
            break;

        case "DirectedPaths":
            // Handle the case of DirectedPaths,
            //  where two integers are given.
            // First is the source and
            // second is the destination.
            String[] str = sc.nextLine().split(" ");
            DijkstraSP ds = new DijkstraSP(eWG,
                Integer.parseInt(str[0]));

            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            if (ds.hasPathTo(Integer.parseInt(str[1]))) {
                System.out.format("%.1f",
                    ds.distance(Integer.parseInt(str[1])));
            } else {
            System.out.println("No Path Found.");
            }
            break;

        case "ViaPaths":
            // Handle the case of ViaPaths, where three integers are given.
            String[] str1 = sc.nextLine().split(" ");
            boolean flag1 = false;
            boolean flag2 = false;
            double distance1 = Double.POSITIVE_INFINITY;
            double distance2 = Double.POSITIVE_INFINITY;
            StringBuilder str2 = new StringBuilder();
            StringBuilder str3 = new StringBuilder();
            // First is the source and second is the via is the one where path should pass throuh.
            DijkstraSP ds1 = new DijkstraSP(eWG,
                Integer.parseInt(str1[0]));
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            if (ds1.hasPathTo(Integer.parseInt(str1[1]))) {
                flag1 = true;
                distance1 = ds1.distance(Integer.parseInt(str1[1]));
                str2 = ds1.st();
            }
            DijkstraSP ds2 = new DijkstraSP(eWG, Integer.parseInt(str1[1]));
            if (ds2.hasPathTo(Integer.parseInt(str1[2]))) {
                flag2 = true;
                distance2 = ds2.distance(Integer.parseInt(str1[2]));
                str3 = ds2.st();
            }
                double distance = distance1 + distance2;
                if (flag1 && flag2) {
                System.out.format("%.1f", distance);
                System.out.println();
                System.out.println(str2.append(" " + str3));

            } else {
            System.out.println("No Path Found.");
            }
            break;

        default:
            break;
        }

    }
}
