<h1 class="page-title">웹 애플리케이션의 이해: 계산기 웹 프로그램 </h1><p class="page-description"></p><table class="properties"><tbody></tbody></table></header><div class="page-body"><p id="3e55c2c7-2cb0-4410-9e9e-624c8b4a8aa0" class="">New project</p><p id="f102516e-de8e-4fc1-b8ac-e02c2abaf271" class="">Name: was-practice</p><p id="ea030550-bd4e-46f3-ab69-1cb3249f29f5" class="">JAVA</p><p id="af75f8bd-383c-4a56-a980-d9f65f9fb3b0" class="">Gradle</p><p id="3e56c9e9-a695-4552-952e-7cd60274cc16" class="">temurin-11</p><p id="ce66f543-822f-458b-9267-536f79cf0396" class="">Groovy</p><p id="ffd32dce-89f8-405b-8a32-a910920ea876" class="">
</p><h1 id="64b2cbee-e0fe-4baf-a099-aca4674ccb78" class="">step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.</h1><p id="dba88096-91b3-4a91-be8f-eaaff395b8a5" class="">1.dependency 추가</p><p id="689127dc-5e64-4869-8cd1-cdee723d1bf6" class=""><code>testImplementation &#x27;org.assertj:assertj-core:3.23.1&#x27;</code></p><p id="a6163a49-6c0b-4add-adfe-8c0a5cc5df53" class=""><code>implementation &#x27;ch.qos.logback:logback-classic:1.2.3&#x27;</code></p><p id="8628fc61-f477-4b12-9d5f-1110b8d5da31" class="">dependency에 이 2개 추가</p><p id="c95db531-2fe8-4a2a-a86f-c71f3ffe999d" class="">2.기본적으로 만들어놓았던 calculator 계산 폴더 가져와서 org.example 밑에다 추가</p><figure id="5ba9e6b2-0bbc-4eaa-b53c-31d36600480b"><div class="source"><a href="https://www.notion.soundefined"></a></div></figure><p id="5897abff-53c1-4d3e-b8e9-ce19422298ff" class="">
</p><p id="efc4f1df-27e6-4fbd-9de8-e361cb1f5eaf" class="">3.이걸 Web application으로 만들기</p><ul id="96301480-8651-4f24-93a4-515fb942439c" class="bulleted-list"><li style="list-style-type:disc">CustomWebApplicationServer 만들기</li></ul><pre id="6511be9f-61c1-4d3d-83f4-c4cea82fc6ce" class="code"><code>package org.example;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomWebApplicationServer {
    private final int port; //포트번호

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class); //로그 표시를 위해

    public CustomWebApplicationServer(int port) { //생성자
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info(&quot;[CustomWebApplicationServer] started {} port.&quot;, port);

            Socket clientSocket;
            logger.info(&quot;[CustomWebApplicationServer] waiting for client.&quot;);

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info(&quot;[CustomWebApplicationServer] client connected!&quot;);
                
            }


        }
    }
}</code></pre><figure id="c2f7fd36-2f26-4b10-a583-a323486f7535" class="image"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-21_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_10.17.13.png"><img style="width:3584px" src="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-21_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_10.17.13.png"/></a></figure><p id="11a7ff63-a2e3-432a-b1d0-efe212604409" class="">[main 함수에서 포트 연결 성공]</p><p id="42993a6f-e72c-4b44-b8da-fc59dde66ea9" class="">
</p><pre id="a7a47cf5-b6cb-4ebc-8124-9e63b2729e12" class="code"><code>while ((clientSocket = serverSocket.accept()) != null) {
                logger.info(&quot;[CustomWebApplicationServer] client connected!&quot;);

                /**
                 * step1 - 사용자 요청을 메인 thread기 처리하도록 한다.
                 */

                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    String line;
                    while((line = br.readLine()) != &quot;&quot;){
                        System.out.println(line);
                    }
                }

            }</code></pre><p id="d033b64c-1bb6-4064-b72f-14ada32559df" class="">이 부분 추가해서 http protocol 확인해보기</p><pre id="ae29bca2-069c-4d3e-8837-f880fdd65ec8" class="code"><code>22:24:52.792 [main] INFO org.example.CustomWebApplicationServer - [CustomWebApplicationServer] started 8081 port.
