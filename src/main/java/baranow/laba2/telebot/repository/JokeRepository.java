package baranow.laba2.telebot.repository;

import baranow.laba2.telebot.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokeRepository extends JpaRepository<Joke, Long> {

}
