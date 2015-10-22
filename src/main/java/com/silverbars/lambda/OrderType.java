package com.silverbars.lambda;

public enum OrderType {
    BUY {
        @Override
        public int comparePrice(Integer priceToCompare, Integer priceToCompareWith) {
            return priceToCompareWith.compareTo(priceToCompare);
        }
    },
    SELL {
        @Override
        public int comparePrice(Integer priceToCompare, Integer priceToCompareWith) {
            return priceToCompare.compareTo(priceToCompareWith);
        }
    };


    public abstract int comparePrice(Integer priceToCompare, Integer priceToCompareWith);
}
