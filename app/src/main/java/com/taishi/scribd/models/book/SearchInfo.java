
package com.taishi.scribd.models.book;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SearchInfo {

    private String textSnippet;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The textSnippet
     */
    public String getTextSnippet() {
        return textSnippet;
    }

    /**
     * 
     * @param textSnippet
     *     The textSnippet
     */
    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
