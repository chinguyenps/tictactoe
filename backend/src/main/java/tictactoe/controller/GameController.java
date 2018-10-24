package tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tictactoe.domain.Game;
import tictactoe.domain.GameHistory;
import tictactoe.service.GameHistoryService;
import tictactoe.service.GameService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/game")
@RestController
public class GameController {

  
	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameHistoryService gameHistoryService;	
    
    @RequestMapping("/start")
    public Game start() {
    	return gameService.newGame();
    }
    
    @RequestMapping("/reset")
    public void saveHistory(@RequestParam(value="history") String history) {
    	gameService.reset();
    }    
    
    @RequestMapping("/save")
    public void save(@RequestParam(value="id") String id) {
    	gameHistoryService.saveHistory(id);
    }    
    
    @RequestMapping("/load")
    public GameHistory load(@RequestParam(value="id") String id) {
    	return gameHistoryService.loadHistory(id);
    }     
}