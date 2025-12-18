"use client";

import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function MenuHeader() {
    const router = useRouter();
    const [loginStatus, setLoginStatus] = useState(false);

    useEffect(() => {
        setLoginStatus(!!localStorage.getItem('isLogin'));
    }, []);

    return (
        <h1>
            메뉴 목록
            {/* localStorage에 'isLogin'이 있을 때만 '메뉴 추가' 버튼이 보입니다! */}
            { (loginStatus) && <button onClick={ () => router.push(`/menu/regist`) }>메뉴 추가</button> }
        </h1>
    )
}