package com.ohgiraffers.section03.annotationconfig;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.ohgiraffers")
public class ContextConfiguration {

    /* ComponentScan
    * basePackages로 설정된 하위 경로에 특정 어노테이션을 가지고 있는 클래스를bean으로 등록
    * @Component 어노테이션이 작성 된 클래스를 인식하여 bean으로 등록
    * 목적에 따라 @Controller, @Service, @Repository, @Configuration 등을 사용 */


}
