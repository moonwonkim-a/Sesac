from fastapi import APIRouter

router = APIRouter(prefix='/path_params', tags=['path_params'])

# 경로매개변수
@router.get("/items/{item_id}")
async def read_item(item_id: int):
    return {"item_id": item_id}

"""
경로 작동은 순차적으로 실행되기 때문에 /users/{user_id} 이전에 /users/me를 먼저 선언해야 한다.
"""
# 고정된 경로를 항상 동적 경로('/users/{user_id}'/)보다 위에 작성해야 한다.
@router.get("/users/me")
async def read_user_me():
    return {"user_id": "the current user"}


@router.get("/users/{user_id}")
async def read_user(user_id: str):
    return {"user_id": user_id}



from enum import Enum, StrEnum

"""
Enum을 이용해서 매개변수를 지정한 값목록안에서만 처리할 수 있다.

- Enum클래스가 str, Enum 또는 StrEnum을 상속하면, Enum객체를 str처럼 사용가능하다.
    - enum객체 is ModelName.alexnet
    - enum객체.value == "lenet"
    위와 같이 쓰지 않고, 직접 비교 가능하다.
    - enum객체 == 'alexnet'
"""
class ModelName(StrEnum):
    alexnet = "alexnet"
    resnet = "resnet"
    lenet = "lenet"


@router.get("/models/{model_name}")
async def get_model(model_name: ModelName):
    # if model_name is ModelName.alexnet:
    if model_name == 'alexnet':
        return {"model_name": model_name, "message": "Deep Learning FTW!"}

    if model_name == "lenet":
        return {"model_name": model_name, "message": "LeCNN all the images"}

    return {"model_name": model_name, "message": "Have some residuals"}