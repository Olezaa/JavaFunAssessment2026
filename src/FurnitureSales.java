
import java.util.Scanner;

public class FurnitureSales {

    String[] arPersons = new String[4];
    double[][] arSales = new double[4][4];

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        FurnitureSales sales = new FurnitureSales();
        sales.initialize();

        String continueChoice;

        do {
            System.out.println("\nPlease select a menu item below:");
            System.out.println("1 - See All Salespeople");
            System.out.println("2 - Find Salesperson");
            System.out.println("3 - Total Monthly Sales");
            System.out.println("4 - Monthly Salary");
            System.out.println("5 - Best Salesperson");
            System.out.println("6 - Monthly Turnover");
            System.out.println("7 - Total Salary Expenditure");

            System.out.print("Your Option: ");

            int choice = sales.sc.nextInt();
            sales.sc.nextLine();

            switch (choice) {
                case 1:
                    sales.display();
                    break;

                case 2:
                    System.out.print("Search for salesperson: ");
                    String name = sales.sc.nextLine();

                    int position = sales.findSalesPerson(name);

                    if (position == -1) {
                        System.out.println("Salesperson not found.");
                    } else {
                        System.out.println(sales.arPersons[position]
                                + " is found at " + (position + 1));
                    }
                    break;

                case 3:
                    sales.calcTotalMonthlySales();
                    break;

                case 4:
                    sales.calcMonthlySalary();
                    break;

                case 5:
                    sales.getBestSalesPerson();
                    break;

                case 6:
                    System.out.println("Monthly Turnover "
                            + sales.calcMonthlyTurnOver());
                    break;

                case 7:
                    System.out.println("Salary Expenditure "
                            + sales.calcSalaryExpenditure());
                    break;

                default:
                    System.out.println("Invalid menu option.");
            }

            System.out.print("Do you want to continue? (Y/N) ");
            continueChoice = sales.sc.nextLine();

        } while (continueChoice.equalsIgnoreCase("Y"));

        System.out.println("Program ended.");
        sales.sc.close();
    }

    public void initialize() {
        arPersons[0] = "Ole";
        arPersons[1] = "Tk";
        arPersons[2] = "Ntombi";
        arPersons[3] = "Sihle";

        arSales[0][0] = 18500;
        arSales[0][1] = 9000;
        arSales[0][2] = 2000;
        arSales[0][3] = 27900;

        arSales[1][0] = 16200;
        arSales[1][1] = 5000;
        arSales[1][2] = 7600;
        arSales[1][3] = 36590;

        arSales[2][0] = 6000;
        arSales[2][1] = 2900;
        arSales[2][2] = 16870;
        arSales[2][3] = 19000;

        arSales[3][0] = 21500;
        arSales[3][1] = 12900;
        arSales[3][2] = 18800;
        arSales[3][3] = 46500;
    }

    public int findSalesPerson(String name) {
        for (int i = 0; i < arPersons.length; i++) {
            if (arPersons[i].equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }

    public double calcTotalMonthlySales() {
        System.out.print("Search for salesperson: ");
        String name = sc.nextLine();

        int position = findSalesPerson(name);

        if (position == -1) {
            System.out.println("Salesperson not found.");
            return 0;
        }

        double total = 0;

        for (int i = 0; i < arSales[position].length; i++) {
            total += arSales[position][i];
        }

        System.out.println("Total Sales for "
                + arPersons[position] + ": " + total);

        return total;
    }

    public double calcMonthlySalary() {
        System.out.print("Search for salesperson: ");
        String name = sc.nextLine();

        int position = findSalesPerson(name);

        if (position == -1) {
            System.out.println("Salesperson not found.");
            return 0;
        }

        double totalSales = 0;

        for (int i = 0; i < arSales[position].length; i++) {
            totalSales += arSales[position][i];
        }

        double commission = totalSales * 0.10;
        double salary = 7500 + commission;

        System.out.println("Monthly Salary for "
                + arPersons[position] + ": " + salary);

        return salary;
    }

    public double calcMonthlyTurnOver() {
        double turnover = 0;

        for (int i = 0; i < arPersons.length; i++) {
            for (int j = 0; j < arSales[i].length; j++) {
                turnover += arSales[i][j];
            }
        }

        return turnover;
    }

    public double calcSalaryExpenditure() {
        double totalSalaries = 0;

        for (int i = 0; i < arPersons.length; i++) {
            double monthlySales = 0;

            for (int j = 0; j < arSales[i].length; j++) {
                monthlySales += arSales[i][j];
            }

            double commission = monthlySales * 0.10;
            double salary = 7500 + commission;

            totalSalaries += salary;
        }

        return totalSalaries;
    }

    public void getBestSalesPerson() {
        double highestSales = 0;
        int bestPosition = 0;

        for (int i = 0; i < arPersons.length; i++) {
            double monthlySales = 0;

            for (int j = 0; j < arSales[i].length; j++) {
                monthlySales += arSales[i][j];
            }

            if (monthlySales > highestSales) {
                highestSales = monthlySales;
                bestPosition = i;
            }
        }

        System.out.println("Best Salesperson");
        System.out.println(arPersons[bestPosition]
                + "     " + highestSales);
    }

    public void display() {
        System.out.printf("%-12s %12s %12s %12s %12s %14s%n",
                "Name", "Week 1", "Week 2",
                "Week 3", "Week 4", "Total Sales");

        System.out.println(
                "--------------------------------------------------------------------------");

        for (int i = 0; i < arPersons.length; i++) {
            double monthlySales = 0;

            System.out.printf("%-12s", arPersons[i]);

            for (int j = 0; j < arSales[i].length; j++) {
                System.out.printf(" %12.1f", arSales[i][j]);
                monthlySales += arSales[i][j];
            }

            System.out.printf(" %14.1f%n", monthlySales);
        }
    }
}
