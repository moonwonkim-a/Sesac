/**
 * 암묵적 타입 변환
 * 자바스크립트 엔진에 의해 함묵적으로 타입이 자동 변환 되는 것을 암묵적 타입 변환 이라고 한다.
 */

// 문자열 타입으로 변환되는 타입

// 문자열 연결 연산자로 동작(+연산자 사용)
// 문자열 타입이 아닌 피연산자를 문자열 타입으로 암묵적으로 변환한다. (10부분이 문자로 변환되어 값이 1020이 됨)
console.log(10 +'20');

console.log(true + '');
console.log(null + '');
console.log(undefined + '');

// 숫자 타입으로 변환

// 산술 연산자(+를 제외한 나머지 산술연산자)의 피연자는 모두 숫자여야 하므로
// 숫자가 아닌 피연산자를 숫자 타입으로 암묵적 타입 변환한다.
console.log(10 - '5');
console.log(10 * '5');
console.log(10 / '5');
console.log(10 % '5');


// +단항 연산자는 피연산자가 숫자 타입의 값이 아니면 숫자 타입의 값으로 암묵적 타입 변환
console.log(+'javacript'); //NaN = Not a Number
console.log(+true); //True = 1, False = 0 으로 치환됨

// 빈 문자열(''), 빈 배열([]), null, false는 0으로 true는 1로 변환
// 객체와 undfined는 변환되지 않아 NaN

// 불리언 타입으로 변환

// 자바스크립트 엔진은 불리언 타입이 아닌 값을 Truthy 값(참으로 평가 되는 값)
// 또는 Falsy 값(거짓으로 평가되는 값)으로 구분한다.

/**
 * Falsy한 값 (false로 평가되는 값)
 * fales
 * 0 숫자(0)
 * '' (빈 문자열)
 * null
 * undefined
 * NaN (Not a Number)
 * 
 * 이 값들은 조건문이나 논리 연산자에서 **false**로 평가된다.
 */
if(true) console.log('if(true)');
if('') console.log("if('')");