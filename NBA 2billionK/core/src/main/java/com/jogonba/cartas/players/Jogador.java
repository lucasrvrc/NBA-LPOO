package com.jogonba.cartas.players;
import java.util.ArrayList;
import com.jogonba.cartas.board.Tabuleiro;
import com.jogonba.cartas.cards.Carta;
import com.jogonba.cartas.cards.CartaCriatura;

public class Jogador implements Nome {
    private String nome;
    private int identificador;
    private int vida;
    private int mana;
    private Hand hand;
    private Deck deck;
    private Cemiterio cemiterio;
    private Tabuleiro tabuleiro;

    public Jogador(int identificador){
        this.identificador = identificador;
        this.vida = 50;
        this.mana = 1;
        this.hand = new Hand();
        this.cemiterio = new Cemiterio();
    }

    //Métodos relevantes:
    public void diminuirVida (int valor){
        this.vida -= valor;
    }
    public void diminuirMana (int valor){
        this.mana -= valor;
    }
    public void aumentarMana (int valor){
        this.mana += valor;
    }
    public void jogarCarta (int posicaoHand){
        Carta cartaRemovida = hand.removerCarta(posicaoHand);
        tabuleiro.colocarCarta(cartaRemovida);
    }
    public void removerCarta (int posicaoTabuleiro){
        Carta cartaRemovida = tabuleiro.removerCarta(posicaoTabuleiro);
        cemiterio.adicionarCarta(cartaRemovida);
    }
    public void atacar (CartaCriatura cartaAtacante, CartaCriatura cartaOponente, Jogador jogadorOponente){
        if (cartaAtacante.getAtaque() >= cartaOponente.getDefesa()){
            int dano = cartaAtacante.getAtaque() - cartaOponente.getDefesa();
            jogadorOponente.diminuirVida(dano);
            int posicaoTabuleiro = tabuleiro.verificarPosicao(cartaOponente);
            jogadorOponente.removerCarta(posicaoTabuleiro);
        } else {
            cartaOponente.diminuirDefesa(cartaAtacante.getAtaque());
        }
    }
    //Condições de vitória:
    public boolean isVivo(){
        return vida > 0;
    }
    public boolean semCartas (Deck deck){
        return deck.estaVazio();
    }

    //Fases do jogador:
    public void faseCompra(){
        hand.comprarCarta(deck);
    }

    public void faseMana (int turno){
        this.mana = turno;
    }

    public void fasePrincipal(){

    }

    //Getters e setters:
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getVida() {
        return vida;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getMana() {
        return mana;
    }

    @Override
    public void setNome(){
        this.nome = nome;
    }
    @Override
    public String getNome(){
        return nome;
    }

    public int getIdentificador(){
        return identificador;
    }
    public void setIdentificador(int identificador){
        this.identificador = identificador;
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