public class Deck {
  private List<BlackjackCard> cards;
  private Date creationDate;

  public Deck() {
    this.creationDate = new Date();
    this.cards = new ArrayList<BlackjackCard>();
    for(int value = 1 ; value <= 13 ; value++){
      for(SUIT suit : SUIT.values()){
        this.cards.add(new BlackjackCard(suit, value));
      }
    }
  }

  public List<BlackjackCard> getCards() {
    return cards;
}

public class Shoe {
  private List<BlackjackCard> cards;
  private int numberOfDecks;

  private void createShoe() {
    this.cards = new ArrayList<BlackjackCard>();
    for(int decks = 0 ; decks < numberOfDecks ; decks++){
      cards.add(new Deck().getCards());
    }
  }

  public Shoe(int numberOfDecks) {
    this.numberOfDecks = numberOfDecks;
    createShoe();
    shuffle();
  }

  public void shuffle() {
    int cardCount = cards.size();
    Random r = new Random();
    for (int i = 0; i < cardCount ; i++){
      int index = r.nextInt(cardCount-i-1);
      swap(i, index);
    }
  }

  public void swap(int i, int j) {
    BlackjackCard temp = cards[i];
    cards[i] = cards[j];
    cards[j] = temp;
  }

  //Get the next card from the shoe
  public BlackjackCard dealCard() {
    if(cards.size() == 0 ){
      createShoe();
    }
    return cards.remove(0);
  }
}
