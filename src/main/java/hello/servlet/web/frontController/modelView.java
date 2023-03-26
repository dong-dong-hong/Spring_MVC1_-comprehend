package hello.servlet.web.frontController;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter@Getter
public class modelView {
    private String viewName;
    private Map<String,Object> model = new HashMap<>();

    public modelView(String viewName) {
        this.viewName = viewName;
    }
}
