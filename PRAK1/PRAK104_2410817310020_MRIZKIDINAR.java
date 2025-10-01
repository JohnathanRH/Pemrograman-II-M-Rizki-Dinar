import java.util.Scanner;

public class PRAK104_2410817310020_MRIZKIDINAR {

    public static char[] input()
    {
        char arr[] = new char[3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            if(sc.hasNext())
            {
                arr[i] = sc.next().charAt(0);
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        char abu[] = new char[3];
        char bagas[] = new char[3];
        int skor_abu = 0;
        int skor_bagas = 0;

        System.out.print("Tangan Abu ");
        abu = input();

        System.out.print("Tangan Bagas ");
        bagas = input();

        for (int i = 0; i < 3; i++) {
            if(abu[i] == bagas[i]){continue;}

            switch (abu[i])
            {
                case 'G' :
                    if (bagas[i] == 'B'){skor_bagas++;}
                    else if(bagas[i] == 'K'){skor_abu++;}
                case 'B' :
                    if (bagas[i] == 'K'){skor_bagas++;}
                    else if(bagas[i] == 'G'){skor_abu++;}
                case 'K' :
                    if (bagas[i] == 'G'){skor_bagas++;}
                    else if(bagas[i] == 'B'){skor_abu++;}
            }
        }

        if (skor_abu == skor_bagas)
        {
            System.out.print("Seri");
        }
        else if (skor_abu > skor_bagas)
        {
            System.out.print("Abu");
        }
        else if (skor_abu < skor_bagas) {
            System.out.print("Bagas");
        }
    }
}