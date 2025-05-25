package com.automationexercise.utils;

public class RetryConfiguration {
    protected static final int maxRetries = System.getenv("MAX_RETRIES") != null
            ? Integer.parseInt(System.getenv("MAX_RETRIES"))
            : 5;
    protected static final int retryInterval = System.getenv("RETRY_INTERVAL") != null
            ? Integer.parseInt(System.getenv("RETRY_INTERVAL"))
            : 5;
}
