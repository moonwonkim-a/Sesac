const foods = ['파스타','스테이크','타코','햄버거'];
console.log(foods);

// push() : 맨 뒤에 값 추가하기
foods.push('감바스');
foods.push('리조또');
console.log(`push 후: ${foods}`);

// pop() : 맨 뒤 값 떼어내기
foods.pop();
console.log(`pop 한번: ${foods}`);
const food = foods.pop(); //제거한 값을 반환 //감바스
foods.pop();
console.log(`pop 두번: ${foods}`);
console.log(food);

/**
 * unshift(): 맨 앞에 값을 추가한다.
 * shift(): 맨 앞 값을 제거한다.
 */
foods.unshift('피자');
foods.unshift('감자튀김');
console.log(`unshift 후: ${foods}`); 

foods.shift();
console.log(`shift 후: ${foods}`);

/**
 * indexOf(값): 특정 값이 있는 '첫 번째 인덱스'를 알려준다. 없으면 -1을 반환한다.
 * includes(값): 특정 값이있는지 여부만 true/false로 알려준다.
 */

foods.push('파스타');
console.log(foods);

console.log(foods.indexOf('파스타'));
console.log(foods.indexOf('냉면'));

console.log(foods.includes('타코'));
console.log(foods.includes('국밥'));

// MDN(Mozilla Develooper Network)에서 'Array' 검색하면 array의 모든 method 설명을 볼 수 있다.
