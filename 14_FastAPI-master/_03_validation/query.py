from typing import Annotated, Literal, List

from fastapi import APIRouter, Query

router = APIRouter(prefix="/query", tags=["query"])

# Query()를 통해 쿼리매개변수를 정의할 수 있다.
# - default: 기본값
# - max_length: 최대 길이
# - min_length: 최소 길이
# - pattern: 정규식
# - gt/lt/ge/le: 크다/작다/크거나 같다/작거나 같다
# - alias: 별칭(변수명 대신 사용)
# - title/description: 제목/설명
# - example: 예시

# Annotated[type, metadata]를 통해 메타데이터를 추가할 수 있다.
@router.get("/items/")
# async def read_items(q: str | None = Query(default=None, max_length=50)):
async def read_items(
        q: Annotated[
            str | None, Query(min_length=3, max_length=50, pattern="^query\d+$")
        ] = None,
):
    results = {"items": [{"item_id": "Foo"}, {"item_id": "Bar"}]}
    if q:
        results.update({"q": q})
    return results


# pydantic을 이용한 검증
from pydantic import BaseModel, Field


# pydantic.BaseModel을 상속받아 데이터 모델을 정의할 수 있다.
class FilterParams(BaseModel):
    # 정의된 필드외 사용금지
    # model_config = {"extra": "forbid"}

    limit: int = Field(100, gt=0, le=100)
    offset: int = Field(0, ge=0)
    order_by: Literal["created_at", "updated_at"] = "created_at"
    tags: List[str] = [] # str를 요소로하는 List


@router.get("/products/")
async def read_products(filter_query: Annotated[FilterParams, Query()]):
    return filter_query