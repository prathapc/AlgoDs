package com.practice.ps;

/**
 * Created by Prathap on 05 Feb, 2020
 */
public class PrettyJson {

    public static void main(String[] args) {
        String json = "{\"id\": \"0001\", \"type\": \"donut\", \"name\": \"Cake\", \"ppu\": 0.55, \"batters\":{\"batter\":[{ \"id\": \"1001\", \"type\": \"Regular\" },{ \"id\": \"1002\", \"type\": \"Chocolate\" }]},\"topping\":[{ \"id\": \"5001\", \"type\": \"None\" },{ \"id\": \"5002\", \"type\": \"Glazed\" }]}";
        System.out.println(pretty(json));
    }

    public static String pretty(String s) {
        StringBuilder sb = new StringBuilder();
        int indent = 0;
        char prev = 0;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) continue;
            if (c == ']' || c == '}')
                indent--;

            if (prev == '[' || prev == '{' || prev == ',' || c == ']' || c == '}') {
                sb.append('\n');
                for (int i = 0; i < indent; i++)
                    sb.append("  ");
            }
            sb.append(c);

            if (c == '[' || c == '{')
                indent++;
            prev = c;
        }
        return sb.toString();
    }

}
