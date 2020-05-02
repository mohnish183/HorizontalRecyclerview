package com.example.horizontalrecyclerview;

/**
 * @author Shayak Banerjee
 * @version 0.1
 * @since 12 June 2019
 */
public class NewOffer {
    private String logoLink;
    private String companyName;
    private String numberOfRewards;

    /**
     * Constructor
     *
     * @param logoLink        URL of the logo
     * @param companyName     Name of the company offering the cashback
     * @param numberOfRewards number of rewards being offered by the company
     */
    public NewOffer(String logoLink, String companyName, String numberOfRewards) {
        this.logoLink = logoLink;
        this.companyName = companyName;
        this.numberOfRewards = numberOfRewards;
    }

    public String getLogoLink() {
        return logoLink;
    }


    public String getCompanyName() {
        return companyName;
    }


    public String getNumberOfRewards() {
        return numberOfRewards;
    }

}