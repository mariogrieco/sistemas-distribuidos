import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LucasSeries extends Remote {
    int[] calculateLucasSeries(int n) throws RemoteException;
}
