package com.mod.SubmitModS.Controller;

import com.mod.SubmitModS.Model.User;
import com.mod.SubmitModS.Model.UserMessage;
import com.mod.SubmitModS.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/submit-mod")
public class MainController {

    private final UserService userService;

    @PostMapping("/{id}/new-message")
    public ResponseEntity<UserMessage> createMessage(@RequestBody UserMessage userMessage, @PathVariable Long id) {
        log.info("Called methode createMessage for message with id :", userMessage.getId());
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(userService.createUserMessage(userMessage, id));
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(404).build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("Called methode createUser");
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(userService.createUser(user));
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(404).build();
        }

    }
}