22:24:52.797 [main] INFO org.example.CustomWebApplicationServer - [CustomWebApplicationServer] waiting for client.
22:24:58.961 [main] INFO org.example.CustomWebApplicationServer - [CustomWebApplicationServer] client connected!
GET / HTTP/1.1
Host: localhost:8081
Connection: Keep-Alive
User-Agent: Apache-HttpClient/4.5.13 (Java/17.0.5)
Accept-Encoding: br,deflate,gzip,x-gzip</code></pre><p id="3d800044-ea79-4d74-b17a-556e71eb72bd" class="">이렇게 확인할 수 있다.</p><p id="b880bb7a-442e-402b-82b3-7061ff004e0a" class="">즉 우리가 Spring 을 이용해서 웹 개발을 할 때 어떠한 누군가는 내부적으로 이러한 프로토콜이 들어왔을 때 파싱을 해서 어떠한 요청이구나…라는 걸 판단을 할 것이며, 그러한 판단에 맞게끔 스프링이 요청을 보내는 작업을 누군가는 수행할 것이다. 이것을 수행하는 녀석이 바로 Tomcat 이다.</p><p id="7a083159-87d2-4dde-a14d-ee3764692360" class="">
</p><p id="426d6436-17d7-4e9c-8145-bb43e6d62e54" class="">그러므로 지금 만들고 있는 것은 Custom한 Tomcat을 만들고 있는 과정이라고 할 수 있다.</p><p id="9a406a5c-42fc-4727-982f-dadf413120e3" class="">Tomcat을 WAS라고 표현하는데, 이걸 한 번 만들어보는 것이다.</p><p id="d1b07ab2-8d1e-4d41-a609-172787e849c8" class="">
</p><p id="c432bfd6-a5ff-4e6e-b30b-630927e16cf2" class="">test.http에 이렇게 변환해서 test하면</p><pre id="e2fe83b0-abd7-4a55-8511-5d22fdab8770" class="code"><code># GET/calculate?operand1=11&amp;operator=*&amp;operand2=55
GET http://localhost:8081/calculate?operand1=11&amp;operator=*&amp;oeprand2=55</code></pre><pre id="219866aa-8388-48d6-a56f-2352fc5664af" class="code"><code>brary/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home/bin/java -javaagent:/private/var/folders/k0/vk4qjwsj5t16r8_qc2jztf_m0000gn/T/AppTranslocation/7BA4893C-D55E-436C-9D4F-EA4D3B30B606/d/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=51768:/private/var/folders/k0/vk4qjwsj5t16r8_qc2jztf_m0000gn/T/AppTranslocation/7BA4893C-D55E-436C-9D4F-EA4D3B30B606/d/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/jinyongyun/Downloads/was-practice/out/production/classes:/Users/jinyongyun/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-classic/1.2.3/7c4f3c474fb2c041d8028740440937705ebb473a/logback-classic-1.2.3.jar:/Users/jinyongyun/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-core/1.2.3/864344400c3d4d92dfeb0a305dc87d953677c03c/logback-core-1.2.3.jar:/Users/jinyongyun/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.25/da76ca59f6a57ee3102f8f9bd9cee742973efa8a/slf4j-api-1.7.25.jar org.example.Main
22:33:57.439 [main] INFO org.example.CustomWebApplicationServer - [CustomWebApplicationServer] started 8081 port.
22:33:57.444 [main] INFO org.example.CustomWebApplicationServer - [CustomWebApplicationServer] waiting for client.
22:34:05.331 [main] INFO org.example.CustomWebApplicationServer - [CustomWebApplicationServer] client connected!
GET /calculate?operand1=11&amp;operator=*&amp;oeprand2=55 HTTP/1.1
Host: localhost:8081
Connection: Keep-Alive
User-Agent: Apache-HttpClient/4.5.13 (Java/17.0.5)
Accept-Encoding: br,deflate,gzip,x-gzip</code></pre><p id="cc9b22c7-9c5c-433d-a58e-d68e3e24a493" class="">이런 식으로 나온다.</p><p id="945101fd-28af-4a93-912a-f7b14bc2b56f" class="">
</p><p id="fde5e102-7832-4503-8a44-7be555dbd942" class="">Request message의 첫 번째 줄인 Request line을 split을 한 다음에 이 값을 추출해서 계산을 수행해 보는 것을 구현해 보겠다.</p><p id="ff53164b-3e19-482c-9258-9be1380a4df2" class="">
</p><p id="41ac33df-1c74-46ae-87ed-5faaa9bcb290" class="">필요하다고 판단되는 객체는</p><p id="2cafb246-4281-46cc-a936-7dc96877375b" class="">HttpRequest  </p><ul id="64041dba-374f-4512-acac-b5bef1cb8bf8" class="bulleted-list"><li style="list-style-type:disc">Request line</li></ul><ul id="d970dd00-793f-445d-a1d5-c42f67a5c6c9" class="bulleted-list"><li style="list-style-type:disc">Header(이것도 딱히 필요 x)</li></ul><ul id="97bce251-f91c-46f8-befb-bd56063d9fd0" class="bulleted-list"><li style="list-style-type:disc">Body (Get이니까 필요x)</li></ul><p id="5653b560-24e1-4d94-8f1b-bc1d13030a2a" class="">이 객체를 이용해 QueryString에서 값을 잘 추출하고 연산을 수행해보자!</p><p id="f09e7488-fc38-4024-9187-00ed4b424cfc" class=""><strong>TDD</strong> 방식(테스트 주도 방식)으로 구현</p><blockquote id="160d7ba4-f1f1-4faf-862a-c4ff6d8fa5a3" class="block-color-gray_background">src 폴더 밑에 언제나 있던 test 폴더가 없길래 굉장히 당황했다.</blockquote><blockquote id="3e9c284e-42c9-4d3a-9e14-8b3d5091a718" class="block-color-gray_background">한 줄 TIP</blockquote><blockquote id="3d1ab1c7-b844-48d3-8be9-87942dc87c61" class="block-color-gray_background"><strong>프로젝트 폴더 우클릭 - New - Directory를 클릭한 뒤, 필요한 폴더 삽입</strong></blockquote><p id="5fe68293-8d2c-4e75-954b-ed40743e7c7a" class="">
</p><p id="a7e3d9d2-0d77-4415-99e3-1be364603052" class="">test&gt;java&gt;RequestLineTest 클래스 제작</p><p id="96d62869-ce93-4e88-aee5-95ee7ea06ce5" class="">RequestLine 클래스 필요, main &gt; java &gt; org.example &gt; 에다 클래스 제작</p><p id="57812350-4a5d-45e6-b31f-2b7eaff67f4b" class="">관습적으로 test &gt; java에도 org.example directory 추가 (test도 이렇게 맞춰주는 것이 관습적으로 이뤄짐)</p><p id="56a06a99-10e1-40f4-9d2d-fbca4afeeffe" class="">RequestLineTest 클래스를 새로 만든 org.example에 넣기</p><pre id="44b5c711-ef71-4d09-969d-66284f252123" class="code"><code>package org.example;

import org.example.RequestLine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {

    @Test
    void create(){
       RequestLine requestLine = new RequestLine(&quot;GET /calculate?operand1=11&amp;operator=*&amp;oeprand2=55 HTTP/1.1&quot;);

       assertThat(requestLine).isNotNull();
    }
}</code></pre><pre id="990d5fea-4709-492c-958f-f06f09207e94" class="code"><code>package org.example;

public class RequestLine {
    public RequestLine(String requestLine){


    }
}</code></pre><figure id="39e42694-242a-479d-9397-ec1a8e11506a" class="image"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-21_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_11.01.43.png"><img style="width:3564px" src="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-21_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_11.01.43.png"/></a></figure><p id="b2f3dc91-50e4-4066-8edf-448292c752a8" class="">테스트 코드 정상 통과</p><p id="b9ab5e5c-ea9e-402d-a091-dffad04f4082" class="">
</p><p id="daeae527-0fe9-41c1-ae1b-c24e6c2bf733" class="">
</p><p id="68902569-2e97-4c0f-be58-706450c5835d" class="">RequestLine 클래스에서 split 할 수 있는 기능 부여</p><pre id="6187a96f-ab1b-461c-aff9-f94a0f7a963c" class="code"><code>package org.example;

public class RequestLine {
    private final String method; //GET이 들어갈 예정
    private final String urlPath; // 결로 + QueryString이 들어갈 예정

