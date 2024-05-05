package interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class EncodeandDecodeTinyURL_535 {

  public class Codec {


    Map<String, String> map = new HashMap<>();
    int counter = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
      String encodedUrl = "url" + "_" + counter;
      map.put(encodedUrl, longUrl);
      counter++;
      return encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
      return map.get(shortUrl);
    }
  }

  public static void main(String[] args) {
    EncodeandDecodeTinyURL_535 en = new EncodeandDecodeTinyURL_535();
    Codec codec = en.new Codec();
    String encoded = codec.encode("https://leetcode.com/problems/design-tinyurl");
    System.out.println(codec.decode(encoded));
  }

}
