import java.util.*;

public class MinimumCoins
{
    public static void main(String ar[]) throws Exception
    {
        int v, d=0;
        int smallest;
        List resultSet = new ArrayList();
        List<Integer> deno = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer value");
        v = sc.nextInt();
        while(true)
        {
            System.out.print("Enter Denominations (-1 to end)");
            d = sc.nextInt();
            if(d==-1)
                break;
            deno.add(d);
        }
        System.out.println(deno.size());
        if(v<=0)
            System.out.println(resultSet);
        l1:while(v!=0)
        {
            int i=0;
            while(i<deno.size())
            {
                if(v>=deno.get(i) && v< deno.get(i+1))
                {
                     if(i==0 || i==deno.size()-1)
                     {
                         System.out.println("Cannot find solution"+"\n"+"Try a different set of denominations");
                         break l1;
                     }
                     if(v==deno.get(i+1))
                     {
                         resultSet.add(deno.get(i));
                         v = v-deno.get(i);
                     }
                     else
                     {  
                         resultSet.add(deno.get(i));
                         v = v-deno.get(i);
                     }
                }
                i++;
            }
        }
        System.out.println(resultSet);
    }
}