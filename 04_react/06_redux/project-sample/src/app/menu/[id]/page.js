import Menu from "@/components/items/Menu";
import MenuDetailButtons from "@/components/commons/MenuDetailButtons";

//   서버 컴포넌트는 params를 통해 URL의 동적 세그먼트 값(id)을 받을 수 있습니다.
export default async function MenuDetailPage({ params }) {
    const { id } = await params;


    return (
        <div>
            <h1>메뉴 상세</h1>

            {/*   버튼들은 상호작용이 필요하므로 클라이언트 컴포넌트로 분리하고 id를 넘겨줍니다. */}
            <MenuDetailButtons id={id} />

            {/*   메뉴 상세 정보 표시는 서버에서 미리 데이터를 가져와 렌더링합니다. */}
            <Menu id={id}/>
        </div>
    );
}

