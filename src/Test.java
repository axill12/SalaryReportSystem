import java.time.LocalDate;

public class Test {

    public static void main (String [] args) {
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.recordList.add(new Record ("A17", true, LocalDate.of(2017, 5, 22), 7.5f, (short) 22, (short) 0));
        reportGenerator.recordList.add(new Record ("A17", true, LocalDate.of(2017, 5, 26), 8f, (short) 22, (short) 0));
        reportGenerator.recordList.add(new Record ("A189", true, LocalDate.of(2017, 5, 22), 6.2f, (short) 30, (short) 5));
        reportGenerator.recordList.add(new Record ("A63", true, LocalDate.of(2017, 5, 23), 9.5f, (short) 17, (short) 0));
        reportGenerator.recordList.add(new Record ("A63", true, LocalDate.of(2017, 7, 14), 7.4f, (short) 17, (short) 0));
        reportGenerator.recordList.add(new Record ("A239", false, LocalDate.of(2017, 5, 21), 8.4f, (short) 19, (short) 10));
        reportGenerator.recordList.add(new Record ("A712", false, LocalDate.of(2017, 5, 21), 6.9f, (short) 23, (short) 15));
        reportGenerator.recordList.add(new Record ("A712", false, LocalDate.of(2017, 5, 21), 7.9f, (short) 23, (short) 15));
        reportGenerator.recordList.add(new Record ("A472", false, LocalDate.of(2017, 5, 22), 7.2f, (short) 18, (short) 20));
        reportGenerator.recordList.add(new Record ("A472", false, LocalDate.of(2017, 5, 22), 9f, (short) 18, (short) 20));
        reportGenerator.recordList.add(new Record ("A472", false, LocalDate.of(2017, 5, 28), 10f, (short) 18, (short) 20));

        reportGenerator.totalCostPerDay(LocalDate.of(2017, 5, 22), true);
        reportGenerator.totalCostPerDay(LocalDate.of(2017, 5, 21), false);
        reportGenerator.rankingReport(true, LocalDate.of(2017, 5, 26), LocalDate.of(2017, 5, 22), LocalDate.of(2017, 5, 23));
        reportGenerator.rankingReport(false, LocalDate.of(2017, 5, 22), LocalDate.of(2017, 5, 21));
    }

}