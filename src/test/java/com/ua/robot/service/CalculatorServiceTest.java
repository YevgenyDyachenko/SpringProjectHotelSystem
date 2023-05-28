package com.ua.robot.service;

import com.ua.robot.domain.Room;
import com.ua.robot.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = CalculatorService.class)
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @MockBean
    private RoomRepository roomRepository;

    @Test
    void shouldMultiply() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    void shouldDivide() {
        assertEquals(2, calculatorService.divide(6, 3));
    }

    @Test
    void shouldDivideWithException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(12, 0));
    }

    @Test
    void shouldGetStudentsCount() {
        when(roomRepository.count()).thenReturn(10L);
        when(roomRepository.findAll()).thenReturn(List.of(new Room(), new Room()));

        assertEquals(10L, calculatorService.getStudentsCount());
    }
}