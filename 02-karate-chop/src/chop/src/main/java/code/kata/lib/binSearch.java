package code.kata.lib;

public class binSearch {
    // chop 函數：模擬 Ruby 的 chop 功能
    public static int chop(int target, int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }

    public static int chopRecursive(int target, int[] array, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return chopRecursive(target, array, mid + 1, high);
        } else {
            return chopRecursive(target, array, low, mid - 1);
        }
    }
}
