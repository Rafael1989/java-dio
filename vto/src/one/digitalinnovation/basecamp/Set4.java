package one.digitalinnovation.basecamp;

import java.util.*;

public class Set4 {
    public static void main(String[] args) {
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>();
        linguagens.add(new LinguagemFavorita("Java",1989,"Intellij"));
        linguagens.add(new LinguagemFavorita("C",1999,"Eclipse"));
        linguagens.add(new LinguagemFavorita("Python",1995,"Netbeans"));

        System.out.println("--\tOrdem de Insercao\t--");
        System.out.println(linguagens);

        Set<LinguagemFavorita> linguagens2 = new HashSet<>();
        linguagens2.add(new LinguagemFavorita("Java",1989,"Intellij"));
        linguagens2.add(new LinguagemFavorita("C",1999,"Eclipse"));
        linguagens2.add(new LinguagemFavorita("Python",1995,"Netbeans"));

        System.out.println("--\tOrdem Natural (nome)\t--");
        System.out.println(linguagens2);

        System.out.println("--\tOrdem IDE\t--");
        Set<LinguagemFavorita> linguagens3 = new TreeSet<>(new ComparatorIDE());
        linguagens3.addAll(linguagens2);
        System.out.println(linguagens3);

        System.out.println("--\tOrdem Ano de criacao e nome\t--");
        Set<LinguagemFavorita> linguagens4 = new TreeSet<>(new ComparatorAnoCriacaoNome());
        linguagens4.addAll(linguagens2);
        System.out.println(linguagens4);

        System.out.println("--\tOrdem Nome, ano de criacao e IDE\t--");
        Set<LinguagemFavorita> linguagens5 = new TreeSet<>(new ComparatorNomeAnoCriacaoIDE());
        linguagens5.addAll(linguagens2);
        System.out.println(linguagens5);

        for(LinguagemFavorita linguagemFavorita : linguagens5){
            System.out.println(linguagemFavorita.getNome());
        }

    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private int anoCriacao;
    private String ide;

    public LinguagemFavorita(String nome, int anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return anoCriacao == that.anoCriacao && Objects.equals(nome, that.nome) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoCriacao, ide);
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        return this.getNome().compareToIgnoreCase(linguagemFavorita.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ano = Integer.compare(o1.getAnoCriacao(), o2.getAnoCriacao());
        if(ano != 0) return ano;
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if(nome != 0) return nome;
        int ano = Integer.compare(o1.getAnoCriacao(), o2.getAnoCriacao());
        if(ano != 0) return ano;
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}
