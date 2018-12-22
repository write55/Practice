
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KillMe {

    public static int[] reverse(int[] x) {
        for (int i = 0; i < x.length / 2; i++) {
            x[i] = x[i] + x[x.length - 1 - i];
            x[x.length - 1 - i] = x[i] - x[x.length - 1 - i];
            x[i] = x[i] - x[x.length - 1 - i];
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 0 to exit");
        System.out.print("Enter length of array: ");
        int length = Integer.parseInt(in.readLine());
        while (length != 0) {
            int[] X = new int[length];
            for (int i = 0; i < length; i++) {
                X[i] = i + 1;
            }
            System.out.println("Original Array: \n" + Arrays.toString(X));
            reverse(X);
            System.out.println("New Array: \n" + Arrays.toString(X));
            System.out.print("Enter another: ");
            length = Integer.parseInt(in.readLine());
        }
    }

}