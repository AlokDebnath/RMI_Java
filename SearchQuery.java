// Java program to implement the Search interface
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class SearchQuery extends UnicastRemoteObject
						implements Search
{
  HashMap<String, Integer> graph_names;
  HashMap<String, int[]> graph;

  SearchQuery() throws RemoteException
	{
		super();
    graph_names = new HashMap<String, Integer>();
    graph = new HashMap<String, int[]>();
	}

  public void add_graph(String str, int numNodes) throws RemoteException
  {
    graph_names.put(str, numNodes);
    return;
  }

  public void add_edge(String str, int edge[]) throws RemoteException
  {
    // create hashmap
    graph.put(str, edge);
    return;
  }

  public int[] get_mst(String str) throws RemoteException
  {
    int val[] = graph.get(str);
    return val;
  }
}
