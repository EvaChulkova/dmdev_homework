package rentCars.dao;

import rentCars.dto.BookingFilter;
import rentCars.entity.Booking;
import rentCars.exception.RentCarsDaoException;
import rentCars.util.RentCarsConnectionManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingDao {
    public static final BookingDao INSTANCE = new BookingDao();

    public static final String DELETE_BOOKING_SQL = """
            DELETE FROM booking
            WHERE id = ?
            """;

    public static final String ADD_BOOKING_SQL = """
            INSERT INTO booking (client_id, car_id, rental_start, rental_finish, administrator_id, status, comment) 
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

    public static final String UPDATE_BOOKING_SQL = """
            UPDATE booking
            SET client_id = ?,
            car_id = ?,
            rental_start = ?,
            rental_finish = ?,
            administrator_id = ?,
            status = ?,
            comment = ?
            WHERE id = ?
            """;

    public static final String FIND_ALL_BOOKINGS_SQL = """
            SELECT id,
            client_id,
            car_id,
            rental_start,
            rental_finish,
            administrator_id,
            status,
            comment
            FROM booking
            """;

    public static final String FIND_BOOKING_BY_ID = FIND_ALL_BOOKINGS_SQL + """
            WHERE id = ?
            """;

    private BookingDao() {}

    public void updateBooking(Booking booking) {
        try (Connection connection = RentCarsConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKING_SQL)) {
            preparedStatement.setInt(1, booking.getClientId());
            preparedStatement.setInt(2, booking.getCarId());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(booking.getRentalStart()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(booking.getRentalFinish()));
            preparedStatement.setInt(5, booking.getAdministratorId());
            preparedStatement.setString(6, booking.getStatus());
            preparedStatement.setString(7, booking.getComment());
            preparedStatement.setLong(8, booking.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public List<Booking> findBookingWithFilters(BookingFilter bookingFilter) {
        List<Object> parameters = new ArrayList<>();
        List<String> whereSQL = new ArrayList<>();

        if (bookingFilter.clientId() != null) {
            whereSQL.add("client_id = ? ");
            parameters.add(bookingFilter.clientId());
        }
        if (bookingFilter.carId() != null) {
            whereSQL.add("car_id = ?");
            parameters.add(bookingFilter.carId());
        }
        if(bookingFilter.administratorId() != null) {
            whereSQL.add("administrator_id = ?");
            parameters.add(bookingFilter.administratorId());
        }
        if(bookingFilter.status() != null) {
            whereSQL.add("status LIKE = ? ");
            parameters.add("%" + bookingFilter.status() + "%");
        }
        parameters.add(bookingFilter.limit());
        parameters.add(bookingFilter.offset());

        String where = whereSQL.stream()
                .collect(Collectors.joining(" AND ", " WHERE ", " LIMIT ? OFFSET ?"));

        String sql = FIND_ALL_BOOKINGS_SQL + where;
        try (Connection connection = RentCarsConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Booking> bookings = new ArrayList<>();
            while (resultSet.next()) {
                bookings.add(buildBooking(resultSet));
            }
            return bookings;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public Optional<Booking> findBookingById(Long id) {
        try (Connection connection = RentCarsConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BOOKING_BY_ID)) {
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        Booking booking = null;
        if (resultSet.next()) {
            booking = new Booking(
                    resultSet.getLong("id"),
                    resultSet.getInt("client_id"),
                    resultSet.getInt("car_id"),
                    resultSet.getTimestamp("rental_start").toLocalDateTime(),
                    resultSet.getTimestamp("rental_finish").toLocalDateTime(),
                    resultSet.getInt("administrator_id"),
                    resultSet.getString("status"),
                    resultSet.getString("comment")
            );
        }
        return Optional.ofNullable(booking);
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public List<Booking> findAllBookings() {
        try (Connection connection = RentCarsConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BOOKINGS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Booking> bookings = new ArrayList<>();
            while (resultSet.next()) {
                bookings.add(buildBooking(resultSet));
            }
            return bookings;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    private Booking buildBooking(ResultSet resultSet) throws SQLException {
        return new Booking(
                resultSet.getLong("id"),
                resultSet.getInt("client_id"),
                resultSet.getInt("car_id"),
                resultSet.getTimestamp("rental_start").toLocalDateTime(),
                resultSet.getTimestamp("rental_finish").toLocalDateTime(),
                resultSet.getInt("administrator_id"),
                resultSet.getString("status"),
                resultSet.getString("comment")
        );
    }

    public Booking addBooking(Booking booking) {
        try (Connection connection = RentCarsConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOOKING_SQL, Statement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setInt(1, booking.getClientId());
        preparedStatement.setInt(2, booking.getCarId());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(booking.getRentalStart()));
        preparedStatement.setTimestamp(4, Timestamp.valueOf(booking.getRentalFinish()));
        preparedStatement.setInt(5, booking.getAdministratorId());
        preparedStatement.setString(6, booking.getStatus());
        preparedStatement.setString(7, booking.getComment());

        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        while (generatedKeys.next()) {
            booking.setId(generatedKeys.getLong("id"));
        }
        return booking;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public boolean deleteBooking(Long id) {
        try (Connection connection = RentCarsConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKING_SQL)) {
        preparedStatement.setLong(1, id);
        return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public static BookingDao getInstance() {
        return INSTANCE;
    }
}
