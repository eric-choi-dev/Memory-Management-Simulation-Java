package coe318.lab6;

public class Node {
    private static int nextId = 0; // Static variable to keep track of the next ID
    private final int id; // Unique identifier for each Node

    /**
     * Constructor for Node.
     * Assigns a unique ID to each new Node.
     */
    public Node() {
        this.id = nextId++;
    }

    /**
     * Returns the unique ID of the Node as a string.
     *
     * @return String representation of the Node's ID.
     */
    @Override
    public String toString() {
        return Integer.toString(id);
    }

    /**
     * Getter for the Node's ID.
     *
     * @return The unique identifier of the Node.
     */
    public int getId() {
        return id;
    }
}