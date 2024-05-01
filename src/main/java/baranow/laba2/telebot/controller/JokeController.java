package baranow.laba2.telebot.controller;
import baranow.laba2.telebot.model.Joke;
import baranow.laba2.telebot.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/jokes")
public class JokeController {
    private final JokeService jokeService;


    @PostMapping
    ResponseEntity<Void> addJoke(@RequestBody Joke joke){
        jokeService.addJoke(joke);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    ResponseEntity<Joke> getJokeById(@PathVariable Long id, @RequestParam(name = "userId", required = false) Long userId) {
        Optional<Joke> jokeOptional = jokeService.getJokeById(id, userId);
        return jokeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping
    ResponseEntity<List<Joke>> getAllJoke(){
        return ResponseEntity.ok(jokeService.getAllJokes());

    }



    @PutMapping("/{id}")
    ResponseEntity<Joke> updateJokeById(@PathVariable Long id, @RequestBody Joke updatedJoke) {
        Optional<Joke> updatedJokeOptional = jokeService.putJokeById(id, updatedJoke);
        return updatedJokeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteJokeById(@PathVariable Long id){
        jokeService.deleteJokeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top5")
    ResponseEntity<List<Joke>> getTopFiveJokes() {
        return ResponseEntity.ok(jokeService.getTopFiveJokes());
    }



}
