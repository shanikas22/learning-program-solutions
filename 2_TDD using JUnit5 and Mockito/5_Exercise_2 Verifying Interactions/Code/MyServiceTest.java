//package com.example;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//public class MyServiceTest {
//
//    @Test
//    public void testExternalApi() {
//        // Step 1: Create a mock of ExternalApi
//        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
//
//        // Step 2: Stub getData() to return a fixed value
//        when(mockApi.getData()).thenReturn("Mock Data");
//
//        // Step 3: Inject the mock into MyService
//        MyService service = new MyService(mockApi);
//
//        // Step 4: Call the method and verify result
//        String result = service.fetchData();
//        System.out.println("Test Result: " + result);
//        // Step 5: Assert result is as mocked
//        assertEquals("Mock Data", result);
//    }
//}
package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Inject into service and call method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3: Verify that getData() was called
        verify(mockApi).getData();  // ✅ Test will fail if this wasn't called
        when(mockApi.getData()).thenReturn("Mock Data");
        System.out.println("👉 Mock used: " + mockApi);
        System.out.println("🧪 fetchData() result: " + service.fetchData());

    }
}
