
package com.taishi.scribd.models.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SaleInfo {

    private String country;
    private String saleability;
    private Boolean isEbook;
    private ListPrice listPrice;
    private RetailPrice retailPrice;
    private String buyLink;
    private List<Offer> offers = new ArrayList<Offer>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The saleability
     */
    public String getSaleability() {
        return saleability;
    }

    /**
     * 
     * @param saleability
     *     The saleability
     */
    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    /**
     * 
     * @return
     *     The isEbook
     */
    public Boolean getIsEbook() {
        return isEbook;
    }

    /**
     * 
     * @param isEbook
     *     The isEbook
     */
    public void setIsEbook(Boolean isEbook) {
        this.isEbook = isEbook;
    }

    /**
     * 
     * @return
     *     The listPrice
     */
    public ListPrice getListPrice() {
        return listPrice;
    }

    /**
     * 
     * @param listPrice
     *     The listPrice
     */
    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * 
     * @return
     *     The retailPrice
     */
    public RetailPrice getRetailPrice() {
        return retailPrice;
    }

    /**
     * 
     * @param retailPrice
     *     The retailPrice
     */
    public void setRetailPrice(RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 
     * @return
     *     The buyLink
     */
    public String getBuyLink() {
        return buyLink;
    }

    /**
     * 
     * @param buyLink
     *     The buyLink
     */
    public void setBuyLink(String buyLink) {
        this.buyLink = buyLink;
    }

    /**
     * 
     * @return
     *     The offers
     */
    public List<Offer> getOffers() {
        return offers;
    }

    /**
     * 
     * @param offers
     *     The offers
     */
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
