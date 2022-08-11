package Ceasar_Code_Project;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CesarCryptFile {
    public List<Character> cesarCipher(Scanner scanner
            , List<Character> unencryptedList
            , Character[] uppercaseDic
            , Character[] lowercaseDic
            , Character[] symbolsDic)
    {
        List<Character> encryptedList = new ArrayList<>();
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
        for (int i =0; i < unencryptedList.size(); i++)
        {
            for (int j = 0; j < size; j++)
            {
                int offset = (j + key) % size;
                if (unencryptedList.get(i).equals(uppercaseDic[j]))
                {
                    encryptedList.add(uppercaseDic[offset]);
                } else if (unencryptedList.get(i).equals(lowercaseDic[j]))
                {
                    encryptedList.add(lowercaseDic[offset]);
                } else if (unencryptedList.get(i).equals(symbolsDic[j]))
                {
                    encryptedList.add(symbolsDic[offset]);
                }else if(encryptedList.size() == i && j+1 == size)
                {
                    encryptedList.add(unencryptedList.get(i));
                }
            }
        }
        if(!encryptedList.isEmpty())
            System.out.println("<-----Документ успешно зашифрован----->");
        return encryptedList;
    }
    public void printEncryptedDocument(List<Character> encryptedList)
    {
        System.out.println("<-----Encoded_Document----->");
        System.out.println();
        for (Character character:encryptedList)
        {
            System.out.print(character);
        }
        System.out.println();
        System.out.println("<-----Encoded_Document----->");
    }
}
