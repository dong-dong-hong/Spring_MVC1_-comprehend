package hello.servlet.web.frontController.v1;

import hello.servlet.web.frontController.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontController.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontController.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="fontControllerServletV1", urlPatterns = "/front-controller/v1/*") // /front-controller/v1를 포함한 하위 모든 요청은 이 서블릿에서 받아들인다.
                                                                                    // 예) /front-controller/v1/a ,  /front-controller/v1/a/b
public class FontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
        // controllerMap
        // key : 매핑 URL
        // value : 호출될 컨트롤러
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FontControllerServletV1.service");

        // /front-controller/v1/members
        String requestURI = request.getRequestURI();

//        ControllerV1 controller= new MemberListControllerV1();
        ControllerV1 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // service()
        // 먼저 requestURI를 조회해서 실제 호출할 컨트롤러 controllerMap에서 찾는다. 만약 없다면 404(SC_NOT_FOUND) 상태 코드를 반환한다.
        // 컨트롤러를 찾고 controller.process(request,response);을 호출해서 해당 컨트롤러를 실행한다.

        controller.process(request,response);
    }
}
