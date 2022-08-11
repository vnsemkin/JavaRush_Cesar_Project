package Ceasar_Code_Project;
import java.util.ArrayList;
import java.util.List;
public class BruteForceDecode
{
     public List<Character> bruteForceDecode
             (List<Character> encryptedList
            , Character[] uppercaseDic
            , Character[] lowercaseDic
            , Character[] symbolsDic)
     {
        List<Character> unencryptedList = new ArrayList<>();
        int size = uppercaseDic.length;
        for (int key = 0; key < size; key++)
        {
            unencryptedList.clear();
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
            for (int x = 0, y = 1; y < unencryptedList.size(); x++, y++) {
                if (unencryptedList.get(x).equals(',')
                        && unencryptedList.get(y).equals(' ')
                        && (unencryptedList.get(unencryptedList.size() - 1).equals('.')
                        || unencryptedList.get(unencryptedList.size() - 1).equals('!')
                        || unencryptedList.get(unencryptedList.size() - 1).equals('?')))
                {
                    System.out.println();
                    System.out.println("<-----Code_Key :" + key + "----->");
                    for (Character character : unencryptedList)
                    {
                        System.out.print(character);
                    }
                    System.out.println("\n<-----Code_Key :" + key + "----->");
                    break;
                }
            }
        }
        return unencryptedList;
     }
}
