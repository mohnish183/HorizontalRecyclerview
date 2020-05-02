package com.example.horizontalrecyclerview;

/**
 * @author Shayak Banerjee
 * @version 0.1
 * @since 12 June 2019
 */
public class LatestOffer {
    private String logoLink;
    private String offer;
    private String cashback;
    private String numberOfUsers;
    private String timeLeft;

    /**
     * Constructor
     *
     * @param logoLink      url of the logo
     * @param offer         offer text
     * @param cashback      cashback text
     * @param numberOfUsers number of users
     * @param timeLeft      time for the which the offer is valid
     */
    public LatestOffer(String logoLink, String offer, String cashback, String numberOfUsers, String timeLeft) {
        this.logoLink = logoLink;
        this.offer = offer;
        this.cashback = cashback;
        this.numberOfUsers = numberOfUsers;
        this.timeLeft = timeLeft;
    }

    public String getLogoLink() {
        return logoLink;
    }


    public String getOffer() {
        return offer;
    }


    public String getCashback() {
        return cashback;
    }


    public String getNumberOfUsers() {
        return numberOfUsers;
    }


    public String getTimeLeft() {
        return timeLeft;
    }

}
