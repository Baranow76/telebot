package baranow.laba2.telebot.service;

import baranow.laba2.telebot.model.CallJoke;
import baranow.laba2.telebot.model.Joke;
import baranow.laba2.telebot.repository.JokeRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JokeServiceImpl implements JokeService {

    private final JokeRepository jokeRepository;


    @Override
    public void addJoke(Joke joke) {
            jokeRepository.save(joke);
    }

    @Override
    public List<Joke> getAllJokes() {
        return jokeRepository.findAll();
    }

    @Override
    public Optional<Joke> getJokeById(Long id) {
        Optional<Joke> jokeOptional = jokeRepository.findById(id);
        if (jokeOptional.isPresent()) {
            Joke joke = jokeOptional.get();
            CallJoke callJoke = new CallJoke();
            callJoke.setJoke(joke);
            callJoke.setTimeCall(new Date());
            callJoke.setIdUserCall(1L);
            joke.getCallJokes().add(callJoke);
            jokeRepository.saveAndFlush(joke);
            return jokeOptional;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Joke> putJokeById(Long id, Joke updatedJoke) {
        Optional<Joke> existingJoke = jokeRepository.findById(id);
        if (existingJoke.isPresent()) {
            Joke jokeToUpdate = existingJoke.get();
            jokeToUpdate.setTextJoke(updatedJoke.getTextJoke());
            jokeRepository.save(jokeToUpdate);
        }
        return existingJoke;
    }

    @Override
    public void deleteJokeById(Long id){
        jokeRepository.deleteById(id);
    }


}