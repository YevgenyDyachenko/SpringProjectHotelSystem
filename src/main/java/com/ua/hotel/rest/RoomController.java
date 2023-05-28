package com.ua.hotel.rest;

import com.ua.hotel.domain.Room;
import com.ua.hotel.dto.RoomDto;
import com.ua.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<RoomDto> findById(@PathVariable Long id) {
        return roomService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rooms/name/{name}")
    public ResponseEntity<RoomDto> findByName(@PathVariable String name) {
        return roomService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rooms/find")
    public ResponseEntity<RoomDto> findByParam(@RequestParam String name, @RequestParam int price) {
        return roomService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/rooms")
    public ResponseEntity<Void> save(@RequestBody Room room) {
        roomService.save(room);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/rooms/{id}/guests/{guestId}")
    public ResponseEntity<Void> update(@PathVariable Long id, @PathVariable Long guestId) {
        roomService.addGuest(id, guestId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/rooms/{roomId}/move/{toRoomId}")
    public ResponseEntity<Void> move(@PathVariable Long roomId, @PathVariable Long toRoomId) {
        roomService.moveGuest(roomId, toRoomId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


    @PutMapping("/rooms/updateRoom/{id}")
    public void updateInfo(@PathVariable Long id, @RequestBody Room room) {
        room = roomService.updateInfo(id, room);
        roomService.save(room);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteById(@PathVariable Long id) {
        roomService.delete(id);

    }


}
