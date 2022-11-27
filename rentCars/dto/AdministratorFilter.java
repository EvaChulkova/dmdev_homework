package rentCars.dto;

public record AdministratorFilter(int limit,
                                  int offset,
                                  String fio,
                                  String login) {
}
