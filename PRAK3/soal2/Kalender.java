package soal2;

import java.util.HashMap;
import java.util.Map;

public class Kalender {
    private static HashMap<Integer, Map.Entry<String, Integer>> bulan = isi_bulan();

    private static HashMap<Integer, Map.Entry<String, Integer>> isi_bulan()
    {
        HashMap<Integer, Map.Entry<String, Integer>> bulan = new HashMap<>();
        bulan.put(1, Map.entry("Januari",31));
        bulan.put(2, Map.entry("Februari", 29));
        bulan.put(3, Map.entry("Maret", 31));
        bulan.put(4, Map.entry("April", 30));
        bulan.put(5, Map.entry("Mei", 31));
        bulan.put(6, Map.entry("Juni", 30));
        bulan.put(7, Map.entry("Juli", 31));
        bulan.put(8, Map.entry("Agustus", 31));
        bulan.put(9, Map.entry("September", 30));
        bulan.put(10, Map.entry("Oktober", 31));
        bulan.put(11, Map.entry("November", 30));
        bulan.put(12, Map.entry("Desember", 31));
        return bulan;
    }

    public static Map.Entry<String, Integer> getBulan(int no_bulan)
    {
        return bulan.get(no_bulan);
    }
}
