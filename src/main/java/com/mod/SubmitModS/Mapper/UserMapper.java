package com.mod.SubmitModS.Mapper;

import com.mod.SubmitModS.Model.User;
import com.mod.SubmitModS.Model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final UserMessageMapper userMessageMapper;

    public User toModel(UserEntity userEntity) {
        if(userEntity == null) {return null;}
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setUuid(userEntity.getUuid());
        user.setCreatedAt(userEntity.getCreatedAt());
        if(userEntity.getUserMessages() != null && !userEntity.getUserMessages().isEmpty()) {
            user.setUserMessages(userEntity.getUserMessages()
                    .stream()
                    .map(userMessageMapper::toModel)
                    .toList());
        }
        return user;

    }

    public UserEntity toEntity(User user) {
        if(user == null) {return null;}
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setUuid(user.getUuid());
        userEntity.setCreatedAt(user.getCreatedAt());
        if(user.getUserMessages() != null && !user.getUserMessages().isEmpty()){
            userEntity.setUserMessages(user.getUserMessages()
                    .stream()
                    .map(userMessageMapper::toEntity)
                    .toList());
        }
        return userEntity;
    }
}
