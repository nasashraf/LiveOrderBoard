package com.silverbars.oo;

public class Summary {

    private final Quantity quantity;
    private final Integer price;
    private final OrderType orderType;

    Summary(final Quantity quantity, final int price, final OrderType orderType) {
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
    }

    static Summary aSummaryOf(final Quantity quantity, final int price, final OrderType orderType) {
        return new Summary(quantity, price, orderType);
    }

    Double quantity() {
        return quantity.value();
    }

    Integer price() {
        return price;
    }

    OrderType type() {
        return orderType;
    }



    @Override
    public String toString() {
        return "Summary{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", orderType=" + orderType +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Summary)) return false;

        Summary summary = (Summary) o;

        if (orderType != summary.orderType) return false;
        if (!price.equals(summary.price)) return false;
        if (!quantity.equals(summary.quantity)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quantity.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + orderType.hashCode();
        return result;
    }
}
