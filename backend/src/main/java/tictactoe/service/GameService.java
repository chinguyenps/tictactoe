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
    	String id = java.util.UUID.randomUUID().toString();
    	Game game = repository.save(new Game(id));
        return game;
    }
    
    public void reset(String id) {

    }    
}