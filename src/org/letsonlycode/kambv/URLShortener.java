package org.letsonlycode.kambv;

import java.util.HashMap;
import java.util.Map;

class URLShortener {
    Long counter = 1L;
    Map<Long, String> indexToUrl = new HashMap<Long, String>();
    Map<String, Long> urlToIndex = new HashMap<String, Long>();
    String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlToIndex.containsKey(longUrl)) {
            return "http://tinyurl.com/"+base62Encode(urlToIndex.get(longUrl));
        }
        else {
            indexToUrl.put(counter, longUrl);
            urlToIndex.put(longUrl, counter);
            counter++;
            return "http://tinyurl.com/"+base62Encode(urlToIndex.get(longUrl));
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String base62Encoded = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        long decode = 0;
        for(int i = 0; i < base62Encoded.length(); i++) {
            decode = decode * 62 + base62.indexOf("" + base62Encoded.charAt(i));
        }
        return indexToUrl.get(decode);
    }

    private String base62Encode(long value) {
        StringBuilder sb = new StringBuilder();
        while (value != 0) {
            sb.append(base62.charAt((int)(value % 62)));
            value /= 62;
        }
        while (sb.length() < 6) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }
}

class URLShortenerDriver{
    public static void main(String[] args) {
        String url = "https:localhost:1080/prweb/myappp/specifier?abc=1234";
        URLShortener urlShortener = new URLShortener();
        String shortUrl = urlShortener.encode(url);

        System.out.println(shortUrl);

        System.out.println(urlShortener.decode(shortUrl));

    }
}