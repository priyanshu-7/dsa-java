// "static void main" must be defined in a public class.
public class Graphs {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        /*
        0 -> 1, 2
        1 -> 0, 1, 2, 3
        2 -> 0, 1
        3 -> 1
        */
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        BFS(adj, 0);
        shortestPath(adj, 0);
    }
    static void addEdge(ArrayList<ArrayList<Integer>> arr, int u, int v) {
        arr.get(u).add(v);
        arr.get(v).add(u);
    }
    static void BFS(ArrayList<ArrayList<Integer>> adj, int source) {
        boolean visited[] = new boolean[adj.size()-1];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            System.out.println(curr);
            for(int vertex:adj.get(curr)) {
                if(visited[vertex] == false) {
                    visited[vertex] = true;
                    q.offer(vertex);
                }
            }
        }
    }
    static void shortestPath(ArrayList<ArrayList<Integer>> adj, int source) {
        boolean visited[] = new boolean[adj.size()-1];
        int[] distance = new int[adj.size()-1];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        //visited[source] = true;
        distance[source] = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int vertex:adj.get(curr)) {
                if(visited[vertex] == false) {
                    distance[vertex] = distance[curr]+1;
                    visited[vertex] = true;
                    q.add(vertex);
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
    //For disconnected graphs, run BFS on for each source.
    /*static void bfsHelper(ArrayList<ArrayList<Integer>> adj, int source) {
        boolean visited[] = new int[adj.size()];
        for(int i = 0; i<adj.size(); i++) {
            if(visited[i] == false) {
                BFS(adj, i, visited);
            }
        }
    }*/
}
