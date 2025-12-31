from typing import Union

from fastapi import FastAPI, Query
from form_urlencoded import router as form_urlencoded_router
from form_multipart import router as form_multipart_router

app = FastAPI()

app.include_router(router=form_urlencoded_router)
app.include_router(router=form_multipart_router)