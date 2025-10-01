import java.util.Scanner;

public class PRAK101_2410817310020_MRIZKIDINAR {
    public static void main(String[] args) {

        String bulan[] = {
                "Januari", "Februari", "Maret",
                "April", "Mei", "Juni",
                "Juli", "Agustus", "September",
                "Oktober", "November", "Desember"
        };

        String nama;
        String tempat_lahir;
        int tanggal;
        int bulan_lahir = 0;
        int tahun_lahir;
        int tinggi_badan;
        float berat_badan = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukan Nama Lengkap: ");
        nama = scanner.nextLine();
        System.out.print("Masukan Tempat Lahir: ");
        tempat_lahir = scanner.nextLine();
        System.out.print("Masukan Tanggal Lahir: ");
        tanggal = scanner.nextInt();

        while(bulan_lahir < 1 || bulan_lahir > 12)
        {
            System.out.print("Masukan Bulan Lahir: ");
            bulan_lahir = scanner.nextInt() - 1;
        }

        System.out.print("Masukan Tahun Lahir: ");
        tahun_lahir = scanner.nextInt();
        System.out.print("Masukan Tinggi Badan: ");
        tinggi_badan = scanner.nextInt();

        while(berat_badan <= 0)
        {
            System.out.print("Masukan Berat badan: ");
            berat_badan = scanner.nextFloat();
        }

        System.out.println("\n");
        scanner.close();

        System.out.println(
            "Nama Lengkap "+nama+
            ", Lahir di "+tempat_lahir+
            " pada tanggal "+String.valueOf(tanggal)+
            " "+bulan[bulan_lahir]+
            " "+String.valueOf(tahun_lahir)+
            "\nTinggi Badan "+String.valueOf(tinggi_badan)+
            " cm dan Berat Badan "+String.valueOf(berat_badan)+
            " kilogram"
        );
    }
}