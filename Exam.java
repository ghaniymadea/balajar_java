package belajar_2;
//Overloading
class CobaHitung{
    int p, l;
    double r;

    int hitung(int p , int l){
        return (p*l);
    }
    double hitung(double r){
        return (2*3.14*r);
    }
}
public class Exam extends CobaHitung{
    public static void main(String[] args) {
        Exam datar = new Exam();
        System.out.println("Hitung Luas Persegi Panjang = "+ datar.hitung(5, 4));
        System.out.println("Hitung Keliling Lingkaran = "+ datar.hitung(6));
    }
}
