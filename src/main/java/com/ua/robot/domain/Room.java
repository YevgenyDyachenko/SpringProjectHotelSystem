package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name="guest_id")
    private Guest guest;
}
