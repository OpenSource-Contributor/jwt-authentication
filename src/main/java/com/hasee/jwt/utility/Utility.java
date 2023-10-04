package com.hasee.jwt.utility;

public class Utility {
    public static boolean isNotNull( String arg )
    {
        return arg != null && arg.trim().length() != 0;
    }

    public static boolean isNull( String arg )
    {
        return arg == null || arg.trim().length() == 0;
    }
}
