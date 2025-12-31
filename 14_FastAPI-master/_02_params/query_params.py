from fastapi import APIRouter

router = APIRouter(prefix='/query_params', tags=['query_params'])

# 쿼리매개변수
# - 경로매개변수가 아닌 매개변수는 쿼리매개변수로 사용가능하다.
# - 자료형, 기본값 지정이 가능하다.
# - 기본값을 None으로 지정하지 않으면 필수값이다.
fake_items_db = [{"item_name": "Foo"}, {"item_name": "Bar"}, {"item_name": "Baz"}]

@router.get("/items/")
async def read_item(skip: int = 0, limit: int = 10):
    return fake_items_db[skip : skip + limit]


@router.get("/products/{product_id}")
async def read_product(product_id: str, q: str | int = None):
    if q:
        return {"product_id": product_id, "q": q}
    return {"product_id": product_id}