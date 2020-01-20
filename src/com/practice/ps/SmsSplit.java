package com.practice.ps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Prathap on 08 Dec, 2019
 */
public class SmsSplit {

    static ArrayList<String> splitText(String message, int charLimit) {

        return splitTextAuxUsingSplit(message, charLimit);
    }

    static ArrayList<String> splitTextAuxUsingSplit(String message, int charLimitOriginal) {
        int charLimit = charLimitOriginal - 5;
        ArrayList<String> result = new ArrayList<String>();
        String[] splitted = message.split(" ");
        String temp;

        for (int i = 0; i < splitted.length - 1; i++) {
            temp = splitted[i];
            while ((temp + 1 + splitted[i + 1]).length() <= charLimit && i + 1 < splitted.length - 1) {  //+1 for space
                temp = temp + " " + splitted[i + 1];
                i++;
            }
            result.add(temp);
        }
        String lastElement = result.get(result.size() - 1);
        if (lastElement.length() + 1 + splitted[splitted.length - 1].length() < charLimit) {  //+1 for space
            result.set(result.size() - 1, lastElement + " " + splitted[splitted.length - 1]);
        } else {
            result.add(splitted[splitted.length - 1]);
        }

        int resultSize = result.size();
        for(int i = 0; i < resultSize; i++) {
            result.set(i, result.get(i) +"("+ (i+1) + "/" + resultSize + ")" );
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus consequat nec dui quis maximus. Praesent vehicula feugiat condimentum. Nunc portamludimi vulputate elit sit amet lacinia. Vivamus volutpat accumsan consequat. Nulla mattis odio erat, vel convallis neque semper nec. Integer a pharetra purus";
        int limit = 160;

        List<String> sentences=new ArrayList<String>();
        List<String> result=new ArrayList<String>();
        //if(s==null || s.isEmpty()) return sentences;
        limit=limit-"(x/x)".length();
        String[] words=s.split("\\s+");
        for(int i=0;i<words.length;i++)
        {
            StringBuilder sb=new StringBuilder();
            sb.append(words[i]);
            while(i+1<words.length && sb.length()+words[i+1].length()+1<=limit)
            {
                sb.append(" "+words[i+1]);
                i++;
            }
            sentences.add(sb.toString());
        }
        int size=sentences.size();
        for(int j=0;j<sentences.size();j++)
        {
            result.add(sentences.get(j)+"("+(j+1)+"/"+size+")");
        }
        //return result;
        System.out.println(result);
    }
}
