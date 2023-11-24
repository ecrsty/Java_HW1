package Task3and4;

import java.util.List;
import java.util.Map;

public class Division {
    private String name;
    private Map<String, Employer> employers;
    private Employer headOfDivision;

    public Division(String name, Map<String, Employer> employers, Employer headOfDivision) {
        this.name = name;
        this.employers = employers;
        this.headOfDivision = headOfDivision;
    }

    public void addEmployer(Employer employer) {
        this.employers.put(employer.getName(), employer);
    }

    public List<Employer> getEmployerList() {
        return this.employers.values().stream().toList();
    }
}
