package org.example;

class BiathlonAthlete implements Comparable<BiathlonAthlete> {
    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private String firstShootingRange;
    private String secondShooting;
    private String thirdShooting;
    private int penalty;
    private int finalTime;

    public BiathlonAthlete(String[] data) {
        this.athleteNumber = Integer.parseInt(data[0]);
        this.athleteName = data[1];
        this.countryCode = data[2];
        this.skiTimeResult = data[3];
        this.firstShootingRange = data[4];
        this.secondShooting = data[5];
        this.thirdShooting = data[6];
        // calculam timpul final si il punem intr-un atribut, punem si getter
        BiathlonCalculator calculator = new BiathlonCalculator();
        this.penalty = calculator.calculatePenalty(firstShootingRange) +
                calculator.calculatePenalty(secondShooting) +
                calculator.calculatePenalty(thirdShooting);
        this.finalTime = calculator.calculateFinalTime(skiTimeResult, penalty);
    }

    //default constructor pentru testare

    public BiathlonAthlete(){
        this.athleteNumber = 0;
        this.athleteName = "null";
        this.countryCode = "null";
        this.skiTimeResult = "null";
        this.firstShootingRange = "null";
        this.secondShooting = "null";
        this.thirdShooting = "null";
        this.penalty = 0;
        this.finalTime = 0;
    }

    @Override
    public int compareTo(BiathlonAthlete other) {
        return Integer.compare(finalTime, other.finalTime);
    }
    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String name){
        this.athleteName = name;
    }

    public int getFinalTime() {
        return finalTime;
    }


    // pentru test
    public void setFinalTime(int time) {
        this.finalTime = time;
    }

}