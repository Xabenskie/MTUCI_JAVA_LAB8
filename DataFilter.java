import java.util.List;
import java.util.stream.Collectors;

public class DataFilter {
    @DataProcessor
    public List<String> filterData(List<String> data) {
        return data.stream()
                .filter(s -> s.startsWith("a")) // Фильтруем строки, начинающиеся с 'a'
                .collect(Collectors.toList());
    }
}

