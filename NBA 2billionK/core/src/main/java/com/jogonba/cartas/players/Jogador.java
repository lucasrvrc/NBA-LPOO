package com.jogonba.cartas.players;
import java.util.ArrayList;
import com.jogonba.cartas.cards.Carta;

public class Jogador {
    private String nome;
    private int vida;
    private int mana;
    private Hand hand;
    private Deck deck;
    private Cemiterio cemiterio;

    public Jogador(String nome, Deck deck){
        this.nome = nome;
        this.deck = deck;
        this.vida = 30;
        this.mana = 1;
        this.hand = new Hand();
        this.cemiterio = new Cemiterio();
    }

    //Métodos relevantes:
    public void diminuirVida(int valor){
        this.vida -= valor;
    }
    public void diminuirMana(int valor){
        this.mana -= valor;
    }
    public void aumentarMana(int valor){
        this.mana += valor;
    }
    //Condições de vitória:
    public boolean isVivo(){
        return vida > 0;
    }

    //Getters e setters:
    public void setVida() {
        this.vida = vida;
    }
    public int getVida() {
        return vida;
    }

    public void setMana() {
        this.mana = mana;
    }
    public int getMana() {
        return mana;
    }

    public void setNome(){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public Hand getHand(){
        return hand;
    }

    public Deck getDeck(){
        return deck;
    }

    public Cemiterio getCemiterio(){
        return cemiterio;
    }
}
