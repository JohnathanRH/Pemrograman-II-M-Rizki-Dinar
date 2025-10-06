package praktikum2.soal1;

public class Main {
    public static void main(String[] args) {
        Buah apel = new Buah(
                "apel",
                0.4f,
                7000f,
                40
        );

        Buah mangga = new Buah(
                "mangga",
                0.2f,
                3500f,
                15
        );

        Buah alpukat = new Buah(
                "alpukat",
                0.25f,
                10000,
                12
        );

        apel.show_data();
        mangga.show_data();
        alpukat.show_data();
    }
}