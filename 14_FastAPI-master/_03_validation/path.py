from typing import Annotated, Union

from fastapi import APIRouter, Path, Query

router = APIRouter(prefix="/path", tags=["path"])

# Path()를 통해 경로매개변수를 정의/검증할 수 있다.

@router.get("/items/{item_id}")
async def read_items(
    item_id: Annotated[int, Path(title="The ID of the item to get")],
    q: Annotated[str | None, Query(alias="item-query")] = None,
):
    results = {"item_id": item_id}
    if q:
        results.update({"q": q})
    return results