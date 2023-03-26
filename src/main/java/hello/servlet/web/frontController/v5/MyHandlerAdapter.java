package hello.servlet.web.frontController.v5;

import hello.servlet.web.frontController.modelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MyHandlerAdapter {

    boolean support(Object handler);

    modelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
