package atividade4.questao4;

public class Pessoa implements Comparable<Pessoa> {

    private String rg;
    private String nome;
    private int idade;
    private char genero;
    private double peso;
    private double altura;

    public Pessoa(String rg, String nome, int idade, char genero, double peso, double altura) {
        this.rg = rg;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }

    public String getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int compareTo(Pessoa c) {
        return this.rg.compareTo(c.getRg());
    }

}