    private String queryString;

public RequestLine(String method, String urlPath, String queryString){
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    public RequestLine(String requestLine){
        //GET /calculate?operand1=11&amp;operator=*&amp;oeprand2=55 HTTP/1.1
        
    String[] tokens = requestLine.split(&quot; &quot;);
    this.method = tokens[0];
    String[] urlPathTokens = tokens[1].split(&quot;//?&quot;);
    this.urlPath = urlPathTokens[0];
    if(urlPathTokens.length == 2){
        this.queryString = urlPathTokens[1];
    }
    }
}</code></pre><p id="ba26ab73-fac1-4014-86e6-dd0364ad7dfd" class="">이렇게 만들어서 RequestLineTest 테스트 진행해보았는데</p><pre id="1fe5abe4-1dcb-485e-9c70-98c0805591ec" class="code"><code>package org.example;

import org.example.RequestLine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {

    @Test
    void create(){
       RequestLine requestLine = new RequestLine(&quot;GET /calculate?operand1=11&amp;operator=*&amp;oeprand2=55 HTTP/1.1&quot;);

       assertThat(requestLine).isNotNull();
       assertThat(requestLine).isEqualTo(new RequestLine(&quot;GET&quot;,&quot;/calculate&quot;,&quot;operand1=11&amp;operator=*&amp;oeprand2=55&quot;));
    }
}</code></pre><p id="97c58a62-e38d-467e-97b7-12fb2d6f5863" class="">갑자기 발생한 오류</p><pre id="1f02be6d-225a-4371-87d3-5e46786c31f4" class="code"><code>org.opentest4j.AssertionFailedError: 
expected: org.example.RequestLine@69fb6037
 but was: org.example.RequestLine@5f16132a
Expected :org.example.RequestLine@69fb6037
Actual   :org.example.RequestLine@5f16132a
&lt;Click to see difference&gt;</code></pre><p id="bd922750-81c7-4798-93cb-8d1057703776" class="">객체끼리 비교할 때는 equals() and hashCode()를 추가해야하는데, 이를 추가하지 않아서 발생한 듯 하다.</p><p id="7a8649cc-654b-4459-af41-4c93bab1f994" class="">그래서 이렇게 추가</p><pre id="072362cc-5855-4bf3-8ac1-20a26a78e5e2" class="code"><code>package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method; //GET이 들어갈 예정
    private final String urlPath; // 결로 + QueryString이 들어갈 예정

    private String queryString;


    public RequestLine(String method, String urlPath, String queryString){
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }
    public RequestLine(String requestLine){
        //GET /calculate?operand1=11&amp;operator=*&amp;oeprand2=55 HTTP/1.1

    String[] tokens = requestLine.split(&quot; &quot;);
    this.method = tokens[0];
    String[] urlPathTokens = tokens[1].split(&quot;//?&quot;);
    this.urlPath = urlPathTokens[0];
    if(urlPathTokens.length == 2){
        this.queryString = urlPathTokens[1];
    }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) &amp;&amp; Objects.equals(urlPath, that.urlPath) &amp;&amp; Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}</code></pre><figure id="49bfe951-5240-4815-8211-c3daaca9999d" class="image"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25AB_9.52.26.png"><img style="width:3580px" src="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25AB_9.52.26.png"/></a></figure><p id="6e7950e3-d979-4d5f-bf6d-ad5258e5f189" class="">정상적으로 두 객체가 같다고 나온 결과를 볼 수 있다.</p><p id="da5f3762-f0ec-4694-8cf5-82c66d9116b3" class="">
</p><p id="b452700b-f842-45ab-a0e6-e4bf9aa48e37" class="">우리가 원하는 건 더 나아가서, QueryString에서 operand 1,2 값과 operator 값이기 때문에 QueryString 객체를 추가해준다.</p><p id="b3dc434e-de29-491e-8dc8-eef9d833afff" class="">QueryString 클래스와 QueryStringTest 작성</p><p id="b6e7cba7-2c61-4bff-bd08-70ae33ebb321" class="">QueryString은 key와 value 값이 짝지어진 형태로 구성되기에</p><p id="a2e20c11-361b-4dbe-806e-66e10f49e128" class="">QueryStringsTest라는 클래스도 추가해준다. (리스트 형태 테스트)</p><p id="76b3db18-e870-4530-a65e-cd2c61d3c640" class="">
</p><blockquote id="a03e4388-a410-4472-8f45-4ea408bd5bcb" class="block-color-gray_background">한 줄 TIP</blockquote><blockquote id="6c0ab1fc-6097-49e9-b889-3a0a4f60ebe1" class="block-color-gray_background">command + option + L 은 자동정렬</blockquote><p id="3659f660-7ebb-4e2a-9a24-b0f9f5824b34" class="">
</p><pre id="8e625606-2358-43fd-988e-7a2fe050523a" class="code"><code>package org.example;

public class QueryString {


    private final String key;

    private final String value;

    public QueryString(String key, String value){
        this.key = key;
        this.value = value;

    }
}</code></pre><pre id="b6f7c951-fc6c-44e5-8747-009f7b6d0cdb" class="code"><code>package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
private List&lt;QueryString&gt; queryStrings = new ArrayList&lt;&gt;();
    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split(&quot;&amp;&quot;);
        Arrays.stream(queryStringTokens)
                .forEach(queryString -&gt; {
                    String[] values = queryString.split(&quot;=&quot;);
                    if (values.length != 2) {
                      throw new IllegalArgumentException(&quot;잘못된 QueryString 포맷을 가진 문자열입니다&quot;);
                    }

                    queryStrings.add(new QueryString(values[0], values[1]));
                });
    }
}</code></pre><pre id="725c282c-21ff-42e3-ae51-c02dd21393b2" class="code"><code>package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {
    @Test
    void createTest(){
        QueryStrings queryStrings = new QueryStrings(&quot;operand1=11&amp;operator=*&amp;operand2=55&quot;); //List&lt;QueryString&gt;

        assertThat(queryStrings).isNotNull();

    }

}</code></pre><p id="82872a04-4f57-410a-98f5-0133e17624f1" class="">차례대로 QueryString QueryStrings QueryStringTest 이다.</p><p id="13d06805-7b1b-47a7-a8e1-d9deb2401c86" class="">
</p><p id="73dba20d-1017-4f65-8cea-98e20780c69c" class="">CustomWebApplicationServer.class 에서 프로토콜을 출력해주는 부분을 이젠 지우고</p><p id="f589a671-57de-432c-b2a6-df6974f1a90f" class="">RequestLine 클래스를 완성했으므로</p><p id="2edb942c-2cf4-4c67-9ed8-1946c12a350f" class="">이젠 RequestLine과 Header 그리고 Body를 담을 수 있는 HttpRequest 클래스를 만들어줘야 한다.</p><pre id="6010d630-6e96-4cf6-9685-311e31d69724" class="code"><code>package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;

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
}</code></pre><p id="06ae6dc1-af25-48d4-a435-cc02458a2892" class="">밑에 처음보는 함수들은 CustomWebApplicationServer를 바꿔서 생긴 것이다.</p><pre id="d804d382-537f-47a1-af75-d7805253a7f7" class="code"><code>/**
                 * step1 - 사용자 요청을 메인 thread가 처리하도록 한다.
                 */

                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                   HttpRequest httpRequest = new HttpRequest(br);

                   if(httpRequest.isGetRequest() &amp;&amp; httpRequest.matchPath(&quot;/calculate&quot;)){
                       QueryStrings queryStrings = httpRequest.getQueryStrings();
                       int operand1 = Integer.parseInt(queryStrings.getValue(&quot;operand1&quot;));
                       String operator = queryStrings.getValue(&quot;operator&quot;);
                       int operand2 = Integer.parseInt(queryStrings.getValue(&quot;operand2&quot;));

                      int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));</code></pre><p id="fe9e5fee-0a38-4ddc-8042-b4b7cd8b2e4a" class="">이 부분을 바꿨는데, HttpRequest에서 br를 받아서 처리하도록 만들었기 때문에</p><p id="004e8da0-4dbd-4400-a64f-14e8ee7e399b" class="">요청의 형식이 같고 (GET) 경로가 같다면, 생성된 httpRequest로 부터 queryString을 추출하고</p><p id="bd06154f-3609-4c57-b65d-c55f0b428735" class="">각 operand와 operator를 추출하여 기존에 만들어놓은 calculate 클래스를 이용해 계산 결과를 만들어낸다.</p><p id="ecbdd717-5491-481d-95ef-c876c2411275" class="">아래는 httpRequest에서 함수를 추가함에 따라 requestLine에서 함수를 추가해준 것이다.</p><pre id="e25a4d2b-6709-4137-ad65-402d9150340c" class="code"><code>package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method; //GET이 들어갈 예정
    private final String urlPath; // 결로 + QueryString이 들어갈 예정

    private QueryStrings queryStrings;


    public RequestLine(String method, String urlPath, String queryStrings){
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryStrings);
    }
    public RequestLine(String requestLine){
        //GET /calculate?operand1=11&amp;operator=*&amp;operand2=55 HTTP/1.1

    String[] tokens = requestLine.split(&quot; &quot;);
    this.method = tokens[0];
    String[] urlPathTokens = tokens[1].split(&quot;\\?&quot;);
    this.urlPath = urlPathTokens[0];
    if(urlPathTokens.length == 2){
        this.queryStrings = new QueryStrings(urlPathTokens[1]);
    }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) &amp;&amp; Objects.equals(urlPath, that.urlPath) &amp;&amp; Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

    public boolean isGetRequest() {
        return &quot;GET&quot;.equals(this.method);
    }

    public boolean matchPath(String requestPath){
        return urlPath.equals(requestPath);

    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }
}</code></pre><p id="06c9e582-8621-4494-8976-c68b51921b76" class="">
</p><p id="e65c8d12-ab0f-41e8-b555-71485e151a6e" class="">HTTPRequest 가 완성이 되었기 때문에 이를 바탕으로 HttpResponse 객체를 만들어야한다. WAS가 하는 역할이 그렇지 않은가…</p><p id="1c4587cf-0eb7-490d-b887-4b62e854f826" class="">
</p><pre id="40c53831-597a-4599-a0ac-a6160c615fda" class="code"><code>package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;

