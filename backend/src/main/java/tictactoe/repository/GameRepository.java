package tictactoe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tictactoe.domain.Game;

public interface GameRepository extends MongoRepository<Game, String> {

    //public Game findByFirstName(String firstName);
    //public List<Game> findByLastName(String lastName);

}