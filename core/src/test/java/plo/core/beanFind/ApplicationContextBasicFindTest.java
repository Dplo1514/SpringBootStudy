package plo.core.beanFind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import plo.core.AppConfig;
import plo.core.member.MemberService;
import plo.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름 조회")
    void findBeanByName(){
        MemberService memberSerivce = ac.getBean("memberService", MemberService.class);
        //이름으로 찾아온 bean을 꺼내서 찾아온 후 값을 할당한 memberService의 할당 값이 MemberServiceImpl과 같은지 확인
        assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberSerivce = ac.getBean(MemberService.class);
        //타입으로 찾아온 bean을 꺼내서 찾아온 후 값을 할당한 memberService의 할당 값이 MemberServiceImpl과 같은지 확인
        assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByInstanceType(){
        MemberService memberSerivce = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 조회 실패")
    void findBeanByNameX(){
        //ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class ,
                () -> ac.getBean("xxxx", MemberService.class));
    }

}
