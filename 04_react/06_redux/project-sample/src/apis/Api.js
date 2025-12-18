import axios from 'axios';

// 하드코딩된 주소 대신, 환경 변수에서 API URL을 가져옵니다.
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
            throw error; // 에러를 다시 던져서 createAsyncThunk에서 처리할 수 있게 합니다.
        });
};