package com.mod.SubmitModS.Service;

import com.mod.SubmitModS.Mapper.UserMapper;
import com.mod.SubmitModS.Mapper.UserMessageMapper;
import com.mod.SubmitModS.Model.User;
import com.mod.SubmitModS.Model.UserEntity;
import com.mod.SubmitModS.Model.UserMessage;
import com.mod.SubmitModS.Model.UserMessageEntity;
import com.mod.SubmitModS.Repository.UserMessageRepository;
import com.mod.SubmitModS.Repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserMessageRepository userMessageRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserMessageMapper userMessageMapper;


    public UserMessage createUserMessage(UserMessage userMessageToCreate, Long id) {
        if(userMessageToCreate == null){
            return null;
        }
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User with id " + id + " not found"));


        UserMessageEntity userMessageEntity = new UserMessageEntity();
        userMessageEntity.setId(userMessageToCreate.getId());
        userMessageEntity.setUserMessage(userMessageToCreate.getUserMessage());
        userMessageEntity.setCreatedAt(LocalDateTime.now());

        userEntity.addMessage(userMessageEntity);

        userMessageRepository.save(userMessageEntity);

        return userMessageToCreate;
    }

    public User createUser(User user) {
        if(user == null){return null;}
        if (userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new EntityExistsException("User with name " + user.getUsername() + " already exists");
        }
        UserEntity userEntity = new UserEntity();

        if(user.getUserMessages() == null || user.getUserMessages().isEmpty()){userEntity.setUserMessages(null);}
        else{
            //List<UserMessage> temp = user.getUserMessages();
            //userMessageMapper.toEntity(temp);
            //userEntity.setUserMessagesEntity(userMessageMapper.toEntity(new ArrayList<>()));
        }
        userEntity.setUserMessages(null);

        userEntity.setId(null);
        userEntity.setUsername(user.getUsername());
        userEntity.setUuid(user.getUuid());
        userEntity.setCreatedAt(LocalDateTime.now());

        userRepository.save(userEntity);
        return userMapper.toModel(userRepository.save(userEntity));
    }
}
