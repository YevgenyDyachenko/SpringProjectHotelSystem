package com.ua.hotel.service;

import com.ua.hotel.domain.Room;
import com.ua.hotel.dto.RoomDto;
import com.ua.hotel.repository.GuestRepository;
import com.ua.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public List<RoomDto> findAll() {
        return roomRepository.findAll().stream()
                .map(RoomService::buildRoomDto)
                .collect(Collectors.toList());
    }

    private static RoomDto buildRoomDto(Room room) {
        var guestName = "NO GUESTS";
        if (room.getGuest() != null) {
            guestName = room.getGuest().getLastName();
        }
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .price(room.getPrice())
                .description(room.getDescription())
                .guestName(guestName)
                .build();
    }

    public Optional<RoomDto> findById(Long id) {
        return roomRepository.findById(id).map(RoomService::buildRoomDto);
    }


    public Optional<RoomDto> findByName(String name) {
        return roomRepository.findRoomByName(name).map(RoomService::buildRoomDto);
    }





    public void save(Room room) {
        roomRepository.save(room);
    }

    public void delete(Long roomId){ roomRepository.deleteById(roomId);}

    public void addGuest(Long roomId, Long guestId) {
        var guest = guestRepository.findById(guestId).get();
        var room = roomRepository.findById(roomId).get();
        room.setGuest(guest);


        roomRepository.save(room);
    }

    public void moveGuest(Long roomId, Long newRoomId) {

        var room = roomRepository.findById(roomId).get();
        var guest = room.getGuest();
        var room2 = roomRepository.findById(newRoomId).get();
        room.setGuest(null);
        room2.setGuest(guest);

        roomRepository.save(room);
        roomRepository.save(room2);
    }



    public Room updateInfo(Long id, Room room){

        Room roomFmDb = roomRepository.findById(id).get();
        if (room.getName() != null) {
            roomFmDb.setName(room.getName());
        }
        if (room.getPrice() != 0) {
            roomFmDb.setPrice(room.getPrice());
        }
        if (room.getDescription() != null) {
            roomFmDb.setDescription(room.getDescription());
        }
        if (room.getGuest() != null) {
            roomFmDb.setGuest(room.getGuest());
        }

        return roomFmDb;
    }

}
