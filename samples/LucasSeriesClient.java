import java.rmi.Naming;
import java.util.Arrays;
import java.util.List;

public class LucasSeriesClient {
    public static void main(String[] args) {
        try {
            int n = 10;
            List<String> serverAddresses = Arrays.asList("localhost", "localhost", "localhost", "localhost");
            int[] lucasSeries = LucasSeriesLoadBalancer.calculateLucasSeries(n, serverAddresses);
            System.out.println("Los primeros " + n + " términos de la serie de Lucas son:");
            for (int i = 0; i < n; i++) {
                System.out.print(lucasSeries[i] + " ");
            }
        } catch (Exception e) {
            System.err.println("LucasSeriesClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
