package one.digitalinnovation.basecamp;

import java.util.*;

public class Map1 {
    public static void main(String[] args) {
        Map antesJava5 = new HashMap();
        Map<String, Double> java5 = new HashMap<String,Double>();
        Map<String,Double> java7 = new HashMap<>();
        Map<String, Double> java9 = Map.of("gol",14.4,"uno",15.6,"mobi",16.1,"hb20",14.5,"kwid",15.6);

        System.out.println("Crie um dicionario que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carroPopulares = new HashMap<>(){{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",16.1);
            put("kwid",15.6);
        }};
        System.out.println(carroPopulares.toString());

        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        carroPopulares.put("gol",15.2);

        System.out.println(carroPopulares);

        System.out.println("Confira se o modelo tucson está no dicionário: " + carroPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: " + carroPopulares.get("uno"));

        System.out.println("Exiba o terceiro modelo adicionado: no map nao dá");

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carroPopulares.keySet();
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carroPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais economico e seu consumo: ");
        Double consumoMax = Collections.max(carroPopulares.values());
        Set<Map.Entry<String, Double>> entries = carroPopulares.entrySet();
        String modeloMax = "";
        for(Map.Entry<String, Double> entry : entries){
            if(entry.getValue().equals(consumoMax)){
                modeloMax = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMax + " - " + consumoMax);
            }
        }

        System.out.println("Exiba o modelo menos economico e seu consumo: ");

        Double consumoMin = Collections.min(carroPopulares.values());
        Set<Map.Entry<String, Double>> entries2 = carroPopulares.entrySet();
        String modeloMin = "";
        for(Map.Entry<String, Double> entry : entries2){
            if(entry.getValue().equals(consumoMin)){
                modeloMin = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMin + " - " + consumoMin);
            }
        }

        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carroPopulares.values().iterator();
        Double soma = 0.0;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a media dos consumos deste dicionario de carros: " + (soma/carroPopulares.size()));

        System.out.println(carroPopulares);
        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carroPopulares.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carroPopulares);

        System.out.println("Exiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carroPopulares1 = new LinkedHashMap<>(){{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",16.1);
            put("kwid",15.6);
        }};
        System.out.println(carroPopulares1.toString());

        System.out.println("Exiba o dicionario ordenado pelo modelo: ");
        Map<String, Double> carroPopulares2 = new TreeMap<>(carroPopulares1);
        System.out.println(carroPopulares2);

        System.out.println("Apague o dicionario de carros: ");
        carroPopulares.clear();

        System.out.println("Confira se o dicionario está vazio: " + carroPopulares.isEmpty());

    }
}
