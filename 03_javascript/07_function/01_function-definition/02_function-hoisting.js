/** 
 * 함수 호이스팅 
 * 함수 선언문은 런타임 이전 자바스크립트 엔진에 의해 먼저 실행 된다.
 * 따라서 선언문 이전에 함수를 참조, 호출할 수 있다.
 * 함수 선언문이 코드 선두로 끌어 올려진 것처럼 동작하는
 * 자바스크립트 고유의 특징을 함수 호이스팅이라고 한다.*/

console.log(hello);
console.log(hi);

console.log(hello('문'));
//console.log(hi('문')); //TypeError: hi is not a function

// 함수 선언문
function hello(name) {
    return `${name}님 안녕하세요`
}

// 함수 표현식 해당 x
var hi = function(name) {
    return `${name} hi`
}