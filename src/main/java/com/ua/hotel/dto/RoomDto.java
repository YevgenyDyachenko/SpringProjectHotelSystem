package com.ua.hotel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {

    private Long id;
    private String name;
    private int price;
    private String description;
    private String guestName;
}
