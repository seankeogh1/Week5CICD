package ie.atu.week5.week5.service;
import ie.atu.week5.week5.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PassengerService {
    private final List<Passenger> store = new ArrayList<>();

    public List<Passenger> getPassengers() {
        return new ArrayList<>(store); //defensive copy
    }
    public Optional<Passenger> findById(String id) {
        for (Passenger p : store) {
            if (p.getPassengerId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Passenger create(Passenger p) {
        if (findById(p.getPassengerId()).isPresent()) {
            throw new IllegalArgumentException("Passenger already exists");
        }
        store.add(p);
        return p;
    }
    public Passenger update(Passenger p) {
        Optional<Passenger> found = findById(p.getPassengerId());
        if (found.isPresent()) {
            store.remove(found.get());
            store.add(p);
            return p;
        }
        throw new IllegalArgumentException("Passenger not found");
    }

    public Passenger delete(String id) {
        Optional<Passenger> found = findById(id);
        if (found.isPresent()) {
            store.remove(found.get());
            return found.get();
        }
        throw new IllegalArgumentException("Passenger not found");

    }
}
