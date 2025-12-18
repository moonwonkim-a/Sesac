import { createAsyncThunk } from '@reduxjs/toolkit';
import { request } from "./Api";

/* 1. 서버 컴포넌트 & 순수 데이터 조회를 위한 API 함수 (fetch...)      */
/*    - dispatch 없음, Redux와 무관                                     */
/*    - async/await으로 직접 호출해서 사용                               */

export const fetchMenuListAPI = async () => {
    const result = await request('GET', '/menu');
    return result;
}

export const fetchMenuAPI = async (id) => {
    const result = await request('GET', `/menu/${id}`);
    return result;
}

/* 2. 클라이언트 컴포넌트 & Redux 상태 관리를 위한 Thunk 함수 (call...) */
/*    - createAsyncThunk로 생성                                         */
/*    - dispatch로 호출해서 사용                                         */

//   MenuModifyForm에서 사용할 메뉴 상세 정보 조회용 Thunk!
export const callGetMenuAPI = createAsyncThunk(
    'menu/GET_MENU',
    async (id, { rejectWithValue }) => {
        try {
            const result = await request('GET', `/menu/${id}`);
            return result;
        } catch (error) {
            return rejectWithValue(error.response.data);
        }
    }
);

export const callRegistMenuAPI = createAsyncThunk(
    'menu/REGIST_MENU',
    async (menuData) => {
        const result = await request('POST', '/menu/', menuData);
        return result;
    }
);

export const callModifyMenuAPI = createAsyncThunk(
    'menu/MODIFY_MENU',
    async (menuData) => {
        const result = await request('PUT', `/menu/${menuData.id}`, menuData);
        return result;
    }
);

export const callDeleteMenuAPI = createAsyncThunk(
    'menu/DELETE_MENU',
    async (id) => {
        const result = await request('DELETE', `/menu/${id}`);
        return result;
    }
);