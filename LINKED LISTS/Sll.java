
public class Sll {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            // this.next=null;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    static int size = 0;
    public static Node head;
    public static Node tail;

    public static void insfirst(int val) {
        Node n = new Node(val);
        if (head == null) {
            head = n;
            tail = n;
            size += 1;
            return;
        }
        n.next = head;
        head = n;
        size += 1;
    }

    public static void inslast(int val) {
        Node k = new Node(val);
        tail.next = k;
        tail = k;
        size += 1;
    }

    public static void insertatpos(int val, int pos) {
        Node k = new Node(val);
        Node temp = head;
        int i = 1;
        if (size == 0) {
            insfirst(val);
            return;
        }
        if (pos == size) {
            inslast(val);
            return;
        }
        while (i < pos) {
            temp = temp.next;
            i += 1;
        }
        k.next = temp.next;
        temp.next = k;
        size += 1;

    }

    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }

    public static void delf() {
        if (head == null) {
            System.out.println("no sufficient elements");
            return;
        }
        head = head.next;
        size -= 1;
    }

    public static void dellast() {
        if (tail == null) {
            System.out.println("no sufficient elements");
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size -= 1;
    }

    public static void deleteatpos(int pos) {
        if (pos == size) {
            dellast();
            return;
        }
        if (pos > size) {
            System.out.println("pos length exceeding");
            return;
        }
        Node temp = head;
        int i = 1;
        while (i < pos) {
            temp = temp.next;
            i += 1;
        }
        temp.next = temp.next.next;
        size -= 1;
    }

    public static boolean search(int val) {
        Node temp = head;
        if (head == null) {
            return false;
        }
        while (temp != null) {
            if (temp.val == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void update(int val, int upd) {
        Node temp = head;
        if (head == null) {
            return;
        }
        while (temp != null) {
            if (temp.val == val) {
                temp.val = upd;
                return;
            }
            temp = temp.next;
        }

    }

    public static void insr(Node temp, int val, int pos, int count) {
        if (temp == null) {
            System.out.println("exceeded");
            return;
        }
        if (count == pos - 1) {
            Node nn = new Node(val);
            nn.next = temp.next;
            temp.next = nn;
        }
        insr(temp.next, val, pos, count += 1);
    }

    public static void main(String[] args) {
        // Sll ll = new Sll();
        insfirst(5);
        insfirst(10);
        inslast(15);
        insertatpos(20, 2);
        insertatpos(55, 1);
        // delf();
        // dellast();
        // deleteatpos(1);
        // update(55, 10);
        insr(head, 100, 3, 1);
        display();
        // System.out.println(search(20));
        System.out.println(size);
    }
}