from typing import Annotated, Union

from fastapi import APIRouter, Path, Query, Body
from pydantic import BaseModel

router = APIRouter(prefix="/body", tags=["body"])

# Body()를 통해 요청 본문을 정의할 수 있다.
class Item(BaseModel):
    name: str
    description: Union[str, None] = None
    price: float
    tax: Union[float, None] = None


"""
요청 json이 아래와 같을 때, Body를 통해 처리할 수 있다. 
{
    "item": {
        "name": "Foo",
        "description": "The pretender",
        "price": 42.0,
        "tax": 3.2
    }
}

"""
@router.put("/items/{item_id}")
async def update_item(item_id: int, item: Item = Body(embed=True)):
    results = {"item_id": item_id, "item": item}
    return results

"""
아래와 같은 json body의 모델이 여러개인 경우

{
    "item": {
        "name": "Foo",
        "description": "The pretender",
        "price": 42.0,
        "tax": 3.2
    },
    "user": {
        "username": "dave",
        "full_name": "Dave Grohl"
    },
    "importance": 5
}
"""
class User(BaseModel):
    username: str
    full_name: Union[str, None] = None


@router.post("/users/{user_id}/items")
async def update_item(user_id: int, item: Item, user: User, importance: int = Body(gt=0)):
    results = {"item": item, "user": user, "importance": importance}
    return results