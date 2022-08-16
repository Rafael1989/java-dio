package one.digitalinnovation.basecamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();
        Double soma = 0d;
        Double media = 0d;
        for (int i = 0; i < 6; i++){
            System.out.println("Digite a temperatura do mes " + (i +1));
            double temperatura = scanner.nextDouble();
            temperaturas.add(temperatura);
            soma += temperatura;
        }
        media = soma / 6;

        for (int i = 0; i < temperaturas.size(); i++){
            if(temperaturas.get(i) > media){
                switch (i+1){
                    case 1:
                        System.out.println("Janeiro");
                        break;
                    case 2:
                        System.out.println("Fevereiro");
                        break;
                    case 3:
                        System.out.println("Marco");
                        break;
                    case 4:
                        System.out.println("Abril");
                        break;
                    case 5:
                        System.out.println("Maio");
                        break;
                    case 6:
                        System.out.println("Junho");
                        break;
                    default:
                        System.out.println("Mes invalido");
                        break;
                }
            }
        }
    }
}
