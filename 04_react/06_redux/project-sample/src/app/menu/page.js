// 데이터 fetching(MenuList)은 서버에서, 버튼 클릭 같은 상호작용은 클라이언트 컴포넌트에서 처리하도록 분리할 수 있습니다.

// 1. 서버에서 데이터 로딩
import MenuList from "@/components/lists/MenuList"; 

// 2. 상호작용을 위한 클라이언트 컴포넌트
import MenuHeader from "@/components/commons/MenuHeader"; 

export default function MenusPage() {

    return (
        <div>
            {/* 로그인 상태 확인 및 네비게이션 버튼은 클라이언트 컴포넌트에서 처리합니다. */}
            <MenuHeader/>

            {/* 메뉴 목록은 서버에서 미리 데이터를 가져와 렌더링할 수 있습니다. */}
            <MenuList/>
        </div>
    );
}

