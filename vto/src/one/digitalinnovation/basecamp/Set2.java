package one.digitalinnovation.basecamp;

import java.util.*;

public class Set2 {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatoria\t--");
        Set<Serie> series = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70 show", "comedia", 60));
        }};

        for(Serie serie : series) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem insercao\t--");
        Set<Serie> seriesLinkedHashSet = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70 show", "comedia", 25));
        }};

        for(Serie serie : seriesLinkedHashSet) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem natural (TempoEpisodio)\t--");
        Set<Serie> seriesTreeSet = new TreeSet<>(seriesLinkedHashSet);
        System.out.println(seriesTreeSet);

        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> seriesTreeSet2 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        seriesTreeSet2.addAll(series);
        System.out.println(seriesTreeSet2);

        System.out.println("--\tOrdem Gênero\t--");
        Set<Serie> seriesTreeSet3 = new TreeSet<>(new ComparatorGenero());
        seriesTreeSet3.addAll(series);
        System.out.println(seriesTreeSet3);

        System.out.println("--\tOrdem Tempo Episodio\t--");
        Set<Serie> seriesTreeSet4 = new TreeSet<>(new ComparatorTempoEpisodio());
        seriesTreeSet4.addAll(series);
        System.out.println(seriesTreeSet4);

    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "\nnome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.tempoEpisodio, serie.getTempoEpisodio());
        if(tempoEpisodio != 0) return tempoEpisodio;
        return this.getGenero().compareTo(serie.getGenero());
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie serie1, Serie serie2) {
        int nome = serie1.getNome().compareToIgnoreCase(serie2.getNome());
        if(nome != 0) return nome;
        int genero = serie1.getGenero().compareToIgnoreCase(serie2.getGenero());
        if(genero != 0) return genero;
        return Integer.compare(serie1.getTempoEpisodio(), serie2.getTempoEpisodio());
    }
}

class ComparatorGenero implements Comparator<Serie> {

    @Override
    public int compare(Serie serie1, Serie serie2) {
        return serie1.getGenero().compareToIgnoreCase(serie2.getGenero());
    }
}

class ComparatorTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie serie1, Serie serie2) {
        return Integer.compare(serie1.getTempoEpisodio(), serie2.getTempoEpisodio());
    }
}
