package ru.ifmo.telegrambot.bot;


import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.ifmo.telegrambot.models.User;
import ru.ifmo.telegrambot.services.UsersService;

public class TelegramBot extends TelegramLongPollingBot {
    String token;

    @Autowired
    private UsersService service;

  public TelegramBot(String token, String name) {
    super(name);
    this.token = token;
  }

  @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            String username = update.getMessage().getFrom().getUserName();
            if (!service.isUserExists(username)) {
                service.addUser(new User(username, chatId));
            }
        }
    }

  public void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(chatId);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

  public UsersService getUsersService(){
    return service;
  }

    @Override
    public String getBotUsername() {
        return token;
    }
}
