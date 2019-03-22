package com.practice.algo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

  public static void main(String args[]) throws FileNotFoundException, IOException, JSONException {

    String response = "{\"module\":{\"id\":1002814697,\"name\":\"Dhananjay Kumar\",\"birthday\":null,\"email\":\"dhananjay.kumar@redmart.com\",\"emailConfirmed\":null,\"phone\":null,\"phonePrefixCode\":null,\"gender\":null,\"avatar\":\"https://lh6.googleusercontent.com/-8cd7j5MthwE/AAAAAAAAAAI/AAAAAAAAAAA/AAN31DUJVTdvC18iiiOq7UecR3nrHxyx3Q/s96-c/photo.jpg\",\"passwordVersion\":null,\"alipayUserId\":\"2161220003466663\",\"language\":null,\"taxId\":null,\"branchId\":null,\"contactEmail\":\"dhananjay.kumar@redmart.com\",\"isVerified\":false,\"b2b\":false,\"isTest\":false,\"status\":\"NORMAL\",\"type\":\"BUYER\",\"isLiveUp\":false,\"liveUpStatus\":\"NO_MEMBER_FOR_NEW\",\"enableEwallet\":false,\"hasAddress\":true,\"memberLevel\":\"TRUSTED\",\"enableNewsletter\":null,\"userTag1\":2228224,\"userTag2\":null,\"userTag3\":null,\"userTag4\":null,\"userTag5\":null,\"ext\":\"{\"registerEnv\":{\"adid\":\"b9f2dd69e4fbbeacc3fcdc3d38e9c349\",\"utdid\":\"W7x+E2cRui0DAHivQBWPvnVF\",\"clientIp\":\"42.106.246.38\",\"platform\":\"android\"}}\",\"gmtCreate\":1539247069.937000000,\"gmtModified\":1547804698.400000000,\"siteId\":\"SG\"},\"success\":true,\"errorCode\":null,\"notSuccess\":false}";
    String response1 = response.replaceAll("\"\\{", "{");
    String response2 = response1.replaceAll("}\"", "}");
    System.out.println(response2);

    //    ObjectMapper objectMapper = new ObjectMapper();
//    objectMapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
//
//    String content = new String(Files.readAllBytes(Paths.get("/Users/prathap/Downloads/lzpayloadtxt.rtf")));
//    LazadaAccountInfoResponseDto lazadaAccountInfoResponseDto = objectMapper.readValue(StringEscapeUtils.unescapeHtml4(content), LazadaAccountInfoResponseDto.class);
//    System.out.println(lazadaAccountInfoResponseDto.getLazadaAccountInfoDto().getEmail());
//
//    //JSONObject jsonObject = new JSONObject(content);
//    //System.out.println(jsonObject.get("errorCode"));
//
//    try {
//      byte[] utf8Bytes = content.getBytes("UTF8");
//      String text = new String(utf8Bytes,"UTF8");
//      JSONObject jsonObject = new JSONObject(text);
//      System.out.println(jsonObject.get("errorCode"));
//    }
//    catch (UnsupportedEncodingException e) {
//      e.printStackTrace();
//    }

  }

  private static boolean isValidMove(char[][] boggle, char ch, String word, int rowIndex, int colIndex, int N, int M) {
    if (rowIndex < 0 || rowIndex > (M - 1) || colIndex < 0 || colIndex > (N - 1)) {
      return false;
    }
    if (boggle[rowIndex][colIndex] == ch && "".equals(word)) {
      return true;
    }

    boolean b = false;
    if (!"".equals(word)) {
      b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex + 1, colIndex, M, N);
      if (!b)
        b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex - 1, colIndex, M, N);
      if (!b)
        b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex, colIndex + 1, M, N);
      if (!b)
        b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex, colIndex - 1, M, N);
      if (!b)
        b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex - 1, colIndex - 1, M,
            N);
      if (!b)
        b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex + 1, colIndex + 1, M,
            N);
      if (!b)
        b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex + 1, colIndex - 1, M,
            N);
      if (!b)
        b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex - 1, colIndex + 1, M,
            N);
      return b;
    } else {
      return true && b;
    }
  }

}
