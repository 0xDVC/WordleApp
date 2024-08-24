import React from 'react';
import GameBoard from '@components/GameBoard';

const App: React.FC = () => {
    return (
        <div className="App">
            <header className="bg-white shadow-md p-4 mb-8">
                <h1 className="text-2xl font-bold text-center">Wordle Clone</h1>
            </header>
            <GameBoard />
        </div>
    );
};

export default App;