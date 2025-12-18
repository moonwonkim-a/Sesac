from my_parser import parse_qa_data_to_list
import os
import json

def run_pipeline() :
    """전체 데이터 처리 파이프라인을 실행하는 메인 함수"""
    print("텍스트를 JSON으로 변환하는 파이프라인 시작")

    # 현재 실행 중인 파일(main.py)의 절대 경로를 기준으로 경로 설정
    base_dir = os.path.dirname(os.path.abspath(__file__))   # C:/PYTHON_LLM/module_project
    # 입/출력 파일 경로 만들기
    input_file_path = os.path.join(base_dir, 'data', 'qa_data.txt') # C:/PYTHON_LLM/module_project/data/qa_data.txt
    output_file_path = os.path.join(base_dir, 'qna_for_llm.json')   # C:/PYTHON_LLM/module_project/qna_for_llm.json

    # 데이터를 딕셔너리의 리스트로 파싱
    qa_data = parse_qa_data_to_list(input_file_path)

    # 파싱된 데이터를 JSON 파일로 저장
    if qa_data:
        print(f"총 {len(qa_data)}개의 유효한 Q&A를 찾았습니다.")
        try:
            with open(output_file_path, 'w', encoding='utf-8') as f:
                json.dump(qa_data, f, indent=2, ensure_ascii=False)
            print(f"데이터가 성공적으로 저장되었습니다.")
        except Exception as e:
            print(f"파일 저장 중 오류 발생 : {e}")
    else:
        print("처리할 유요한 데이터가 없습니다.")
    
    print("파이프라인 종료")

# 이 파일이 '직접 실행된 경우'에만 이 코드를 실행 (관용구)
if __name__ == '__main__':
    run_pipeline()