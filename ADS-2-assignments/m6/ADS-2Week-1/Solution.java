import java.util.Scanner;
class PageRank {
	double[] pR;
	Digraph dgraph; 
	Iterable<Integer> adJ;
	PageRank(Digraph dgra) {
		dgraph = dgra;
		int x = dgraph.v();
		double y = 1.0 / (double) x;
		// System.out.println(y);
		pR = new double[x];
        for (int i = 0; i < x; i++) {
        	pR[i] = y;
        	// System.out.println(pR[i]);
        	pR[i] = getPR(i);    
        }

	}
	double getPR(int vertice) {
        adJ = dgraph.adj(vertice);
        double prval = 0.0;
        if (dgraph.indegree(vertice) == 0){
        	pR[vertice] = 0.0;

        } else {
		for(int j = 0; j < 1000; j++) {
			for (int i : adJ) {
				prval += (double) (pR[vertice] / dgraph.outdegree(i));
			}
			pR[vertice] = prval;
		}
		}
		return pR[vertice];

	}
	public String toString()  {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < dgraph.v(); i++) {
			s.append(i+" - "+pR[i]+"\n");
		}
		return s.toString();
	}
	}

class WebSearch {
	WebSearch(PageRank pr, String f1) {
		
	}

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
		System.out.println(pr);
		// print the page rank object
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		WebSearch ws = new WebSearch(pr, file);
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		while(sc.hasNext()){
			String str1 = sc.nextLine().replace("q=", "");
			System.out.println("str1");
		}
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
