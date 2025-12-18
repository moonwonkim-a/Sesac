"use client";

import { createSlice } from '@reduxjs/toolkit';
import { callLoginAPI } from '../apis/UserAPICalls'; // Thunk import

const initialState = {
    userInfo: null,
    error: null,
};

const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        resetLoginUser: () => initialState,
    },
    extraReducers: (builder) => {
        builder
            .addCase(callLoginAPI.fulfilled, (state, { payload }) => {
                if (payload.message) { // 로그인 실패
                    state.error = payload.message;
                    state.userInfo = null;
                } else { // 로그인 성공
                    //  API 호출이 성공하면, 리듀서에서 localStorage에 로그인 상태를 저장합니다.
                    //  (참고: 리듀서는 순수해야 한다는 원칙에 약간 어긋나지만, 기존 코드 동작을 유지하기 위한 방식)
                    localStorage.setItem("isLogin", true);
                    state.userInfo = payload;
                    state.error = null;
                }
            })
            .addCase(callLoginAPI.rejected, (state, { payload }) => {
                state.error = payload;
            });
    }
});

export const { resetLoginUser } = userSlice.actions;
export default userSlice.reducer;