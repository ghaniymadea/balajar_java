package belajar_2;

class Hewan {
    void suara() {
        System.out.println("Hewan membuat suara");
    }
}

// Subclass
class Anjing extends Hewan {
    @Override
    void suara() {
        System.out.println("Anjing menggonggong");
    }
}

// Subclass lainnya
class Kucing extends Hewan {
    @Override
    void suara() {
        System.out.println("Kucing mengeong");
    }
}

// Main class
public class Senku {
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Anjing();
        Hewan hewan3 = new Kucing();

        hewan1.suara(); // Output: Hewan membuat suara
        hewan2.suara(); // Output: Anjing menggonggong
        hewan3.suara(); // Output: Kucing mengeong
    }
}
