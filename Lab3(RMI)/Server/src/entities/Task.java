package entities;

import entities.MathInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Task extends UnicastRemoteObject implements MathInterface {
    public Task() throws RemoteException {
        int a, b;
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double div(int a, int b) throws RemoteException {
        return a / b;
    }

    @Override
    public double avg(int a, int b) throws RemoteException {
        return (a + b) / 2;
    }
}
