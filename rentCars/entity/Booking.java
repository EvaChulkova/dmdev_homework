package rentCars.entity;

import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private Integer clientId;
    private Integer carId;
    private LocalDateTime rentalStart;
    private LocalDateTime rentalFinish;
    private Integer administratorId;
    private String status;
    private String comment;

    public Booking(Long id, Integer clientId, Integer carId, LocalDateTime rentalStart, LocalDateTime rentalFinish, Integer administratorId, String status, String comment) {
        this.id = id;
        this.clientId = clientId;
        this.carId = carId;
        this.rentalStart = rentalStart;
        this.rentalFinish = rentalFinish;
        this.administratorId = administratorId;
        this.status = status;
        this.comment = comment;
    }

    public Booking(){}

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", carId=" + carId +
                ", rentalStart=" + rentalStart +
                ", rentalFinish=" + rentalFinish +
                ", administratorId=" + administratorId +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                '}' + '\n';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public LocalDateTime getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(LocalDateTime rentalStart) {
        this.rentalStart = rentalStart;
    }

    public LocalDateTime getRentalFinish() {
        return rentalFinish;
    }

    public void setRentalFinish(LocalDateTime rentalFinish) {
        this.rentalFinish = rentalFinish;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
