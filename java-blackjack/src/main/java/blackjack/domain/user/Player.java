package blackjack.domain.user;

// 게임 참여자를 의미하는 객체
public class Player extends User {
    private final String name;
    private final double bettingMoney;

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public String getName() {
        return name;
    }

    public double getBettingMoney() {
        return bettingMoney;
    }

    public double calculateStatusValue(Dealer dealer) {
        if (dealer.checkStatus(Status.BUST)) {
            return 1.0;
        }
        if (checkStatus(Status.BUST)) {
            return -1.0;
        }
        if (checkStatus(Status.BLACKJACK) && !dealer.checkStatus(Status.BLACKJACK)) {
            return 1.5;
        }
        if (isWinner(this) && !isWinner(dealer)) {
            return 1.0;
        }
        if (!isWinner(this) && isWinner(dealer)) {
            return -1.0;
        }
        return comparePlayerAndDealer(dealer);
    }

    public String cardsToString() {
        return super.cardsToString(name);
    }

    private boolean isWinner(User user) {
        return user.checkStatus(Status.BLACKJACK) || user.checkStatus(Status.WIN);
    }

    private double comparePlayerAndDealer(Dealer dealer) {
        if (totalScore > dealer.getTotalScore()) {
            return 1.0;
        }
        if (totalScore < dealer.getTotalScore()) {
            return -1.0;
        }
        return 0.0;
    }
}
