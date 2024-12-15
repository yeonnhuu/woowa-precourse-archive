package christmas.domain.enums;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);

    private final String name;
    private final int minimumDiscount;

    Badge(String name, int minimumDiscount) {
        this.name = name;
        this.minimumDiscount = minimumDiscount;
    }

    public static Badge calculateBadge(int discount) {
        for (Badge badge : Badge.values()) {
            if (discount >= badge.minimumDiscount) {
                return badge;
            }
        }
        return Badge.NONE;
    }

    @Override
    public String toString() {
        return "<12월 이벤트 배지>" + System.lineSeparator()
                + name + System.lineSeparator();
    }
}
