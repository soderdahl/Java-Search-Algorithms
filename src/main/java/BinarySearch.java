public class BinarySearch {

    public static void main(String[] args) {
    int[] input = {-9, -5, -4, 1, 2, 3, 4, 5, 6, 10, 12, 25, 35, 100, 150};
        //System.out.println( binarySearch(input, 220));

        System.out.println(recursiveBinarySearch(input, -20));


}

    public static int binarySearch(int[] input, int value){
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end)/2;
            System.out.println("Midpoint: " + midpoint+ "; Value: " + input[midpoint]);
            if (input[midpoint] == value) {
                return midpoint;
            } else if (input[midpoint] > value) {
                end = midpoint;
            } else
                start = midpoint +1;
        }

        return -1;
    }

    public static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    private static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        if (start >= end) {
            System.out.println("The value is not fund");
            return -1;
        }

        int midpoint = (start + end) / 2;
        System.out.println("Midpoint: " + midpoint+ "; Value: " + input[midpoint]);
        if (input[midpoint] == value) {
            return midpoint;
        }
        else if (input[midpoint] < value) {
            return recursiveBinarySearch(input, midpoint-1, end, value);
        }
        else {
            return recursiveBinarySearch(input, start, midpoint, value);
        }
    }
}
