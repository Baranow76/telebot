package baranow.laba2.telebot.service;

import baranow.laba2.telebot.model.Joke;

import java.util.List;
import java.util.Optional;

//Интерфейс для сервиса
public interface JokeService {

    void addJoke(Joke joke);

    List<Joke> getAllJokes();

    Optional<Joke> getJokeById(Long id, Long userId);

    Optional<Joke> putJokeById(Long id, Joke updatedJoke);

    void deleteJokeById(Long id);
    List<Joke> getTopFiveJokes();


}
