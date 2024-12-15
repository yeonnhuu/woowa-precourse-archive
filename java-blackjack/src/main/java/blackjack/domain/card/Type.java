package blackjack.domain.card;

public enum Type {
    SPADE("스페이드"),
    HEART("하트"),
    DIAMOND("다이아몬드"),
    CLUB("클로버");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String toKorean() {
        return name;
    }
}