package borkowski.domain;

public class Shoes {
    private Long id;
    private Integer size;
    private String brand;
    private String color;


    public Shoes() {
    }

    public Shoes(Long id, Integer size, String brand, String color) {
        this.id = id;
        this.size = size;
        this.brand = brand;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}