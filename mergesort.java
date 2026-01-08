import java.util.ArrayList;
import java.util.Arrays;

public class mergesort {

    static void mergesort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;

        mergesort(arr, l, mid);        // left half
        mergesort(arr, mid + 1, r);    // right half

        merge(arr, l, mid, r);         // merge both halves
    }

    static void merge(int[] arr, int l, int mid, int r) {
        ArrayList<Integer> temp = new ArrayList<>();

        int i = l;
        int j = mid + 1;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }

        // remaining elements of left half
        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        // remaining elements of right half
        while (j <= r) {
            temp.add(arr[j]);
            j++;
        }

        // copy back to original array
        for (int k = 0; k < temp.size(); k++) {
            arr[l + k] = temp.get(k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 3, 2};

        mergesort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