public class HttpResponse {
    private static final Logger logger = LoggerFactory.getLogger(HttpResponse.class);

    private final DataOutputStream dos;

    public HttpResponse(DataOutputStream dos) {
        this.dos = dos;
    }

    public void response200Header(String contentType, int lengthOfBodyContent) {
        try {
            dos.writeBytes(&quot;HTTP/1.1 200 OK \r\n&quot;);
            dos.writeBytes(&quot;Content-Type: &quot; + contentType + &quot;;charset=utf-8\r\n&quot;);
            dos.writeBytes(&quot;Content-Length: &quot; + lengthOfBodyContent + &quot;\r\n&quot;);
            dos.writeBytes(&quot;\r\n&quot;);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void responseBody(byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}</code></pre><p id="88072719-6885-4548-8a0e-f9ba2bbbfd91" class="">간단하게 log값 출력하는 거, DataOutputStream을 생성자를 통해 받아줄 것이고, 헤더값 세팅하는 부분</p><p id="58527d5d-02c4-4d8a-9eea-898a53435e4c" class="">body 값 세팅하는 부분으로 구성된다.</p><p id="9fd6fabe-1b50-4eb9-8387-3b2cd4265fb1" class="">즉 CustomWebApplication에서는 HttpResponse에게 헤더하고 바디 만들어줘! 라고 하면 되는 것이다.</p><pre id="ff72921e-1987-4c53-8eb3-8e7f089238d6" class="code"><code>int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                      byte[] body = String.valueOf(result).getBytes();

                      HttpResponse response = new HttpResponse(dos);
                      response.response200Header(&quot;application/json&quot;, body.length);
                      response.responseBody(body);</code></pre><p id="98752024-8788-491d-b316-96b388e4d6e8" class="">이렇게 작성해주면 된다.</p><p id="f803ffee-b225-4ed8-b9e3-3385f3827ed2" class="">
</p><p id="938fc94e-93e8-457d-879b-266d8db8c745" class="">최종 CustomWebApplicationServer.class</p><pre id="629a0a0f-7eda-42de-8cc8-f01a6b15c595" class="code"><code>package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port; //포트번호

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class); //로그 표시를 위해

    public CustomWebApplicationServer(int port) { //생성자
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info(&quot;[CustomWebApplicationServer] started {} port.&quot;, port);

            Socket clientSocket;
            logger.info(&quot;[CustomWebApplicationServer] waiting for client.&quot;);

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info(&quot;[CustomWebApplicationServer] client connected!&quot;);

                /**
                 * step1 - 사용자 요청을 메인 thread기 처리하도록 한다.
                 */

                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                   HttpRequest httpRequest = new HttpRequest(br);

                   if(httpRequest.isGetRequest() &amp;&amp; httpRequest.matchPath(&quot;/calculate&quot;)){
                       QueryStrings queryStrings = httpRequest.getQueryStrings();
                       int operand1 = Integer.parseInt(queryStrings.getValue(&quot;operand1&quot;));
                       String operator = queryStrings.getValue(&quot;operator&quot;);
                       int operand2 = Integer.parseInt(queryStrings.getValue(&quot;operand2&quot;));
                        System.out.println(operand1);
                        System.out.println(operand2);
                        System.out.println(operator);
                      int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                      byte[] body = String.valueOf(result).getBytes();

                      HttpResponse response = new HttpResponse(dos);
                      response.response200Header(&quot;application/json&quot;, body.length);
                      response.responseBody(body);
                    }
                }

            }


        }
    }
}</code></pre><figure id="e1c0be91-ef32-4dc3-9af9-efcd8ef7e14f" class="image"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25AB_11.39.07.png"><img style="width:3578px" src="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25AB_11.39.07.png"/></a></figure><p id="9023f0dd-1287-47eb-b46c-b94dc046aebf" class="">연산 결과 테스트도 무사히 통과한 모습</p><figure id="9661c704-e9f3-4489-80ef-2ec7f08ff2eb" class="image"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25AB_11.59.03.png"><img style="width:3584px" src="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25AB_11.59.03.png"/></a></figure><p id="b4392576-a414-40a4-9735-4770848d70b4" class="">부호가 다른 연산임에도 정상작동</p><p id="8e4eb7c8-1e4c-4d3a-83b4-de3919892409" class="">
</p><p id="21c2d13d-eeb6-41cf-a421-d55b7c6308b1" class="">이렇게 Tomcat을 custom해서 만들어보았고, HTTP protocol이 어떻게 생겼나 살펴보았다.</p><p id="0a3059d2-fe6d-40d7-8c59-8ae1c98ad6d0" class="">
</p><figure id="0d24ec30-ad5d-4425-b7d1-6578fa987867"><div class="source"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2592%25E1%2585%25AA%25E1%2584%2586%25E1%2585%25A7%25E1%2586%25AB_%25E1%2584%2580%25E1%2585%25B5%25E1%2584%2585%25E1%2585%25A9%25E1%2586%25A8_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.03.53.mov">https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d6eced9a-cb62-4673-acdf-3abd6bff0ab2/%E1%84%92%E1%85%AA%E1%84%86%E1%85%A7%E1%86%AB_%E1%84%80%E1%85%B5%E1%84%85%E1%85%A9%E1%86%A8_2023-06-22_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2.03.53.mov</a></div></figure><p id="ca7e6579-7c7c-4037-a315-9994a23c22a6" class="">
</p><h1 id="2c44c3d7-fc4e-42db-a55a-68db9e3b1186" class="">step2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.</h1><p id="a597c80b-2531-4998-a23c-194505b18a04" class="">step1에서의 문제점은 client의 요청이 들어왔을 때, 해당하는 작업을 main thread에서 처리한다는 점이다.</p><p id="982337f7-06b9-4101-a344-ab23eac69ebd" class="">만약 main thread에서 해당 작업을 수행하며 blocking이 걸리면 다음 client 요청이 해당 client의 요청이 끝날 때까지 기다려야하는 심각한 문제가 발생한다.</p><p id="19ec21bb-6d29-4df7-bb5e-c771e5ae08df" class="">
</p><p id="02bfb056-2921-4d46-8138-75f2477842fc" class="">그래서 client의 요청이 들어왔을 때 main thread가 아닌 별도의 thread에서 동작할 수 있도록 수정해보고자 한다.</p><p id="48a2fc5d-81a1-4bfd-b298-753b6bb1117a" class="">client의 요청이 들어오면, 요청 별로 별도의 thread가 만들어지고 그 thread 별로 inputStream과 outputStream을 얻을 것이다.</p><p id="0422c8c6-fb68-4135-b8ef-1c117ee37861" class="">
</p><p id="bfe571bf-3d9e-4dd9-8d8b-f6ee8fa5d7be" class="">이 작업을 분리하기 위해 ClientRequestHandler 클래스를 만들고, CustomWebApplicationHandler에서 클라이언트 요청을 받는 부분 이후부터 가져온다.</p><p id="615dda19-639b-427c-8508-ba202661a94a" class="">기존의 CustomWebApplicationHandler는 이렇게 바뀌고</p><pre id="1257ff20-aabf-4539-a0fd-bc3ae32ee99c" class="code"><code>package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port; //포트번호

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class); //로그 표시를 위해

    public CustomWebApplicationServer(int port) { //생성자
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info(&quot;[CustomWebApplicationServer] started {} port.&quot;, port);

            Socket clientSocket;
            logger.info(&quot;[CustomWebApplicationServer] waiting for client.&quot;);

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info(&quot;[CustomWebApplicationServer] client connected!&quot;);

                /**
                 * step1 - 사용자 요청을 메인 thread기 처리하도록 한다.
                 * step2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
                 */

                new Thread(new ClientRequestHandler(clientSocket)).start();

            }


        }
    }
}</code></pre><p id="bb2a4bd4-107b-4a44-ba14-3a0f5d25310e" class="">이 아래가 새로 만든 ClientRequestHandler이다.</p><pre id="5e98a854-22a9-441a-891f-6812539971a2" class="code"><code>package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientRequestHandler implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);

    private final Socket clientSocket;

    public ClientRequestHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run(){

        logger.info(&quot;[ClientRequestHandler] new client {} started.&quot; , Thread.currentThread().getName());

        try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            DataOutputStream dos = new DataOutputStream(out);


            HttpRequest httpRequest = new HttpRequest(br);

            if (httpRequest.isGetRequest() &amp;&amp; httpRequest.matchPath(&quot;/calculate&quot;)) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();
                int operand1 = Integer.parseInt(queryStrings.getValue(&quot;operand1&quot;));
                String operator = queryStrings.getValue(&quot;operator&quot;);
                int operand2 = Integer.parseInt(queryStrings.getValue(&quot;operand2&quot;));
                System.out.println(operand1);
                System.out.println(operand2);
                System.out.println(operator);
                int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                byte[] body = String.valueOf(result).getBytes();

                HttpResponse response = new HttpResponse(dos);
                response.response200Header(&quot;application/json&quot;, body.length);
                response.responseBody(body);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}</code></pre><p id="9086b15f-b98c-477a-8ba5-5e4c3254ae60" class="">
