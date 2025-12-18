import { fetchMenuAPI } from '../../apis/MenuAPICalls';

//   컴포넌트를 async 함수로 선언하는 것이 핵심!
async function Menu({ id }) {

    //  더 이상 Redux Store를 거치지 않습니다.
    //  서버에서 렌더링되는 시점에, 필요한 데이터를 직접 API로 호출해서 가져옵니다.
    console.log(`서버 컴포넌트 'Menu'에서 ${id}번 메뉴 데이터를 직접 fetching합니다...`);
    const menu = await fetchMenuAPI(id); // Redux Thunk 함수를 직접 호출해서 데이터를 받음

    /*
    const result = useSelector(state => state.menuReducer);
    const menu = result.menu;
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(callGetMenuAPI(id));
    }, []);

    이 모든 코드가 단 한 줄, 'const menu = await callGetMenuAPI(id)();'로 바뀌었습니다!
    서버 컴포넌트의 강력함!!
    */

    //   데이터가 없을 경우를 대비한 방어 코드
    if (!menu) {
        return <div>메뉴 정보를 찾을 수 없습니다.</div>;
    }

    return (
        <>
            <h3>메뉴 이름 : { menu.menuName }</h3>
            <h3>메뉴 가격 : { menu.menuPrice }</h3>
            <h3>메뉴 종류 : { menu.categoryName }</h3>
            <h3>메뉴 상세 : { menu.detail.description }</h3>
            <img src={ menu.detail.image } style={ { maxWidth: 500 } } alt={ menu.menuName }/>
        </>
    );
}

export default Menu;