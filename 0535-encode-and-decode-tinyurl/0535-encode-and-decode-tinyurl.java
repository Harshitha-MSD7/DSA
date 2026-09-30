public class Codec {
    private  HashMap<String, String> encode = new HashMap<>();
    private HashMap<String, String> decode = new HashMap<>();
    private String base = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(!encode.containsKey(longUrl)){
            String shortUrl = base + (encode.size() + 1);
            encode.put(longUrl, shortUrl);
            decode.put(shortUrl, longUrl);
        }
        return encode.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decode.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));