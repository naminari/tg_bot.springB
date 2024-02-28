package ru.ifmo.telegrambot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.ifmo.telegrambot.bot.TelegramBot;

@Configuration
public class AppConfig {
  @Value("${bot.token}")
  private String token;

  @Value("${bot.name}")
  private String name;

  @Bean
  public TelegramBot telegramBot() throws TelegramApiException {
    TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
    TelegramBot telegramBot = new TelegramBot(token, name);
    botsApi.registerBot(telegramBot);
    return telegramBot;
  }
}
