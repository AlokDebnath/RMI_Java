// Creating a Search interface
import java.rmi.*;
public interface Search extends Remote
{
	// Declaring the method prototype
  public void add_graph(String str, int numNodes) throws RemoteException;
	public void add_edge(String str, int edge[]) throws RemoteException;
	public int get_mst(String str) throws RemoteException;
}
