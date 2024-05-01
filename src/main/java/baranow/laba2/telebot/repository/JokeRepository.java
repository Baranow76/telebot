package baranow.laba2.telebot.repository;

import baranow.laba2.telebot.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import baranow.laba2.telebot.model.Joke;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JokeRepository extends JpaRepository<Joke, Long>{

    List<Joke> findTop5ByOrderByCountCallDesc();
}
