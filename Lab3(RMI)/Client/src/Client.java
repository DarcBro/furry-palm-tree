import entities.MathInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            MathInterface mathInterface = (MathInterface) Naming.lookup("//localhost/server");
            System.out.println("Использование удаленного вызова метода\nВыбери необходимое действие:");
            System.out.println("1)Сумма прайсов"+"\n2)Разность прайсов"+"\n3)Произведение прайсов"+"\n4)Частное прайсов"+"\n5)Среднее значение прайсов");
            int action = scanner.nextInt();
            int x,y;
            switch (action){
                case 1:{
                    System.out.println("Введи первую цену");
                    x = scanner.nextInt();
                    System.out.println("Введи вторую цену");
                    y = scanner.nextInt();
                    System.out.println("Сумма =  "+ mathInterface.add(x,y));
                    break;
                }
                case 2:{
                    System.out.println("Введи первую цену");
                    x = scanner.nextInt();
                    System.out.println("Введи вторую цену");
                    y = scanner.nextInt();
                    System.out.println("Разность =  " + mathInterface.sub(x,y));
                    break;
                }
                case 3:{
                    System.out.println("Введи первую цену");
                    x = scanner.nextInt();
                    System.out.println("Введи вторую цену");
                    y = scanner.nextInt();
                    System.out.println("Произведение = " + mathInterface.mul(x,y));
                    break;
                }
                case 4:{
                    System.out.println("Введи первую цену");
                    x = scanner.nextInt();
                    System.out.println("Введи вторую цену");
                    y = scanner.nextInt();
                    System.out.println("Частное = " + mathInterface.div(x,y));
                    break;
                }
                case 5:{
                    System.out.println("Введи первую цену");
                    x = scanner.nextInt();
                    System.out.println("Введи вторую цену");
                    y = scanner.nextInt();
                    System.out.println("Среднее значение = " + mathInterface.avg(x,y));
                    break;
                }
            }
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
