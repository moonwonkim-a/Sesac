def parse_qa_data_to_list(file_path : str) -> list[dict]:
    """텍스트 파일을 읽어와서, Q&A 딕셔너리들의 리스트로 변환하는 함수"""
    qa_list = []
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
    
        # strip() : 앞 뒤 공백 제거
        blocks = content.strip().split('===')

        for block in blocks :
            if not block.strip() : 
                continue
            lines = block.strip().split('\n')
            if len(lines) >= 2:
                question = lines[0].replace('Q:', '').strip()
                answer = lines[1].replace('A:', '').strip()
                if question and answer:
                    qa_list.append({"question" : question, "answer" : answer})
    except FileNotFoundError:
        print("파일을 찾을 수 없습니다.")
    except Exception as e:
        print(f"처리중 오류 발생 : {e}")
    return qa_list