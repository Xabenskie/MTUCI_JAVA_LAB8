import java.util.List;
import java.util.stream.Collectors;

public class DataTransformer {
	@DataProcessor
	public List<String> transformData(List<String> data) {
			return data.stream()
							.map(String::toUpperCase) // Преобразуем строки в верхний регистр
							.collect(Collectors.toList());
	}
}