import java.util.*;

public class Activity {
    static class pair{
        int s;
        int e;
        pair(int s,int e)
        {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "Start is = "+s+" end is "+e;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while(t-- != 0)
        {
            int n = s.nextInt();
            List<pair> activites = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int si = s.nextInt();
                int ei = s.nextInt();
                activites.add(new pair(si,ei));
            }

            Collections.sort(activites, new Comparator<pair>() {
                @Override
                public int compare(pair o1, pair o2) {
                    return o1.e - o2.e;
                }
            });

           // System.out.println(activites);
            int count = 1;
            int end = activites.get(0).e;
            for(int i=1;i<activites.size();i++)
            {
                int start = activites.get(i).s;
                if(start >= end)
                {
                    count++;
                    end = activites.get(i).e;
                }
            }
            System.out.println(count);
        }
    }
}
