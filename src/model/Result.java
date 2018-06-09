package model;

public class Result {
  private String innerText;
  private String innerHtml;

  public Result(String innerText, String innerHtml){
    this.innerText = innerText;
    this.innerHtml = innerHtml;
  }

  public String getInnerText() {
    return innerText;
  }
}
