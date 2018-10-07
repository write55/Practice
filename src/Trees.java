import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trees {

    // PRIVATE DATA
    private int treesRemoved = 0;
    private int hoursTaken = 0;
    private int stumpsGround = 0;

    // CONSTANTS
    public final static int TREE_COST = 500;
    public final static int TRIM_COST = 80;
    public final static int STUMP_COST = 25;
    public final static int DISCOUNT = 1000;
    public final static double DISCOUNT_PERCENT = .1;

    // CONSTRUCTOR
    public Trees(int tr, int ht, int sg) {
        treesRemoved = tr;
        hoursTaken = ht;
        stumpsGround = sg;
    }

    // GETTERS
    public int getTreesRemoved() {
        return treesRemoved;
    }

    public int getHoursTaken() {
        return hoursTaken;
    }

    public int getStumpsGround() {
        return stumpsGround;
    }

    // SETTERS
    public void setTreesRemoved(int tr) {
        this.treesRemoved = tr;
    }

    public void setHoursTaken(int hoursTaken) {
        this.hoursTaken = hoursTaken;
    }

    public void setStumpsGround(int sg) {
        this.stumpsGround = sg;
    }

    // GET INPUT
    public void getInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input number of trees removed: ");
        this.setTreesRemoved(new Integer(in.readLine()));
        System.out.print("Input number of hours for trimming: ");
        this.setHoursTaken(new Integer(in.readLine()));
        System.out.print("Input number of stumps ground: ");
        this.setStumpsGround(new Integer(in.readLine()));
    }

    // CALCULATE COST
    public double calculateCost() {
        double cost = 0;
        cost += TREE_COST * this.getTreesRemoved() + TRIM_COST * this.getHoursTaken() + STUMP_COST * this.getStumpsGround();
        if (cost > DISCOUNT) {
            cost *= 1 - DISCOUNT_PERCENT;
        }
        return cost;
    }

    // TOSTRING METHOD
    public String toString() {
        return "Number of trees removed: " + getTreesRemoved() + "\n" +
                "Number of hours taken for trimming: " + getHoursTaken() + "\n" +
                "Number of stumps ground: " + getStumpsGround();
    }

    public static void main(String[] args) throws IOException {
        Trees current = new Trees(0, 0, 0);
        current.getInput();
        current.toString();
        System.out.println("Your total cost is " + current.calculateCost());
    }
}
