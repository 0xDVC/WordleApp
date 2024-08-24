import React, { useState, useEffect } from 'react';
import GuessRow from './GuessRow';
import Keyboard from './Keyboard';

const GameBoard: React.FC = () => {
    const [guesses, setGuesses] = useState<string[]>([]);
    const [currentGuess, setCurrentGuess] = useState('');
    const [gameState, setGameState] = useState<'playing' | 'won' | 'lost'>('playing');

    useEffect(() => {
        // Start a new game when component mounts
        startNewGame();
    }, []);

    const startNewGame = async () => {
        // Call your backend API to start a new game
        setGuesses([]);
        setCurrentGuess('');
        setGameState('playing');
    };

    const handleKeyPress = (key: string) => {
        if (gameState !== 'playing') return;

        if (key === 'Enter') {
            submitGuess();
        } else if (key === 'Backspace') {
            setCurrentGuess(prev => prev.slice(0, -1));
        } else if (currentGuess.length < 5) {
            setCurrentGuess(prev => prev + key);
        }
    };

    const submitGuess = async () => {
        if (currentGuess.length !== 5) return;

        // Call your backend API to submit the guess
        // Update guesses, gameState based on the response
        setGuesses(prev => [...prev, currentGuess]);
        setCurrentGuess('');

        // Check if game is won or lost
        // Update gameState accordingly
    };

    return (
        <div className="flex flex-col items-center justify-center min-h-screen">
            <div className="mb-8">
                {[...Array(6)].map((_, i) => (
                    <GuessRow key={i} guess={guesses[i] || ''} />
                ))}
            </div>
            <Keyboard onKeyPress={handleKeyPress} />
        </div>
    );
};

export default GameBoard;