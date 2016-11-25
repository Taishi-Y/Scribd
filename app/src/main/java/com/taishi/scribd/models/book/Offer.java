
package com.taishi.scribd.models.book;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Offer {

    private Integer finskyOfferType;
    private ListPrice_ listPrice;
    private RetailPrice_ retailPrice;
    private Boolean giftable;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The finskyOfferType
     */
    public Integer getFinskyOfferType() {
        return finskyOfferType;
    }

    /**
     * 
     * @param finskyOfferType
     *     The finskyOfferType
     */
    public void setFinskyOfferType(Integer finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    /**
     * 
     * @return
     *     The listPrice
     */
    public ListPrice_ getListPrice() {
        return listPrice;
    }

    /**
     * 
     * @param listPrice
     *     The listPrice
     */
    public void setListPrice(ListPrice_ listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * 
     * @return
     *     The retailPrice
     */
    public RetailPrice_ getRetailPrice() {
        return retailPrice;
    }

    /**
     * 
     * @param retailPrice
     *     The retailPrice
     */
    public void setRetailPrice(RetailPrice_ retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 
     * @return
     *     The giftable
     */
    public Boolean getGiftable() {
        return giftable;
    }

    /**
     * 
     * @param giftable
     *     The giftable
     */
    public void setGiftable(Boolean giftable) {
        this.giftable = giftable;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
