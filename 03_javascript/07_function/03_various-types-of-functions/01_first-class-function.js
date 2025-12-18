/**
 * 함수의 정체는 일급 객체
 * 자바스크립트에서 함수는 '값(value)'으로 취급될 수 있다.
 */

// 1. 변수에 담을 수 있다.(함수 표현식)
var sayHello = function() {
    console.log('안녕?');
}

sayHello();

// 2. 객체의 속성으로 담을 수 있다.(mathod)

var myObject = {
    sayHi : function() {
        console.log('반가워');
    },
    // 최신 문법으로는 아래와 같이 단축해서 사용 가능하다.
    sayBye() {
        console.log('잘가');
    }
};

myObject['sayHi']();
myObject.sayHi();
myObject.sayBye();

// 3. 함수의 인자(argument)로 전달할 수 있다.
// 4. 함수의 결과(return value)로 반환될 수 있다.

function manager(task, count) {
    console.log('매니저가 업무를 지시합니다.');
    for(let i = 0; i < count; i++) {
        task(); // 인자로 받은 함수(task)를 실행.
    }
    return function(){
        console.log('모든 업무가 완료되었습니다.');
    }
}
// sayHello 함수를 인자로 전달.
var report = manager(sayHello, 3);

// manager 함수가 반환한 새로운 함수를 실행
report();