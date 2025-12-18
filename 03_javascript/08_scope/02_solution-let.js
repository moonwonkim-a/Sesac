// 1. 변수 중복 선언 금지 -> 코드의 안정성 확보
let msg = '안녕하세요';

// SyntaxError: Identifier 'msg' has already been declared
// let msg = '안녕히 가세요';

// 2. 블록({}) 레벨 스코프 -> 변수 오염 방지

// 이름만 같고 다른 영역의 다른 성질의 변수로 적용되는 i
let i = 100;
for (let i = 0; i<5; i++) {
    // 이 i는 for문 {}안에서만 사는, 이름만 같은 완전히 다른 변수이다.
    console.log(`for문 내부의 i :`,i);
}
// for문의 i는 전역 i에 전혀 영향을 주지 못함.
console.log(`for문 바깥의 i: `,i);

// 3. 변수 호이스팅이 일어나지 않는 것처럼 동작
//console.log(test); // ReferenceError: Cannot access 'test' before initialization

let test; // 선언과 초기화 단계가 분리되어, 선언 전에 접근하면 에러 발생
test = '반갑습니다.'
console.log(test);