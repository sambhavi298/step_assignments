public class Problem8 {
    String[] table = new String[500];

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % 500;
    }

    void park(String plate) {
        int idx = hash(plate);

        while (table[idx] != null) {
            idx = (idx + 1) % 500;
        }
        table[idx] = plate;
        System.out.println("Parked at: " + idx);
    }
}
