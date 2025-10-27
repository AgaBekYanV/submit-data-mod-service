package com.mod.SubmitModS.Controller;

import com.mod.SubmitModS.Model.User;
import com.mod.SubmitModS.Model.UserMessage;
import com.mod.SubmitModS.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/submit-mod")
public class MainController {

    private final UserService userService;

    @PostMapping("/{id}/new-message")
    public ResponseEntity<UserMessage> createMessage(@PathVariable Long id, @RequestBody UserMessage message) {
        log.info("Called methode createMessage for message with id :", id);
        log.info("Called methode createMessage with message:", message.getUserMessage());
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(userService.createUserMessage(message, id));
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
