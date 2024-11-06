package com.jogonba.cartas.players;
import java.util.LinkedList;
import com.jogonba.cartas.cards.Carta;

public class Hand {
    private LinkedList<Carta> cartasHand;

    public Hand(){
        this.cartasHand = new LinkedList<>();
    }

    //Métodos relevantes:
    public void comprarCarta(Deck deck){
        Carta cartaRemovida = deck.removerCarta();
        cartasHand.add(cartaRemovida);
    }

    public Carta removerCarta(){
        return cartasHand.poll();
    }


}
