import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree_Ex1 {
    public static void main(String[] args)
    {
        String[] result=new String[5];
        Queue<String> q=new LinkedList<>();
        q.add("1");
        for(int i=0;i<5;i++)
        {
            result[i]=q.poll();
            String n1=result[i]+"0";
            String n2=result[i]+"1";
            q.add(n1);
            q.add(n2);
        }
        System.out.print(Arrays.toString(result));
    }
}
