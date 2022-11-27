package rentCars.dto;

public record ClientFilter(int limit,
                           int offset,
                           String fio,
                           Integer licenceNo,
                           String login) {
}
