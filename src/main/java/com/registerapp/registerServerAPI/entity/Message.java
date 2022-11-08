package com.registerapp.registerServerAPI.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long message_id;

    @Column(name = "content")
    private String content;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private User sender_id;

    @Column(name = "receiver_id")
    private Long receiver_id;

    public Message(String content, LocalTime time, LocalDate date, User sender_id, Long receiver_id) {
        this.content = content;
        this.time = time;
        this.date = date;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
    }
}
