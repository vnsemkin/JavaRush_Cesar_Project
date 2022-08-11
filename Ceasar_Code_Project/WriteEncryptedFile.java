package Ceasar_Code_Project;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteEncryptedFile
{
    List<Character> encryptedList = new ArrayList<>();

    private Path inputFilePath(Scanner scanner)
    {
        scanner.nextLine();
        System.out.print("Введите имя файла :");
        return Path.of(scanner.nextLine());
    }

    public void writeEncryptedFile(Scanner scanner, List<Character> encryptedList)
    {
        try {
            Path outPath = inputFilePath(scanner);
            Files.createFile(outPath);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(outPath))))
            {
                for (Character character : encryptedList)
                {
                    bufferedWriter.write(character);
                    bufferedWriter.flush();
                }
                if (Files.exists(outPath) && Files.size(outPath) != 0)
                {
                    System.out.println("<----- Файл_Успешно_Создан----->");
                    System.out.println(outPath.toAbsolutePath());
                    System.out.println("--------------------------------");
                }
            } catch (IOException e)
            {
                System.out.println("<-----Ошибка_Записи_Файла!----->");
            }
        } catch (IOException e)
        {
            System.out.println("<-----Ошибка_Создания_Файла----->");
        }
    }

    public List<Character> readEncryptedFile(Scanner scanner)
    {
        Path outPath = inputFilePath(scanner);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(outPath))))
        {
            while (bufferedReader.ready())
            {
                encryptedList.add((char) bufferedReader.read());
            }
            if (Files.exists(outPath) && encryptedList.size() != 0)
            {
                System.out.println("<------Файл_Успешно_Считан----->");
                System.out.println("<-------Файл для дешифровки----->");
                System.out.println(outPath.toAbsolutePath());
                System.out.println("---------------------------------");
            }
        } catch(FileNotFoundException e)
                {
                    System.out.println("<-----Файл_Не_Найден----->");
                } catch(IOException e){
                    System.out.println("<-----Ошибка_Чтения_Файла----->");
                }
        return encryptedList;
    }
}
