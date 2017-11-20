package com.vishal.coinchange;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeBottomUp {

    public static int makeChange(int amount) {

        int[] coins = {10, 6, 1};
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0,0);
        int numberOfCoins = makeChange(amount, cache, coins);
        System.out.println(cache);
        return numberOfCoins;
    }

    private static int makeChange(int amount, Map<Integer, Integer> cache, int[] coins) {

        if (cache.containsKey(amount))
            return cache.get(amount);

        if (amount == 0) return 0;

        for (int i = 1; i <= amount; i++) {
            int minimumCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                int remaining = i - coin;
                if (remaining >= 0) {
                    int currentMin = cache.get(remaining) + 1;
                    if (currentMin < minimumCoins) {
                        minimumCoins = currentMin;
                    }
                }
            }

            cache.put(i, minimumCoins);
        }

        return cache.get(amount);
    }

    public static void main(String[] args) {

        System.out.println(makeChange(17));
    }
}
