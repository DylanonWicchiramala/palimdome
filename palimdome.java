import java.math.*;
import java.util.InputMismatchException;
import java.util.Scanner;
class palimdome {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        long inp = s.nextLong();

        System.out.println("revert num of "+inp+" is "+revert(inp));
        System.out.println();
        System.out.println("palimdome of "+inp+" is "+palimdome(inp));
        System.out.println();
        System.out.println(inp+" have "+m(inp)+" หลัก");
    }

    public static long revert(long minp) {
        if(errChk(minp) != 0){
            errChk(minp);
            return -1;
        }
        long out = 0;

        for (int i = 0; minp != 0; i++) {
            out += (minp % 10);
            out *= 10;
            minp /= 10;
        }
        return out / 10;
    }

    public static long palimdome(long minp) {
        if(errChk(minp) != 0){
            errChk(minp);
            return -1;
        }
            long rev = revert(minp);
            minp /= 10;
            minp *= Math.pow(10,m(minp)+1);
            minp += rev;
            return minp;
    }

    public static byte m(long minp){
        if(errChk(minp) != 0){
            errChk(minp);
            return -1;
        }
        byte coun = 0;
        while(minp != 0){
            minp /= 10;
            coun++;
        }
        return coun;
    }

    public static byte errChk(long data){
        if (data < 0){
            System.err.println("Error.try positive number.");
            return -1;
        }
        try{
            return 0;
        }
        catch (InputMismatchException e){
            System.err.println("Error.try input number.");
            return -2;
        }
        catch (Exception e){
            System.err.println("Error.unknown.");
            return -3;
        }
    }
}
