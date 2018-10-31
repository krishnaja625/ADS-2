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
     * MAin method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        sc.nextLine();
        DiGraph dg = new DiGraph(vertices);
        while (sc.hasNext()) {
            String num = sc.nextLine();
            String[] numbers = num.split(" ");
            dg.addEdge(Integer.parseInt(numbers[0]),
                Integer.parseInt(numbers[1]));
        }
        DirectedCycle cc = new DirectedCycle(dg, 0);
        if (cc.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");

        }
    }
}

