"use client"; //   훅과 이벤트 핸들러를 사용하므로 클라이언트 컴포넌트로 지정!

import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from "react-redux";
import { useRouter } from 'next/navigation'; 
import { callLoginAPI } from '../../apis/UserAPICalls';
import { resetLoginUser } from "../../modules/UserModule";

function LoginForm() {

    const router = useRouter(); 
    const dispatch = useDispatch();
    const result = useSelector(state => state.userReducer);

    //   localStorage는 브라우저 전용이므로, 클라이언트 컴포넌트에서만 접근 가능합니다.
    const [loginStatus, setLoginStatus] = useState(false);
    useEffect(() => {
        setLoginStatus(!!localStorage.getItem('isLogin'));
    }, [result]); // 로그인 성공/실패 시 상태를 다시 확인하도록 result를 의존성 배열에 추가

    const [loginInfo, setLoginInfo] = useState({
        id: '',
        password: ''
    });

    const onChangeHandler = (e) => {
        setLoginInfo({
            ...loginInfo,
            [e.target.name]: e.target.value
        });
    }

    const onClickHandler = () => {
        dispatch(callLoginAPI(loginInfo));
    }

    useEffect(() => {
        if(result?.message) {
            alert('아이디와 비밀번호를 확인해주세요');
            setLoginInfo({
                id: '',
                password: ''
            });
            dispatch(resetLoginUser());
        } else if(loginStatus) {
            router.push('/');
        }
    }, [result, loginStatus, dispatch, router]);

    return (
        <>
            <div>
                <label>ID : </label>
                <input type="text" name="id" value={ loginInfo.id } onChange={ onChangeHandler }/> &nbsp;&nbsp;&nbsp;
                <label>PASSWORD : </label>
                <input type="password" name="password" value={ loginInfo.password } onChange={ onChangeHandler }/>
                <button onClick={ onClickHandler }>로그인</button>
            </div>
        </>
    );
}

export default LoginForm;