import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindEventualSafeStates {
    static int WHITE = 0, GRAY = 1, BLACK = 2;

    //https://leetcode.com/problems/find-eventual-safe-states/
    public static void main(String[] args) {
        System.out.println(new FindEventualSafeStates().eventualSafeNodes(new int[][]{
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        }));

        System.out.println("==============================================================================================================================");

        System.out.println(new FindEventualSafeStates().eventualSafeNodes(new int[][]{
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        }));

        System.out.println("==============================================================================================================================");

        System.out.println(new FindEventualSafeStates().eventualSafeNodes(new int[][]{
                {}, {0, 2, 3, 4}, {3}, {4}, {}
        }));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] color = new int[graph.length];
        for (int currentNode = 0; currentNode < graph.length; currentNode++) {
            System.out.println("Started Checking for : " + currentNode);
            if (color[currentNode] == BLACK || !isCyclic(currentNode, graph, color)) {
                res.add(currentNode);
            }
        }
        return res;
    }


    public List<Integer> eventualSafeNodes2(int[][] graph) {
        Set<Integer> cyclic = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int currentNode = 0; currentNode < graph.length; currentNode++) {
            int[] color = new int[graph.length];
            if (cyclic.contains(currentNode) || isCyclic(currentNode, graph, color)) {
                for (int clr = 0; clr < color.length; clr++) {
                    if (color[clr] == GRAY) {
                        System.out.println(clr + " is GRAY");
                        cyclic.add(clr);
                    }
                }
            } else {
                res.add(currentNode);
            }
            System.out.println(cyclic + " " + res);
        }
        return res;
    }

    private boolean isCyclic(int currentNode, int[][] graph, int[] color) {
        color[currentNode] = GRAY;
        System.out.print(currentNode + " :[");
        for (int i = 0; i < color.length; i++) {
            System.out.print(" " + color[i] + " ");
        }
        System.out.println("]");
        for (int child : graph[currentNode]) {
            if (color[child] == GRAY) {
                return true;
            } else if (color[child] == WHITE && isCyclic(child, graph, color))
                return true;
        }
        color[currentNode] = BLACK;
        System.out.println("reached end at " + currentNode);
        return false;
    }
}
