//name = 매개변수
function Rice(name) {
    return `이것은 ${name} 입니다.`
}
//'현미' = 인수
console.log(Rice('현미'));

// 인수가 부족해서 할당되지 않은 매개변수는 'undefined'로 출력됨
console.log(Rice());

// 인수가 매개변수를 초과한다면 초과된 인수는 무시됨. 출력x
console.log(Rice('현미','잡곡'));

// 인수를 전달하지 않았으면 매개변수 기본값을 사용할 수 있다.
function food(name = '파스타') {
    return `맛있는 ${name}`
}
console.log(food());
console.log(food('스테이크'));

// 반환문
function Music(name){
    console.log(`음악 종류 명`);
    return `${name}`
}
console.log(Music('hous'));

// 변수에 담은 함수 (*)
const hi_menual = function() {
    console.log(`안녕하세요`);
}

hi_menual();  // 함수호출

// 객체 속성에 담은 함수 (*)
const dog = {
    name1: function(){
        console.log(`뽀삐`); 
    }, // 일반적인 방법
    name2() {
        console.log(`사랑`);
    } // 단축사용방법
};
dog.name1();
dog['name2']();

// 함수의 인자 형태로 전달. (*)
function manager(TT, CC) {
    console.log(`매니저는 친절하게 인사를 합니다.`);
    for(let i = 0; i<CC; i++){
        TT()
    }
    return function(){
        console.log(`모든 업무가 완료되었습니다.`)
    }
}
const report = manager(hi_menual,2); //hi_menual함수를 인자로 전달
report() // 함수 호출

// 고차 함수 = 함수를 인자로 받는 함수
function 예시1(예시1Callback, a, b) {
    console.log(`계산을 시작합니다`);
    const result = 예시1Callback(a,b);
    return result;
}

// 콜백 함수 = 고차 함수에 '재료'처럼 전달되는 함수
function add(a,b) {
    return a+b;
}
function multiply(a,b) {
    return a*b;
}
const resultadd = 예시1(add,10,11);
console.log(resultadd);
const resultmultiply = 예시1(multiply,50,100);
console.log(resultmultiply);

// .sort() = 정렬 기준을 담은 콜백 함수
const arr = [1,5,3,6,15,99,4,55,0];

arr.sort(function(a,b){
    return a-b; // 내림차순 <=> 올림차순으로 하려면 b-a
});
console.log(arr);

// 즉시 실행 함수(IIFE) -> (즉시 실행 함수)(); 형태 -> 사용하는 이유 = 변수 이름 충돌 방지, 전역스코프를 오염시키지 않기 위해.
(function() {
    const IIFE에서만존재하는함수 = `이 함수 안에서만 존재함.`;
    console.log(IIFE에서만존재하는함수);
})();
//console.log(IIFE에서만존재하는함수); // IIFE 밖에서는 실행이 안됨. 함수 안에서만 존재 할 수 있기 때문.

const 결과값 = (function(){
    let a = 500;
    let b = 1000;
    return a*b;
})();
console.log(결과값); // 변수에 담긴 형태

/** var 키워드 문제점 3가지
 * 1. 변수 중복 선언 허용 -> 코드의 신뢰성 하락
 * 2. 함수 레벨 스코프 -> 의도치 않은 변수 오염
 * 3. 변수 호이스팅 -> 코드의 가독성 및 예측 가능성 저하
 */

// let 
// 1. 변수 중복 선언 금지
// 2. 블록 레벨 스코프 -> 변수 오염 방지
let i = 100;
for (let i = 0; i<10; i++){
    console.log(`for문i`);
}
console.log(`for문 밖i`,i);
// 3. 변수 호이스팅이 일어나지 '않는 것 처럼' 동작
/* console.log(test)
let test;
test = 'hello' */ //ReferenceError: Cannot access 'test' before initialization

