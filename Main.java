import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int pilihan;
        Kendaraan foundKendaraan = null;

        DLLKen dllKen = new DLLKen();
        dllKen.daftarKendaraan("S 4567 YV", "Basko", "Mobil", 2000, 2012, 4);
        dllKen.daftarKendaraan("N 4511 VS", "Arta", "Mobil", 2500, 2015, 3);
        dllKen.daftarKendaraan("AB 4321 A", "Wisnu", "Motor", 125, 2010, 2);
        dllKen.daftarKendaraan("B 1234 AG", "Sisa", "Motor", 150, 2020, 1);

        DLLPaj dllPaj = new DLLPaj();

        do {
            System.out.println(
                    "==============================================================");
            System.out.println("Menu");
            System.out.println(
                    "==============================================================");
            System.out.println("[1] Daftar Kendaraan");
            System.out.println("[2] Bayar Pajak");
            System.out.println("[3] Tampilkan Seluruh Transaksi");
            System.out.println("[4] Urutkan Transaksi Berdasarkan Nama Pemilik");
            System.out.println("[5] Keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    dllKen.tampilKendaraan();
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Masukkan Data Pembayaran");
                    System.out.print("Masukkan Nomor TNKB : ");
                    String noTNKB = sc.nextLine();
                    try {
                        foundKendaraan = dllKen.getKendaraan(noTNKB);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    if (foundKendaraan == null) {
                        System.out.println("Kendaraan tidak ditemukan!");
                    }
                    System.out.print("Masukkan Bulan Bayar : ");
                    int bulanBayar = sc.nextInt();
                    sc.nextLine();
                    dllPaj.daftarPajak(noTNKB, bulanBayar, foundKendaraan);
                    System.out.println();
                    break;

                case 3:
                    dllPaj.tampilTransaksi();
                    System.out.println();
                    break;

                case 4:
                    dllPaj.sortTransaksiPajak();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Goodbye ^_^");
                    break;

                default:
                    break;
            }

        } while (pilihan != 5);

        sc.close();
    }
}
