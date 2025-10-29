package soal2;

public class Kucing extends HewanPeliharaan{
    String warnaBulu;

    public Kucing(
            String n,
            String r,
            String w
    ) {
        super(n, r);
        warnaBulu = w;
    }

    public void displayDetailKucing()
    {
        super.display();
        System.out.println(
                "Memiliki warna bulu : " + warnaBulu
        );
    }
}
