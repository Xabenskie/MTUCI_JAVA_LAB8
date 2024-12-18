import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data;

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        // Здесь можно загрузить данные из файла, базы данных и т.д.
        // Для примера, просто создадим список строк
        data = List.of("apple", "banana", "cherry", "date", "fig", "grape");
    }

    public void processData() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (Object processor : processors) {
            executor.submit(() -> {
                for (var method : processor.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(DataProcessor.class)) {
                        try {
                            data = (List<String>) method.invoke(processor, data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Ждем завершения всех потоков
        }
    }

    public void saveData(String destination) {
        // Здесь можно сохранить данные в файл, базу данных и т.д.
        // Для примера, просто выведем данные на экран
        System.out.println("Сохраненные данные: " + data);
    }
}
