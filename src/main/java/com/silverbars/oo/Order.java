package com.silverbars.oo;

public class Order {

    private final String userId;
    private final double quantity;
    private final Integer price;
    private final OrderType orderType;


    private Order(final String userId, final double quantity, final Integer price, final OrderType orderType) {
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
    }

    static Order anOrderWith(final String userId, final double quantity, final Integer price, final OrderType orderType) {
        return new Order(userId, quantity, price, orderType);
    }

    double quantity() {
        return quantity;
    }

    Integer price() {
        return price;
    }

    OrderType type() {
        return orderType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (Double.compare(order.quantity, quantity) != 0) return false;
        if (orderType != order.orderType) return false;
        if (!price.equals(order.price)) return false;
        if (!userId.equals(order.userId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userId.hashCode();
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + price.hashCode();
        result = 31 * result + orderType.hashCode();
        return result;
    }
}
