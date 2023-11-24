package Task4;

import java.util.List;

public interface CSVService{
    public List<Division> Import(String path);
    public void Export(List<Division> divisions, String path);
}
