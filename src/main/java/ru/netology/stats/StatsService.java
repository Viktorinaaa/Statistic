package ru.netology.stats;

public class StatsService {
    //Сумма всех продаж
    public int calculateSum(int[] purchases) {
        int sum = 0;
        for (int purchase : purchases) {
            sum += purchase;
        }
        return sum;
    }

    //Среднее арифметическое
    public int findAvg(int[] purchases){
        return calculateSum(purchases)/purchases.length;
    }
    //Номер месяца, в котором был пик продаж
    public int maxSales(int[] purchases){
        int maxMonth = 0;
        int month = 0;
        for (int purchase : purchases){
            if (purchase >= purchases[maxMonth]){
                maxMonth = month;
            }
            month += 1;
        }
        return maxMonth + 1;
    }

    //Номер месяца, в котором был минимум продаж
    public int minSales(int[] purchases) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (int purchase : purchases) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (purchase <= purchases[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }

    //Кол-во месяцев, в которых продажи были ниже среднего (см. п.2)
    public int numberMonthAvgUnder(int[] purchases){
        int numberMonth = 0;
        for (int purchase : purchases){
            if (purchase < findAvg(purchases)){
                numberMonth += 1;
            }
        }
        return numberMonth;
    }

    //Кол-во месяцев, в которых продажи были выше среднего (см. п.2)
    public int numberMonthAvgOver(int[] purchases){
        int numberMonth = 0;
        for (int purchase : purchases){
            if (purchase > findAvg(purchases)){
                numberMonth += 1;
            }
        }
        return numberMonth;
    }
}
