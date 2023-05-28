package com.ua.hotel.repository;

import com.ua.hotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findRoomByName(String name);

    Optional<Room> findRoomByNameAndPrice(String name, int price);
}
