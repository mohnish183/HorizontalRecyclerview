package com.example.horizontalrecyclerview;

/**
 * This class is used to store the data that will be displayed in the FAQ's recycler view
 *
 * @author Shayak Banerjee
 * @version 0.1
 * @since 11 June 2019
 */
public class FAQItem{
    /**
     * Title of the FAQItem
     */
    public String title;
    /**
     * Description of the FAQItem
     */
    public String description;

    /**
     * Constructor<br>Assigns members
     * @param title title of the FAQItem
     * @param description description of the FAQItem
     */
    FAQItem(String title, String description){
        this.title = title;
        this.description = description;

    }

    /**
     * @return title of the FAQItem
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return description of the FAQItem
     */
    public String getDescription() {
        return description;
    }
}