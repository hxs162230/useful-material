535. Encode and Decode TinyURL
Medium

522

1161

Favorite

Share
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

public class Codec {
    HashMap<String,String> short2long = new HashMap<>();
    HashMap<String,String> long2short = new HashMap<>();
    String dic = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String BASE_HOST = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(long2short.containsKey(longUrl)) return BASE_HOST + long2short.get(longUrl);
        String key ="";
        do{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<6;i++){
                int idx = (int) (Math.random()*dic.length());
                sb.append(dic.charAt(idx));
            }
            key = sb.toString();
        }while(short2long.containsKey(key));
            short2long.put(key,longUrl);
            long2short.put(longUrl,key);
        return BASE_HOST + long2short.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String str = shortUrl.replace(BASE_HOST,"");
        if(!short2long.containsKey(str)) return "";
        return short2long.get(str);
    }
}