/**
 * 매개변수(parameter)와 인수(argument)
 */

//함수 선언문

function hello(매개변수) {
    
    //매개변수는 함수 몸체 내부에서만 참조할 수 있다.
    console.log(매개변수);

    //모든 인수는 암묵적으로 argumets 객체의 프로퍼티로 보관된다.
    console.log(arguments); // 가변인자 함수 구현 시 유용하게 사용 된다.

    return `${매개변수}님 안녕하세요`;
}

//console.log(매개변수);

var result = hello('문'); //전달하는 값을 '인수(argument)' 라고 한다.
console.log(result);

//인수가 부족해서 할당되지 않은 매개변수의 값은 undefined 이다.
result = hello();
console.log(result);

//매개변수보다 인수가 더 많은 경우 초과된 인수는 무시된다.
result = hello('문','썬'); //'썬'의 경우 초과된 인수이기때문에 무시됨. 
console.log(result);

function  hi(name='호랑이'){
    // 인수를 전달하지 않았을 경우, ES6에서 도입된 매개변수 기본값을 사용할 수 있다.
    return`${name} 안녕`
}

result = hi();
console.log(result); // 기본값이 '호랑이'로 정해서 아무런 값을 입력하지 않아도 '호랑이'가 출력됨.