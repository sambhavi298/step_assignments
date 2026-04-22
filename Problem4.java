class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String n, double r, double v) {
        name = n;
        returnRate = r;
        volatility = v;
    }
}

public class Problem4 {

    static void mergeSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(Asset[] arr, int l, int m, int r) {
        Asset[] temp = new Asset[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            temp[k++] = (arr[i].returnRate <= arr[j].returnRate) ? arr[i++] : arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, l, temp.length);
    }

    public static void main(String[] args) {
        Asset[] arr = {
            new Asset("AAPL", 12, 5),
            new Asset("TSLA", 8, 7),
            new Asset("GOOG", 15, 4)
        };

        mergeSort(arr, 0, arr.length - 1);

        for (Asset a : arr) {
            System.out.println(a.name + ":" + a.returnRate);
        }
    }
}
