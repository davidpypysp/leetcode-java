package com.shiping.leetcode.easy;

/**
 * Created by shipingci on 7/30/16.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        int vis[] = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) a++;
            else {
                vis[secret.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < secret.length(); i++ ) {
            if(secret.charAt(i) != guess.charAt(i)) {
                if(vis[guess.charAt(i) - '0'] > 0) {
                    b++;
                    vis[guess.charAt(i) - '0']--;
                }
            }
        }
        String res = Integer.toString(a) + 'A' + Integer.toString(b) + 'B';
        return res;
    }
}
