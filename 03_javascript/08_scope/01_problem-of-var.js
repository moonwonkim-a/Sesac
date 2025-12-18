/**
 * ES5까지 사용되던 var 키워드는 세 가지 주요 문제점을 가지고 있다.
 */

// 1. 변수 중복 선언 허용 -> 코드의 신뢰성 하락
var msg = '안녕하세요';
console.log(msg);

// 같은 이름으로 변수를 또 선언해도 애러가 발생하지 않음
var msg = '안녕히 가세요';
console.log(msg);


// 2. 함수 레벨 스코프 -> 의도치 않은 변수 오염
var i = 100; // 중요한 전역 변수

for (var i = 0; i < 5; i++) {
    console.log(`for문 내부의 i :`, i);
}

console.log(`for문 바깥의 i:`, i);


// 3. 변수 호이스팅 -> 코드의 가독성 및 예측 가능성 저하 // 정상적인 코드의 흐름은 위에서 아래로
console.log(test); // undefined (에러는 나지 않음)

test = '반갑습니다.'
console.log(test);

var test; // 선언이 가장 위로 끌어올려진 것처럼 동작함
