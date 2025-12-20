package coe318.lab6;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private static Circuit instance = null; // Singleton instance
    private final List<Resister> resistors; // Collection of Resistors in the Circuit

    /**
     * Private constructor to prevent instantiation.
     * Initializes the list of resistors.
     */
    private Circuit() {
        resistors = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of Circuit.
     * Creates a new instance if it does not already exist.
     *
     * @return The singleton Circuit instance.
     */
    public static Circuit getInstance() {
        if (instance == null) {
            instance = new Circuit();
        }
        return instance;
    }

    /**
     * Adds a Resistor to the Circuit.
     *
     * @param r The Resistor to add.
     * @throws IllegalArgumentException if the Resistor is null.
     */
    public void add(Resister r) {
        if (r == null) {
            throw new IllegalArgumentException("Resistor cannot be null.");
        }
        resistors.add(r);
    }

    /**
     * Returns the string representation of the Circuit.
     * Each Resistor's string representation is separated by a newline.
     *
     * @return String representation of the Circuit.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Resister r : resistors) {
            sb.append(r.toString()).append("\n");
        }
        return sb.toString().trim(); // Remove the trailing newline
    }

    /**
     * Getter for the list of Resistors.
     *
     * @return A list of Resistors in the Circuit.
     */
    public List<Resister> getResistors() {
        return new ArrayList<>(resistors); // Return a copy to preserve encapsulation
    }
}