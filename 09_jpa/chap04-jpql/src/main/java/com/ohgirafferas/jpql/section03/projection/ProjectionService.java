package com.ohgirafferas.jpql.section03.projection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectionService {

    private ProjectionRepository projectionRepository;

    public ProjectionService(ProjectionRepository projectionRepository) {
        this.projectionRepository = projectionRepository;
    }

    @Transactional
    public List<Menu> singleEntityProjection(){

        List<Menu> menuList = projectionRepository.singleEntityProjection();

        menuList.get(0).setMenuName("이베리코 도토리묵");

        return menuList;
    }
}