// summary
let globalVar = '전역 변수';  // 가장 넓은 스코프 (이 파일 어디서든 사용 가능한 스코프)
if(true) {
    let blockVar = '블록 스코프 변수' // if문 안에서만 유효

    function sayHi(){
        let fuctionVar = '함수 스코프 변수'; // sayHi 함수 안에서만 유효
        
        console.log(globalVar);
        console.log(blockVar);
        console.log(fuctionVar);
    }
    sayHi();
    // console.log(functionVar); // ERROR : 함수 밖에서는 접근 불가
}
// console.log(blockVar); // ERROR : 블록 밖에서는 접근 불가
/**
 * 원칙 1: 기본적으로 모든 변수는 const로 선언한다. (가장 안전)
 * 원칙 2: 값이 반드시 바뀌어야만 하는 변수에만 let을 사용한다.
 * 원칙 3: var는 이제 사용하지 않는다.
 */

// 생성자 함수 -> 일반함수와 구분하기 위해 첫 글자를 대문자로 작성하는 것이 관례(꼭 안해도되지만 일종의 약속)
function Cat(name,age,weight){
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.getInfor = function(){
        return `${this.name} 은(는) ${this.age}살 이고 ${this.weight}kg 입니다.`;
    } // 일종의 설계도
}
// new 키워드를 사용하여 설계도로부터 실제 객체를 생성한다.
const cat1 = new Cat('나비',1,3);
console.log(cat1);
console.log(cat1['getInfor']());
const cat2 = new Cat('렝가',3,5);
console.log(cat2);
console.log(cat2.getInfor());
const cat3 = new Cat('뚱냥이',5,10);
console.log(cat3);
console.log(cat3.getInfor());


//prototype

function Student(name,age){
    this.name = name;
    this.age = age;
};

const totalStudent = {
    getInfor: function(){
        console.log(`${this.name}은(는) 나이가 ${this.age}살 입니다.`)
    }
}

Student.prototype = totalStudent;

const student1 = new Student('영희',17);
console.log(student1);
student1.getInfor();

const student2 = new Student('철수',9);
student2.getInfor();

//array





// simulater
const user = {
    login: function(){
        console.log(`[${this.name}](${this.type}) 님이 입장하셨습니다.`);
    }
};

// user 정보
function User(type, wepon, name) {
  this.type = type;
  this.wepon = wepon;
  this.name = name;
  this.Simulation = function() {
    console.log(`강화 simulation을 시작합니다.`) // simulation 시작시 출력되는 문구
    for (let i = 1; i <= 10;) {
      const probability = Math.floor(Math.random() * 10) + 1;  // 1 ~ 10

      if (i < 3) {
        // 거의 무조건 성공 (예: 무조건 성공)
        i++;
        console.log(`${i} ${wepon} =>${i+1} ${wepon}(${this.type})
                        결과 : [${this.name}] 님이 +${i} ${wepon} 강화에 성공하셨습니다. => +${i} 나무`);
      } else if (i < 8) {
        if (probability >= 5) {
          i++;
          console.log(`${i} ${wepon} =>${i+1} ${wepon}(${this.type})
                        결과 : (${this.type})[${this.name}] 님이 +${i} ${wepon} 강화에 성공하셨습니다. => +${i} 나무`);
        } else {
          i--;
          console.log(`${i} ${wepon} =>${i+1} ${wepon}(${this.type})
                        결과 : (${this.type})[${this.name}] 님이 +${i+1} ${wepon} 강화에 실패하셨습니다. => +${i} 나무`);
        }
      } else {  // i >= 8
        if (probability >= 9) {
          i++;
          console.log(`${i} ${wepon} =>${i+1} ${wepon}(${this.type})
                        결과 : (${this.type})[${this.name}] 님이 +${i} ${wepon} 강화에 성공하셨습니다. => +${i} 나무`);
        } else {
          i--;
          console.log(`${i} ${wepon} =>${i+1} ${wepon}(${this.type})
                        결과 : (${this.type})[${this.name}] 님이 +${i+1} ${wepon} 강화에 실패하셨습니다. => +${i} 나무`);
        }
      }

      if (i === 10) {
        console.log(`[${this.name}](${this.type})님 MAX ${this.wepon} 축하드립니다.`);
        break;
      }
    }
  };
}

User.prototype = user;

// 신규 user 등록
const user1 = new User('학생','연필','문');
const user2 = new User('직장인','볼팬','썬');

// 작동.
user2.login();
user2.Simulation();