package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuRequestDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuResponseDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    /* 1. 특정 메뉴 코드로 메뉴 조회 */
    @GetMapping("/{menuCode}")
    public ResponseEntity<MenuResponseDTO> findMenuByMenuCode (@PathVariable int menuCode){

        MenuResponseDTO resultMenu = menuService.findMenuByMenuCode(menuCode);

        // ResponseEntity.ok() : 상태 코드 200(ok)와 함께 JSON 변환
        return ResponseEntity.ok(resultMenu);
    }

    /* 2. 메뉴 목록 조회 (메뉴 코드기준 내림차순 정렬) */
//    @GetMapping
//    public ResponseEntity<List<MenuResponseDTO>> findMenuList(){
//
//        List<MenuResponseDTO> menuList = menuService.findMenuList();
//
//        return ResponseEntity.ok(menuList);
//    }

    /* 페이징 처리된 메뉴 목록 조회 */
    @GetMapping                                           // default값을 지정해줌
    public ResponseEntity<Page<MenuResponseDTO>> findMenuList(@PageableDefault(size = 30, sort = "menuCode")Pageable pageable){

        Page<MenuResponseDTO> menuList = menuService.findMenuList(pageable);

        return ResponseEntity.ok(menuList);
    }

    /* 메뉴 가격으로 메뉴 목록 조회 */
    @GetMapping("/search")
    public ResponseEntity<List<MenuResponseDTO>> findByMenuPrice(@RequestParam Integer menuPrice){

        List<MenuResponseDTO> menuList = menuService.findMenuByMenuPrice(menuPrice);

        return ResponseEntity.ok(menuList);
    }
    /* 메뉴 가격으로 메뉴 목록 조회 (페이징 적용) */
    @GetMapping("/search_paging")
    public ResponseEntity<Page<MenuResponseDTO>> findByMenuPrice(
            @RequestParam Integer menuPrice, Pageable pageable){

        Page<MenuResponseDTO> menuList = menuService.finByMenuPriceSort(menuPrice,pageable);

        return ResponseEntity.ok(menuList);
    }

    /* 모든 카테고리 목록 조회 */
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> findCategoryList(){

        List<CategoryDTO> categoryDTOSList = menuService.findAllCategory();

        return ResponseEntity.ok(categoryDTOSList);
    }

    /* 메뉴 등록 */
    @PostMapping
    public ResponseEntity<MenuResponseDTO> registMenu(@RequestBody MenuRequestDTO requestDTO){

        MenuResponseDTO newMenu = menuService.registMenu(requestDTO);

        // 신규 리소스 생성 시 201 Created 상태 코드 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(newMenu);
    }

    /* 메뉴 수정 */
    @PutMapping("/{menuCode}")
    public  ResponseEntity<MenuResponseDTO> modifyMenu(@PathVariable int menuCode, @RequestBody MenuRequestDTO requestDTO){

        MenuResponseDTO updatedMenu = menuService.modifyMenu(menuCode,requestDTO);

        return ResponseEntity.ok(updatedMenu);
    }

    /* 메뉴 삭제 */
    @DeleteMapping("/delete/{menuCode}")
    public ResponseEntity<Void> deleteMenu(@PathVariable int menuCode){

        menuService.deleteMenu(menuCode);

        // 삭제 성공 시 내용 없이 204 No Content 응답
        return ResponseEntity.noContent().build();  // body값이 없을 때 .build()로 마무리
    }
}
