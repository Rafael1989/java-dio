package one.digitalinnovation.basecamp;

public class Main7 {

    public static void main(String[] args) {
        System.out.println("Exercicio retornos");

        double areaQuadrado = QuadrilateroReturn.area(3);
        System.out.println("Area do quadrado:" + areaQuadrado);

        double areaRetangulo = QuadrilateroReturn.area(5,5);
        System.out.println("Area do retangulo:" + areaRetangulo);

        double areaTrapezio = QuadrilateroReturn.area(7,8,9);
        System.out.println("Area do trapezio:" + areaTrapezio);
    }
}
