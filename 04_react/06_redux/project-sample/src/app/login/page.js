//   로그인 페이지 자체는 서버 컴포넌트로 둘 수 있습니다.
import LoginForm from '@/components/form/LoginForm'; 

export default function LoginPage() {
    //  기존의 로그인 여부 확인 후 리다이렉트 로직은 미들웨어나 상위 레이아웃에서 처리하는 것이 더 좋습니다.
    //  여기서는 일단 로그인 폼만 렌더링하는 역할에 집중합니다.
    return (
        <>
            <h1>로그인 페이지</h1>
            <LoginForm/>
        </>
    );
}