import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double rate, int deposit) {
        double compoundPercent = amount * Math.pow((1 + rate / 12), 12 * deposit);
        return round(compoundPercent, 2);
    }

    double calculateSimplePercent(double amount, double rate, int deposit) {
        return round(amount + amount * rate * deposit, 2);
    }

    double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    void calculateDepositWithPercent() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        
        double amountWithPercent = 0;
        if (action == 1) amountWithPercent = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) amountWithPercent = calculateComplexPercent(amount, 0.06, period);

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountWithPercent);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositWithPercent();
    }
}
