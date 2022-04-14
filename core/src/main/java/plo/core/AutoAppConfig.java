package plo.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import plo.core.member.MemberRepository;
import plo.core.member.MemoryMemberRepository;

@Configuration
//@component가 붙은 class의 bean을 스캔해서 자동으로 등록해준다.
//excludeFilters : 스캔해서 빈으로 등록하지 않을 조건을 설정해준다.
//basePackges : 지정한 패키지부터 bean스캔을 시작한다.
//basePackageClasses : 지정한 클래스의 패키지를 탐색 위치로 지정한다.
//탐색 위치를 지정을 안한다면? : @ComponentScan이 붙은 클래스의 패키지 위치부터 탐색을 시작한다.
//탐색위치 지정 권장 방법 : 위치를 따로 지정해주지 않고 @ComponentScan이 붙은 클래스를 패키지의 최상단에 두는 것
@ComponentScan(
        basePackages = "plo.core.member" ,
        basePackageClasses = AutoAppConfig.class ,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION , classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
