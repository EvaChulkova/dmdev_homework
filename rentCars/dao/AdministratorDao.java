package rentCars.dao;

import rentCars.dto.AdministratorFilter;
import rentCars.entity.Administrator;
import rentCars.exception.RentCarsDaoException;
import rentCars.util.RentCarsConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdministratorDao {
    public static final AdministratorDao INSTANCE = new AdministratorDao();

    public static final String DELETE_FROM_ADMINISTRATOR_SQL = """
            DELETE FROM administrator
            WHERE id = ?
            """;

    public static final String ADD_ADMIN_SQL = """
            INSERT INTO administrator(fio, login, password, role_id) 
            VALUES (?, ?, ?, ?) 
            """;

    public static final String UPDATE_ADMIN_SQL = """
            UPDATE administrator
            SET fio = ?,
            login = ?,
            password = ?, 
            role_id = ?
            WHERE id = ?
            """;

    public static final String FIND_ALL_ADMINS_SQL = """
            SELECT id,
            fio,
            login,
            password,
            role_id
            FROM administrator
            """;

    public static final String FIND_ADMIN_BY_ID = FIND_ALL_ADMINS_SQL + """
            WHERE id = ?
            """;

    private AdministratorDao() {}

    public void updateAdmin(Administrator administrator) {
        try (Connection connection = RentCarsConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADMIN_SQL)) {
            preparedStatement.setString(1, administrator.getFio());
            preparedStatement.setString(2, administrator.getLogin());
            preparedStatement.setString(3, administrator.getPassword());
            preparedStatement.setInt(4, administrator.getRoleId());
            preparedStatement.setLong(5, administrator.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public List<Administrator> findAdminWithFilters(AdministratorFilter administratorFilter) {
        List<Object> parameters = new ArrayList<>();
        List<String> whereSQL = new ArrayList<>();

        if(administratorFilter.fio() != null) {
            whereSQL.add("fio LIKE ? ");
            parameters.add("%" + administratorFilter.fio() + "%");
        }
        if (administratorFilter.login() != null) {
            whereSQL.add("login LIKE ? ");
            parameters.add("%" + administratorFilter.login() + "%");
        }
        parameters.add(administratorFilter.limit());
        parameters.add(administratorFilter.offset());

        String where = whereSQL.stream()
                .collect(Collectors.joining(" AND ", " WHERE ", " LIMIT ? OFFSET ?"));


        String sql = FIND_ALL_ADMINS_SQL + where;
        try (Connection connection = RentCarsConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Administrator> admins = new ArrayList<>();
            while (resultSet.next()) {
                admins.add(buildAdmin(resultSet));
            }
            return admins;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public Optional<Administrator> findById(Long id) {
        try (Connection connection = RentCarsConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ADMIN_BY_ID)) {
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        Administrator administrator = null;
        if (resultSet.next()) {
            //buildAdmin(resultSet)
            administrator = new Administrator(
                    resultSet.getLong("id"),
                    resultSet.getString("fio"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getInt("role_id")
            );
        }
        return Optional.ofNullable(administrator);
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public List<Administrator> findAllAdmins() {
        try (Connection connection = RentCarsConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_ADMINS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Administrator> admins = new ArrayList<>();
            while (resultSet.next()) {
                admins.add(buildAdmin(resultSet));
            }
            return admins;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    private Administrator buildAdmin(ResultSet resultSet) throws SQLException {
        return new Administrator(
                resultSet.getLong("id"),
                resultSet.getString("fio"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getInt("role_id")
        );
    }


    public Administrator addAdmin(Administrator administrator) {
        try (var connection = RentCarsConnectionManager.get();
        var preparedStatement = connection.prepareStatement(ADD_ADMIN_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, administrator.getFio());
            preparedStatement.setString(2, administrator.getLogin());
            preparedStatement.setString(3, administrator.getPassword());
            preparedStatement.setInt(4, administrator.getRoleId());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                administrator.setId(generatedKeys.getLong("id"));
            }
            return administrator;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public boolean deleteAdmin(Long id) {
        try (var connection = RentCarsConnectionManager.get();
        var preparedStatement = connection.prepareStatement(DELETE_FROM_ADMINISTRATOR_SQL)) {
        preparedStatement.setLong(1, id);
        return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new RentCarsDaoException(throwables);
        }
    }

    public static AdministratorDao getInstance() {
        return INSTANCE;
    }
}
