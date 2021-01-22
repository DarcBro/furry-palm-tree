import entities.Task;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args)
    {
        try
        {
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
            r.rebind("server", new Task());
            System.out.println("Server is live!\nStart the client");
        } catch (RemoteException e)
        {
            System.out.println("Wasted" + e);
        }
    }
}
