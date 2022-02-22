import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rabot {
    public static void main(String[] args) throws  Exception{
        //при вставлении текста, а не объекта, программа работает без ошибок и выполняет своё назначение
        FileReader fileAirports = new FileReader("C:/airports.dat");
        Scanner scan = new Scanner(fileAirports);


        System.out.println("Введите строку:");
        String info = scan.nextLine();
        String regex = "[^\r\n]*" + info + "*[^\r\n]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(info);
        long AtTheStart = System.currentTimeMillis();
        int count = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            //если перед методом substring будет переменная типа String, то программа будет работать правильно
            System.out.println(fileAirports.substring(start, end));
            count += 1;
        }
        long AtTheEnd = System.currentTimeMillis() - AtTheStart;
        System.out.println("Количество найденных строк: " + count + " Время, затраченное на поиск: " + AtTheEnd + " мс");
        scan.close();
    }
}
