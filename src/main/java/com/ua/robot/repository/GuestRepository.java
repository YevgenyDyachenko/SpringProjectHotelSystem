package com.ua.robot.repository;

import com.ua.robot.domain.Guest;
import com.ua.robot.domain.Room;
import com.ua.robot.dto.GuestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    Optional<Guest> findGuestByLastName(String lastName);
}
