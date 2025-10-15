package soal3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args)
    {
        ArrayList<Mahasiswa> list_mhs = new ArrayList<>();
        Menu menu = new Menu(list_mhs);
        boolean aktif = true;

        while(aktif)
        {
            Router.route(menu, "main_menu");
            Scanner sc = new Scanner(System.in);

            System.out.print("Pilihan: ");
            String inp = sc.nextLine();
//            sc.close();

            if(inp == "0")
            {
                System.out.println("Terima kasih!");
                return;
            }

            Router.route(menu, inp);
        }
    }
}
