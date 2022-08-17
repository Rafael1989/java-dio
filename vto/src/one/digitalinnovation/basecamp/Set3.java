package one.digitalinnovation.basecamp;

import java.util.*;

public class Set3 {
    public static void main(String[] args) {
        TreeSet<String> arcoIris = new TreeSet<>();
        arcoIris.add("Vermelho");
        arcoIris.add("Laranja");
        arcoIris.add("Amarelo");
        arcoIris.add("Verde");
        arcoIris.add("Azul");
        arcoIris.add("Anil");
        arcoIris.add("Violeta");
        System.out.println("Exiba todas as cores uma abaixo da outra: ");
        arcoIris.forEach(System.out::println);
        System.out.println("A quantidade de cores que o arco-íris tem: " + arcoIris.size());
        System.out.println("Exiba as cores em ordem alfabética: ");
        arcoIris.forEach(System.out::println);
        System.out.println("Exiba as cores na ordem inversa da que foi informada");
        Iterator<String> stringIterator = arcoIris.descendingIterator();
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }
        System.out.println("Exiba todas as cores que comecam com a letra v");
        for (String cor : arcoIris){
            if(cor.startsWith("V")){
                System.out.println(cor);
            }
        }
        System.out.println("Remova todas as cores que nao comecam com a letra v");
        Iterator<String> iterator = arcoIris.iterator();
        while (iterator.hasNext()){
            String cor = iterator.next();
            if(!cor.startsWith("V")) iterator.remove();
        }
        System.out.println(arcoIris);
        System.out.println("Limpe o conjunto");
        arcoIris.clear();
        System.out.println(arcoIris);
        System.out.println("Confira se o conjunto está vazio: " + arcoIris.isEmpty());


    }
}
