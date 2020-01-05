package ispracs;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class DeffiServer 
{
public static void main(String [] args) throws IOException
{ 
    ServerSocket s1 = new ServerSocket(5000);
    Socket s4 = s1.accept();
     System.out.println(InetAddress.getLocalHost());
    System.out.println(s4.toString());
    double n=11,g=7;
    Scanner sc = new Scanner (System.in);
    DataInputStream d1 = new DataInputStream(s4.getInputStream());
    DataOutputStream d2 = new DataOutputStream(s4.getOutputStream());
    System.out.println("Enter A's private key" );
    double x=sc.nextDouble();
    double a=(Math.pow(g, x))% n;
    d2.writeUTF(a+""); 
    System.out.println("sent msg to client"+a );
    String str = d1.readUTF();
    System.out.println("Received msg from client: "+ str );
    double b = Double.valueOf(str);
    double k1 = (Math.pow(b, x))%n;
    d2.writeUTF(k1+"");
    System.out.println("sent msg to client"+k1 );
    str = d1.readUTF();
    System.out.println("Received msg from client: "+ str );
    if(str.equals(k1+""))
    System.out.println("Keys matched");
    else
    System.out.println("Keys are not matched");
}
}
