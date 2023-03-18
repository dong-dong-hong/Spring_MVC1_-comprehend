package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// application.properties -> logging.level.org.apache.coyote.http11=debug 해주면
// 요청 시 서버가 받은 HTTP 요청 메시지를 출력하는 것을 확인할 수 있다. 하지만 운영 서버x ->성능저하 (개발단계에서만 사용)
@WebServlet(name = "helloServlet", urlPatterns = "/hello") // 서블릿 애노테이션
// name : 서블릿 이름
// urlPatterns : URL 매핑
// 서블릿 이름이랑 매핑은 겹치면 안됨(중복x)
public class HelloServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("hello " + username);
    }
}
