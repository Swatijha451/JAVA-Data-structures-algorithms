import java.util.*;
class Complex{
    int real;
    int imag;
    public Complex(int i,int r){
        real=r;
        imag=i;
    }
    public static  Complex complexNumbersSum(Complex c1, Complex c2){
        return new Complex(c1.real+c2.real, c1.imag+c2.imag);
    }
    public static Complex complexNumberDifference(Complex c1,Complex c2){
        return new Complex(c1.real-c2.real,c1.imag-c2.imag);
    }
    public static Complex complexNumberProduct(Complex c1, Complex c2){
        return new Complex(c1.real*c2.real-c1.imag*c2.imag, c1.real*c2.imag+c2.real*c1.imag);
    }
    public  void printcomplexnumber(){
        if(real==0 && imag!=0){
            System.out.println("i"+imag);

        } else if(real!=0&& imag==0){
            System.out.println(real);
        } else{
            System.out.println(real+" + "+"i"+imag);
        }
            
        
    }
}
public class complexnumbersusingclass {
    public static void main(String[] args) {
        
    
    Complex c1= new Complex(4,5);
    Complex c2= new Complex(5,7);
    Complex c= Complex.complexNumbersSum(c1,c2);
    c.printcomplexnumber();
    }
}
