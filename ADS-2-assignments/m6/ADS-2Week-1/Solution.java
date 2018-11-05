import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
class PageRank {
	double[] pR;
	Digraph dgraph;
	Digraph revgraph;
	int vertic;
	Iterable<Integer> adJ;
	PageRank(Digraph dgra) {
		dgraph = dgra;
		revgraph = dgraph.reverse();
		vertic = dgraph.v();
		int x = dgra.v();
		double y = 1.0 / (double) x;
		pR = new double[vertic];
        for (int i = 0; i < vertic; i++) {
        	pR[i] = y;
        	pR[i] = getPR(i);    
        }

	}
	double getPR(int vertice) {
		   for (int i = 0; i < vertic; i++) {
            if (dgraph.outdegree(i) == 0) {
                for (int j = 0; j < vertic; j++) {
                    if (i != j) {
                        dgraph.addEdge(i, j);
                    }
                }
            }
        }  
        adJ = dgraph.adj(vertice);
        if (dgraph.indegree(vertice) == 0){

        	pR[vertice] = 0.0;

        } else {
		for(int j = 0; j < 1000; j++) {
        double prval = 0.0;
		for (int i : revgraph.adj(vertice)) {
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

/*class WebSearch {
	private HashMap<String, ArrayList<Integer>> h = new
    HashMap<String, ArrayList<Integer>>();
	WebSearch(PageRank pr, String f1) {
		Scanner sc1 = new Scanner(f1);
            while (sc1.hasNextLine()) {
                String[] tokens = sc1.nextLine().split(",");
                String[] words = tokens[1].split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (h.containsKey(words[i])) {
                        ArrayList<Integer> arraylist = h.get(words[i]);
                        arraylist.add(Integer.parseInt(tokens[0]));
                    } else {
                        ArrayList<Integer> arraylist = new ArrayList<Integer>();
                        arraylist.add(Integer.parseInt(tokens[0]));
                        h.put(words[i], arraylist);
                    }
                }
            }
		
	}
	int iAmFeelingLucky(String query) {
		if (!(h.containsKey(query))) {
			return -1;
		}
		ArrayList<Integer> id1 = h.get(query);
		return 11;
		pr.getMax()
		}

}
*/

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
		/*WebSearch ws = new WebSearch(pr, file);*/
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
	

	/*		while(sc.hasNext()){
			String str1 = sc.nextLine().replace("q=", "");
			ws.iAmFeelingLucky(str1);
		}*/


		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
