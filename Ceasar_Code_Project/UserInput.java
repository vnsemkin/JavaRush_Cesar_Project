package Ceasar_Code_Project;
import java.util.InputMismatchException;
import java.util.Scanner;
public class UserInput
{
    public int userInput(Scanner scanner)
    {
        int userInput;
        while(true) {
            try {
                System.out.print("Выберите пункт меню :");
                userInput = scanner.nextInt();
                if (userInput < 0 || userInput > 9)
                {
                    System.out.println("""
                            <-------------------->
                             Нет такого пункта меню!
                            <-------------------->
                            """);
                    continue;
                }
                break;
            } catch (InputMismatchException e)
            {
                System.out.println("""
                        \n<-------------------->
                        Ошибка!
                        Введите корректный пункт меню!
                        <-------------------->
                        """);
                scanner.nextLine();
            }
        }
        return userInput;
    }
}
