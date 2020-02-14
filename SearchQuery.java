import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class SearchQuery extends UnicastRemoteObject
						implements Search
{
  HashMap<String, Integer> graph_names;
  HashMap<String, int[][]> graph;

  SearchQuery() throws RemoteException
	{
		super();
    graph_names = new HashMap<String, Integer>();
    graph = new HashMap<String, int[][]>();
	}

  public void add_graph(String str, int numNodes) throws RemoteException
  {
    graph_names.put(str, numNodes);
    int init_graph[][] = new int[numNodes][numNodes];
    for (int i = 0; i < numNodes; i++)
      for (int j = 0; j < numNodes; j++)
        init_graph[i][j] = 0;
    graph.put(str, init_graph);
    return;
  }

  public void add_edge(String str, int edge[]) throws RemoteException
  {
    int cur_graph[][] = graph.get(str);
    cur_graph[edge[0] - 1][edge[1] - 1] = edge[2];
    // add reverse edge as well since graph is undirected.
    cur_graph[edge[1] - 1][edge[0] - 1] = edge[2];
    graph.put(str, cur_graph);
    return;
  }

  public int get_mst(String str) throws RemoteException
  {
    int num_verts = graph_names.get(str);
    int fin_graph[][] = graph.get(str);
    MST mst = new MST(num_verts, fin_graph);
    return mst.primMST();
  }
}
