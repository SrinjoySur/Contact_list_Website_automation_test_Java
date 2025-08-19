package com.contact_list.api.util;

import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {
    private static final ConcurrentHashMap<String, String> tokenStore = new ConcurrentHashMap<>();

    // Store token per role
    public static void storeToken(String role, String token) {
        tokenStore.put(role.toLowerCase(), token);
    }

    // Retrieve token by role
    public static String getToken(String role) {
        if (!tokenStore.containsKey(role.toLowerCase())) {
            return null;
        }
        return tokenStore.get(role.toLowerCase());
    }

    // Clear tokens (if needed, for cleanup between tests)
    public static void clearTokens() {
        tokenStore.clear();
    }
}