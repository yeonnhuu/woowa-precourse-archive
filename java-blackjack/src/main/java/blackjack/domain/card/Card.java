package blackjack.domain.card;

// 카드 한장을 의미하는 객체
public class Card {
    private final Symbol symbol;
    private final Type type;

    public Card(Symbol symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }

    public boolean isAce() {
        return symbol.equals(Symbol.ACE);
    }

    public int getScore() {
        return symbol.getScore();
    }

    @Override
    public String toString() {
        return symbol.toLetter() + type.toKorean();
    }
}
