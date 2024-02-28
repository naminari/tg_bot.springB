package ru.ifmo.telegrambot.services;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.telegrambot.models.User;
import ru.ifmo.telegrambot.repositories.UserRepository;

@Service
@Component
@RequiredArgsConstructor
public class UsersService {
  private final UserRepository userRepository;

  public Optional<User> getUserByName(String name) {
    return userRepository.findByName(name);
  }

  public boolean isUserExists(String name) {
    return this.getUserByName(name).isPresent();
  }

  @Transactional
  public void addUser(User user) {
    userRepository.save(user);
  }

  @Transactional
  public void deleteUser(User user) {
    userRepository.delete(user);
  }
}
