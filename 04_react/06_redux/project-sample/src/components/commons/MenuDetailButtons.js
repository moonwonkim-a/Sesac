"use client";

import { useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';
import { useSelector, useDispatch } from 'react-redux';
import { callDeleteMenuAPI } from '@/apis/MenuAPICalls';
import { resetStatus } from '@/modules/MenuModule';

export default function MenuDetailButtons({ id }) {
    const router = useRouter();
    const dispatch = useDispatch();
    const result = useSelector(state => state.menuReducer);
    const [loginStatus, setLoginStatus] = useState(false);

    useEffect(() => {
        setLoginStatus(!!localStorage.getItem('isLogin'));
    }, []);

    useEffect(() => {
        if (result.delete) {
            alert('메뉴 삭제');
            router.replace(`/menu`); 
            dispatch(resetStatus());
        }
    }, [result, router]);

    const updateHandler = () => router.push(`/menu/modify/${id}`);
    const deleteHandler = () => dispatch(callDeleteMenuAPI(id));

    return (
        <h1>
            { (loginStatus) &&
                <>
                    <button onClick={ updateHandler }>메뉴 수정</button>
                    <button onClick={ deleteHandler }>메뉴 삭제</button>
                </>
            }
        </h1>
    );
}