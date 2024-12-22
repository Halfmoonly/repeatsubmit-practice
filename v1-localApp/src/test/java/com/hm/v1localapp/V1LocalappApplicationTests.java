package com.hm.v1localapp;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class V1LocalappApplicationTests {
    @Autowired
    private MockService myService;
    @Test
    void contextLoads() {
    }



    // Test that the semaphore allows up to 'limit' concurrent executions.
    @Test
    public void testSemaphoreAllowsWithinLimit() throws Exception {

        // Assuming the nThreads > limit which  is set to SemaphoreDoc annotation

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try {
            Future<String> future1 = executorService.submit(() -> myService.doSomething("param1"));
            Future<String> future2 = executorService.submit(() -> myService.doSomething("param2"));

            // Both should complete successfully within the limit.
            assertNotNull(future1.get(5, java.util.concurrent.TimeUnit.SECONDS));
            assertNotNull(future2.get(5, java.util.concurrent.TimeUnit.SECONDS));

            // This one should fail because it exceeds the limit.
            Future<String> future3 = executorService.submit(() -> myService.doSomething("param3"));
            assertThrows(Exception.class, () -> future3.get(5, java.util.concurrent.TimeUnit.SECONDS));
        } finally {
            executorService.shutdown();
        }
    }

    // Test that the semaphore releases permits after blocking time.
    @Test
    public void testSemaphoreReleasesPermits() throws Exception {
        // Call the service method to acquire a permit.
        String result1 = myService.doSomething("param1");
        assertNotNull(result1);

        // Wait for more than the blocking time (set to 5 seconds in SemaphoreDoc).
        Thread.sleep(6000); // Sleep for 6 seconds

        // Now call again, it should succeed as the permit has been released.
        String result2 = myService.doSomething("param2");
        assertNotNull(result2);
    }

}
