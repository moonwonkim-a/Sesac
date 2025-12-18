// app/not-found.js
//  파일 이름이 not-found.js로 약속되어 있습니다.
//  Next.js가 경로를 찾지 못하면 이 파일을 자동으로 보여줍니다.

import Link from 'next/link'; 

export default function NotFound() {

    return (
        <>
            <h1>404 - Page Not Found</h1>
            <Link href={ '/' }>
                <span>메인으로 돌아가기</span>
            </Link>
        </>
    );
}