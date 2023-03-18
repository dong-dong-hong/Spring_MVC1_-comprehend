package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/*
 1. 파라미터 전송 기능
 http://localhost:8080/request-param?username=hello&age=20

 */
@WebServlet(name = "RequestParamServlet",  urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("RequestParamServlet.service");

        System.out.println("[전체 파라미터 조회] - start");
//        Enumeration<String> parameterNames = request.getParameterNames();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }
        response.getWriter().write("ok");
    }
    // 복수 파라미터에서 단일 파라미터 조히
    // username=hello&username=son과 같이 파라미터 이름은 하나인데, 같이 중복하면 어떻게 될까?
    // request.getParameter()는 하나의 파라미터 이름에 대해서 단 하나의 값만 있을 때 사용해야 한다. 지금처럼 중복일 때는 request.getParameterValues()를 사용해야 한다.
    // 참고로 이렇게 중복일 때 request.getParameter()를 사용하면 request.getParmeterValues()의 첫 번째 값을 반환한다.

}
