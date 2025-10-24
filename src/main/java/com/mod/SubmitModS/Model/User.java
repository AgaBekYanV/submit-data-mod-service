package com.mod.SubmitModS.Model;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String username;

    private String uuid;

    private LocalDateTime createdAt;

    private List<UserMessage> userMessages = new ArrayList<>();

    public void setUserMessages(List<UserMessage> userMessages) {
        for(UserMessage userMessage : userMessages){
            this.userMessages.add(userMessage);
        }
    }

    public List<UserMessage> getUserMessages() {
        return userMessages;
    }
}
