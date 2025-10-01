import java.util.Scanner;

public class PRAK102_2410817310020_MRIZKIDINAR {
    public static void main(String[] args) {
        int n;
        int i = 0;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        while(i < 11)
        {
            i++;
            int kalkulasi = n;

            if(kalkulasi % 5 == 0){
                kalkulasi = (kalkulasi / 5) -1;
            }

            System.out.print(kalkulasi + " ");
            n++;
        }
        sc.close();
    }
}