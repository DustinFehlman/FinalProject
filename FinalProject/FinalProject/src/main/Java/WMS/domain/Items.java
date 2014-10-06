package WMS.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    private int size;
    private int sku;
    private String name;
    private String itemType;
    private boolean stowed;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSku() {
        return sku;
    }

    public boolean isStowed() {
        return stowed;
    }

    public void setStowed(boolean stowed) {
        this.stowed = stowed;
    }

    public String getName() {
        return name;
    }

    public String getItemType() {
        return itemType;
    }

}