</p><figure id="02cf51fe-7c5e-4953-a017-55e0d8b3b7bd" class="image"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.35.15.png"><img style="width:3536px" src="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.35.15.png"/></a></figure><p id="b4be1729-fa42-486e-915e-fa7d24ffa6a3" class="">
</p><figure id="739a28ee-cb3c-4fb6-9b37-a762ca6c4fd1" class="image"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.35.24.png"><img style="width:3582px" src="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.35.24.png"/></a></figure><p id="286b274a-be07-4913-94c0-8198fb5b6f20" class="">
</p><p id="45d695db-ab0f-4772-b94c-88220fbc8e54" class="">출력 결과에서 눈여겨봐야 할 점은 별도의 스레드로 실행되었다는 점이다. </p><p id="28884f03-0c20-4bb1-be9a-081103ca88f3" class="">더 이상의 문제는 없겠지….라고 생각할 수도 있지만, 사용자의 요청이 생성될 때마다 스레드를 새로 만들어서 문제가 발생한다.</p><p id="a3ac8388-ffa7-4dff-b9f2-396ed2ec6025" class="">Thread는 생성될 때마다 독립적인 stack 메모리 공간을 할당받는다. 이렇게 메모리를 할당받는 작업은 상당히 비싼 작업이다. 요청이 몰리게 되면 스레드를 굉장히 많이 생성할건데 이러면 메모리 할당처럼 비싼 작업이 많이 발생한다. 그래서 상당히 performance 면에서도 좋지 않고 CPU context switch 횟수가 증가해서 좋지는 않다.</p><p id="71529c2e-f9da-4dd3-a66a-45e56050c66d" class="">최악의 경우 서버의 리소스가 감당이 안되어 서버가 다운될 수 있다.</p><p id="0e067bd2-0d12-4b1e-b151-aa8ece274c17" class="">
</p><p id="950546da-2a24-4ba8-8698-716d2c177056" class="">그래서 우리는 thread를 고정된 개수만큼 생성해두고, 거기서 재활용하는 thread pool 개념을 적용해서 안정적으로 동작하게 해볼 것이다.</p><p id="6bf23ec7-745e-40cc-affd-7509d7a874a9" class="">
</p><h1 id="80d8109d-d6c7-4a8e-9112-c4b49207c59f" class="">step3 - Thread pool 적용</h1><pre id="138839f4-ea27-40b0-9d02-255fa7ade024" class="code"><code>private final ExecutorService executorService = Executors.newFixedThreadPool(10);</code></pre><p id="b474fff3-dc74-434c-8e6b-5c548bb8993b" class="">CustomWebApplicationServer에 newFixedThreadPool 이용해서 threadpool 만들기</p><pre id="60e5aa35-70a9-4a9e-9435-2dc18731937c" class="code"><code>package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {
    private final int port; //포트번호

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class); //로그 표시를 위해

    public CustomWebApplicationServer(int port) { //생성자
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info(&quot;[CustomWebApplicationServer] started {} port.&quot;, port);

            Socket clientSocket;
            logger.info(&quot;[CustomWebApplicationServer] waiting for client.&quot;);

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info(&quot;[CustomWebApplicationServer] client connected!&quot;);

                /**
                 * step1 - 사용자 요청을 메인 thread기 처리하도록 한다.
                 * step2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
                 */
               
                executorService.execute(new ClientRequestHandler(clientSocket));

            }


        }
    }
}</code></pre><p id="454931c4-3938-47c3-bd77-d0789cc8e229" class="">
</p><figure id="a347cd39-62df-4aa8-b0e6-f3fd3db5036b" class="image"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.45.47.png"><img style="width:3540px" src="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2023-06-22_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.45.47.png"/></a></figure><p id="e175ab42-564e-4cc3-b583-9ea24afbc1a1" class="">new client pool-1-thread-1 started. 라고 뜬 것을 보아 thread pool이 정상동작하고 있는 것을 볼 수 있다.</p><p id="88d730c6-72ae-4a3c-834d-41f036fb589f" class="">
</p><p id="cf3f1935-fb92-47cb-8578-af3b26916bc9" class="">이 부분은 사실 Tomcat을 사용하면 개발자가 직접 구현을 하지 않아도 되는 부분이지만, 어떻게 동작하고 어떻게 구현하면 되는지를 살펴보았다.</p><p id="dce558c6-a866-487c-88be-29b924729de6" class="">
</p><h1 id="3bbf9235-9d7b-4367-9bea-eb1d8d552a12" class="">CGI 프로그램과 서블릿</h1><p id="21a4d0cb-841d-4449-ab07-5d7f2d1e63ee" class="">CGI(Common Gateway Interface)</p><ul id="17947935-dafd-4b33-ba59-5db0e684d1a2" class="bulleted-list"><li style="list-style-type:disc">웹 서버와 애플리케이션 사이에 데이터를 주고받는 규약</li></ul><ul id="ad6a8843-adb0-4e12-a9c2-071ef7acf0cd" class="bulleted-list"><li style="list-style-type:disc">CGI 규칙에 따라서 만들어진 프로그램을 CGI 프로그램이라고 한다.</li></ul><ul id="42b2d90f-ad93-470b-a139-e09b568cc841" class="bulleted-list"><li style="list-style-type:disc">CGI프로그램 종류로는 <strong>컴파일 방식(C,C++,Java 등)</strong>과 <strong>인터프리터 방식(PHP, Python)</strong>이 있다.</li></ul><p id="2c8ff994-6f7f-4f64-95d0-f7e2c993ebbf" class="">
</p><p id="150c36c9-abfe-4630-abd0-7ceb7ce3d4e7" class="">인터프리터 방식 CGI 프로그램</p><ul id="b97e2516-4f94-4674-bd6b-0ed89f5165c8" class="bulleted-list"><li style="list-style-type:disc">Web Server는 Script engine을 수행시키며 Script engine은 해당 Script 파일을 해석하여 웹 서버에게 결과값을 리턴한다. 이 그림에서 웹 서버와 스크립트 엔진 사이에 CGI규칙을 통해서 통신하는 모습을 볼 수 있다.</li></ul><figure id="a7609818-f163-40ab-9e2d-bb7dcf46b70a" class="image"><a href="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/Untitled_(Draft)-6.jpg"><img style="width:1512px" src="%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%8B%E1%85%A2%E1%84%91%E1%85%B3%E1%86%AF%E1%84%85%E1%85%B5%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB%E1%84%8B%E1%85%B4%20%E1%84%8B%E1%85%B5%E1%84%92%E1%85%A2%20%E1%84%80%E1%85%A8%E1%84%89%E1%85%A1%E1%86%AB%E1%84%80%E1%85%B5%20%E1%84%8B%E1%85%B0%E1%86%B8%20%E1%84%91%E1%85%B3%E1%84%85%E1%85%A9%E1%84%80%E1%85%B3%E1%84%85%E1%85%A2%E1%86%B7%20f4ac8efe34e6462b97baa0f7140f96b0/Untitled_(Draft)-6.jpg"/></a></figure><p id="2664e5af-cf00-43f5-8c41-a3e93c9a7a29" class="">Servlet과 Servlet Container에서도 동일하게 규칙이 적용된다. 웹 서버와 서블릿 컨테이너 사이에는 CGI 규칙에 따라서 데이터를 주고받는다. 개발자는 더이상 CGI 규칙에 대해 알 필요가 없다.</p><p id="74b2af4f-4e7b-4e2c-842d-e52df9a2dc1f" class="">대신 서블릿 컨테이너와 서블릿 파일 사이의 규칙을 알고 있어야 한다.</p><p id="de24728c-7b57-4bc6-9529-d0bf7e1224e4" class="">둘 다 server와 파일 사이에서 조정을 수행하는데 한쪽은 엔진이고 왜 한쪽은 컨테이너냐 하면</p><p id="5932ea65-ef22-475d-9316-c19aa07f4be4" class="">보통 라이프 사이클을 관리하면 컨테이너라 한다.</p><p id="dcbdcbe4-bcc4-430d-9c09-19e543e71411" class="">
</p><h2 id="b9bcebf5-16a1-48d0-b6d6-6c02511890aa" class="">서블릿</h2><p id="30c205c3-b786-49c7-8701-c6057c91f2d7" class="">servlet(Server + Applet의 합성어)</p><p id="ebdf1493-ffa9-4771-b380-e51cae6a90fc" class="">간단하게 이야기해서 자바에서 웹 애플리케이션을 만드는 기술</p><p id="b2cf3450-d2f3-4882-b53f-d285bd60f1bf" class="">동적인 웹 페이지를 구현하기 위한 표준</p><p id="00f62c22-f6eb-4f18-98cc-30f8af1d35f5" class="">
</p><h2 id="fd3aab04-dbfc-46c3-884b-ffc5dda59c6e" class="">ServletContainer</h2><p id="8a2dd2ac-4bd7-48d9-adc4-20c7904ea212" class="">서블릿의 생성부터 소멸까지의 라이프사이클을 관리하는 역할</p><p id="7b7b6a3e-d1a6-461f-a95c-56eb6575ad81" class="">서블릿 컨테이너는 웹 서버와 소켓을 만들고 통신하는 과정을 대신 처리해준다.</p><p id="674899ce-31ff-45e6-a36e-7c48b58eea26" class="">개발자는 비즈니스 로직에만 집중하면 된다.</p><p id="45928ac0-ffa0-40e2-92e6-4990d37250ca" class="block-color-orange_background"><strong>서블릿 객체를 싱글톤으로 관리(인스턴스 하나만 생성하여 공유하는 방식)</strong></p><p id="c854c9b9-13ad-4b8a-8ce0-7dc11c2e4f6b" class="block-color-orange_background"><strong>-상태를 유지(stateful)하게 설계하면 안됨</strong></p><p id="f83356ed-69dc-42ea-9034-f55fcfaab613" class="">-Thread safety하지 않음</p><pre id="bb2ede1e-e146-4c65-b1f7-d52708022516" class="code"><code>package org.example.counter;

