package Task4;

import java.io.File;
import java.util.*;


// отформатируй путь к файлу в методах экспорта/импорта и в мэйне
// можно пошаманить с подразделениями, сделать их как эмплоеров в списке


public class WorkModel {
    public static void main(String[] args) {
        // инициализация объекта, отвечающего за импорт/экспорт данных о сотрудниках
        CSVService csvService = new CSVServiceImpl();
        // проверка существования директории для сохранения данных
        File dir = new File("emplDB");
        if(!dir.exists()){
            dir.mkdir();
        }
        // инициализация отделов
        Division div1 = new Division("Div1");
        Division div2 = new Division("Div2");
        // инициализация сотрудников
        List<Employer> employers = Arrays.asList(
                new Employer("Vasya", 70000, div1, PositionType.WORKER),
                new Employer("Gleb", 70000, div1, PositionType.MANAGER),
                new Employer("Arina", 70000, div1, PositionType.SALER),
                new Employer("Lisa", 70000, div1, PositionType.HEAD),
                new Employer("Olga", 70000, div2, PositionType.WORKER),
                new Employer("Petya", 70000, div2, PositionType.SALER),
                new Employer("Anton", 70000, div2, PositionType.MANAGER),
                new Employer("Oleg", 70000, div2, PositionType.HEAD)
        );
        // добавление сотрудников в их отделы
        for (Employer emp : employers) {
            String divName = emp.getDivision().toString();
            if (divName == "Div1")
                    div1.addEmployer(emp);
            else
                div2.addEmployer(emp);
        }
        // добавление отделов в список и экспорт
        List<Division> divisions = new ArrayList<>();
        divisions.add(div1);
        divisions.add(div2);
        csvService.Export(divisions, "emplDB/empls.csv");


        List<Division> importedDivisions = csvService.Import("emplDB/empls.csv");
        for (Division division : importedDivisions) {
            System.out.println("-- Название отдела: "+division.toString());
            List<Employer> impEmpls = division.getEmployerList();
            int i = 1;
            System.out.println("Список работников:");
            for (Employer emp : impEmpls) {
                System.out.println(i+". "+emp.getName());
                System.out.println("Должность: "+emp.getPosition());
                System.out.println("Зарплата: "+emp.getSalary());
                System.out.println("Отдел: "+emp.getDivision());
                i++;
            }
            System.out.println();
        }
    }
}
