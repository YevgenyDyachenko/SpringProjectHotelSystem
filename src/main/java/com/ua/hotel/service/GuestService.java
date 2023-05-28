package com.ua.hotel.service;

import com.ua.hotel.domain.Room;
import com.ua.hotel.domain.Guest;
import com.ua.hotel.dto.GuestDto;
import com.ua.hotel.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    public void save(Guest guest) {
        guestRepository.save(guest);
    }

    public List<GuestDto> findAll() {
        return guestRepository.findAll()
                .stream()
                .map(GuestService::buildGuestDto)
                .collect(Collectors.toList());
    }

    private static GuestDto buildGuestDto(Guest guest) {
        return GuestDto.builder()
                .id(guest.getId())
                .lastName(guest.getLastName())
                .passport(guest.getPassport())
                .roomsName(guest.getRooms().stream()
                        .map(Room::getName)
                        .collect(Collectors.toList()))
                .build();
    }

    public Optional<GuestDto> findById(Long id) {
        return guestRepository.findById(id).map(GuestService::buildGuestDto);
    }

    public Optional<GuestDto> findByLastName(String lastName) {
        return guestRepository.findGuestByLastName(lastName).map(GuestService::buildGuestDto);
    }

    public Optional<GuestDto> findByPassport(String passport) {
        return guestRepository.findGuestByPassport(passport).map(GuestService::buildGuestDto);
    }


    public Guest update(Long id, Guest guest){
        Guest guestFmDb = guestRepository.findById(id).get();
        if(guest.getLastName()!=null){
            guestFmDb.setLastName(guest.getLastName());
        }
        if(guest.getPassport()!=null){
            guestFmDb.setPassport(guest.getPassport());
        }
        if (guest.getRooms()!=null){
            guestFmDb.setRooms(guest.getRooms());
        }
        return guestFmDb;
    }


    public void deleteGuest(Long guestId){ guestRepository.deleteById(guestId);}


}
