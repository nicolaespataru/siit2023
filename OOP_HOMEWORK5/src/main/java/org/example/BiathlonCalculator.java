package org.example;

class BiathlonCalculator {

    public int calculatePenalty(String shootingRange) {
        int totalPenalty = 0;
        totalPenalty += countMissedShots(shootingRange);
        return totalPenalty * 10;
    }

    private int countMissedShots(String shootingRange) {
        int missCount = 0;
        char missSymbol = ShootingResult.MISS.getSymbol();

        for (int i = 0; i < shootingRange.length(); i++) {
            if (shootingRange.charAt(i) == missSymbol) {
                missCount++;
            }
        }

        return missCount;
    }
    public int calculateFinalTime(String skiTimeResult, int penalty) {
        return parseTime(skiTimeResult) + penalty;
    }

    private int parseTime(String timeStr) {
        String[] timeComponents = timeStr.split(":");
        int minutes = Integer.parseInt(timeComponents[0]);
        int seconds = Integer.parseInt(timeComponents[1]);
        return minutes * 60 + seconds;
    }
}