//싱글톤 객체는 상태를 유지하게 설계하면 안된다!!
public class Counter implements Runnable{
    private int count = 0; // 상태값

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }

    public int getValue(){
        return count;
    }

    @Override
    public void run(){
      this.increment();
        System.out.println(&quot;Value for Thread After increment &quot; + Thread.currentThread().getName() + &quot; &quot; + this.getValue());
        this.decrement();
        System.out.println(&quot;Value for Thread at last &quot; + Thread.currentThread().getName() + &quot; &quot; + this.getValue());

    }

}</code></pre><p id="e2c1748e-4f14-4d65-91ed-dd9a69ce3130" class="">
</p><pre id="b84efac1-d49e-4c4b-9f52-d7107bf4253c" class="code"><code>package org.example.counter;

public class RaceConditionDemo {
    public static void main(String[] args) {
        Counter counter = new Counter(); // 하나의 자원을 공유하면 race condition이 발생
        Thread t1 = new Thread(counter, &quot;Thread-1&quot;);
        Thread t2 = new Thread(counter, &quot;Thread-2&quot;);
        Thread t3 = new Thread(counter, &quot;Thread-3&quot;);

        t1.start();
        t2.start();
        t3.start();
    }
}</code></pre><p id="c72fb3ca-d208-4ce9-bd6a-36ef73a1b93f" class="">위의 Counter 클래스를 바탕으로 아래 RaceConditionDemo를 실행시키면 다음과 같은 결과가 나온다.</p><pre id="573eda09-2ae1-42c4-ba4a-aec69ba0726f" class="code"><code>/Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home/bin/java -javaagent:/private/var/folders/k0/vk4qjwsj5t16r8_qc2jztf_m0000gn/T/AppTranslocation/7BA4893C-D55E-436C-9D4F-EA4D3B30B606/d/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=54102:/private/var/folders/k0/vk4qjwsj5t16r8_qc2jztf_m0000gn/T/AppTranslocation/7BA4893C-D55E-436C-9D4F-EA4D3B30B606/d/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/jinyongyun/Downloads/was-practice/out/production/classes:/Users/jinyongyun/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-classic/1.2.3/7c4f3c474fb2c041d8028740440937705ebb473a/logback-classic-1.2.3.jar:/Users/jinyongyun/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-core/1.2.3/864344400c3d4d92dfeb0a305dc87d953677c03c/logback-core-1.2.3.jar:/Users/jinyongyun/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.25/da76ca59f6a57ee3102f8f9bd9cee742973efa8a/slf4j-api-1.7.25.jar org.example.counter.RaceConditionDemo
Value for Thread After increment Thread-3 3
Value for Thread After increment Thread-1 1
Value for Thread After increment Thread-2 2
Value for Thread at last Thread-1 1
Value for Thread at last Thread-3 2
Value for Thread at last Thread-2 0

