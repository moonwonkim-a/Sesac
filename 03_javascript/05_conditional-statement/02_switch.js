/**
 * 조건문: switch문
 * 하나의 변수에 대해 여러 경우를 처리합니다.
 */

var fruit = '사과'

switch(fruit) {
    case '사과':
        console.log('선택한 과일은 사과입니다.');
        break;
    case '바나나':
        console.log('선택한 과일은 바나나입니다.');
        break;
    case '망고':
        console.log('선택한 과일은 망고입니다.');
        break;
    default:
        console.log('알 수 없는 과일입니다.'); //위 조건에 해당되지 않을 때 실행
}