package com.github.aop.log;

import com.github.aop.log.api.*;

public class LoggerFactory {
    private static LogResolver RESOLVER = new EasyLogResolver();

    public static void setLogResolver(LogResolver resolver) {
        LoggerFactory.RESOLVER = resolver;
    }

    public static Logger getLogger(Class<?> clazz) {
        if (RESOLVER == null) {
            return NoopLogger.INSTANCE;
        }
        return LoggerFactory.RESOLVER.getLogger(clazz);
    }
}
