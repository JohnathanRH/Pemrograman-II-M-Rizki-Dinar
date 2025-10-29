package soal2;

import java.util.List;

public class Anjing extends HewanPeliharaan{

    String warnaBulu;
    List<String> kemampuan;

    public Anjing(
            String n,
            String r,
            String w,
            List<String> k
    ) {
        super(n, r);
        warnaBulu = w;
        kemampuan = k;
    }

    public void displayDetailAnjing()
    {
        super.display();
        System.out.print(
                "Memiliki warna bulu : " + warnaBulu + "\n" +
                "Memiliki kemampuan : "
        );

        for(String k : kemampuan)
        {
            System.out.print(k);

            if(! kemampuan.getLast().equals(k))
            {
                System.out.print(", ");
            }
        }
    }
}
