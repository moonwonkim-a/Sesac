from typing import Union

from fastapi import FastAPI

from path_params import router as path_params_router
from query_params import router as query_params_router
from request_body import router as request_body_router

app = FastAPI()

# router 추가
app.include_router(router=path_params_router)
app.include_router(router=query_params_router)
app.include_router(router=request_body_router)