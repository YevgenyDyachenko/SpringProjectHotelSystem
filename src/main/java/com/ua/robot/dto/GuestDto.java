package com.ua.robot.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GuestDto {

    private Long id;
    private String lastName;
    private List<String> roomsName;
}
