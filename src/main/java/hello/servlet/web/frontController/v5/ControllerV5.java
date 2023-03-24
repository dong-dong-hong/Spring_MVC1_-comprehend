package hello.servlet.web.frontController.v5;

import java.util.Map;

public interface ControllerV5 {

    /**
     *
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String,String> paramMap,Map<String, Object> model);
}
