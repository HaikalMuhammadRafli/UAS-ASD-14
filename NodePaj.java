
public class NodePaj {

    NodePaj prev;
    TransaksiPajak transaksiPajak;
    NodePaj next;

    NodePaj(NodePaj prev, TransaksiPajak transaksiPajak, NodePaj next) {
        this.prev = prev;
        this.transaksiPajak = transaksiPajak;
        this.next = next;
    }
}