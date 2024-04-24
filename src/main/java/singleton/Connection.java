package singleton;

public class Connection {
    private static Connection instance;
    private static int instanceCreated = 0;
    private int quantConnection;

    public Connection() {
        this.quantConnection = 0;
        instanceCreated++;
        // System.out.println(instanceCreated + "instanceCreated");
    }

    void setQuantConnection(int value) {
        this.quantConnection = value;
    }

    public int getQuantConnection() {
        return this.quantConnection;
    }

    public int getQuantInstance() {
        return instanceCreated;
    }

    public static Connection getInstance() {

        if (instance == null) {
            instance = new Connection();
        }
        // verifyConnections();
        return instance;
    }

    public void verifyConnections() {
        if (this.quantConnection > 15) {
            instance = new Connection();
        }
    }

}
