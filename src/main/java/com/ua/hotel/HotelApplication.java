package com.ua.hotel;

import com.ua.hotel.domain.*;
import com.ua.hotel.service.GuestService;
import com.ua.hotel.service.RoomService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }

    @Bean
    public CommandLineRunner initialCreate(RoomService roomService, GuestService guestService){
        return (args) -> {
            Room room1 = new Room(1L, "FirstRoom", 20, "Single", null);
           Guest guest1 = new Guest(1L, "Thompson", "LO557883", null);
           guestService.save(guest1);
            roomService.save(room1);
            roomService.addGuest(1l, 1l);

            Room room2 = new Room(2L, "SecondRoom", 40, "Double", null);
            Guest guest2 = new Guest(2L, "Nicholson", "BL148293", null);
            guestService.save(guest2);
            roomService.save(room2);
            roomService.addGuest(2l, 2l);

            Room room3 = new Room(3L, "ThirdRoom", 60, "Triple", null);
            Guest guest3 = new Guest(3L, "Holmes", "WB935994", null);
            guestService.save(guest3);
            roomService.save(room3);
            roomService.addGuest(3l, 3l);

        } ;
    }

}
