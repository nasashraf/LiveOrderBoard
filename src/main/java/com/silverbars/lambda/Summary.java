package com.silverbars.lambda;

import java.util.function.Function;

class Summary {

    private final Quantity quantity;
    private final Price price;
    private final OrderType orderType;

    Summary(final Quantity quantity, final Price price, final OrderType orderType) {
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
    }


    static Summary aSummaryOf(final Quantity quantity, final Price price, final Function<Quantity, OrderType> typeForQuantity) {
        return new Summary(quantity.abs(), price, typeForQuantity.apply(quantity));
    }

    Quantity quantity() {
        return quantity;
    }

    Price price() {
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
