package coe318.lab6;

public class Resister {
    private static int nextId = 1; // Static variable to keep track of the next Resistor ID
    private final int id; // Unique identifier for each Resistor
    private final double resistance; // Resistance value in Ohms
    private final Node node1; // First connected Node
    private final Node node2; // Second connected Node

    /**
     * Constructor for Resistor.
     *
     * @param resistance The resistance in Ohms (must be positive).
     * @param node1      The first Node connected to the Resistor (must not be null).
     * @param node2      The second Node connected to the Resistor (must not be null).
     * @throws IllegalArgumentException if resistance is not positive or any node is null.
     */
    public Resister(double resistance, Node node1, Node node2) {
        if (resistance <= 0) {
            throw new IllegalArgumentException("Resistance must be positive.");
        }
        if (node1 == null || node2 == null) {
            throw new IllegalArgumentException("Nodes cannot be null.");
        }
        this.resistance = resistance;
        this.node1 = node1;
        this.node2 = node2;
        this.id = nextId++;
        
        // Add this resistor to the Circuit
        Circuit.getInstance().add(this);
    }

    /**
     * Returns an array of the two Nodes connected by the Resistor.
     *
     * @return Array containing node1 and node2.
     */
    public Node[] getNodes() {
        return new Node[]{node1, node2};
    }

    /**
     * Returns the string representation of the Resistor in the format:
     * R{id} {node1} {node2} {resistance}
     *
     * @return String representation of the Resistor.
     */
    @Override
    public String toString() {
        return String.format("R%d %s %s %.2f", id, node1.toString(), node2.toString(), resistance);
    }

    /**
     * Getter for the Resistor's ID.
     *
     * @return The unique identifier of the Resistor.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the Resistor's resistance.
     *
     * @return The resistance value in Ohms.
     */
    public double getResistance() {
        return resistance;
    }
}