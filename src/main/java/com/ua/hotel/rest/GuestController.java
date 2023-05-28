package com.ua.hotel.rest;

import com.ua.hotel.domain.Guest;
import com.ua.hotel.dto.GuestDto;
import com.ua.hotel.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @PostMapping("/guests")
    public void save(@RequestBody Guest guest) {
        guestService.save(guest);
    }

    @PutMapping("/guests/updateGuest/{id}")
    public void update(@PathVariable Long id, @RequestBody Guest guest) {
        guest = guestService.update(id, guest);
        guestService.save(guest);
    }


    @GetMapping("/guests")
    public List<GuestDto> findAll() {
        return guestService.findAll();
    }


    @DeleteMapping("/guests/{id}")
    public void deleteById(@PathVariable Long id) {
        guestService.deleteGuest(id);

    }


    @GetMapping("/guests/{id}")
    public ResponseEntity<GuestDto> findById(@PathVariable Long id) {
        return guestService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/guests/name/{name}")
    public ResponseEntity<GuestDto> findByLastName(@PathVariable String name) {
        return guestService.findByLastName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/guests/passport/{passport}")
    public ResponseEntity<GuestDto> findByPassport(@PathVariable String passport) {
        return guestService.findByPassport(passport)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
