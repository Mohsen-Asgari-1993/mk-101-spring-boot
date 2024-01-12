package ir.maktabsharif101.springboot.firstspringboot.util;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class SemaphoreUtil {

    private static final Semaphore CUSTOMER_REGISTRATION = new Semaphore(1);

    @SneakyThrows
    public static void acquireCustomerRegistration() {
        CUSTOMER_REGISTRATION.acquire();
    }

    @SneakyThrows
    public static void releaseCustomerRegistration() {
        CUSTOMER_REGISTRATION.release();
    }
}
