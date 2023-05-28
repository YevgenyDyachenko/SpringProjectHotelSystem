package com.ua.hotel.repository;

import com.ua.hotel.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    Optional<Guest> findGuestByLastName(String lastName);

    Optional<Guest> findGuestByPassport(String passport);
}
