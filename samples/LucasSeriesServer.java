import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LucasSeriesServer extends UnicastRemoteObject implements LucasSeries {
    public LucasSeriesServer() throws RemoteException {
        super();
    }

    public int[] calculateLucasSeries(int n) throws RemoteException {
        int[] lucasSeries = new int[n];
        lucasSeries[0] = 2;
        if (n > 1) {
            lucasSeries[1] = 1;
            for (int i = 2; i < n; i++) {
                lucasSeries[i] = lucasSeries[i - 1] + lucasSeries[i - 2];
            }
        }
        return lucasSeries;
    }

    public static void main(String[] args) {
        try {
            LucasSeriesServer server = new LucasSeriesServer();
            Naming.rebind("LucasSeries", server);
            System.out.println("LucasSeriesServer is running...");
        } catch (Exception e) {
            System.err.println("LucasSeriesServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
