# Web Server Endpoints
This is a program to show REST Endpoints work. It's written in Java Servlet, deployed on Google App Engine.<br>
Basically, I have implement **2** functions through end point:<br>
### 1. Return text and html with specified tags given from a url.<br>
**Path**: ```/parse``<br>`
And there are 2 parameters:<br>
**endpoint**: The url you want to access.<br>
**tag**: Which HTML tag you want to find with. <br>
<br>
**Example**: 
[https://web-server-endpoints.appspot.com/parse?endpoint=https://cobalt.io&tag=h1](https://web-server-endpoints.appspot.com/parse?endpoint=https://cobalt.io&tag=h1)<br>
In this case, it's finding within the URL "https://cobalt.io" with tag h1.<br>
And, the result will be: <br>
```json
{
  "h1": [
    {
      "innerText": "Pen Testing as a Service for Modern SaaS Businesses",
      "innerHtml": "
<span class=\"text-nowrap\">Pen Testing as a Service</span>
<span class=\"text-nowrap\">for Modern SaaS Businesses</span>"
    },
    {
      "innerText": "Crowdsourced Pen Testing for Modern SaaS Businesses",
      "innerHtml": "
<span class=\"text-nowrap\">Crowdsourced Pen</span>
<span class=\"text-nowrap\">Testing for Modern</span>
<span class=\"text-nowrap\">SaaS Businesses</span>"
    },
    {
      "innerText": "Crowdsourced Pen Testing for Modern SaaS Businesses",
      "innerHtml": "
<span class=\"text-no-wrap\">Crowdsourced</span>
<span class=\"text-no-wrap\">Pen Testing for Modern</span>
<span class=\"text-no-wrap\">SaaS Businesses</span>"
    },
    {
      "innerText": "The Cobalt Platform",
      "innerHtml": "The Cobalt Platform"
    },
    {
      "innerText": "Customer First",
      "innerHtml": "Customer First"
    }
  ]
}
```

### 2. Check if the given text exists in the certain url with certain tag. <br>
**Path**: ``/contains``<br>
And there are 3 parameters:<br>
**endpoint**: The url you want to access.<br>
**tag**: Which HTML tag you want to find with. <br>
**text**: Which text you are goin to find. It's CASE SENSITIVE. <br>
**Example**:
[https://web-server-endpoints.appspot.com/contains?endpoint=www.cobalt.io&tag=h1&text=Crowdsourced%2520Pen%2520Testing%2520for%2520Modern%2520SaaS%2520Businesses
](https://web-server-endpoints.appspot.com/contains?endpoint=www.cobalt.io&tag=h1&text=Crowdsourced%2520Pen%2520Testing%2520for%2520Modern%2520SaaS%2520Businesses
)<br>

In this case, it's finding if the text "Crowdsourced Pen Testing for Modern SaaS Businesses" exists within the URL "https://cobalt.io" with tag h1.<br>
And the result will be: <br>
```json
{
  "exists": true
}
```