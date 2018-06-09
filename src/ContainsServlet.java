import com.google.gson.Gson;
import model.Result;
import org.jsoup.Jsoup;
import util.Util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    PrintStream out = new PrintStream(resp.getOutputStream());

    String url = req.getParameter(Constants.URL);
    String tag = req.getParameter(Constants.TAG);
    String text = req.getParameter(Constants.TEXT);
    System.out.println("RAW data:" + text);


    if (!Util.isValidParameters(url, tag)){
      printResult(out, false);
      return;
    }

    if (text == null || "".equals(text)){
      printResult(out, true);
      return;
    }
    text = text.replace("%20", " ");
    System.out.println("Parsed: " + text);
    List<Result> resultList = Util.parseHtmlByTag(url, tag);
    for (Result result : resultList) {
      String htmlText = result.getInnerText();
      if (htmlText != null && htmlText.contains(text)){
        printResult(out, true);
        return;
      }
    }
    printResult(out, false);
  }

  private void printResult(PrintStream out, boolean exist) {
    Map<String, Boolean> resultMap = new HashMap<>();
    Gson gson = Util.getGson();

    resultMap.put(Constants.EXIST_KEY, exist);
    out.println(gson.toJson(resultMap));
  }
}
