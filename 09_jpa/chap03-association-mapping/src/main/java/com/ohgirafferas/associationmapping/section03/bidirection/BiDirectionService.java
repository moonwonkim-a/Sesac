package com.ohgirafferas.associationmapping.section03.bidirection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BiDirectionService {

    private BidirectionRepository bidirectionRepository;

    public BiDirectionService(BidirectionRepository bidirectionRepository) {
        this.bidirectionRepository = bidirectionRepository;
    }

    public Menu findMenu(int menuCode) {
        return bidirectionRepository.findMenu(menuCode);
    }

    @Transactional
    public Category findCategory(int categoryCode){
        Category category = bidirectionRepository.findCategory(categoryCode);
        System.out.println(category.getMenuList());
        System.out.println(category.getMenuList().get(0).getCategory());    // 양방향 참조 가능
        return category;
    }

}
