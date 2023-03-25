package hello.servlet.web.frontController.v5.adapter;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean support(Object handler) {
        return false;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}
