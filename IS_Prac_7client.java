package ispracs;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class Client2 { 
    public static void main(String[] args) throws IOException  { 
        int n=11,g=7;
         Scanner sc = new Scanner (System.in);
            InetAddress ip = InetAddress.getLocalHost(); 
            Socket s = new Socket(ip, 5000); 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
       System.out.println("connection done !");
DataInputStream d1 = new DataInputStream(s.getInputStream());
DataOutputStream d2 = new DataOutputStream(s.getOutputStream());
  System.out.println("Enter B's private key" );
    double y=sc.nextDouble();
double b=(Math.pow(g, y))% n;
String str = d1.readUTF(); System.out.println("received msg from Server" + str);
System.out.println("sent msg to server"+b );
d2.writeUTF(b+"");
double a = Double.valueOf(str);
double k2 = (Math.pow(a, y))%n;
System.out.println("sent msg to server"+k2 );
d2.writeUTF(k2+"");
str = d1.readUTF();
System.out.println("received msg from Server "+ str);
if(str.equals(k2+""))
System.out.println("Keys matched");
else
System.out.println("Keys are not matched");
} } 
