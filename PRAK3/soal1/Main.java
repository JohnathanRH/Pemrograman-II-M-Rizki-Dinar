package soal1;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dadu> dadus = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();


        for (int i = 0; i < input; i++) {
            dadus.add(new Dadu(1,6));
            Dadu dadu_sekarang = dadus.get(i);
            System.out.println("Dadu ke-"+(i+1)+" bernilai "+dadu_sekarang.getNilai());
        }

        sc.close();
    }
}