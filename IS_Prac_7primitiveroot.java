//Program : function to check whether the number is a primitive root of modulo prime.
package ispracs;
import java.util.ArrayList;
import java.util.Scanner;
public class Diffehelman {
    public static void main(String[] args) {
        System.out.println("Enter the value of n Prime Number:");
        Scanner sc=new Scanner(System.in);
        double n=sc.nextDouble();
        System.out.println("Enter the value of g:");
        double g= sc.nextDouble();
        if(primitiveRoot(g, n))
        {
            System.out.println("g is the primitive root of n........");
        }        
    }
    static boolean primitiveRoot(double a,double n){
        int count=1,flag=0;
        ArrayList<Double> as=new ArrayList<Double>();
        while(true)
        {
           double b=Math.pow(a, count-1); 
           double c=b%n;
           c=c*a;
           double v=c%n;
           as.add(v);
           double p=1.0;
           if(v==p)
               if(as.contains((double)count))
               {flag=1;
               System.out.println(count+"  "+b*a+"  =  "+b+" *  "+a+" = "+b+" mod "+n+" * " +a+" = "+v+" mod "+n+" = "+v);break;}
           System.out.println(count+"  "+b*a+"  =  "+b+" *  "+a+" = "+b+" mod "+n+" * " +a+" = "+v+" mod "+n+" = "+v);
           count++;
        }
        if(flag==1)
            return true;
        else
            return false;
    }
}
