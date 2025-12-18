package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuRequestDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuResponseDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor    // final 필드만을 파라미터로 받는 생성자를 자동으로 생성 + 의존성 주입까지 해결
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    // @RequiredArgsConstructor 어노테이션이 자동으로 생성해주는 구문
//    public MenuService(MenuRepository menuRepository) {
//        this.menuRepository = menuRepository;
//    }

    /* 1. 메뉴 코드로 상세 조회 */
    public MenuResponseDTO findMenuByMenuCode(int menuCode){

        // orElseThrow : Optional 안에 값이 존재하지 않는 경우 정해놓은 예외를 즉시 발생
        Menu foundMenu = menuRepository.findById(menuCode).orElseThrow(
                () -> new IllegalArgumentException("메뉴가 존재하지 않습니다."));

        return modelMapper.map(foundMenu,MenuResponseDTO.class);    // ModelMapper 안의 내장 메소드 .map()
    }

    /* 2. 전체 메뉴 목록 조회 (내림차순) */
//    public List<MenuResponseDTO> findMenuList(){
//
//        // Sort.by("정렬기준") : 정렬기준으로 오름차순(기본)  .descending()를 붙히면 내림차순으로 변경
//        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending());
//
//        // Entity list 를 DTO list로 바꿀 때 많이 쓰는 방법
//        return menuList.stream()
//                .map(menu -> modelMapper.map(menu, MenuResponseDTO.class))
//                .collect(Collectors.toList());
//    }

    /* 전체 메뉴 목록 조회 (페이징 처리) */
    public Page<MenuResponseDTO> findMenuList(Pageable pageable){

        // 페이지 번호 보정
        int page = pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1;
        int size = pageable.getPageSize();
        String sortDir = "menuCode";

        // PageRequest 객체 생성 (페이지번호, 사이즈, 정렬방법)
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortDir).descending());

        // 조회 (findAll에 PageRequest를 넘기면 됨)
        Page<Menu> menuList = menuRepository.findAll(pageRequest);

        return menuList.map(menu -> modelMapper.map(menu, MenuResponseDTO.class));
    }

    /* 가격으로 검색 (쿼리 메소드) */
    public List<MenuResponseDTO> findMenuByMenuPrice (Integer menuPrice){
        // 쿼리 메소드 호출
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThanOrderByMenuPriceDesc(menuPrice);

        return  menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuResponseDTO.class))
                .collect(Collectors.toList());
    }

    public Page<MenuResponseDTO> finByMenuPriceSort (Integer menuPrice, Pageable pageable){

//        Sort sort = Sort.by("menuPrice").descending();

        Page<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice, pageable);

        return menuList.map(menu-> modelMapper.map(menu,MenuResponseDTO.class));
    }

    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();
        return categoryList.stream()
                .map(category -> modelMapper.map(category,CategoryDTO.class))
                .toList();
    }

    /* 메뉴 등록 */
    @Transactional
    public MenuResponseDTO registMenu(MenuRequestDTO requestDTO){

        Category category = categoryRepository.findById(requestDTO.getCategoryCode())
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 카테고리 입니다."));

        // DTO -> Entity 변환 (builder 패턴 사용)
        Menu newMenu = Menu.builder()
                .menuName(requestDTO.getMenuName())
                .menuPrice(requestDTO.getMenuPrice())
                .orderableStatus(requestDTO.getOrderableStatus())
                .category(category)
                .build();

        // 내부적으로 EntityManager.persist() 호출되어 영속성 컨텍스트로 들어간다.
        Menu savedMenu = menuRepository.save(newMenu);

        // 저장 후, 생성된 Entity를 다시 DTO로 변환하여 반환
        return modelMapper.map(savedMenu,MenuResponseDTO.class);
    }

    /* 메뉴 수정 */
    @Transactional
    public MenuResponseDTO modifyMenu(int menuCode, MenuRequestDTO requestDTO) {

        Menu foundMenu = menuRepository.findById(menuCode)
                .orElseThrow(() -> new IllegalArgumentException("수정할 메뉴가 존재하지 않습니다."));

        Category newCategory = categoryRepository.findById(requestDTO.getCategoryCode())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리 입니다."));

//        foundMenu.modifyMenuName(requestDTO.getMenuName());
//        foundMenu.modifyMenuPrice(requestDTO.getMenuPrice());

        foundMenu.modify(
                requestDTO.getMenuName(),
                requestDTO.getMenuPrice(),
                newCategory,
                requestDTO.getOrderableStatus()
        );

        return modelMapper.map(menuCode,MenuResponseDTO.class);
    }

    /* 메뉴 삭제 */
    @Transactional
    public void deleteMenu(int menuCode){

        if(!menuRepository.existsById(menuCode)){
            throw new IllegalArgumentException("삭제할 메뉴가 존재하지 않습니다.");
        }
        menuRepository.deleteById(menuCode);    // menuCode에 해당하는 데이터를 삭제
    }
}
