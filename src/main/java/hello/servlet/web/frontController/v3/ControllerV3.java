package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.modelView;

import java.util.Map;

public interface ControllerV3 {

    modelView process(Map<String,String> paramMap);
}
