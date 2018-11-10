import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int edges = sc.nextInt();
		sc.nextLine();
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		EdgeWeightedGraph eWG = new EdgeWeightedGraph(vertices);
		for (int i = 0; i < vertices; i++) {
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
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}