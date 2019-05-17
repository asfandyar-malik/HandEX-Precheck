package com.handex.representations;

public class StateResponse {

    public String minimumInterestOffer;
    public String maxInterestRateOffer;
    public Result status;

    public StateResponse() {
    }

    public StateResponse(String minimumInterestOffer, String maxInterestRateOffer, Result status) {
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
