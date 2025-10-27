package com.mod.SubmitModS.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_message")
@Data
public class UserMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "user_message")
    private String userMessage;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
