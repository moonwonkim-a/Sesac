from typing import Union

from fastapi import FastAPI, Query
from query import router as query_router
from path import router as path_router
from body import router as body_router

app = FastAPI()

app.include_router(router=query_router)
app.include_router(router=path_router)
app.include_router(router=body_router)