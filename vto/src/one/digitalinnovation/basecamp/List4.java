package one.digitalinnovation.basecamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> respostas = new ArrayList<>();
        System.out.println("Telefonou para a vítima? (S/N)");
        respostas.add(scanner.next());
        System.out.println("Esteve no local do crime? (S/N)");
        respostas.add(scanner.next());
        System.out.println("Mora perto da vítima? (S/N)");
        respostas.add(scanner.next());
        System.out.println("Devia para a vítima? (S/N)");
        respostas.add(scanner.next());
        System.out.println("Já trabalhou com a vítima? (S/N)");
        respostas.add(scanner.next());
        int count = 0;
        for (String resposta : respostas){
            if(resposta.equalsIgnoreCase("S")){
                count++;
            }
        }

        switch (count){
            case 0:
            case 1:
                System.out.println("Inocente");
                break;
            case 2:
                System.out.println("Suspeita");
                break;
            case 3:
            case 4:
                System.out.println("Cúmplice");
                break;
            case 5:
                System.out.println("Assassina");
                break;
            default:
                System.out.println("Número de respostas incorreto");
                break;
        }
    }
}
