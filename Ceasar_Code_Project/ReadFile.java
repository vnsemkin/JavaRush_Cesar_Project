package Ceasar_Code_Project;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public List<Character> fileReader(Scanner scanner)
    {
        List<Character> unencryptedList = new ArrayList<>();
        boolean successReadingFile = true;
        Path path = null;
            try {
                scanner.nextLine();
                System.out.print("Введите имя  файла :");
                path = Path.of(scanner.nextLine());
                BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(path)));
                while (bufferedReader.ready())
                {
                    unencryptedList.add((char) bufferedReader.read());
                }
            } catch (FileNotFoundException e)
            {
                System.out.println("<------Файл_Не_Найден!----->");
                System.out.println(path.toAbsolutePath());
                successReadingFile = false;
            } catch (IOException e)
            {
                System.out.println("<-----Ошибка_Чтения_Файла!----->");
                successReadingFile = false;
            }
            if (successReadingFile && unencryptedList.size() != 0)
            {
                System.out.println("<------Файл_Успешно_Считан------>!");
            }
            return unencryptedList;
    }
    public void printFile(List<Character> unencryptedList)
    {
        if(unencryptedList.size() == 0)
        {
            System.out.println("<-----Файл_Не_Считан!----->");
        }else
        {
            System.out.println("<------Незашифрованный_Файл----->");
            for (Character character : unencryptedList)
            {
                System.out.print(character);
            }
        }
        System.out.print("\n---------------------------------------\n");
    }
}
