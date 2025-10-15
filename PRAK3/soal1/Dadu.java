package soal1;
import java.util.random.RandomGenerator;
import java.util.Random;

public class Dadu {

    private int nilai, origin, bound;

    public Dadu(int origin, int bound)
    {
        this.origin = origin;
        this.bound = bound;
        nilai = acakNilai();
    }

    private int acakNilai()
    {
        RandomGenerator rng = new Random();
        int acak = rng.nextInt(origin, bound+1);
        return acak;
    }

    public int getNilai()
    {
        return nilai;
    }
}
