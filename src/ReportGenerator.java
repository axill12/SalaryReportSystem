import java.time.LocalDate;
import java.util.*;

public class ReportGenerator {

    ArrayList<Record> recordList = new ArrayList<> ();

    //It calculates the total employee cost for a specified date for in house or outsourced employees.
    public void totalCostPerDay (LocalDate date, boolean inHouse) {
        Record record;
        float totalCost = 0;
        for (int i=0; i < recordList.size(); i++) {
            record = recordList.get(i);
            if (record.isInHouse() == inHouse && record.getDate().isEqual(date)) {
                totalCost += record.costForRecord();
            }
        }
        String employeeType = inHouse ? "in house" : "outsourced";
        System.out.println("Total cost for date " + date.toString() + " for " + employeeType + " employees is " + totalCost + ".");
    }

    /** *It computes and presents the total costs of employees for the specified dates for in house or outsourced employees, depending on
     * @param inHouse, in descending order.
     */
    public void rankingReport (boolean inHouse, LocalDate ... dates) {
        HashMap<String, Float> costListPerEmployee = new HashMap<>();
        boolean hasOneOfDates = false;
        String ID;
        for (int i=0; i < recordList.size(); i++) {
            for (LocalDate date : dates) {
                if (recordList.get(i).getDate().isEqual(date)) {
                    hasOneOfDates = true;
                }
            }
            if (hasOneOfDates && recordList.get(i).isInHouse() == inHouse) {
                ID = recordList.get(i).getID();
                if (costListPerEmployee.containsKey(ID)) {
                    costListPerEmployee.put(ID, costListPerEmployee.get(ID) + recordList.get(i).costForRecord());
                } else {
                    costListPerEmployee.put(ID, recordList.get(i).costForRecord());
                }
            }
            hasOneOfDates = false;
        }

        //When it finds an employee with bigger cost than the cost of employee that contains employee with bigger cost is assigned to it.
        Map.Entry<String, Float> entryWithMaxCost = null;
        /*When it finds an employee with bigger cost than the cost of employee that contains it bigger cost is assigned to it.
        Cost of entryWithMaxCost cannot be assigned to zero. I need it to be zero to compare it with current examined entry in while.
         */
        float maxCost = 0f;
        int mapSize = costListPerEmployee.size();
        for (int i=0; i < mapSize; i++) {
            for (Map.Entry<String, Float> entry : costListPerEmployee.entrySet()) {
                if (entry.getValue() > maxCost) {
                    entryWithMaxCost = entry;
                    maxCost = entry.getValue();
                }
            }
            System.out.println("Employee with ID " + entryWithMaxCost.getKey() + " costed " + entryWithMaxCost.getValue() + " for the specified dates.");
            costListPerEmployee.remove(entryWithMaxCost.getKey());
            entryWithMaxCost.setValue(0f);
            maxCost = 0f;
        }
    }

}
