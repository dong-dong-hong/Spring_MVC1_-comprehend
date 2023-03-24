package hello.servlet.web.frontController.v5.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.v5.ControllerV5;

import java.util.List;
import java.util.Map;

public class MemberListControllerV5 implements ControllerV5 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.finall();

        model.put("members",members);
        return "members";
    }
}
