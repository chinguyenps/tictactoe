package tictactoe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tictactoe.domain.GameHistory;

public interface GameHistoryRepository extends MongoRepository<GameHistory, String> {
}