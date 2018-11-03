import java.util.Scanner;
class PageRank {
	double[] pR;
	Digraph dgraph; 
	Iterable<Integer> adJ;
	PageRank(Digraph dgra) {
		dgraph = dgra;
		int x = dgraph.v();
        for (int i = 0; i < dgraph.v(); i++) {
        	pR[i] = 1 / x;
        	pR[i] = getPR(i);    
        }

	}
	double getPR(int vertice) {
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
	void tostring() {
        String str = "";
		for (int i = 0; i < dgraph.v(); i++) {
			str = "";
			str = i +" - "+ pR[i];
			System.out.println(str);
		}

	}
	
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		 Digraph dg = new Digraph(vertices);
		 try {
		for (int i = 0; i < vertices; i++) {
			String[] tokens = sc.nextLine().split(" ");
			for (int j = 1; j < tokens.length; j++) {
				dg.addEdge(Integer.parseInt(tokens[0]),
                               Integer.parseInt(tokens[j]));

			}
		}
		} catch (Exception e) {
            System.out.println(e);
        }
			System.out.println(dg);

		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		/*int x = dg.v();
		System.out.println(x);*/
		
		// Create page rank object and pass the graph object to the constructor
		PageRank pr = new PageRank(dg);
		pr.tostring();
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
