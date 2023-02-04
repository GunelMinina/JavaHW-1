import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {

        ex1();
    }

    static void ex1() {
        /*
Дана json строка { { "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}}
Задача написать метод(ы), который распарсить строку
и выдаст ответ вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
Используйте StringBuilder для подготовки ответа
 */
        String s = "{[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]}";


        StringBuilder stringBuilder = new StringBuilder();
        String json = s.substring(4, s.length() - 4);
        String[] students = json.split("},");
        for (int i = 0; i < students.length ; i++) {
            String[] data = students[i].split(",");
            String[] data_name = data[0].split(":");
            String[] data_mark = data[1].split(":");
            String[] data_subj = data[2].split(":");
            String name = data_name[1].replace("\"", "");
            String mark = data_mark[1].replace("\"", "");
            String subj = data_subj[1].replace("\"", "");
            stringBuilder.append("Студент "+ name +" получил "+ mark +" по предмету "+ subj + "\n");

        }

        String filePath = "result.txt";
        writeToFile(stringBuilder.toString(), filePath);
        System.out.println(stringBuilder);
    }

    static void writeToFile(String s, String filePath){
        /*
        Создать метод, который запишет результат работы в файл
        Обработайте исключения и запишите ошибки в лог файл
         */

        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.INFO, "Все хорошо");
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write(s);
        } catch (Exception e){
            logger.log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
    }

}
