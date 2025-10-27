package com.mod.SubmitModS.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserMessage {

    private Long id;

    private String userMessage;

    private LocalDateTime createdAt;


}
