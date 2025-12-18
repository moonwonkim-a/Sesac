/**
 * 연산자(operator)는 두 개 이상의 값을 조작하거나 비교하여 결과를 생성하는 기호이다.
 * 자주 사용되는 연산자에는 산술 연산자, 할당 연산자, 증감 연산자 등이 있다.
 */

// 1. 산술 연산자

var a = 10;
var b = 3;

console.log(a+b);
console.log(a-b);
console.log(a*b);
console.log(a/b);
console.log(a%b);  //나머지
console.log(a**b); //거듭제곱

// 2. 할당 연산자
var c = 5;
c += 3; // c = c + 3
c -= 3; // c = c - 3

// 3. 증감 연산자
var d = 5;
console.log(d++);  // 후위 증가(출력: 5) / 출력 먼저 한 다음 연산
console.log(++d);  // 전위 증가(출력: 7) / 연산을 다 한 다음 출력
console.log(--d);  // 6
console.log(d--);