package Model;

public class Player {

private String name;
private int id;
private Card cards[];
public final static int MAX_CARD = 5;
boolean isFlush = false;

public Player(int id){
	this.setId(id);
	this.setName(name);
    cards = new Card[MAX_CARD];	
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Card[] getCards() {
    return cards;
}

public void setCards(Card[] cards) {
	this.cards = cards;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Card getCardAtIndex(int index) {
    if (index >= 0 && index < MAX_CARD)
        return cards[index];
    else
        return null;
}




}



