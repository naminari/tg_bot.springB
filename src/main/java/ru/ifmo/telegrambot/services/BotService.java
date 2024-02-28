package ru.ifmo.telegrambot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.telegrambot.bot.TelegramBot;

@Service
@RequiredArgsConstructor
public class BotService {

  @Autowired
  private final TelegramBot bot;

  public boolean isUserExists(String name) {
    return bot.getUsersService().isUserExists(name);
  }

  public void sendMessage(Long chatId, String text_message) {
    bot.sendMessage(chatId, text_message);
  }
}
