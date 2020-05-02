package com.example.horizontalrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * This class is used to insert data into the offers in CompanyCouponActivity
 *
 * @author Shayak Banerjee
 * @version 0.1
 * @since 15 June 2019
 */
public class CompanyOfferAndCoupon implements Serializable {
    private String imageLink;
    private String category;
    private String offerDescription;
    private String markedPrice;
    private String discountedPrice;
    private int type; // offer or coupon

    public static final int COUPON = 0;
    public static final int OFFER = 1;

    public int getType() {
        return type;
    }

    /**
     * Constructor
     *
     * @param category         category of the merchandise
     * @param offerDescription description displayed in offer
     * @param markedPrice      marked price of merchandise
     * @param discountedPrice  discounted price of merchandise
     * @param type             <code>CompanyOfferAndCoupon.COUPON</code> or <code>CompanyOfferAndCoupon.OFFER</code>. Non null, must be specified
     * @param imageLink        image URL
     */
    public CompanyOfferAndCoupon(@NonNull String imageLink, @NonNull String category,
                                 @NonNull String offerDescription, @Nullable String markedPrice,
                                 @Nullable String discountedPrice, @NonNull Integer type) {
        this.category = category;
        this.offerDescription = offerDescription;
        this.markedPrice = markedPrice;
        this.discountedPrice = discountedPrice;
        this.type = type;
        this.imageLink = imageLink;
    }

    /**
     * @return category of the merchandise
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return description displayed in offer
     */
    public String getOfferDescription() {
        return offerDescription;
    }

    /**
     * @return marked price of merchandise
     */
    public String getMarkedPrice() {
        return markedPrice;
    }

    /**
     * @return discounted price of merchandise
     */
    public String getDiscountedPrice() {
        return discountedPrice;
    }

    /**
     *
     * @return image URL
     */
    public String getImageLink() {
        return imageLink;
    }

}
