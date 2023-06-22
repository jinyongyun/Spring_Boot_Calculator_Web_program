package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.http.HttpHeaders;

public class HttpRequest {
    private final RequestLine requestLine;

    //private final HttpHeaders httpHeaders; 계산기에서는 필요 없다
    //private final Body body; 얘도 마찬가지

    public HttpRequest(BufferedReader br) throws IOException { //프로토콜의 첫번째 line이 requestLine 이기 때문에 첫번째 라인 집어넣기
        this.requestLine = new RequestLine(br.readLine());
    }



    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String path) {
        return requestLine.matchPath(path);
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }
}
