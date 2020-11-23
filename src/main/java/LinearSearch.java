public class LinearSearch {

    public static void main(String[] args) {
        int[] intArray = {23, 66, 33, -9, -5, 10, 88, 99};

        System.out.println(linearSearch(intArray, 99));
    }

    public static int linearSearch(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                System.out.println("Index: " + i);
                return i;
            }
        }
        System.out.println("The number is not found!");

        return -1;
    }
}
