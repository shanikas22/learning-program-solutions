package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Step 1: Create a mock of ExternalApi
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Stub getData() to return a fixed value
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject the mock into MyService
        MyService service = new MyService(mockApi);

        // Step 4: Call the method and verify result
        String result = service.fetchData();
        System.out.println("Test Result: " + result);
        // Step 5: Assert result is as mocked
        assertEquals("Mock Data", result);
    }
}
