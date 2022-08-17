package one.digitalinnovation.basecamp;

import java.util.*;

public class Map3 {
    public static void main(String[] args) {
        Map<String, Long> populacoes = new HashMap<>();
        populacoes.put("PE",9616621L);
        populacoes.put("AL",3351543L);
        populacoes.put("CE",9187103L);
        populacoes.put("RN",3534265L);
        populacoes.put("RN",3535165L);
        populacoes.put("PB",4039277L);
        System.out.println("Populacao PE: " + populacoes.get("PE"));

        System.out.println("Exiba todos os estados e suas populacoes na ordem que foi informado: ");
        Map<String, Long> populacoes1 = new LinkedHashMap<>();
        populacoes1.put("PE",9616621L);
        populacoes1.put("AL",3351543L);
        populacoes1.put("CE",9187103L);
        populacoes1.put("RN",3534265L);
        populacoes1.put("RN",3535165L);
        populacoes1.put("PB",4039277L);
        for(Map.Entry<String,Long> populacao : populacoes1.entrySet())
            System.out.println(populacao.getKey() + " - " + populacao.getValue());

        System.out.println("Exiba os estados e suas populacoes em ordem alfabetica: ");
        Map<String, Long> populacoes2 = new TreeMap<>(populacoes1);
        for(Map.Entry<String,Long> populacao : populacoes2.entrySet())
            System.out.println(populacao.getKey() + " - " + populacao.getValue());

        System.out.println("Exiba o estado com menor populacao e sua quantidade");
        Long menorPopulacao = Collections.min(populacoes1.values());
        Set<Map.Entry<String, Long>> entries2 = populacoes1.entrySet();
        String estado = "";
        for(Map.Entry<String, Long> entry : entries2){
            if(entry.getValue().equals(menorPopulacao)){
                estado = entry.getKey();
                System.out.println("Estado com menor populacao: " + estado + " - " + menorPopulacao);
            }
        }

        System.out.println("Exiba o estado com maior populacao e sua quantidade");
        Long maiorPopulacao = Collections.max(populacoes1.values());
        Set<Map.Entry<String, Long>> entries1 = populacoes1.entrySet();
        String estado1 = "";
        for(Map.Entry<String, Long> entry : entries1){
            if(entry.getValue().equals(maiorPopulacao)){
                estado1 = entry.getKey();
                System.out.println("Estado com maior populacao: " + estado1 + " - " + maiorPopulacao);
            }
        }


        Iterator<Long> iterator = populacoes1.values().iterator();
        Long soma = 0L;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da populacao desses estados: " + soma);

        System.out.println("Exiba a media da populacao deste dicionario de estados: " + (soma/populacoes1.size()));

        System.out.println("Remova os estados com a populacao menor que 4000000: ");
        Iterator<Long> iterator1 = populacoes1.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next() < 4000000) iterator1.remove();
        }
        for(Map.Entry<String,Long> populacao : populacoes1.entrySet())
            System.out.println(populacao.getKey() + " - " + populacao.getValue());

        System.out.println("Apague o dicionario de estados: ");
        populacoes.clear();

        System.out.println("Confira se o dicionario esta vazio: " + populacoes.isEmpty());

        Random random = new Random();
        Map<Integer,Integer> lancamentoDado = new HashMap<>();
        Integer contador = 1;
        for (int i = 0; i < 100; i++){
            int numero = random.nextInt(6) + 1;
            if(lancamentoDado.get(numero) != null){
                lancamentoDado.put(numero,contador++);
            }else{
                lancamentoDado.put(numero,contador);
            }
        }

        Set<Map.Entry<Integer,Integer>> lancamentoDado2 = new TreeSet<>(new ComparatorQuantidade());
        lancamentoDado2.addAll(lancamentoDado.entrySet());
        for(Map.Entry<Integer,Integer> lancamento : lancamentoDado2)
            System.out.println(lancamento.getKey() + " - " + lancamento.getValue());


    }
}

class ComparatorQuantidade implements Comparator<Map.Entry<Integer,Integer>>{

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return Integer.compare(o2.getValue(), o1.getValue());
    }
}
