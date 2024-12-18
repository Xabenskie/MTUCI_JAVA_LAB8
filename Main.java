public class Main {
	public static void main(String[] args) {
			DataManager dataManager = new DataManager();
			
			// Регистрируем обработчики
			dataManager.registerDataProcessor(new DataFilter());
			dataManager.registerDataProcessor(new DataTransformer());
			
			// Загружаем данные
			dataManager.loadData("source.txt");
			
			// Обрабатываем данные
			dataManager.processData();
			
			// Сохраняем данные
			dataManager.saveData("destination.txt");
	}
}
