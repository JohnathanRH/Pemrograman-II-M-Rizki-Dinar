// V = pi*r*r*h
import java.util.Scanner;
public class PRAK105_2410817310020_MRIZKIDINAR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final float pi = 3.14f;
        float r;
        float h;
        float v;

        System.out.print("Masukan jari-jari: ");
        r = sc.nextFloat();

        System.out.print("Masukan tinggi: ");
        h = sc.nextFloat();

        v = pi*r*r*h;
        System.out.println(
            "Volume tabung dengan jari-jari "+r+
            " cm dan tinggi "+h+" cm adalah "+
            v+" m3"
        );
        sc.close();
    }
}