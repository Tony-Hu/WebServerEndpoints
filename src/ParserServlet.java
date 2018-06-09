import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Result;
import util.Util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    PrintStream out = new PrintStream(resp.getOutputStream());
    Map<String, List<Result>> resultMap = new HashMap<>();
    Gson gson = Util.getGson();

    String url = req.getParameter(Constants.URL);
    String tag = req.getParameter(Constants.TAG);

    if (!Util.isValidParameters(url, tag)){
      out.println("Invalid parameters!");
      return;
    }

    List<Result> resultList = Util.parseHtmlByTag(url, tag);
    resultMap.put(tag, resultList);

    out.println(gson.toJson(resultMap));
  }
}
