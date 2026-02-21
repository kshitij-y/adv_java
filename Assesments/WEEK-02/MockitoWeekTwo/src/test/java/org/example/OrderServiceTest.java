package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private PaymentGateway paymentGateway;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testPlaceOrder_successfulPayment() {

        double amount = 2000;
        when(paymentGateway.processPayment(amount)).thenReturn(true);

        String result = orderService.placeOrder(amount);

        assertEquals("Order Confirmed", result);

        verify(paymentGateway, times(1)).processPayment(amount);
    }

    @Test
    void testPlaceOrder_paymentFailure() {

        double amount = 1500;
        when(paymentGateway.processPayment(amount)).thenReturn(false);

        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> orderService.placeOrder(amount)
        );

        assertEquals("Payment Failed", ex.getMessage());

        verify(paymentGateway, times(1)).processPayment(amount);
    }

    @Test
    void testPlaceOrder_invalidAmount() {

        double amount = 0;

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> orderService.placeOrder(amount)
        );

        assertEquals("Invalid Order Amount", ex.getMessage());

        verify(paymentGateway, never()).processPayment(anyDouble());
    }
}