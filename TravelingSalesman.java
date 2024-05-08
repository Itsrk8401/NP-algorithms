// Traveling Salesman Problem (TSP) implementation
public class TravelingSalesman {
    static int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
    };
    static int V = 4;
    static int minCost = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[V];
    
    static void tsp(int pos, int cost, int count) {
        if (count == V && graph[pos][0] > 0) {
            minCost = Math.min(minCost, cost + graph[pos][0]);
            return;
        }
        for (int i = 0; i < V; i++) {
            if (!visited[i] && graph[pos][i] > 0) {
                visited[i] = true;
                tsp(i, cost + graph[pos][i], count + 1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        visited[0] = true;
        tsp(0, 0, 1);
        System.out.println("Minimum cost: " + minCost);
    }
}
