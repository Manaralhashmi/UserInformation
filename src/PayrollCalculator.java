public class PayrollCalculator {

    // Method to calculate weekly pay
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        double pay = 0;

        switch (employeeType) {
            case "FULL_TIME":
                if (hoursWorked > 40) {
                    double overtime = hoursWorked - 40;
                    pay = (40 * hourlyRate) + (overtime * hourlyRate * 1.5);
                } else {
                    pay = hoursWorked * hourlyRate;
                }
                break;

            case "PART_TIME":
                if (hoursWorked <= 25) {
                    pay = hoursWorked * hourlyRate;
                } else {
                    System.out.println("Part-time employees can work up to 25 hours only.");
                }
                break;

            case "CONTRACTOR":
                pay = hoursWorked * hourlyRate;
                break;

            case "INTERN":
                if (hoursWorked <= 20) {
                    double discountedRate = hourlyRate * 0.8;
                    pay = hoursWorked * discountedRate;
                } else {
                    System.out.println("Interns can work up to 20 hours only.");
                }
                break;

            default:
                System.out.println("Invalid employee type!");
                break;
        }

        return pay;
    }

    // to calculate tax
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax;

        if (grossPay <= 500) {
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            tax = grossPay * 0.20;
        } else {
            tax = grossPay * 0.25;
        }

        if (hasHealthInsurance) {
            tax -= 50;
            if (tax < 0) tax = 0;
        }

        return tax;
    }

    // Process all employees
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        if (employeeTypes.length != hours.length || hours.length != rates.length || rates.length != names.length) {
            System.out.println("Input arrays are not the same length.");
            return;
        }

        double totalPay = 0;
        double highestPay = 0;
        double lowestPay = Double.MAX_VALUE;
        String highestName = "";
        String lowestName = "";
        int overtimeCount = 0;

        System.out.println("\n--- Payroll Report ---");
        for (int i = 0; i < names.length; i++) {
            double pay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(pay, true);
            double netPay = pay - tax;

            totalPay += netPay;

            if (pay > highestPay) {
                highestPay = pay;
                highestName = names[i];
            }

            if (pay < lowestPay) {
                lowestPay = pay;
                lowestName = names[i];
            }

            if (hours[i] > 40) {
                overtimeCount++;
            }

            System.out.println(names[i] + " | Type: " + employeeTypes[i] +
                    " | Hours: " + hours[i] +
                    " | Gross Pay: $" + String.format("%.2f", pay) +
                    " | Tax: $" + String.format("%.2f", tax) +
                    " | Net Pay: $" + String.format("%.2f", netPay));
        }

        double averagePay = totalPay / names.length;

        System.out.println("\nSummary:");
        System.out.println("Highest paid: " + highestName + " ($" + highestPay + ")");
        System.out.println("Lowest paid: " + lowestName + " ($" + lowestPay + ")");
        System.out.println("Average net pay: $" + String.format("%.2f", averagePay));
        System.out.println("Employees with overtime: " + overtimeCount);
    }

    // Main method
    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        // Process all employees
        processPayroll(types, hours, rates, names);
    }
}
