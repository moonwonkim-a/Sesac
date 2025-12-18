package com.ohgiraffers.section02.annotation;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private Pokemon pokemon;

    /* @Qualifier : 여러개의 빈(bean)객체중에 특정 객체를 이름으로 지정하는 어노테이션
    *  @Primary 어노테이션과 함께 쓰였을 때 @Qualifier가 우선으로 연결된다. */
    @Autowired
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }

}
