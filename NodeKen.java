public class NodeKen {

    NodeKen prev;
    Kendaraan kendaraan;
    NodeKen next;

    NodeKen(NodeKen prev, Kendaraan kendaraan, NodeKen next) {
        this.prev = prev;
        this.kendaraan = kendaraan;
        this.next = next;
    }
}
