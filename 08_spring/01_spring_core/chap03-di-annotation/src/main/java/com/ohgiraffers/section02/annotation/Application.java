package com.ohgiraffers.section02.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();

        // No qualifying bean of type 'com.ohgiraffers.section02.common.Pokemon' available: expected single matching bean but found 3: charmander,pikachu,squirtle
        // 일치하는 빈이 하나 이상 발견되었지만, 어떤 빈을 사용할지 명확하게 지정되지 않았을 때 발생하는 error
        for(String bean : beanNames){
            System.out.println(bean);
        }

        PokemonService pokemonService = context.getBean(PokemonService.class);

        pokemonService.pokemonAttack();
    }
}
