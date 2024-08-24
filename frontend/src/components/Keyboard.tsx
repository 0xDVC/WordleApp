import React from 'react';

const KEYBOARD_ROWS = [
    ['Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'],
    ['A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'],
    ['Enter', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'Backspace'],
];

interface KeyboardProps {
    onKeyPress: (key: string) => void;
}

const Keyboard: React.FC<KeyboardProps> = ({ onKeyPress }) => {
    return (
        <div className="keyboard">
            {KEYBOARD_ROWS.map((row, i) => (
                <div key={i} className="flex justify-center">
                    {row.map((key) => (
                        <button
                            key={key}
                            className="keyboard-key bg-gray-300 hover:bg-gray-400"
                            onClick={() => onKeyPress(key)}
                        >
                            {key === 'Backspace' ? '⌫' : key}
                        </button>
                    ))}
                </div>
            ))}
        </div>
    );
};

export default Keyboard;