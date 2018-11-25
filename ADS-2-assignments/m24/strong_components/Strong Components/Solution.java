import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int condition = (vertex * (vertex - 1)) / 2;
        if (edge <= condition) {
            System.out.println("For " + vertex + " no. of vertices we have " + edge + " number of edges");
            System.out.println("");
            DigraphGenerator dg = new DigraphGenerator();
            System.out.println("The following are the types of graph along with strong components");
            int casenum = 1;
            switch (casenum) {
                case 1:
                    KosarajuSharirSCC kscc = new KosarajuSharirSCC(dg.complete(vertex));
                    int components = kscc.count();
                    System.out.println("1) For complete graph, No. of strong components are " + components);
                case 2:
                    kscc = new KosarajuSharirSCC(dg.simple(vertex, edge));
                    components = kscc.count();
                    System.out.println("2) For simple graph, No. of strong components are " + components);

                case 3:
                    kscc = new KosarajuSharirSCC(dg.path(vertex));
                    components = kscc.count();
                    System.out.println("3) For path graph, No. of strong components are " + components);
                case 4:
                    kscc = new KosarajuSharirSCC(dg.cycle(vertex));
                    components = kscc.count();
                    System.out.println("4) For cycle graph, No. of strong components are " + components);
                case 5:
                    kscc = new KosarajuSharirSCC(dg.eulerianPath(vertex, edge));
                    components = kscc.count();
                    System.out.println("5) For Eulierian path graph, No. of strong components are " + components);
                case 6:
                    kscc = new KosarajuSharirSCC(dg.eulerianCycle(vertex, edge));
                    components = kscc.count();
                    System.out.println("6) For Eulierian cycle graph, No. of strong components are " + components);
                case 7:
                    kscc = new KosarajuSharirSCC(dg.binaryTree(vertex));
                    components = kscc.count();
                    System.out.println("7) For binary tree, No. of strong components are " + components);
                    /*break;*/
                case 8:
                    kscc = new KosarajuSharirSCC(dg.tournament(vertex));
                    components = kscc.count();
                    System.out.println("8) For tournament, No. of strong components are " + components);
                case 9:
                    kscc = new KosarajuSharirSCC(dg.dag(vertex, edge));
                    components = kscc.count();
                    System.out.println("9) For DAG, No. of strong components are " + components);
                case 10:
                    kscc = new KosarajuSharirSCC(dg.rootedInDAG(vertex, edge));
                    components = kscc.count();
                    System.out.println("10) For rooted-in DAG, No. of strong components are " + components);
                case 11:
                    kscc = new KosarajuSharirSCC(dg.rootedOutDAG(vertex, edge));
                    components = kscc.count();
                    System.out.println("11) For rooted-out DAG, No. of strong components are " + components);
                case 12:
                    kscc = new KosarajuSharirSCC(dg.rootedInTree(vertex));
                    components = kscc.count();
                    System.out.println("12) For rooted-in tree, No. of strong components are " + components);
                case 13:
                    kscc = new KosarajuSharirSCC(dg.rootedOutTree(vertex));
                    components = kscc.count();
                    System.out.println("13) For rooted-out tree, No. of strong components are " + components);
                    break;
                default:
                    System.out.println("Wrong case number");
            } 
        } else {
            System.out.println("Number of edges for vertices " + vertex + " must be less than " + condition);
        }
    }
}