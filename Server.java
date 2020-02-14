//program for server application
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class Server
{
	public static void main(String args[])
	{
		try
		{
			// Create an object of the interface
			// implementation class
			Search obj = new SearchQuery();

			// rmiregistry within the server JVM with
			// port number given by user
      int port = Integer.parseInt(args[0]);
			LocateRegistry.createRegistry(port);

			// Binds the remote object by the name
			// geeksforgeeks
			Naming.rebind("rmi://localhost:" + args[0] + "/mst" ,obj);
      // System.out.println("Port binding successful");
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
	}
}

