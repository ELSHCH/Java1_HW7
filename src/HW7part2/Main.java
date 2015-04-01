package HW7part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by shcheki on 27.03.2015.
 */
public class Main {

    public static HashMap setNodes(String text) {
        char[] arrayChar = text.toCharArray();
        HashSet<Character> hashset = new HashSet<Character>();
        HashMap hm = new HashMap();
        int numOccur = 0;
        for (char ch : arrayChar) {
            hashset.add(ch);
        }
        for (char c : hashset) {
            for (int i = 0; i < arrayChar.length; i++) {
                if (arrayChar[i] == c) {
                    numOccur++;
                }
            }
            hm.put(c, numOccur);
            numOccur = 0;
        }
        return hm;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<Node> nodes = new ArrayList<Node>();
        System.out.println("Введите строку для кодирования: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String strIn =br.readLine();
        HashMap hashMap = new HashMap();
        hashMap=setNodes(strIn);
        Set set = hashMap.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            System.out.print(hashMap.keySet() + ": ");
            System.out.println(hashMap.values());
            System.out.println("Закодированная строка: ");
            System.out.println("Строка после разкодирования: ");

        }
    }
}
