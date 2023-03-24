package hello.servlet.web.frontController.v5;

import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v5.controller.MemberFormControllerV5;
import hello.servlet.web.frontController.v5.controller.MemberListControllerV5;
import hello.servlet.web.frontController.v5.controller.MemberSaveControllerV5;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private Map<String, ControllerV5> controllerMap = new HashMap<>();

    public FrontControllerServletV5() {
        controllerMap.put("/front-controller/v5/members/new-form", new MemberFormControllerV5());
        controllerMap.put("/front-controller/v5/members/save", new MemberSaveControllerV5());
        controllerMap.put("/front-controller/v5/members", new MemberListControllerV5());
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV5 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        Map<String, String> paramMap = createParamMap(request);
        Map<String,Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);

        MyView view = viewResolver(viewName);
        view.render(model,request,response);
    }
    private MyView viewResolver(String viewName) {
        MyView view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        return view;
    }
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName,request.getParameter(paramName)));
        return paramMap;
    }


}
