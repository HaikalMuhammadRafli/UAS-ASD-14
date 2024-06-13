public class TransaksiPajak {

    int kode;
    long nominalBayar;
    long denda;
    int bulanBayar;
    Kendaraan kendaraan;

    TransaksiPajak(int kode, long nominalBayar, long denda, int bulanBayar, Kendaraan kendaraan) {
        this.kode = kode;
        this.nominalBayar = nominalBayar;
        this.denda = denda;
        this.bulanBayar = bulanBayar;
        this.kendaraan = kendaraan;
    }
}
