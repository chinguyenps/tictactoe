package tictactoe.service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tictactoe.domain.Game;
import tictactoe.domain.GameHistory;
import tictactoe.repository.GameHistoryRepository;


@Service
public class GameHistoryService {

	@Autowired
	private GameHistoryRepository repository;
	
    public void saveHistory(String id) {

    }
    
    public GameHistory loadHistory(String id) {
    	//return repository.findById(id);
    	return null;
    }    
}