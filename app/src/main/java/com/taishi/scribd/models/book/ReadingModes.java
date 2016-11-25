
package com.taishi.scribd.models.book;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ReadingModes {

    private Boolean text;
    private Boolean image;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The text
     */
    public Boolean getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(Boolean text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The image
     */
    public Boolean getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(Boolean image) {
        this.image = image;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
