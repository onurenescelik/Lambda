package lambda04;

public class Universite {
    //ENCAPSULATION

    private String fakulte;
    private String bolum;
    private int notOrtalamasi;
    private int ogrenciNo;


    public Universite(String fakulte, String bolum, int notOrtalamasi, int ogrenciNo) {
        this.fakulte = fakulte;
        this.bolum = bolum;
        this.notOrtalamasi = notOrtalamasi;
        this.ogrenciNo = ogrenciNo;
    }

    public String getFakulte() {
        return fakulte;
    }

    public String getBolum() {
        return bolum;
    }

    public int getNotOrtalamasi() {
        return notOrtalamasi;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "fakulte='" + fakulte + '\'' +
                ", bolum='" + bolum + '\'' +
                ", notOrtalamasi=" + notOrtalamasi +
                ", ogrenciNo=" + ogrenciNo +
                '}';
    }
}
