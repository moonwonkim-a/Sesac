
# **Next.js 프로젝트 개발 환경 설정 가이드 (with Redux Toolkit)**

이 문서는 Next.js App Router 환경에서 Redux Toolkit을 사용한 상태 관리와 `json-server`를 이용한 Mock API 서버 구축 과정을 안내합니다.

## **1. Mock API 서버 구축 (json-server)**

프론트엔드 개발 시 실제 백엔드 API가 없어도 데이터를 주고받는 것처럼 테스트할 수 있는 가상 API 서버를 구축합니다.

### **1-1. json-server 설치 및 설정**

-   프로젝트 내부에 `mock`이라는 폴더를 생성하고, 그 안에 `db.json` 파일을 넣습니다. 이 파일이 우리의 데이터베이스 역할을 합니다.
-   `db.json` 파일에는 `menu`, `user`와 같은 데이터 키와 배열 형태의 데이터가 포함되어야 합니다. 각 데이터 객체는 고유한 `id` 속성을 갖는 것이 좋습니다.

### **1-2. json-server 실행**

-   `mock` 폴더를 기준으로 터미널을 열고, 아래 명령어를 입력하여 4000번 포트로 Mock API 서버를 실행합니다.

```bash
npx json-server ./db.json --port 4000
```

### **1-3. 실행 확인**

-   웹 브라우저에서 아래 URL로 접속하여 데이터가 정상적으로 표시되는지 확인합니다.

  -   `http://localhost:4000/menu` - 전체 메뉴 조회
  -   `http://localhost:4000/user` - 전체 유저 조회

![json-server-menu](./images/json-server-3.PNG)

## **2. 필수 라이브러리 설치**

Next.js 프로젝트에서 효율적인 상태 관리와 API 통신을 위해 필요한 라이브러리들을 설치합니다.

```bash
npm install @reduxjs/toolkit react-redux redux-logger axios
```

혹시 무한로딩 현상이 있다면 yarn으로 변경해서 설치합니다.
```bash
npm install -g yarn

yarn install

yarn add @reduxjs/toolkit react-redux redux-logger axios
```

| 라이브러리 | 역할                                                                                  |
| :--- |:------------------------------------------------------------------------------------|
| **`@reduxjs/toolkit`** | Redux 공식 라이브러리. Redux 핵심, DevTools, Thunk(비동기) 등 필수 기능이 모두 포함된 **만능 도구**입니다.        |
| **`react-redux`** | React 컴포넌트와 Redux Store를 연결해주는 라이브러리입니다. (`Provider`, `useSelector`, `useDispatch`) |
| **`redux-logger`** | Redux의 상태 변경을 콘솔에 로그로 남겨 디버깅을 도와주는 미들웨어입니다. (선택 사항이지만 강력 추천)                        |
| **`axios`** | API 요청을 보내기 위한 HTTP 클라이언트 라이브러리입니다. (Next.js의 내장 fetch를 사용할 수도 있습니다.)               |

## **3. API 요청 모듈 설정**

애플리케이션 전역에서 사용될 API 요청 관련 설정을 구성합니다.

### **3-1. 환경 변수 설정**

API 서버의 주소를 코드에 직접 작성하는 대신, 환경 변수로 관리하여 유연성과 보안을 높입니다.

-   프로젝트 최상위 폴더에 `.env.local` 파일을 생성하고 아래 내용을 추가합니다.

```
NEXT_PUBLIC_API_URL=http://localhost:4000
```

-   `NEXT_PUBLIC_` 접두사는 해당 변수가 서버와 브라우저(클라이언트) 양쪽에서 모두 접근 가능하도록 만들어줍니다.

### **3-2. `axios` 요청 인스턴스 생성 (`src/apis/Api.js`)**

`axios`를 사용하여 API 요청을 보내는 공통 함수를 정의합니다.

```javascript
// src/apis/Api.js

import axios from 'axios';

// 환경 변수에서 API 서버 URL을 가져옵니다.
const DOMAIN = process.env.NEXT_PUBLIC_API_URL;

export const request = async (method, url, data) => {
    return await axios({
        method,
        url : `${DOMAIN}${url}`,
        data
    })
      .then(res => res.data)
      .catch(error => {
        console.error(error);
        throw error; // 에러를 다시 던져서 호출한 쪽(예: createAsyncThunk)에서 처리할 수 있게 합니다.
      });
};
```

#### **HTTP 요청 메소드와 RESTful API**

-   **GET (Read)**: 데이터 조회 (예: `/menu` - 전체 메뉴 조회, `/menu/1` - 1번 메뉴 조회)
-   **POST (Create)**: 데이터 생성 (예: `/menu` - 메뉴 등록)
-   **PUT (Update)**: 데이터 전체 수정 (예: `/menu/1` - 1번 메뉴 수정)
-   **DELETE (Delete)**: 데이터 삭제 (예: `/menu/1` - 1번 메뉴 삭제)