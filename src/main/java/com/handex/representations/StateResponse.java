package com.handex.representations;

public class StateResponse {

    public Double minimumInterestOffer;
    public Double maxInterestRateOffer;
    public Result status;

    public StateResponse() {
    }

    public StateResponse(Double minimumInterestOffer, Double maxInterestRateOffer, Result status) {
        this.minimumInterestOffer = minimumInterestOffer;
        this.maxInterestRateOffer = maxInterestRateOffer;
        this.status = status;
    }

    @Override
    public String toString() {
        return "StateResponse{" +
                "minimumInterestOffer='" + minimumInterestOffer + '\'' +
                ", maxInterestRateOffer='" + maxInterestRateOffer + '\'' +
                ", status=" + status +
                '}';
    }
}
