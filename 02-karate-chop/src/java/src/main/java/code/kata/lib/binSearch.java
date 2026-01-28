package code.kata.lib;

public class binSearch {
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

    public static int chopRecursive(int target, int[] array) {
        if(array == null || array.length == 0) {
            return -1;
        }
        if(array.length == 1) {
            return array[0] == target ? 0 : -1;
        }

        int mid = array.length / 2;
        if(array[mid] == target) {
            return mid;
        } else if(array[mid] < target) {
            int result = chopRecursive(target, java.util.Arrays.copyOfRange(array, mid + 1, array.length));
            return result == -1 ? -1 : mid + 1 + result;
        } else {
            return chopRecursive(target, java.util.Arrays.copyOfRange(array, 0, mid));
        }
        
    }
}
