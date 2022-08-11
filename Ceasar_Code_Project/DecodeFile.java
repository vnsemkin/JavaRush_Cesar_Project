package Ceasar_Code_Project;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DecodeFile {

    public List<Character> cesarDecoder(Scanner scanner
            , List<Character> encryptedList
            , Character[] uppercaseDic
            , Character[] lowercaseDic
            , Character[] symbolsDic) {
        List<Character> unencryptedList = new ArrayList<>();
        int key;
        while (true) {
            try {
                System.out.print("Введите ключ :");
                key = Math.abs(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("""
                        ____________________
                        Некорректный ключ!
                        Введите число!
                        ____________________
                        """);
                scanner.nextLine();
            }
        }
        int size = uppercaseDic.length;
        for (int i =0; i < encryptedList.size(); i++)
        {
            for (int j = 0; j < size; j++)
            {
                int offset = ((((j - key) % size) + size) % size);
                if (encryptedList.get(i).equals(uppercaseDic[j]))
                {
                    unencryptedList.add(uppercaseDic[offset]);
                } else if (encryptedList.get(i).equals(lowercaseDic[j]))
                {
                    unencryptedList.add(lowercaseDic[offset]);
                } else if (encryptedList.get(i).equals(symbolsDic[j]))
                {
                    unencryptedList.add(symbolsDic[offset]);
                }else if(unencryptedList.size() == i && j+1 == size)
                {
                    unencryptedList.add(encryptedList.get(i));
                }
            }
        }
        boolean isKeyRight = false;
        for (int x = 0, y = 1; y < unencryptedList.size(); x++, y++) {
            if (unencryptedList.get(x).equals(',')
                    && unencryptedList.get(y).equals(' ')
                    && (unencryptedList.get(unencryptedList.size() - 1).equals('.')
                    || unencryptedList.get(unencryptedList.size() - 1).equals('!')
                    || unencryptedList.get(unencryptedList.size() - 1).equals('?'))) {
                System.out.println();
                System.out.println("<-----Code_Key :" + key + "----->");
                System.out.println("Вы ввели правильный ключ!\n");
                System.out.println("<-----Расшифрованный_Файл----->");
                for (Character character : unencryptedList)
                {
                    System.out.print(character);
                }
                System.out.println();
                System.out.println("<-----Расшифрованный_Файл----->");
                isKeyRight = true;
                break;
            }
        }
        if (!isKeyRight) {
            System.out.println();
            System.out.println("<-----Code_Key :" + key + "----->");
            System.out.println("Кажется вы ввели неправильный ключ!\n");
            System.out.println("<-----Расшифрованный_Файл----->");
            for (Character character : unencryptedList) {
                System.out.print(character);
            }
            System.out.println();
            System.out.println("<-----Расшифрованный_Файл----->");
        }
        return unencryptedList;
    }
}


