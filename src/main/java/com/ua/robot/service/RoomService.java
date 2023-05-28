package com.ua.robot.service;

import com.ua.robot.domain.Room;
import com.ua.robot.dto.RoomDto;
import com.ua.robot.repository.GuestRepository;
import com.ua.robot.repository.RoomRepository;
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
            guestName = room.getGuest().getName();
        }
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .age(room.getAge())
                .address(room.getAddress())
                .guestName(guestName)
                .build();
    }

    public Optional<RoomDto> findById(Long id) {
        return roomRepository.findById(id).map(RoomService::buildRoomDto);
    }

    public Optional<Room> findByName(String name) {
        return roomRepository.findRoomByName(name);
    }

//    public Optional<Student> findByNameAndAge(String name, int age) {
//        return studentRepository.findStudentByName(name);
//    }



    public void save(Room room) {
        roomRepository.save(room);
    }

    public void delete(Long roomId){ roomRepository.deleteById(roomId);}

    public void addGroup(Long roomId, Long guestId) {
        var guest = guestRepository.findById(guestId).get();
        var room = roomRepository.findById(roomId).get();
        room.setGuest(guest);

        roomRepository.save(room);
    }
}
