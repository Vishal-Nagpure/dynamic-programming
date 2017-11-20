package com.vishal.coinchange;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeCache {

    static int[] coins = {10, 6, 1};

    public static int makeChange_with_cache(int amount) {

        Map<Integer, Integer> cache = new HashMap<>();
        return makeChange_with_cache(amount, cache);
    }

    public static int makeChange_with_cache(int amount, Map<Integer, Integer> cache) {

        if (cache.containsKey(amount))
            return cache.get(amount);

        if (amount == 0) return 0;
        int minimum = Integer.MAX_VALUE;

        for (int coin : coins) {
            int remainingAmount = amount - coin;
            if (remainingAmount >= 0) {
                int currentMinimum = makeChange_with_cache(remainingAmount, cache);
                if (currentMinimum < minimum) {
                    minimum = currentMinimum;
                }
            }
        }
        cache.put(amount, minimum + 1);
        return cache.get(amount);
    }

    public static void main(String[] args) {

        System.out.println(makeChange_with_cache(12367));
    }
}
