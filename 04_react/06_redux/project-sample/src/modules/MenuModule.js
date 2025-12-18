"use client";

import { createSlice } from '@reduxjs/toolkit';
// extraReducers에서 사용할 모든 Thunk 함수들을 import 합니다.
import { 
    callGetMenuAPI, 
    callRegistMenuAPI, 
    callModifyMenuAPI, 
    callDeleteMenuAPI 
} from '@/apis/MenuAPICalls';

/* 초기 state값 */
const initialState = {
    menu: null,
    regist: null,
    modify: null,
    delete: null
};

const menuSlice = createSlice({
    name: 'menu',
    initialState,
    reducers: {
        // CUD 작업 후, 결과를 초기화하여 다음 작업에 영향을 주지 않도록 합니다.
        resetStatus: (state) => {
            state.regist = null;
            state.modify = null;
            state.delete = null;
        }
    },
    // 3. extraReducers
    extraReducers: (builder) => {
        builder
            // 메뉴 상세 정보 조회 (GET)
            .addCase(callGetMenuAPI.fulfilled, (state, { payload }) => {
                state.menu = payload;
            })
            // 메뉴 등록 (POST)
            .addCase(callRegistMenuAPI.fulfilled, (state, { payload }) => {
                state.regist = payload;
            })
            // 메뉴 수정 (PUT)
            .addCase(callModifyMenuAPI.fulfilled, (state, { payload }) => {
                state.modify = payload;
            })
            // 메뉴 삭제 (DELETE)
            .addCase(callDeleteMenuAPI.fulfilled, (state, { payload }) => {
                state.delete = payload;
            }
        );
    }
});

// createSlice가 자동으로 만들어준 액션 생성 함수들을 export 합니다.
export const { resetStatus } = menuSlice.actions;
export default menuSlice.reducer;