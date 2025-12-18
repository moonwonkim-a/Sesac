import { configureStore } from '@reduxjs/toolkit';
import userReducer from "./modules/UserModule";
import menuReducer from "./modules/MenuModule";

//   configureStore 함수를 사용해서 스토어를 생성합니다.
const store = configureStore({
    reducer: {
        userReducer, // 키와 값이 같으면 userReducer: userReducer 처럼 쓰지 않아도 됩니다.
        menuReducer
    },
});

export default store;