package ie.atu.week5.week5.service;


import ie.atu.week5.week5.model.Passenger;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class PassengerServiceTest {
    private PassengerService service;

    @BeforeEach
    public void setUp() { service = new PassengerService(); }

    @Test
    void createThenFindById() {
        Passenger p = Passenger.builder()
                .passengerId("P1")
                .name("Sean")
                .email("sean@atu.ie")
                .build();

        service.create(p);

        Optional<Passenger> found = service.findById("P1");
        assertTrue(found.isPresent());
        assertEquals("Sean", found.get().getName());
    }

    @Test
    void duplicateIdThrows() {
        service.create(Passenger.builder()
                .passengerId("P2")
                .name("bob")
                .email("b@atu.ie")
                .build());

        assertThrows(IllegalArgumentException.class, () ->
                service.create(Passenger.builder()
                        .passengerId("P2")
                        .name("Bobby")
                        .email("bob@ex.com")
                        .build()));
    }
    @Test
    void updateSuccess(){
        Passenger p = Passenger.builder()
                        .passengerId("123")
                        .name("John")
                        .email("john@atu.ie")
                .build();

        service.create(p);

        Passenger updated = Passenger.builder()
                .passengerId("145")
                .name("Paul")
                .email("lima@ex.com")
                .build();

        service.update(updated);
    }
    @Test
    void deleteSuccess(){
        Passenger p = Passenger.builder()
                .passengerId("123")
                .name("John")
                .email("john@atu.ie")
                .build();

        service.create(p);
        service.delete("123");
    }
    @Test
    void updateFail(){
        Passenger nobody = Passenger.builder()
                .passengerId("13")
                .name("Nobody")
                .email("nobody@atu.ie")
                .build();

        assertThrows(IllegalArgumentException.class, () -> service.update(nobody));

    }
    @Test
    void deleteFail(){
        service.delete("123");
        assertFalse(service.findById("123").isPresent());
    }

    }
