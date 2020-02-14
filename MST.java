import java.util.*;
import java.lang.*;
import java.io.*;

public class MST
{
  int V;
  int graph[][];
  MST(int num_verts, int fin_graph[][])
  {
    super();
    V = num_verts;
    graph = fin_graph;
  }

  int minKey(int key[], boolean mstSet[])
  {
    int min = Integer.MAX_VALUE;
    int min_index = -1;
    for (int v = 0; v < V; v++)
    {
      if (mstSet[v] == false && key[v] < min)
      {
        min = key[v];
        min_index = v;
      }
    }
    return min_index;
  }

  int retrieve(int parent[], boolean mstSet[])
  {
    int sum = 0;
    for (int i = 1; i < V; i++)
    {
        sum += graph[i][parent[i]];
    }
    return sum;
  }

  int primMST()
  {
    int parent[] = new int[V];
    int key[] = new int[V];
    boolean mstSet[] = new boolean[V];
    for (int i = 0; i < V; i++)
    {
      key[i] = Integer.MAX_VALUE;
      mstSet[i] = false;
    }
    key[0] = 0;
    parent[0] = -1;
    for (int ix = 0; ix < V - 1; ix++)
    {
      int u = minKey(key, mstSet);
      // System.out.println("This is the minKey: " + u);
      if (u == -1) return -1;
      mstSet[u] = true;
      for (int v = 0; v < V ; v++)
      {
        if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v])
        {
          parent[v] = u;
          key[v] = graph[u][v];
        }
      }
    }
    return retrieve(parent, mstSet);
  }
}
