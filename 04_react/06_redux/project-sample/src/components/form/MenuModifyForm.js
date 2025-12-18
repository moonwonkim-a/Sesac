"use client";

import { useState, useEffect } from 'react';
import { useRouter } from 'next/navigation';
import { useSelector, useDispatch } from 'react-redux';
import { callModifyMenuAPI, callGetMenuAPI } from '@/apis/MenuAPICalls';
import {resetStatus} from "@/modules/MenuModule"; 

//  페이지 컴포넌트로부터 id를 props로 전달받습니다.
function MenuModifyForm({ id }) {

    const dispatch = useDispatch();
    const router = useRouter(); 

    //  수정할 메뉴의 기존 정보를 불러와서 state에 채워줍니다.
    const menu = useSelector(state => state.menuReducer.menu);
    const modifyResult = useSelector(state => state.menuReducer.modify);

    const [modifyMenu, setModifyMenu] = useState({
        id: 0, 
        menuName: '',
        menuPrice: 0,
        categoryName: '한식',
        isOrderable: false,
        detail: {
            description: '',
            image: ''
        }
    });

    //   페이지가 로드될 때, id에 해당하는 메뉴 정보를 API로 요청합니다.
    useEffect(() => {
        dispatch(callGetMenuAPI(id));
    }, [dispatch, id]);

    //   API 요청으로 메뉴 정보(menu)를 받아오면, modifyMenu state를 업데이트합니다.
    useEffect(() => {
        if(menu) {
            setModifyMenu({
                id: menu.id,
                menuName: menu.menuName,
                menuPrice: menu.menuPrice,
                categoryName: menu.categoryName,
                isOrderable: menu.isOrderable,
                detail: {
                    description: menu.detail?.description || '',
                    image: menu.detail?.image || ''
                }
            });
        }
    }, [menu]);

    /* 입력 값 변경 시 이벤트 핸들러 */
    const onChangeHandler = (e) => {
        let name = e.target.name;
        let value = e.target.value;

        switch (name) {
            case 'menuPrice':
                value = parseInt(value) || 0; // 숫자로 변환 실패 시 0으로 처리
                break;
            case 'isOrderable':
                value = value === 'true'; // 문자열 'true'를 boolean true로 변환
                break;
            case 'description':
                name = 'detail';
                value = {
                    description: value,
                    image: modifyMenu.detail.image
                };
                break;
        }

        setModifyMenu({
            ...modifyMenu,
            id: id, // id는 항상 props에서 받은 값으로 유지
            [name]: value
        });
    }

    /* 파일 첨부 시 동작하는 이벤트 핸들러 */
    const fileChangeHandler = async (e) => {
        const file = e.target.files[0];
        const base64 = await convertBase64(file);
        setModifyMenu(
            {
                ...modifyMenu,
                detail : {
                    description : modifyMenu.detail.description,
                    image : base64
                }
            }
        );
    }

    /* FileReader API를 통해 input type="file"에 첨부 된 파일을 base64 인코딩 형식으로 변환 */
    const convertBase64 = (file) => {
        return new Promise((resolve, reject) => {
            const fileReader = new FileReader();
            fileReader.readAsDataURL(file)
            fileReader.onload = () => {
                resolve(fileReader.result);
            }
            fileReader.onerror = (error) => {
                reject(error);
            }
        })
    }

    useEffect(() => {
        if(modifyResult) {
            alert('메뉴 수정');
            // 다음 단계에서 추가할 초기화 로직
            router.push(`/menu`);
            // 초기화하는 액션 dispatch
            dispatch(resetStatus());
        }
    }, [modifyResult, router, dispatch]);

    const onClickHandler = () => {
        /* modifyMenu에 대한 유효성 검사 후 호출 */
        dispatch(callModifyMenuAPI(modifyMenu));
    }

    //   메뉴 정보가 로딩 중일 때 보여줄 UI
    if(!menu) {
        return <div>메뉴 정보를 불러오는 중입니다...</div>;
    }

    return(
        <>
            <h1>{ id }번 메뉴 수정</h1>
            <label>메뉴 이름 : </label>
            <input type="text" name="menuName" value={ modifyMenu.menuName } onChange={ onChangeHandler }/>
            <br/>
            <label>메뉴 가격 : </label>
            <input type="number" name="menuPrice" value={ modifyMenu.menuPrice } onChange={ onChangeHandler }/>
            <br/>
            <label>카테고리 : </label>
            <select name="categoryName" value={ modifyMenu.categoryName } onChange={ onChangeHandler }>
                <option>한식</option>
                <option>일식</option>
                <option>서양</option>
                <option>동양</option>
                <option>커피</option>
                <option>쥬스</option>
                <option>기타</option>
            </select>
            <br/>
            <label>판매 여부 : </label>
            <select name="isOrderable" value={ modifyMenu.isOrderable } onChange={ onChangeHandler }>
                <option value="true">판매 가능</option>
                <option value="false">판매 불가</option>
            </select>
            <br/>
            <label>설명 : </label>
            <textarea name="description" value={ modifyMenu.detail.description } onChange={ onChangeHandler }></textarea>
            <br/>
            <label>사진 : </label>
            <input
                type="file"
                name="image"
                accept='image/*'
                onChange={ fileChangeHandler }
            />
            <br/>
            <button onClick={ onClickHandler }>메뉴 수정</button>
        </>
    )
}

export default MenuModifyForm;