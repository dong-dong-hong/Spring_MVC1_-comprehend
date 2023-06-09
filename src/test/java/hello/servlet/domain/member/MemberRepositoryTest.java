package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
        // 회원을 저장하고, 목록을 조회하는 테스트를 작성했다.
        // 각 테스트가 끝날 때, 다음 테스트에 영향을 주지 않도록
        // 각 테스트의 저장소를 clearStore()를 호출해서 초기화했다.
    }

    @Test
    void save() {
        //given
        Member member = new Member("son", 26);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }
    @Test
    void findAll() {
        //given
        Member member1 = new Member("son", 26);
        Member member2 = new Member("son2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.finall();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);
    }
}