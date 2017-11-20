package com.vishal.coinchange;

public class CoinChange {

    static int[] coins = {10, 6, 1};

    public static int makeChange(int amount) {

        if (amount == 0) return 0;

        int minimumCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (amount - coin >= 0) {
                int currentMinimumCoin = makeChange(amount - coin);
                if (currentMinimumCoin < minimumCoins) {
                    minimumCoins = currentMinimumCoin;
                }
            }
        }

        return minimumCoins + 1;
    }

    public static void main(String[] args) {

        System.out.println(makeChange(12));
    }
}
