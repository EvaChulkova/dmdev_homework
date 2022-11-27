package rentCars.dao;

import rentCars.dto.CarFilter;
import rentCars.entity.Car;
import rentCars.exception.RentCarsDaoException;
import rentCars.util.RentCarsConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarDao {
    private static final CarDao INSTANCE = new CarDao();

    public static final String DELETE_FROM_CAR_SQL = """
            DELETE FROM car
            WHERE id = ?
            """;

    public static final String ADD_CAR_SQL = """
            INSERT INTO car(brand, color, seat_amount, price, status) 
            VALUES (?, ?, ?, ?, ?)
            """;

    public static final String UPDATE_CAR_SQL = """
            UPDATE car
            SET brand = ?,
            color = ?, 
            seat_amount = ?,
            price = ?,
            status = ?
            WHERE id = ?
            """;

    public static final String FIND_ALL_CARS_SQL = """
            SELECT id,
            brand,
            color,
            seat_amount,
            price, 
            status
            FROM car
            """;

    public static final String FIND_CAR_BY_ID_SQL = FIND_ALL_CARS_SQL +  """
            WHERE id = ?
            """;


    private CarDao() {}

    public List<Car> findAllCarWithFilters(CarFilter carFilter) {
        List<Object> parameters = new ArrayList<>();
        List<String> whereSQL = new ArrayList<>();
        if(carFilter.brand() != null) {
            whereSQL.add("brand LIKE ? ");
            parameters.add("%" + carFilter.brand() + "%");
        }
        if(carFilter.color() != null) {
            whereSQL.add("color LIKE ? ");
            parameters.add("%" + carFilter.color() + "%");
        }
        if(carFilter.seatAmount() != null) {
            whereSQL.add("seat_amount = ? ");
            parameters.add(carFilter.seatAmount());
        }
        if(carFilter.price() != null) {
            whereSQL.add("price = ? ");
            parameters.add(carFilter.price());
        }
        //whereSQL.add("price > ? AND price < ?");
        /*if(carFilter.price() != null) {
            whereSQL.add("price > ? ");
            parameters.add("%" + carFilter.price() + "%");
        }
        if(carFilter.price() != null) {
            whereSQL.add("price < ? ");
            parameters.add("%" + carFilter.price() + "%");
        }*/

        if(carFilter.status() != null) {
            whereSQL.add("status = ? ");
            parameters.add("%" + carFilter.status() + "%");
        }
        parameters.add(carFilter.limit());
        parameters.add(carFilter.offset());

        var where = whereSQL.stream()
                .collect(Collectors.joining(" AND ", " WHERE ", " LIMIT ? OFFSET ?"));

        var sql = FIND_ALL_CARS_SQL + where;
        try (var connection = RentCarsConnectionManager.get();
        var preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            System.out.println(preparedStatement);
            var resultSet = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();
            while (resultSet.next()) {
                cars.add(buildCar(resultSet));
            }
            return cars;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public List<Car> findAllCars() {
        try (var connection = RentCarsConnectionManager.get();
        var preparedStatement = connection.prepareStatement(FIND_ALL_CARS_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();
            while (resultSet.next()) {
                cars.add(buildCar(resultSet));
            }
            return cars;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public Optional<Car> findById(Long id) {
        try (var connection = RentCarsConnectionManager.get();
        var preparedStatement= connection.prepareStatement(FIND_CAR_BY_ID_SQL)) {
            preparedStatement.setLong(1, id);

            var resultSet = preparedStatement.executeQuery();
            Car car = null;
            if (resultSet.next()) {
                //buildCar(resultSet);
                car = new Car(
                        resultSet.getLong("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("color"),
                        resultSet.getInt("seat_amount"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getString("status")
                );
            }
            return Optional.ofNullable(car);
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    private Car buildCar(ResultSet resultSet) throws SQLException {
        return new Car(
                resultSet.getLong("id"),
                resultSet.getString("brand"),
                resultSet.getString("color"),
                resultSet.getInt("seat_amount"),
                resultSet.getBigDecimal("price"),
                resultSet.getString("status")
        );
    }

    public void updateCar(Car car) {
        try (var connection = RentCarsConnectionManager.get();
        var preparedStatement = connection.prepareStatement(UPDATE_CAR_SQL)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getColor());
            preparedStatement.setInt(3, car.getSeatAmount());
            preparedStatement.setBigDecimal(4, car.getPrice());
            preparedStatement.setString(5, car.getStatus());
            preparedStatement.setLong(6, car.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public boolean deleteCar(Long id) {
        try (var connection = RentCarsConnectionManager.get();
             var preparedStatement = connection.prepareStatement(DELETE_FROM_CAR_SQL)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public Car addCar(Car car) {
        try (var connection = RentCarsConnectionManager.get();
        var preparedStatement = connection.prepareStatement(ADD_CAR_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getColor());
            preparedStatement.setInt(3, car.getSeatAmount());
            preparedStatement.setBigDecimal(4, car.getPrice());
            preparedStatement.setString(5, car.getStatus());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()) {
                car.setId(generatedKeys.getLong("id"));
            }
            return car;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }


    public static CarDao getInstance() {
        return INSTANCE;
    }
}
