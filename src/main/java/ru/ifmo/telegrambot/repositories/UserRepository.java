package ru.ifmo.telegrambot.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ifmo.telegrambot.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByName(String name);
}
