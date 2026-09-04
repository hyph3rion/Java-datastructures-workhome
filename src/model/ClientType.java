package model;

public enum ClientType {
    PARTICULAR(80000),
    EPS(5000),
    PREPAGADA(30000);

    private final double baseFee;

    ClientType(double baseFee) {
        this.baseFee = baseFee;
    }

    public double getBaseFee() {
        return baseFee;
    }
}
