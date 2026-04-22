class Client {
    String name;
    int riskScore;
    double balance;

    Client(String n, int r, double b) {
        name = n;
        riskScore = r;
        balance = b;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class Problem2 {

    // Bubble Sort ASC
    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort DESC
    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].riskScore < key.riskScore) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void topClients(Client[] arr, int k) {
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Client[] arr = {
            new Client("A", 20, 1000),
            new Client("B", 50, 2000),
            new Client("C", 80, 1500)
        };

        bubbleSort(arr);
        insertionSort(arr);

        System.out.println("Top Clients:");
        topClients(arr, 3);
    }
}
