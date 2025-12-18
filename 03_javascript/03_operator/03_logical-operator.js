/**
 * 논리 연산자는 여러 조건을 결합하여 하나의 논리적 결과를 도출한다.
 * 논리 연산자는 AND, OR, NOT 연산자가 있다.
 */

var a = true;
var b = false;

// 1. 논리 AND (&&)
console.log(a&&b);    // a와 b가 모두 true일 때만 true (출력: false)

// 2. 논리 OR (||)
console.log(a||b);    // a 또는 b 중 하나만 true이면 true (출력: true)

// 3. 논리 NOT (!)
console.log(!a);      // true이면 false로, false이면 true로 반전 (출력: false)
console.log(!b);      // true

/**
 * [단축 평가]
 * 표현식을 평가하는 도중 평가 결과가 확정 된 경우 나머지 평가 과정을 생략하는 것
 */
// 'apple'이 이미 truthy 값이어서 true로 평가되고
// 논리 연산의 결과를 결정한 첫 번째 피연산자 apple을 그대로 반환한다.
console.log('apple'||'banana');     // apple
console.log(false||'banana');       // banana

// AND의 경우 좌항, 우항 모두 확인해야 하므로
// 논리 연산의 결과를 결정하는 두번째 피연산자 banana를 그대로 반환한다.
console.log('apple'&&'banana');   // banana
console.log(false &&'banana');    // false  //이미 좌항에서 true가 아니게 되었기 때문에 false

var obj = null;
//var val = obj.value;

// 에러 방지(Null Check)
var val = obj && obj.value;

/**
 * if(obj !== null) 과 같은 긴 코드를 대체하고,
 * 프로그램이 멈추는 것을 막을 수 있다.
 */