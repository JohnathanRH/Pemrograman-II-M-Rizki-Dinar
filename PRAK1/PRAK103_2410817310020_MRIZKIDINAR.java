import java.util.Scanner;

public class PRAK103_2410817310020_MRIZKIDINAR {
    public static void main(String[] args) {
        int i = 0;
        int n;
        int start;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        start = sc.nextInt();

        do{
            if(start % 2 != 0)
            {
                System.out.print(start + " ");
                i++;
            }
            start++;
        }
        while (i < n);

        sc.close();
    }
}