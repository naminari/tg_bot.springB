package ru.ifmo.telegrambot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.telegrambot.services.BotService;

@Component
@RestController
@RequiredArgsConstructor
public class BotController {

  private final BotService botService;

  @GetMapping("/is-user-exists/{name}")
  public ResponseEntity<?> isUserExists(@PathVariable String name) {
    if (name.matches("^(?!.* )[a-zA-Z0-9_-]{5,30}(?<! )$")){
      boolean isExists = botService.isUserExists(name);
      return ResponseEntity.ok(isExists);
    } else {
      return ResponseEntity.badRequest().body("Name is not valid");
    }
    
  }

  @PostMapping("/send-message/{chatId}/{message}")
  public ResponseEntity<?> sendMessage(@PathVariable Long chatId, @PathVariable String message) {
    // TODO: используй регулярку или что-то другое чтобы проверить валидность id
    botService.sendMessage(chatId, message);
    return ResponseEntity.ok().build();
  }
}
