/*
PROB: ride
LANG: JAVA
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class ride {

    public static int getProduct(String name) {
        int product = 1;
        for (int i = 0; i < name.length(); i++) {
            product *= ((name.charAt(i) - 'A') + 1);
        }
        return product;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("ride.in"));
        PrintWriter out = new PrintWriter(new File("ride.out"));
        if (getProduct(in.nextLine()) % 47 == getProduct(in.nextLine()) % 47)
            out.println("GO");
        else
            out.println("STAY");
        out.close();
    }

}