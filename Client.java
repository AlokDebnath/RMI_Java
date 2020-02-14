import java.rmi.*;
import java.util.*;

public class Client
{
	public static void main(String args[])
	{
		String answer,value="Reflection in Java";
    ArrayList<Integer> sum_values = new ArrayList<Integer>();
		try
		{
			// lookup method to find reference of remote object
			Search access =	(Search)Naming.lookup("rmi://" + args[0] + ":" + args[1] + "/mst");

      Scanner sc = new Scanner(System.in);
      int sum = 0;
      while(sc.hasNextLine())
      {
        String line = sc.nextLine();
        String parts[] = line.split("\\s+");
        // for (int i = 0; i < parts.length; i++)
        //  System.out.println(parts[i]);

        switch(parts[0])
        {
          case "add_graph":
            access.add_graph(parts[1], Integer.parseInt(parts[2]));
            // System.out.println("Added Graph");
            break;
         case "add_edge":
            int edge[] = {Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])};
            access.add_edge(parts[1], edge);
            // System.out.println("Added edge");
            break;
         case "get_mst":
            System.out.println(parts[1]);
            sum = access.get_mst(parts[1]);
            // System.out.println("The sum is" + sum);
            sum_values.add(sum);
            break;
        }
		  }
      sc.close();
      // System.out.println("Hi!");
      for (int i = 0; i < sum_values.size(); i++)
        System.out.println(sum_values.get(i));
    }
		catch(Exception ae)
		{
			System.out.println(ae);
		}
	}
}

