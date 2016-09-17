import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import java.io.IOException;

public class converter {

    public class languageTranslater {
        public static String word = "namaskar";
        public static String language = "hi";
        public static String url = "http://www.google.com/inputtools/request?text="+word+"&ime=transliteration_en_"+language+"&num=5&cp=0&cs=0&ie=utf-8&oe=utf-8&app=jsapi&uv="+word+"%3A%E0%B2%A8%E0%B2%BE%E0%B2%A8%E0%B3%81-0-0%3A%3A%E0%B2%A8%E0%B2%86%E0%B2%A8%E0%B3%81-1-1%3A%3B0%3B0&cb=_callbacks_._1ilsa9r0q";
        public static void main(String[] args) {
            HttpClient client = new HttpClient();
            HttpMethod method = new GetMethod(url);
            try {
                client.executeMethod(method);
                if (method.getStatusCode() == HttpStatus.SC_OK) {
                    String response = method.getResponseBodyAsString();
                    // step 2 follows
                    String[] split = response.split(",\\[");
                    split[2] = split[2].substring(0,split[2].length()-1);
                    String[] translatedWord =  split[2].split(",");
                    for (int i=0;i< translatedWord.length;i++)
                        System.out.println(translatedWord[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                method.releaseConnection();
            }
        }
    }
}
