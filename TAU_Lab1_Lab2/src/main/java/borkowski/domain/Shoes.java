package borkowski.domain;
import java.util.Objects;

public class Shoes {
    private Long id;
    private Integer size;
    private String brand;
    private String color;
    private long addTime;
    private long updateTime;
    private long readTime;


    public Shoes() {
    }

    public Shoes(Long id, Integer size, String brand, String color) {
        this.id = id;
        this.size = size;
        this.brand = brand;
        this.color = color;
    }

    public Shoes(Long id, Integer size, String brand, String color, long addTime, long updateTime, long readTime) {
        this.id = id;
        this.size = size;
        this.brand = brand;
        this.color = color;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.readTime = readTime;
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

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getReadTime() {
        return readTime;
    }

    public void setReadTime(long readTime) {
        this.readTime = readTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shoes)) return false;
        Shoes shoes = (Shoes) o;
        return getId().equals(shoes.getId()) &&
                getSize().equals(shoes.getSize()) &&
                getBrand().equals(shoes.getBrand()) &&
                getColor().equals(shoes.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSize(), getBrand(), getColor());
    }
}