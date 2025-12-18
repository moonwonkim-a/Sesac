/**
 * const는 let의 장점을 모두 가지면서, '재할당 금지'라는 강력한 규칙이 추가된 키워드이다.
 */

// 1. 선언과 동시에 반드시 초기화(값을 무조건 지정해줘야한다.) 해야한다.
// const greeting;
const greeting = '안녕하세요';

// 2. 재할당이 금지된다.
// greeting = '안녕히 가세요'; // TypeError: Assignment to constant variable.

// const와 객체
const student = {
    name : '문',
    age : 32,
    height : '176cm'
};
// student 변수를 다른 객체로 '바꿔치기' 하는것은 불가능하다.
// student = {name: '홍길동', age: 20, height : '180cm'}; // TypeError: Assignment to constant variable.

// 객체 내부의 '내용물'(프로퍼티)을 변경한느 것은 가능하다.
student['name'] = '홍길동'
console.log(student);