package com.example.horizontalrecyclerview;

public class CashbackVouchers {

        private String logoLink;
        private String offer;
        private String cashback;
  //      private String numberOfUsers;
    //    private String timeLeft;

        /**
         * Constructor
         *
         * @param logoLink      url of the logo
         * @param offer         offer text
         * @param cashback      cashback text
          time for the which the offer is valid
         */
        public CashbackVouchers(String logoLink, String offer, String cashback) {
            this.logoLink = logoLink;
            this.offer = offer;
            this.cashback = cashback;

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


      //  public String getNumberOfUsers() {
        //    return numberOfUsers;
       // }


        //public String getTimeLeft() {
          //  return timeLeft;
       // }

    }
