from fastapi import APIRouter, Form
from typing import Annotated

from pydantic import BaseModel

router = APIRouter(prefix="/form_urlencoded", tags=["form_urlencoded"])


@router.post("/login/")
async def login(username: Annotated[str, Form()], password: Annotated[str, Form()]):
    return {"username": username}


# 폼모델을 작성해서 처리하는 것 또한 가능하다.
class FormData(BaseModel):
    username: str
    password: str


@router.post("/login2/")
async def login(data: Annotated[FormData, Form()]):
    return data