Process finished with exit code 0</code></pre><p id="ad47fa93-4009-4e3e-8684-b823de754c19" class="">분명 예상대로라면 전부 111에 000이 나와야 하지만, race condition 상황(여러 스레드가 하나의 자원에 접근하기 위해 경쟁)이 발생하여 문제가 발생한다.</p><p id="8854bd90-97f9-4624-8647-e018d9efa2bd" class="">즉 싱글톤 객체에서 상태를 유지할 수 있도록 설계하면 문제가 발생한다. 이 부분을 동기화(Synchronization) 시켜주면 안전하게 처리할 수도 있다.</p><pre id="71bb7e8b-8f7a-42b2-9f59-b31bf99baa05" class="code"><code>package org.example.counter;

//싱글톤 객체는 상태를 유지하게 설계하면 안된다!!
public class Counter implements Runnable{
    private int count = 0; // 상태값

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }

    public int getValue(){
        return count;
    }

    @Override
    public void run(){
        synchronized (this) {
            this.increment();
            System.out.println(&quot;Value for Thread After increment &quot; + Thread.currentThread().getName() + &quot; &quot; + this.getValue());
            this.decrement();
            System.out.println(&quot;Value for Thread at last &quot; + Thread.currentThread().getName() + &quot; &quot; + this.getValue());

        }
    }

}</code></pre><p id="77795014-afe7-49fc-ad7d-9ceb4bc7a8cf" class="">이렇게 간단하게 동기화 처리를 해주면</p><pre id="116fdd14-d491-418d-ac07-5265124b480e" class="code"><code>/Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home/bin/java -javaagent:/private/var/folders/k0/vk4qjwsj5t16r8_qc2jztf_m0000gn/T/AppTranslocation/7BA4893C-D55E-436C-9D4F-EA4D3B30B606/d/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=54112:/private/var/folders/k0/vk4qjwsj5t16r8_qc2jztf_m0000gn/T/AppTranslocation/7BA4893C-D55E-436C-9D4F-EA4D3B30B606/d/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/jinyongyun/Downloads/was-practice/out/production/classes:/Users/jinyongyun/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-classic/1.2.3/7c4f3c474fb2c041d8028740440937705ebb473a/logback-classic-1.2.3.jar:/Users/jinyongyun/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-core/1.2.3/864344400c3d4d92dfeb0a305dc87d953677c03c/logback-core-1.2.3.jar:/Users/jinyongyun/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.25/da76ca59f6a57ee3102f8f9bd9cee742973efa8a/slf4j-api-1.7.25.jar org.example.counter.RaceConditionDemo
Value for Thread After increment Thread-1 1
Value for Thread at last Thread-1 0
Value for Thread After increment Thread-3 1
Value for Thread at last Thread-3 0
Value for Thread After increment Thread-2 1
Value for Thread at last Thread-2 0

