package soal3;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ArrayList<Mahasiswa> list_mhs;

    public Menu(ArrayList<Mahasiswa> list_mhs)
    {
        this.list_mhs = list_mhs;
    }

    public void main_menu()
    {
        System.out.println(
                "Menu:\n"+
                "1. Tambah Mahasiswa\n"+
                "2. Hapus Mahasiswa berdasarkan NIM\n"+
                "3. Cari Mahasiswa berdasarkan NIM\n"+
                "4. Tampilkan Daftar Mahasiswa\n"+
                "0. Keluar\n"
        );
    }

    public void tambah_mhs()
    {
        String nama;
        String nim;

        System.out.print("Masukan Nama Mahasiswa: ");
        nama = sc.nextLine();
        System.out.print("Masukan NIM Mahasiswa (harus unik): ");
        nim = sc.nextLine();

        Mahasiswa mhs = new Mahasiswa(nama, nim);

        if(arr_search(nim) != null)
        {
            System.out.println("Mahasiswa dengan NIM tersebut sudah ada!");
            return;
        }

        this.list_mhs.add(mhs);
        System.out.println("Mahasiswa "+nama+" ditambahkan");
    }

    public void hapus_mhs()
    {
        String nim;
        System.out.print("Masukan NIM Mahasiswa yang akan dihapus: ");
        nim = sc.nextLine();

        Mahasiswa mhs = arr_search(nim);
        if(mhs != null)
        {
            list_mhs.remove(mhs);
        }
        else{System.out.println("Mahasiswa dengan NIM "+nim+" Tidak ditemukan!");}
    }

    public void cari_mhs() {
        String nim;
        System.out.print("Masukan NIM Mahasiswa yang ingin dicari: ");
        nim = sc.nextLine();

        Mahasiswa mhs = arr_search(nim);
        if (mhs != null)
        {
            System.out.println(
                "Mahasiswa ditemukan: \n"+
                "Nama: "+mhs.nama+"\n"+
                "NIM: "+mhs.nim+"\n"
            );
        }
        else{System.out.println("Mahasiswa dengan NIM "+nim+" Tidak ditemukan!");}
    }

    public void tampil_list_mhs()
    {
        if(list_mhs.isEmpty())
        {
            System.out.println("List mahasiswa masih kosong!");
            return;
        }
        for(Mahasiswa mhs : list_mhs)
        {
            System.out.println(
                    "NIM: "+mhs.nim+", Nama: "+mhs.nama
            );
        }
    }

    private Mahasiswa arr_search(String nim)
    {
        for(Mahasiswa mh : list_mhs)
        {
            if (mh.getNim().equals(nim))
            {
                return mh;
            }
        }
        return null;
    }
}
