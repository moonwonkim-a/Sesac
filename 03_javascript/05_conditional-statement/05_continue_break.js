/**
 * continue: 현재 반복문의 나머지 코드를 건너뛰고, 다음 반복문으로 넘어간다.
 * break: 현재 반복문을 완전히 종료한다.
 * 
 * 이 두 가지 문은 반복문의 흐름을 제어하는 데 매우 유용하며,
 * 특정 조건에서 반복을 건너뛰거나 중단해야 할 때 사용된다.
 */


for(let i = 1; i <= 10; i++) {
    if(i % 2 === 0) {
        continue;   // i가 짝수라면
    }
    console.log(i); // 홀수만 출력
}

for(let i = 1; i<=10; i++) {
    if(i >5) {
        break;
    }
    console.log(i)
}

// 중첩반복문 continue 예제
for(let i=0; i<=3; i++) {
    for(let j =1; j<=3; j++){
        if(j === 2) {
            continue; //j가 2일 때 현재 반복을 건너뜀
        }
        console.log(`i:${i}, j:${j}`);
    }
}

// break를 사용한 중첩 반복문 예제
outerLoop : for(let i=0; i<=3; i++){
    for(let j=1; j<=3; j++){
        if(j===2){
            break outerLoop;
        }
        console.log(`i:${i}, j:${j}`);
    }
}


// for...of 반복문(ES6)
// 이는 배열이나 이터러블(iterable) 객체의 각 요소를 순회하는 데 사용
const numbers = [1,2,3,4,5,6,7,8,9];

for(const number of numbers) {
    console.log(number);
}


