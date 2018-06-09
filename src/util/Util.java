package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Result;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {
  private static Gson gson;

  public static List<Result> parseHtmlByTag(String url, String tag) throws IOException {
    if (!url.contains("http")){
      url = "http://" + url;
    }
    Document doc = Jsoup.connect(url).timeout(10000).get();
    Elements tags = doc.getElementsByTag(tag);

    List<Result> resultList = new ArrayList<>();
    for (Element element : tags){
      Result result = new Result(element.text(), element.html());
      resultList.add(result);
    }
    return resultList;
  }

  public static Gson getGson() {
    if (gson == null){
      gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().serializeNulls().create();
    }
    return gson;
  }

  public static boolean isValidParameters(String ... parameters){
    for (String parameter : parameters){
      if (parameter == null){
        return false;
      }
    }
    return true;
  }
}
