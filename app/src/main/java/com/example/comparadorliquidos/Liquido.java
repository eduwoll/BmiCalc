package com.example.comparadorliquidos;

public class Liquido {
    String nome;
    Float volume,preco;

    public Liquido(String nome, Float volume, Float preco){
        this.nome = nome;
        this.volume = volume;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Float getVolume() {
        return volume;
    }

    public Float getPreco() {
        return preco;
    }

    public float calculaResultado(){
        return volume/preco;
    }
}
