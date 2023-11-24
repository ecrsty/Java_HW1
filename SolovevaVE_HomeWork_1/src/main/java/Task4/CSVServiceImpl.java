package Task4;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVServiceImpl implements CSVService {
    private Division findOrCreateDivision(Map<String, Division> divisions, String divName) {
        // если словарь не пустой и содержит название искомого отдела
        if (divisions != null && divisions.containsKey(divName)) {
            return divisions.get(divName); // возвращаем искомый отдел по переданному имени
        }
        // иначе создаем новый отдел, вносим его в словарь и возвращаем в качестве результата
        else {
            Division division = new Division(divName);
            divisions.putIfAbsent(divName, division);
            return division;
        }
    }

    // "emplDB/empls.csv"
    @Override
    public List<Division> Import(String path) {
        // словарь для отслеживания имеющихся отделов
        Map<String, Division> divisions = new HashMap<>();
        // чтение данных из файла
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] dataLine;
            while ((dataLine = reader.readNext()) != null){
                String name = dataLine[0];
                Integer salary = Integer.parseInt(dataLine[1]);
                String divName = dataLine[2];
                PositionType position = PositionType.valueOf(dataLine[3]);

                // ищем отдел в словаре имеющихся, если такого нет, то добавляем новый
                Division division = findOrCreateDivision(divisions, divName);
                // создаем работника и добавляем его в соответствующий отдел
                Employer employer = new Employer(name, salary, division, position);
                division.addEmployer(employer);
                // обновляем в словаре данные
                divisions.put(divName, division);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return divisions.values().stream().toList();
    }

    @Override
    public void Export(List<Division> divisions, String path) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            // перебираем все отделы
            for (Division division : divisions) {
                // извлекаем список сотрудников
                List<Employer> employers = division.getEmployerList();
                // записываем данные о каждом сотруднике
                for (Employer employer : employers) {
                    String[] data = {
                        employer.getName(),
                        String.valueOf(employer.getSalary()),
                        employer.getDivision().toString(),
                        employer.getPosition().toString()
                    };
                    writer.writeNext(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
