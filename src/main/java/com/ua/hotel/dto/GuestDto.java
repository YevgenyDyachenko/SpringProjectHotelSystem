package com.ua.hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GuestDto {

    private Long id;
    private String lastName;
    private String passport;
    private List<String> roomsName;
}
