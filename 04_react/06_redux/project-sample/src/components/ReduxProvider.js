"use client"; 

import { Provider } from "react-redux";
import store from "@/Store"; // '@'는 src 폴더를 가리키는 절대 경로 별칭입니다.
                             

//  이 컴포넌트는 자식 컴포넌트(children)를 props로 받아서
//  react-redux의 Provider로 감싸주는 역할만 합니다.
export default function ReduxProvider({ children }) {
    return <Provider store={store}>{children}</Provider>;
}