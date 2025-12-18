/**
 * 표준 내장 객체
 * 자바스크립트가 기본적으로 제공하는 유용한 객체들이다
 */

// String : 문자열 도구 상자
// 텍스트를 자르고, 붙이고, 검색하는 등 문자열을 다루는데 필수적인 기능 제공

const myIntro = '안녕? 내 이름은 문 이야.';

// 검색하기 : indexOf(), includes()
console.log(myIntro.indexOf('이름'));
console.log(myIntro.includes('나이'));

// 잘라내기 : slice() (=> 음수 사용이 가능하고 문자열에 적용 가능), substring()
const fileName = 'my-profile.jpg'
console.log(fileName.slice(11)); // jpg 앞쪽에서 뒤쪽으로
console.log(fileName.slice(-4)); // .jpg 뒤쪽에서 앞쪽으로

console.log(fileName.slice(3,10)); // 3번부터 10번 전까지

// 쪼개서 배열 만들기 : .split()
const tags = "#자바스크립트#개발자#꿀팁#프론트엔드"
const tagArray = tags.split('#');
console.log(tagArray);

// 기타 유용한 도구들
const userId = "    UsEr123     "
console.log(userId);
// .trim(): 문자열 앞/뒤 불필요한 공백 제거
console.log(userId.trim());

// 대문자/소문자로 바꾸기
console.log(userId.toUpperCase()); // 대문자
console.log(userId.toLowerCase()); // 소문자

/**
 * Math : 숫자 도구
 * 랜덤 숫자 생성, 반올림 등 간단하지만 활용도 높은 숫자 기능들을 제공
 */

// 랜덤 숫자 만들기 : Math.random()
// 0 이상 1 미만의 랜덤한 소수를 반환한다.
console.log(Math.random());

// 응용: 1~10 사이의 랜덤정수 만들기
const randomNumber = Math.floor(Math.random() * 10)+1; // Maty.floor = 소숫점 버리기 / (Math.random() * 최댓값) + 최솟값;
console.log(randomNumber);

// 숫자 반올림/버림/올림
console.log(Math.round(3.14)); // 반올림
console.log(Math.floor(3.99)); // 버림
console.log(Math.ceil(3.01)); // 올림

// Date: 날짜와 시간을 다루는 기본적인 기능 제공

// 현재 날짜/시간 생성 및 정보 추출
const now = new Date();
console.log(now);

const year = now.getFullYear();
const month = now.getMonth()+1; // 월(Month)은 9부터 시작한다. 따라서 정확한 월을 입력하려면 +1 해줘야한다.
const date = now.getDate();

console.log(`${year}년 ${month}월 ${date}일`);

/** 실무에서는 더 편리한 '날짜전문 라이브러리'를 사용하는 경우가 많다.
 * (예: Day.js, data-fns, Luxon)
*/