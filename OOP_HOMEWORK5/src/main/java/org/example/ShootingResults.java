package org.example;

enum ShootingResult {
    HIT('x'), MISS('o');

    private final char symbol;

    ShootingResult(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}