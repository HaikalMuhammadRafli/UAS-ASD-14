public class DLLPaj {
    NodePaj head;
    int size;
    int countAI;

    public DLLPaj() {
        head = null;
        size = 0;
        countAI = 1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void daftarPajak(String noTNKB, int bulanBayar, Kendaraan kendaraan) {
        int nominalBayar = 0;
        int denda = 0;

        if (kendaraan.jenis == "Motor") {
            if (kendaraan.cc < 100) {
                nominalBayar = 100000;
            } else if (kendaraan.cc >= 100 && kendaraan.cc <= 250) {
                nominalBayar = 250000;
            } else {
                nominalBayar = 500000;
            }
        } else {
            if (kendaraan.cc < 1000) {
                nominalBayar = 750000;
            } else if (kendaraan.cc >= 1000 && kendaraan.cc <= 2500) {
                nominalBayar = 1000000;
            } else {
                nominalBayar = 1500000;
            }
        }

        if (bulanBayar > kendaraan.bulanHarusBayar) {
            if (bulanBayar - kendaraan.bulanHarusBayar <= 3) {
                denda = 50000;
            } else {
                denda = (bulanBayar - kendaraan.bulanHarusBayar) * 50000;
            }
        }

        TransaksiPajak newTransaksi = new TransaksiPajak(countAI, nominalBayar, denda, bulanBayar, kendaraan);

        if (isEmpty()) {
            head = new NodePaj(null, newTransaksi, null);
        } else {
            NodePaj newNode = new NodePaj(null, newTransaksi, head);
            head.prev = newNode;
            head = newNode;
        }

        System.out.println(
                "==============================================================");
        System.out.println("Daftar Transaksi");
        System.out.println(
                "====================================================================================================================================================");
        System.out.printf("| %-6s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Kode", "Nomor TNKB",
                "Jenis Kendaraan",
                "Nama Pemilik", "Nominal Bayar", "Denda", "Bulan Bayar");
        System.out.printf("| %-6s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                newTransaksi.kode,
                newTransaksi.kendaraan.noTNKB,
                newTransaksi.kendaraan.jenis,
                newTransaksi.kendaraan.nama,
                newTransaksi.nominalBayar,
                newTransaksi.denda, newTransaksi.bulanBayar);
        System.out.println(
                "====================================================================================================================================================");

        size++;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void tampilTransaksi() {
        if (!isEmpty()) {
            NodePaj tmp = head;

            System.out.println(
                    "====================================================================================================================================================");
            System.out.println("Daftar Transaksi");
            System.out.println(
                    "====================================================================================================================================================");
            System.out.printf("| %-6s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Kode", "Nomor TNKB",
                    "Jenis Kendaraan",
                    "Nama Pemilik", "Nominal Bayar", "Denda", "Bulan Bayar");
            System.out.println(
                    "====================================================================================================================================================");

            while (tmp != null) {
                System.out.printf("| %-6s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", tmp.transaksiPajak.kode,
                        tmp.transaksiPajak.kendaraan.noTNKB,
                        tmp.transaksiPajak.kendaraan.jenis,
                        tmp.transaksiPajak.kendaraan.nama, tmp.transaksiPajak.nominalBayar,
                        tmp.transaksiPajak.denda, tmp.transaksiPajak.bulanBayar);

                tmp = tmp.next;
            }

            System.out.println(
                    "====================================================================================================================================================");

            getTotalPendapatan();
            ;
        } else {
            System.out.println("Linked List Kosong!");
        }
    }

    void sortTransaksiPajak() {
        if (!isEmpty()) {
            NodePaj current;
            NodePaj previous;
            boolean sorted;

            do {
                sorted = true;
                current = head;
                previous = null;

                while (current.next != null) {
                    if (current.transaksiPajak.kendaraan.nama
                            .compareTo(current.next.transaksiPajak.kendaraan.nama) > 0) {
                        NodePaj temp = current.next;
                        if (previous == null) {
                            head = temp;
                        } else {
                            previous.next = temp;
                        }
                        current.next = temp.next;
                        temp.next = current;

                        sorted = false;
                        previous = temp;

                    } else {
                        previous = current;
                        current = current.next;
                    }
                }
            } while (!sorted);
        } else {
            System.out.println("Error : Linked List Masih Kosong!");
        }
    }

    void getTotalPendapatan() {
        NodePaj current = head;
        int total = 0;

        while (current != null) {
            total += current.transaksiPajak.nominalBayar;
            total += current.transaksiPajak.denda;
        }

        System.out.println("Total pendapatan : " + total);
    }
}
