package hello.servlet.web.frontController.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.modelView;
import hello.servlet.web.frontController.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public modelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.finall();

        modelView mv =  new modelView("members");
        mv.getModel().put("members",members);

        return mv;
    }
}
