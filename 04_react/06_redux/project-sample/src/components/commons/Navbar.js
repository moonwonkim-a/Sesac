"use client"; 

import { useEffect, useState } from 'react';
import Link from 'next/link'; 
import { useRouter, usePathname } from 'next/navigation'; 
import { useDispatch } from "react-redux";
import { resetLoginUser } from "../../modules/UserModule"

function Navbar() {

    const router = useRouter();
    const pathname = usePathname(); //   현재 URL 경로를 가져오는 훅
    const dispatch = useDispatch();


    // localStorage는 브라우저에만 존재합니다. 서버 렌더링 시점에는 localStorage가 없어서 에러가 날 수 있고,
    // 서버(로그아웃 상태)와 클라이언트(로그인 상태)의 초기 모습이 달라 'Hydration Mismatch' 경고가 발생할 수 있습니다.
    // 따라서, 컴포넌트가 클라이언트에 마운트된 후에 localStorage를 확인하도록 useEffect를 사용하는 것이 안전하고 표준적인 방법입니다.
    const [loginStatus, setLoginStatus] = useState(false);

    useEffect(() => {
        setLoginStatus(!!localStorage.getItem('isLogin'));
    }, [pathname]); //   페이지가 이동할 때마다 로그인 상태를 다시 확인하도록 pathname을 의존성에 추가합니다. (로그인/로그아웃 후 즉시 반영)


    /* 로그아웃 호출 시 localStorage 저장 값 삭제, userReducer 값 리셋, 루트로 새로고침  */
    const logoutHandler = () => {
        localStorage.removeItem('isLogin');
        dispatch(resetLoginUser());
        window.location.href = '/';
    }

    const isActive = (path) => pathname === path;

    return (
        <div>
            <ul>
                <li>
                    <Link href='/' style={{ color: isActive('/') ? 'red' : 'black' }}>
                        메인으로
                    </Link>
                </li>
                <li>
                    <Link href='/menu' style={{ color: isActive('/menu') ? 'red' : 'black' }}>
                        메뉴보기
                    </Link>
                </li>
                { !loginStatus ? (
                    <li>
                        <Link href='/login' style={{ color: isActive('/login') ? 'red' : 'black' }}>
                            로그인
                        </Link>
                    </li>
                ) : (
                    //   a 태그는 페이지를 새로고침 시키므로, 상호작용에는 button을 사용하는 것이 더 좋습니다.
                    <li><button onClick={ logoutHandler }>로그아웃</button></li>
                )
                }
            </ul>
        </div>
    );
}

export default Navbar;