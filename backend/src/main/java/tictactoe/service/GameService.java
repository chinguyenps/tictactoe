package tictactoe.service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tictactoe.domain.Game;
import tictactoe.repository.GameRepository;


@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
    private final AtomicLong counter = new AtomicLong();

    public Game newGame() {
    	Game game = repository.save(new Game(Long.toString(counter.incrementAndGet())));
        return game;
    }
    
    public void reset() {

    }    
}