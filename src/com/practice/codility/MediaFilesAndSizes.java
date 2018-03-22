package com.practice.codility;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by prathap on 07/10/17.
 */
public class MediaFilesAndSizes {

  public static void main(String args[]) {
    /*String S = "my.song.mp3 11b\n" +
        "greatSong.flac 1000b\n" +
        "not3.txt 5b\n" +
        "video.mp4 200b\n" +
        "game.exe 100b\n" +
        "mov!e.mkv 10000b";*/
    String S = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b";
    System.out.print(solution1(S));
  }

  private static String solution1(String S) {
    if(S != null && S.trim().length() > 1) {
      Set<String> music = new HashSet<>(Arrays.asList("mp3", "aac", "flac"));
      Set<String> images = new HashSet<>(Arrays.asList("jpg", "bmp", "gif"));
      Set<String> movies = new HashSet<>(Arrays.asList("mp4", "avi", "mkv"));

      Map<String, BigInteger> files = new LinkedHashMap<>();
      files.put("music", new BigInteger("0"));
      files.put("images", new BigInteger("0"));
      files.put("movies", new BigInteger("0"));
      files.put("other", new BigInteger("0"));

      String filesWithSizes[] = S.split("[\n]");
      for(int i=0; i<filesWithSizes.length; i++) {
        String fileWithSize = filesWithSizes[i].substring(filesWithSizes[i].lastIndexOf(".") + 1, filesWithSizes[i].length() - 1);
        String str[] = fileWithSize.split("\\s+");
        if(music.contains(str[0])) {
          files.put("music", files.get("music").add(new BigInteger(str[1])));
        } else if (images.contains(str[0])) {
          files.put("images", files.get("images").add(new BigInteger(str[1])));
        } else if ( movies.contains(str[0])) {
          files.put("movies", files.get("movies").add(new BigInteger(str[1])));
        } else {
          files.put("other", files.get("other").add(new BigInteger(str[1])));
        }
      }

      StringBuilder str = new StringBuilder();
      str.append("\"");
      for(Map.Entry<String, BigInteger> entry : files.entrySet()) {
        str.append(entry.getKey() + " " + entry.getValue() + "b\n");
      }
      str.replace(str.length()-1, str.length(), "");
      str.append("\"");
      return str.toString().trim();
    }
    return null;
  }
}
