package hello.servlet.web.frontController.v3.controller;

import hello.servlet.web.frontController.modelView;
import hello.servlet.web.frontController.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public modelView process(Map<String, String> paramMap) {
        return new modelView("new-form");
    }
}
