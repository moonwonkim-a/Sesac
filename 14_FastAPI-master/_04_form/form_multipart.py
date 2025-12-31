from typing import Annotated

from fastapi import APIRouter, File, Form, UploadFile

router = APIRouter(prefix="/form_multipart", tags=["form_multipart"])


# 파일이 포함된 요청(form-data/multipart)인 경우 File을 통해 처리할 수 있다.
@router.post("/files/")
async def create_file(
        file: Annotated[UploadFile, File()],
        token: Annotated[str, Form()],
):
    return {
        "file_size": file.size,
        "file_content_type": file.content_type,
        "token": token,
    }