import Link from 'next/link';

// 이 컴포넌트는 props로 데이터를 받아 그리기만 할 뿐, 자체적인 상태나 이벤트 핸들러가 없습니다.
// 따라서 기본값인 '서버 컴포넌트'로 유지하는 것이 성능에 가장 좋습니다.
function MenuItem({ menu }) {

    return (
        <Link href={ `/menu/${ menu.id }` }>
            <div className="menuItem">
                <h3>이름 : { menu.menuName }</h3>
                <h3>가격 : { menu.menuPrice }</h3>
                <h4>종류 : { menu.categoryName }</h4>
            </div>
        </Link>
    );
}

export default MenuItem;