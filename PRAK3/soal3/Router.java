package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Router {

    protected static void route(Menu menu, String path)
    {
        switch (path)
        {
            case "main_menu": menu.main_menu(); break;
            case "1": menu.tambah_mhs(); break;
            case "2": menu.hapus_mhs(); break;
            case "3": menu.cari_mhs(); break;
            case "4": menu.tampil_list_mhs(); break;
            default: menu.main_menu(); break;
        }
    }
}
