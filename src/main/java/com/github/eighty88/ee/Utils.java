package com.github.eighty88.ee;

import java.util.regex.Pattern;

public class Utils {
    private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-OR]");

    public static String stripColor(final String input) {
        return STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }
}
