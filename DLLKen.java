public class DLLKen {
    NodeKen head;
    int size;

    public DLLKen() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void daftarKendaraan(String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar) {
        Kendaraan newKendaraan = new Kendaraan(noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
        if (isEmpty()) {
            head = new NodeKen(null, newKendaraan, null);
        } else {
            NodeKen newNode = new NodeKen(null, newKendaraan, head);
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void tampilKendaraan() {
        if (!isEmpty()) {
            NodeKen tmp = head;

            System.out.println(
                    "==============================================================");
            System.out.println("Daftar Kendaraan");
            System.out.println(
                    "=============================================================================================================");
            System.out.printf("| %-10s | %-20s | %-10s | %-20s | %-10s | %-20s |\n", "Nomor TNKB", "Nama Pemilik",
                    "Jenis", "CC Kendaraan", "Tahun", "Bulan harus Bayar");
            System.out.println(
                    "=============================================================================================================");

            while (tmp != null) {

                System.out.printf("| %-10s | %-20s | %-10s | %-20s | %-10s | %-20s |\n", tmp.kendaraan.noTNKB,
                        tmp.kendaraan.nama, tmp.kendaraan.jenis, tmp.kendaraan.cc, tmp.kendaraan.tahun,
                        tmp.kendaraan.bulanHarusBayar);

                tmp = tmp.next;
            }

            System.out.println(
                    "=============================================================================================================");
        } else {
            System.out.println("Linked List Kosong!");
        }
    }

    public Kendaraan getKendaraan(String key) throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List Kosong!");
        }

        NodeKen tmp = head;
        while (tmp != null) {
            if (tmp.kendaraan.noTNKB.equals(key)) {
                return tmp.kendaraan;
            }
            tmp = tmp.next;
        }

        return null;
    }
}
