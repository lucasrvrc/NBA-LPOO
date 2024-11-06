package com.jogonba.cartas.board;
import com.jogonba.cartas.cards.Carta;
import com.jogonba.cartas.players.Jogador;
import com.jogonba.cartas.players.Hand;
import java.util.LinkedList;

public class Tabuleiro {
    private LinkedList<Carta> slotsJogador1;
    private LinkedList<Carta> slotsJogador2;

    public Tabuleiro() {
        this.slotsJogador1 = new LinkedList<>();
        this.slotsJogador2 = new LinkedList<>();
    }

    //Métodos relevantes:
    public void jogarCartaJ1(Hand hand) {
        Carta cartaRemovida = hand.removerCarta();
        slotsJogador1.add(cartaRemovida);
    }

    public void jogarCartaJ2(Hand hand) {
        Carta cartaRemovida = hand.removerCarta();
        slotsJogador2.add(cartaRemovida);
    }

}
