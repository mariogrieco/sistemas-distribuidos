
public class Main {
    public static void main (String[] args) throws Exception {
       LoadBalancer servers = new LoadBalancer(1, 8, 8080);
        servers.distribute();
        servers.execute();
    }
}
