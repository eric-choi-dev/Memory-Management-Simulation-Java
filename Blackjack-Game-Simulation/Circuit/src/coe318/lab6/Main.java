package coe318.lab6;

public class Main {
    public static void main(String[] args) {
        // Create Nodes
        Node n0 = new Node();
        Node n1 = new Node();
        Node n2 = new Node();

        // Create Resistors
        Resister r1 = new Resister(100.0, n0, n1);
        Resister r2 = new Resister(200.0, n1, n2);
        Resister r3 = new Resister(300.0, n0, n2);

        // Get the Circuit instance
        Circuit circuit = Circuit.getInstance();

        // Display the Circuit
        System.out.println(circuit.toString());
    }
}