Process finished with exit code 0</code></pre><p id="f1d5e771-a843-4f26-8f49-68fc661ab854" class="">이렇게 우리가 기대했던 결과가 나온다.</p><p id="b24ed1a5-08db-4c4c-9861-08cde83dcb41" class="">
</p><p id="c2cf3352-abdd-4d46-8134-59ead6183d5f" class="">우리가 앞에서 WAS를 만들어봤는데 그 과정을 대신 해주는 것이 바로 SevletContainer라고 보면 된다.</p><p id="56e7c27b-f0c9-479e-95c5-b1be3ca9cfe5" class="">
</p><h2 id="f95fe64c-1962-4e15-9d8e-2d61d24503f1" class="">WAS   VS   서블릿 컨테이너</h2><p id="05e63a48-1ea6-4d7f-9ef1-0e705a04673c" class="">WAS는 서블릿 컨테이너를 포함하는 개념</p><p id="7ad3bfc8-75d3-43b8-83de-62f4e87b8b06" class="">WAS는 매 요청마다 스레드 풀에서 기존 스레드를 사용함</p><p id="7396f2e3-5a0c-4c2d-a861-b23b2b2652c6" class="">WAS의 주요 튜닝 포인트는 max thread 수</p><p id="08c43053-57f7-4572-92e0-c1ee2e2ce61f" class="">대표적인 WAS로는 톰캣이 있다.</p><p id="0cf793a5-7e4a-4294-9293-d99f251ecd66" class="">
</p><h1 id="d399ecca-3dc0-406f-8627-88ebd2024f11" class="">계산기 서블릿 만들기</h1><h2 id="71334648-4c62-4ae7-81da-402084868e4e" class="">Servlet 인터페이스</h2><p id="eb059e31-d3be-4b4d-9ae5-8c49f5ef3f1f" class="">서블릿 인터페이스가 서블릿 인터페이스에 있는 메소드들을 호출한다.</p><p id="d2a7ea78-5ee3-462f-8af4-bb9e9cc4fc22" class="">서블릿 생명주기와 관련된 메소드</p><ul id="a3b6a452-f22d-4a08-83af-4462e1679934" class="bulleted-list"><li style="list-style-type:disc">init() : 서블릿 컨테이너가 서블릿 생성 후 초기화 작업을 수행하기 위해 수행하는 메서드</li></ul><ul id="efcce66c-5373-4168-93cb-901ff08c65c6" class="bulleted-list"><li style="list-style-type:disc">service() : 클라이언트 요청이 들어올 때마다 서블릿 컨테이너가 호출하는 메서드</li></ul><ul id="d5da07b5-a6da-498c-bf04-103e584c0005" class="bulleted-list"><li style="list-style-type:disc">destroy() : 서블릿 컨테이너가 종료될 때 호출하는 메서드</li></ul><p id="6d0dd774-ac49-4ffc-a721-e5caa836164f" class="">서블릿 기타 메소드</p><ul id="66ba406a-2bb5-41cd-887a-d971a8728368" class="bulleted-list"><li style="list-style-type:disc">getServletConfig() : 서블릿 초기 설정 정보를 담고 있는 객체를 반환하는 메서드 (서블릿 이름과 서블릿 초기 매개변수 값을 얻을 수 있다.)</li></ul><ul id="9eb82559-4b1a-4575-853e-03e5fb4f6405" class="bulleted-list"><li style="list-style-type:disc">getServletInfo() : 서블릿을 작성한 사람, 서블릿 버전 ,저작권과 같은 서블릿에 대한 정보를 반환하는 메서드</li></ul><p id="0db17b22-82cb-4961-a6a8-a6cecfd813f8" class="">
</p><p id="d827452b-7036-4fad-8d1d-f893d3f2eab7" class="">기존 계산기 프로그램을 </p><p id="2c30e98e-6b2a-4dae-a3be-6b922e3529dd" class="">Servlet → GenericServlet → HttpServlet 순으로 수정 </p><pre id="a50c381b-65f0-47e7-b1f6-96d19c7553b8" class="code"><code>package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServerLauncher {
    private static final Logger logger = LoggerFactory.getLogger(WebApplicationServerLauncher.class);

    public static void main(String[] args) throws Exception {
        // 내장 톰캣
        String webappDirLocation = &quot;webapp/&quot;;
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp(&quot;/&quot;, new File(webappDirLocation).getAbsolutePath());
        logger.info(&quot;configuring app with basedir: {}&quot;, new File(&quot;./&quot; + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}</code></pre><pre id="ff0078c6-26e9-4b1b-ac00-852978129f0c" class="code"><code>package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(&quot;/calculate&quot;)
public class CalculatorServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(&quot;service&quot;);
        int operand1 = Integer.parseInt(request.getParameter(&quot;operand1&quot;));
        String operator = request.getParameter(&quot;operator&quot;);
        int operand2 = Integer.parseInt(request.getParameter(&quot;operand2&quot;));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }
}</code></pre><p id="1f9bff1d-1184-4572-a87f-d7c6975619b1" class="">
</p></div></article></body></html>
