/**
 * 객체(object)
 * 자바스크립트는 객체 기반 프로그래밍 언어로 원시 값을 제외한 나머지 값(함수, 배열, 정규 표현식 등)은 모두 객체이다.
 * 객체는 0개 이상의 프로퍼티로 구성 된 집합이며 푸로퍼티는 키(key)와 값(value)으로 구성된다.
 * 자바스크립트에서 사용할 수 있는 모든 값은 프로퍼티 값이 될 수 있다.
 * 프로퍼티 값이 함수일 경우 method라고 부른다.
 */

// 객체 생성 - 객체 리터럴

var student = {
    // key:value 값 쌍으로 구성된 프로퍼티
    name:'판다',
    age:5,
    // method : 프로퍼티(상태 데이터)를 참조하고 조작할 수 있는 동작
    getInfo : function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`
    }
}

console.log(typeof student);
console.log(student);