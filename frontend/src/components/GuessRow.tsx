import React from 'react';

interface GuessRowProps {
  guess: string;
}

const GuessRow: React.FC<GuessRowProps> = ({ guess }) => {
  return (
    <div className="flex">
      {[...Array(5)].map((_, i) => (
        <div key={i} className={`letter-box ${guess[i] ? 'border-gray-300' : 'border-gray-200'}`}>
          {guess[i] || ''}
        </div>
      ))}
    </div>
  );
};

export default GuessRow;