import java.rmi.Naming;
import java.util.List;

public class LucasSeriesLoadBalancer {
    public static int[] calculateLucasSeries(int n, List<String> serverAddresses) {
        int[] lucasSeries = null;
        int numServers = serverAddresses.size();
        int numTermsPerServer = n / numServers;
        int numTermsLastServer = numTermsPerServer + n % numServers;
        int startIndex = 0;
        int endIndex = 0;
        try {
            for (int i = 0; i < numServers; i++) {
                if (i == numServers - 1) {
                    endIndex += numTermsLastServer;
                } else {
                    endIndex += numTermsPerServer;
                }
                LucasSeries server = (LucasSeries) Naming.lookup("//" + serverAddresses.get(i) + "/LucasSeries");
                int[] partialLucasSeries = server.calculateLucasSeries(endIndex - startIndex);
                if (lucasSeries == null) {
                    lucasSeries = partialLucasSeries;
                } else {
                    System.arraycopy(partialLucasSeries, 0, lucasSeries, startIndex, endIndex - startIndex);
                }
                startIndex = endIndex;
            }
        } catch (Exception e) {
            System.err.println("LucasSeriesLoadBalancer exception: " + e.getMessage());
            e.printStackTrace();
        }
        return lucasSeries;
    }
}
