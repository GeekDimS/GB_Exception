package HW3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author DimS on 19.11.2022
 */

//Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные
// пробелом:
//        Фамилия Имя Отчество датарождения номертелефона пол
//        Форматы данных:
//        фамилия,имя,отчество-строки
//        дата_рождения-строка формата dd.mm.yyyy
//        номер_телефона-целое беззнаковое число без форматирования
//        пол-символ латиницей f или m.
//        Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
//        вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных,чем
//        требуется.
//        Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.Если форматы
//        данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные
//        типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с
//        информацией, что именно неверно.
//        Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку
//        должны
//        записаться полученные данные,вида
//<Фамилия><Имя><Отчество><датарождения><номертелефона><пол>
//Однофамильцы должны записаться в один и тот же файл,в отдельные строки.
//        Не забудьте закрыть соединение с файлом.
//        При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь
//        должен увидеть стектрейс ошибки.

public class Task1 {
    public static void main(String[] args) {
        Record record = new Record();
        record.InputData();
        record.DataToFile();
    }
}

class Record{
    private String data;
    private String[] strArray;
    private final int countData = 6;

    public void InputData(){
        Scanner scanner = new Scanner(System.in);

        int res;
        do {
            System.out.println("Введите данные в следующем формате через пробел: ");
            System.out.println("""
                    Фамилия Имя Отчество датарождения номертелефона пол
                    Форматы данных:
                    фамилия,имя,отчество-строки
                    дата_рождения-строка формата dd.mm.yyyy
                    номер_телефона-целое беззнаковое число без форматирования(11 цифр)
                    пол-символ латиницей f или m:
                    """);
            this.data = scanner.nextLine();
            res = CheckQuantity();
            if(res == -1){
                System.out.println("Вы ввели меньше данных, чем нужно, либо пропустили пробелы");
            }
            if (res == -2) {
                System.out.println("Вы ввели больше данных, чем нужно");
            }

            try {
                ParseData();
            } catch (InputException e) {
                e.printStackTrace();
                res = -3;
            }
        }

        while(res < 0);
        scanner.close();
    }

    private void ParseData() throws InputException{
        if (!strArray[0].matches("[a-zA-Zа-яёА-ЯЁ]+")){
            throw new InputException("В фамилии {" + strArray[0] + "} должны быть только буквы");
        }
        if (!strArray[1].matches("[a-zA-Zа-яёА-ЯЁ]+")){
            throw new InputException("В имени {" + strArray[1] + "} должны быть только буквы");
        }
        if (!strArray[2].matches("[a-zA-Zа-яёА-ЯЁ]+")){
            throw new InputException("В отчестве {" + strArray[2] + "} должны быть только буквы");
        }
        if (!strArray[3].matches("\\d{2}\\.\\d{2}\\.\\d{4}")){
            throw new InputException("Неправильно указана дата рождения {" + strArray[3] + "}");
        }
        if (!strArray[4].matches("\\d{11}")){
            throw new InputException("Неправильно введён номер телефона {" + strArray[4] + "}");
        }
        if (!strArray[5].matches("[fm]")){
            throw new InputException("Неправильно указан пол {" + strArray[5] + "}");
        }
    }

    private int CheckQuantity() {
        strArray = data.split("\\s+");  // Иванов Иван Иванович 01.01.1999 22222222222 m - тестовая запись
        if (strArray.length < this.countData){
            return -1;
        }
        if (strArray.length > this.countData){
            return -2;
        }
        return 0;
    }

    public void DataToFile(){
        try(FileWriter writer = new FileWriter(strArray[0]+".txt", true)) {
            data = String.join(" ", strArray) + "\n";
            writer.write(data);
            System.out.println("Запись успешно занесена в файл "+ strArray[0] + ".txt");
        }
        catch(IOException e){
            System.out.println("Ошибка записи в файл");
            e.getStackTrace();
        }
    }
}

class InputException extends Exception{//Runtime

    public InputException(String e) {super(e);}
}
