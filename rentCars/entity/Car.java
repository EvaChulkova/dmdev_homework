package rentCars.entity;

import java.math.BigDecimal;

public class Car {
    private Long id;
    private String brand;
    private String color;
    private Integer seatAmount;
    private BigDecimal price;
    private String status;

    public Car(){}

    public Car(Long id, String brand, String color, Integer seatAmount, BigDecimal price, String status) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.seatAmount = seatAmount;
        this.price = price;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", seatAmount=" + seatAmount +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}' + "\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(Integer seatAmount) {
        this.seatAmount = seatAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
