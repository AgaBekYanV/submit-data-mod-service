package com.mod.SubmitModS.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "uuid_user")
    private String uuid;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<UserMessageEntity> userMessages = new ArrayList<>();

    public void addMessage(UserMessageEntity userMessageEntity) {
        userMessages.add(userMessageEntity);
    }


/*
    public void setUserMessages(List<UserMessage> userMessages) {
        for(UserMessage userMessage : userMessages){
            this.userMessages.add(userMessage);
        }
    }
*/

}
