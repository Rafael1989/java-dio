package one.digitalinnovation.basecamp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Stream2 {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1","0","4","1","2","3","9","9","6","5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        numerosAleatorios.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        numerosAleatorios.forEach(s -> System.out.println(s));
        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        numerosAleatorios.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });
        numerosAleatorios.stream().map(s -> Integer.parseInt(s));
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if (i % 2 == 0 && i > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);
        List<Integer> listParesMaioresQue3 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2)).collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);

        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores impares");
        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
        System.out.println(numerosAleatoriosInteger);

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante: ");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("Retirando os números repetidos da lista, quantos números ficam?");
        int size = numerosAleatorios.stream()
                .collect(Collectors.toSet())
                .size();
        System.out.println(size);

        System.out.println("Mostre o menor valor da lista: ");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .min(Integer::compare)
                .ifPresent(System.out::println);

        System.out.println("Mostre o maior valor da lista: ");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .max(Integer::compare)
                .ifPresent(System.out::println);

        System.out.println("Pegue apenas os números impares e some: ");
        int sum = numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(i -> (i % 2 != 0))
                .sum();
        System.out.println(sum);

        System.out.println("Mostre a lista na ordem numerica: ");
        numerosAleatorios.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Agrupe os valores impares multiplos de 3 e de 5: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(i -> (i % 3 == 0 || i % 5 == 0) && i % 2 != 0)
                .forEach(System.out::println);



    }
}
