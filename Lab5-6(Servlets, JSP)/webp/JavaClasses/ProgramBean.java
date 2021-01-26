package JavaClasses;

import java.io.Serializable;

public class ProgramBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String display_ID;
    private String display_name;
    private String resolution;
    private String diagonal;
    private String update_frequency;
    private String price;

    public ProgramBean(){ }

    public ProgramBean(String display_ID, String display_name, String resolution, String diagonal, String update_frequency, String price) {

        this.display_ID = display_ID;
        this.display_name = display_name;
        this.resolution = resolution;
        this.diagonal = diagonal;
        this.update_frequency = update_frequency;
        this.price = price;
    }

    public String getDisplay_ID() {
        return display_ID;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getResolution() {
        return resolution;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public String getUpdate_frequency() {
        return update_frequency;
    }

    public String getPrice() {
        return price;
    }
}