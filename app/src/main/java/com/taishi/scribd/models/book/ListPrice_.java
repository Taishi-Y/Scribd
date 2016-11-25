
package com.taishi.scribd.models.book;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ListPrice_ {

    private Integer amountInMicros;
    private String currencyCode;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The amountInMicros
     */
    public Integer getAmountInMicros() {
        return amountInMicros;
    }

    /**
     * 
     * @param amountInMicros
     *     The amountInMicros
     */
    public void setAmountInMicros(Integer amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    /**
     * 
     * @return
     *     The currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 
     * @param currencyCode
     *     The currencyCode
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
