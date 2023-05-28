package com.ua.robot.repository;

import com.ua.robot.domain.Room;
import com.ua.robot.dto.RoomDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findRoomByName(String name);

    Optional<Room> findRoomByNameAndPrice(String name, int price);
}
