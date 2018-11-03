import java.util.Scanner;
class PageRank {
	double[] pR;
	Iterable<Integer> adJ;
	PageRank(Digraph dgraph) {
		
        for (int i = 0; i < dgraph.v(); i++) {
        	pR[i] = 1 / (dgraph.v());
        	pR[i] = getPR(i, dgraph);    
        }

	}
	double getPR(int vertice, Digraph dgraph) {
        adJ = dgraph.adj(vertice);
        double prval = 0;
		for(int j = 0; j < 1000; j++) {
			for (int i : adJ) {
				prval += pR[vertice] / dgraph.outdegree(i);
			}
			pR[vertice] = prval;
		}
		return pR[vertice];
	}
	
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		 Digraph dg = new Digraph(vertices);
		for (int i = 0; i < vertices; i++) {
			String[] tokens = sc.nextLine().split(" ");
			for (int j = 1; j < tokens.length; j++) {
				dg.addEdge(Integer.parseInt(tokens[0]),
                               Integer.parseInt(tokens[j]));

			}
		}

		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		
		
		// Create page rank object and pass the graph object to the constructor
		
		// print the page rank object
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
