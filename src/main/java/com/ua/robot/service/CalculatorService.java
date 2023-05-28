package com.ua.robot.service;

import com.ua.robot.domain.Room;
import com.ua.robot.repository.RoomRepository;
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
