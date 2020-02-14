//program for client application
import java.rmi.*;
import java.util.*;

public class Client
{
	public static void main(String args[])
	{
		String answer,value="Reflection in Java";
		try
		{
			// lookup method to find reference of remote object
			Search access =
				(Search)Naming.lookup("rmi://localhost:1900"+
									"/geeksforgeeks");
      String str = "graph1";
      int num[] = {1, 2, 3};
      access.add_graph(str, 6);
      access.add_edge(str, num);
      int num2[] = {4, 5, 6};
      access.add_edge(str, num2);
      int val[] = access.get_mst(str);
      System.out.print("Graph of " + str + " contains ");
      for (int i = 0; i < 6; i++)
        System.out.print(" " + String.valueOf(val[i]));
      System.out.print("\n");
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
	}
}

