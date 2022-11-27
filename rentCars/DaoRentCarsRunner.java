package rentCars;

import rentCars.dao.AdministratorDao;
import rentCars.dao.BookingDao;
import rentCars.dao.CarDao;
import rentCars.dao.ClientDao;
import rentCars.dto.AdministratorFilter;
import rentCars.dto.BookingFilter;
import rentCars.dto.CarFilter;
import rentCars.dto.ClientFilter;
import rentCars.entity.Administrator;
import rentCars.entity.Booking;
import rentCars.entity.Car;
import rentCars.entity.Client;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class DaoRentCarsRunner {
    public static void main(String[] args) {
        //addCar();
        //deleteCar();
        //updateCar();
        //findAllCars();
        //findCarWithFilter();

        //addAdmin();
        //deleteAdmin();
        //updateAdmin();
        //findAllAdmins();
        //findAdminWithFilters();

        /*//check later
        //addClient();*/
        //deleteClient();
        //findAllClients();
        //updateClient();
        //findClientWithFilters();

        /*//check later
        //addBooking();*/
        //deleteBooking();
        //findAllBookings();
        //updateBooking();
        //findBookingWithFilters();

    }

    private static void findBookingWithFilters() {
        BookingFilter bookingFilter = new BookingFilter(5, 0, null, null, 3, null);
        List<Booking> bookingWithFilters = BookingDao.getInstance().findBookingWithFilters(bookingFilter);
        System.out.println(bookingWithFilters);
    }

    private static void updateBooking() {
        BookingDao bookingDao = BookingDao.getInstance();
        Optional<Booking> maybeBooking = bookingDao.findBookingById(3L);
        System.out.println(maybeBooking);

        maybeBooking.ifPresent(booking -> {
            booking.setCarId(13);
            bookingDao.updateBooking(booking);
        });
    }

    private static void findAllBookings() {
        List<Booking> allBookings = BookingDao.getInstance().findAllBookings();
        System.out.println(allBookings);
    }

    private static void deleteBooking() {
        BookingDao bookingDao = BookingDao.getInstance();
        boolean deleteBooking = bookingDao.deleteBooking(7L);
        System.out.println(deleteBooking);
    }

    /*private static void addBooking() {
        BookingDao bookingDao = BookingDao.getInstance();
        Booking booking = new Booking();
        booking.setClientId(7);
        booking.setCarId(7);
        booking.setRentalStart(2022-11-23T19:46);
        booking.setRentalFinish(2022-12-21T19:46);
        booking.setAdministratorId(2);
        booking.setStatus("Одобрено");
        booking.setComment("Замечаний нет");

        Booking addBooking = bookingDao.addBooking(booking);
        System.out.println(addBooking);
    }*/


    private static void findClientWithFilters() {
        ClientFilter clientFilter = new ClientFilter(5, 0, null, 97888, null);
        List<Client> clientWithFilters = ClientDao.getInstance().findClientWithFilters(clientFilter);
        System.out.println(clientWithFilters);
    }

    private static void updateClient() {
        ClientDao clientDao = ClientDao.getInstance();
        Optional<Client> maybeClient = clientDao.findClientById(3L);
        System.out.println(maybeClient);

        maybeClient.ifPresent(client -> {
            client.setAge(25);
            clientDao.updateClient(client);
        });
    }

    private static void findAllClients() {
        List<Client> allClients = ClientDao.getInstance().findAllClients();
        System.out.println(allClients);
    }

    private static void deleteClient() {
        ClientDao clientDao = ClientDao.getInstance();
        boolean deleteClient = clientDao.deleteClient(8L);
        System.out.println(deleteClient);
    }

    /*private static void addClient() {
        ClientDao clientDao = ClientDao.getInstance();
        Client client = new Client();
        client.setFio("Шехова Нина");
        client.setAge(37);
        client.setLicenceNo(78331);
        client.setValidity();
        client.setLogin("nina@yandex.ru");
        client.setPassword("5553331");
        client.setRoleId(2);

        Client addedClient = clientDao.addClient(client);
        System.out.println(addedClient);
    }*/


    private static void findAdminWithFilters() {
        AdministratorFilter administratorFilter = new AdministratorFilter(10, 0, "Денисова", null);
        List<Administrator> adminWithFilters = AdministratorDao.getInstance().findAdminWithFilters(administratorFilter);
        System.out.println(adminWithFilters);
    }

    private static void updateAdmin() {
        AdministratorDao administratorDao = AdministratorDao.getInstance();
        Optional<Administrator> maybeAdmin = administratorDao.findById(2L);
        System.out.println(maybeAdmin);

        maybeAdmin.ifPresent(administrator -> {
            administrator.setPassword("newPassword");
            administratorDao.updateAdmin(administrator);
        });
    }

    private static void findAllAdmins() {
        List<Administrator> allAdmins = AdministratorDao.getInstance().findAllAdmins();
        System.out.println(allAdmins);
    }

    private static void deleteAdmin() {
        AdministratorDao administratorDao = AdministratorDao.getInstance();
        boolean deleteAdmin = administratorDao.deleteAdmin(4L);
        System.out.println(deleteAdmin);
    }

    private static void addAdmin() {
        AdministratorDao administratorDao = AdministratorDao.getInstance();
        Administrator administrator = new Administrator();
        administrator.setFio("Петров Валерий");
        administrator.setLogin("val@yandex.ru");
        administrator.setPassword("98765");
        administrator.setRoleId(1);

        Administrator addAdmin = administratorDao.addAdmin(administrator);
        System.out.println(addAdmin);
    }


    private static void findCarWithFilter() {
        var carFilter = new CarFilter(10,0,null, "Red", null, null, null);
        var cars = CarDao.getInstance().findAllCarWithFilters(carFilter);
        System.out.println(cars);
    }

    private static void findAllCars() {
        var cars = CarDao.getInstance().findAllCars();
        System.out.println(cars);
    }

    private static void updateCar() {
        var carDao = CarDao.getInstance();
        var maybeCar = carDao.findById(10L);
        System.out.println(maybeCar);

        maybeCar.ifPresent(car -> {
            car.setStatus("Забронирована");
            carDao.updateCar(car);
        });
    }

    private static void deleteCar() {
        var carDao = CarDao.getInstance();
        var deleteCar = carDao.deleteCar(3L);
        System.out.println(deleteCar);
    }

    private static void addCar() {
        var carDao = CarDao.getInstance();
        var car = new Car();
        car.setBrand("Audi Q3");
        car.setColor("Red");
        car.setSeatAmount(5);
        car.setPrice(BigDecimal.valueOf(8150));
        car.setStatus("Доступна");

        var addedCar = carDao.addCar(car);
        System.out.println(addedCar);
    }
}
