package com.mod.SubmitModS.Mapper;

import com.mod.SubmitModS.Model.UserMessage;
import com.mod.SubmitModS.Model.UserMessageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMessageMapper {


    public UserMessage toModel(UserMessageEntity userMessageEntity){
        if(userMessageEntity == null){return null;}
        UserMessage userMessage = new UserMessage();
        userMessage.setId(userMessageEntity.getId());
        userMessage.setUserMessage(userMessageEntity.getUserMessage());
        userMessage.setCreatedAt(userMessageEntity.getCreatedAt());
        return userMessage;
    }

    public UserMessageEntity toEntity(UserMessage userMessage){
        if(userMessage == null){return null;}
        UserMessageEntity userMessageEntity = new UserMessageEntity();
        userMessageEntity.setId(userMessage.getId());
        userMessageEntity.setUserMessage(userMessage.getUserMessage());
        userMessageEntity.setCreatedAt(userMessage.getCreatedAt());
        return userMessageEntity;
    }

    /*
    public List<UserMessageEntity> toEntity(List<UserMessage> userMessages){
        if(userMessages == null){return null;}
        List<UserMessageEntity> userMessageEntities = new ArrayList<>();
        for(UserMessage userMessage : userMessages){
            userMessageEntities = this.toEntity(userMessage);
        }
        UserMessageEntity userMessageEntity = new UserMessageEntity();
        userMessageEntity.setId(userMessage.getId());
        userMessageEntity.setUserMessage(userMessage.getUserMessage());
        userMessageEntity.setCreatedAt(userMessage.getCreatedAt());
        return userMessageEntity;
    }
    */
}
