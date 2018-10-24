import React from 'react';
import ReactDOM from 'react-dom';
import Button from 'react-button-component';

import './index.css';
import Board from '../Board';

import API from '../../services/api/API';

const api = new API({ url:'http://localhost:8080/api' })

class Game extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      history: [{
        squares: Array(9).fill(null)
      }],
      xIsNext: true
    };

    //initiate the api instance for the game's endpoints
    api.createEntity({ name: 'game' })
  }

  handleClick(i) {
    const history = this.state.history;
    const current = history[history.length - 1];
    const squares = current.squares.slice();
    if (calculateWinner(squares) || squares[i]) {
      return;
    }
    squares[i] = this.state.xIsNext ? 'X' : 'O';
    this.setState({
      history: history.concat([{
        squares: squares
      }]),
      xIsNext: !this.state.xIsNext,
    });

    api.endpoints.game.call({ name: 'save'})
    .then(({data}) => console.log(data));
  }

  startGame(){
    api.endpoints.game.call({ name: 'start'})
    .then(({data}) => console.log(data));
  }

  resetGame(){
    api.endpoints.game.call({ name: 'reset'})
    .then(({data}) => console.log(data));
  }

  loadGame(){
    api.endpoints.game.call({ name: 'load'})
    .then(({data}) => console.log(data));
  }
  
  render() {
    const history = this.state.history;
    const current = history[history.length - 1];
    const winner = calculateWinner(current.squares);

    let status;
    if (winner) {
      status = 'Winner: ' + winner;
    } else {
      status = 'Next player: ' + (this.state.xIsNext ? 'X' : 'O');
    }

    return (
      <div className="game">
        <div className="game-board">
          <Board
            squares={current.squares}
            onClick={(i) => this.handleClick(i)}
          />
        </div>
        <div className="game-info">
          <div>{status}</div>

           <div className="button">
            <Button onClick={() => this.startGame()}>
              Start
            </Button>
          </div>

          <div className="button">
            <Button onClick={() => this.resetGame()}>
              Reset
            </Button>
          </div>

          <div className="button">
            <Button onClick={() => this.loadGame()}>
              Load
            </Button>
          </div>

        </div>
      </div>
    );
  }
}

function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return squares[a];
    }
  }
  return null;
}

export default Game