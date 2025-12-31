from fastapi import FastAPI, APIRouter
from pydantic import BaseModel

router = APIRouter(prefix='/request_body', tags=['request_body'])

class Item(BaseModel):
    name: str
    description: str | None = None
    price: float
    tax: float | None = None


@router.post("/items/")
async def create_item(item: Item):
    return item


# 경로매개변수/쿼리매개변수/요청본문을 섞어 사용해도 잘 구분한다.
@router.put("/items/{item_id}")
async def update_item(item_id: int, item: Item, q: str | None = None):
    result = {"item_id": item_id, **item.model_dump()}
    if q:
        result.update({"q": q})
    return result