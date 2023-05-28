package com.ua.hotel.service;

import com.ua.hotel.domain.Room;
import com.ua.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final RoomRepository roomRepository;

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        return a / b;
    }

    public long getStudentsCount() {
        List<Room> rooms = roomRepository.findAll();
        return roomRepository.count();
    }
}
