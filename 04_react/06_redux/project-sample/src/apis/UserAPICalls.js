import { createAsyncThunk } from '@reduxjs/toolkit';
import { request } from "./Api";

//   로그인 API 호출은 클라이언트 컴포넌트(LoginForm)에서 시작됩니다.
export const callLoginAPI = createAsyncThunk(
    'user/LOGIN',
    async (loginInfo, { rejectWithValue }) => {
        try {
            console.log('login api call...');

            // 여기서는 기존 json-server 구조를 가정하여 클라이언트 측 검증 로직을 시뮬레이션하지만,
            // 실제 프로젝트에서는 절대 이렇게 구현하면 안 됩니다!!

            // 실제로는 서버에서 처리해야 함
            const userList = await request('GET', '/user');
            const result = userList.find(user => user.id === loginInfo.id && user.password === loginInfo.password);

            if (!result) {
                //   서버가 '로그인 실패' 메시지를 반환했다고 가정
                return { message: 'LOGIN_FAIL' };
            }

            console.log('login result : ', result);
            return result; // 성공 시 이 값이 fulfilled 액션의 payload가 됩니다.

        } catch (error) {
            return rejectWithValue(error.response.data);
        }
    }
);