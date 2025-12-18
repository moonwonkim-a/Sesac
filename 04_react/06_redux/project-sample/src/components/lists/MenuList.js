import MenuItem from '../items/MenuItem';
import { fetchMenuListAPI } from "../../apis/MenuAPICalls";

//   컴포넌트를 async 함수로 선언합니다.
async function MenuList() {

    /*
    const result = useSelector(state => state.menuReducer);
    const menuList = result.menulist;
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(callGetMenuListAPI());
    }, []);

    Redux Store를 거치고, useEffect를 통해 클라이언트에서 데이터를 가져오던 이 모든 과정이...
    */

    //  ...바로 이 한 줄로 대체됩니다!
    //  서버에서 렌더링되는 시점에, 필요한 메뉴 목록 데이터를 직접 API로 호출해서 가져옵니다.
    console.log("서버 컴포넌트 'MenuList'에서 메뉴 목록 데이터를 직접 fetching합니다...");
    const menuList = await fetchMenuListAPI();

    //   데이터가 없을 경우를 대비한 방어 코드
    if (!menuList || menuList.length === 0) {
        return <div>표시할 메뉴가 없습니다.</div>;
    }

    return (
        <div className="menuBox">
            {/* 서버에서 미리 가져온 menuList 데이터를 사용해서 MenuItem들을 렌더링합니다. */}
            { menuList.map(menu => <MenuItem key={ menu.id } menu={ menu }/>) }
        </div>
    );
}

export default MenuList;