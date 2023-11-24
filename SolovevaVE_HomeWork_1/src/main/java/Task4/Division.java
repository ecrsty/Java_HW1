package Task4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Division {
    private String name;
    private Map<String, Employer> employers = new HashMap<>();
    private Employer headOfDivision;

    public Division(String name) {
        this.name = name;
    }

    public void addEmployer(Employer employer) {
        this.employers.put(employer.getName(), employer);
        if (employer.getPosition() == PositionType.HEAD)
            this.headOfDivision = employer;
    }

    public List<Employer> getEmployerList() {
        return this.employers.values().stream().toList();
    }

    public Employer getHeadOfDivision() {
        return headOfDivision;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
