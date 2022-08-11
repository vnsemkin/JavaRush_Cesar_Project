package Ceasar_Code_Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController
{
    private final Character[] ALPHABET_RUS_UPPERCASE = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
            'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};
    private final Character[] ALPHABET_RUS_LOWERCASE ={'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и',
            'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х',
            'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    private final Character[] SYMBOLS = {'.', ',', '"', '”', ':', '-', '!', '?', '_', ' ', '(', ')', ';', '@', '+', '#', '№',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0','%','$','/','\\','|','*'};
    private List<Character> unencryptedList = new ArrayList<>();
    private List<Character> encryptedList = new ArrayList<>();
    CesarCryptFile cesarCryptFile = new CesarCryptFile();
    DecodeFile decodeFile = new DecodeFile();
    BruteForceDecode bruteForceDecode = new BruteForceDecode();
    ReadFile readFile = new ReadFile();
    UserInput userInput = new UserInput();
    WriteEncryptedFile writeEncryptedFile = new WriteEncryptedFile();
    Menu menu = new Menu();
    private void menuController(Scanner scanner)
    {
        while (true)
        {
            menu.mainMenu();
            int userSelectedMenuItem = userInput.userInput(scanner);
        switch(userSelectedMenuItem)
        {
                case 0 ->
                {
                    System.out.println("<-----До свидания!----->");
                    System.exit(0);
                }
                case 1 ->
                {
                    unencryptedList.clear();
                    unencryptedList = readFile.fileReader(scanner);
                }
                case 2 -> readFile.printFile(unencryptedList);
                case 3 -> encryptedList = cesarCryptFile.cesarCipher
                            (scanner
                            , unencryptedList
                            , ALPHABET_RUS_UPPERCASE
                            , ALPHABET_RUS_LOWERCASE
                            , SYMBOLS);
                case 4 -> cesarCryptFile.printEncryptedDocument(encryptedList);
                case 5 -> writeEncryptedFile.writeEncryptedFile(scanner,encryptedList);
                case 6 ->
                {
                    encryptedList.clear();
                    encryptedList = writeEncryptedFile.readEncryptedFile(scanner);
                }
                case 7 ->
                {
                    unencryptedList.clear();
                    unencryptedList = decodeFile.cesarDecoder
                            (scanner
                            , encryptedList
                            , ALPHABET_RUS_UPPERCASE
                            , ALPHABET_RUS_LOWERCASE
                            , SYMBOLS);
                }
                case 8 ->
                {
                    unencryptedList.clear();
                    unencryptedList = bruteForceDecode.bruteForceDecode
                                    (encryptedList
                                    , ALPHABET_RUS_UPPERCASE
                                    , ALPHABET_RUS_LOWERCASE
                                    , SYMBOLS);
                }
                case 9 -> System.out.println("Метод не реализован.");
                default -> System.out.println("Еще одна попытка. Сосредоточтесь");
            }
        }
    }
    public static void main(String[] args)
    {
        MenuController menuController = new MenuController();
        try (Scanner scanner = new Scanner(System.in))
        {
            menuController.menuController(scanner);
        }
    }
}

