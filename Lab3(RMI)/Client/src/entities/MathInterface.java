package entities;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathInterface extends Remote {
    public int add(int x, int y) throws RemoteException;
    public int sub(int x, int y)throws RemoteException;
    public int mul(int x, int y)throws RemoteException;
    public double div(int x, int y)throws RemoteException;
    public double avg(int x, int y) throws RemoteException;
}
