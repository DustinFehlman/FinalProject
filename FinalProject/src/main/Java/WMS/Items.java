package WMS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    public int size;
    private int sku;
    private String name;
    private String itemType;
    private boolean stowed;

    public Items() {

        //setStowed(false);

        if (getItemType() == "accessories") {

            setSize(1);
        }
        if (getItemType() == "beauty" || getItemType() == "clothing") {

            setSize(2);
        }

        if (getItemType() == "shoes" || getItemType() == "bags") {
            setSize(3);
        }

        if (getItemType() == "housewares") {
            setSize(5);
        }

    }

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
