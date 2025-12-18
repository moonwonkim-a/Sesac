/**
 * 반복문: while
 * 조건이 참인 동안 코드를 반복 실행한다.
 * 반복 조건이 명확하지 않을 때 사용한다.
 */

let count = 3;

while(count > 0) {
    console.log(`카운트다운: ${count}`);
    count--;
}

/**
 * 반복문: do-while
 * 최소 한 번 실행한 후 조건을 검사합니다.
 * do{
 *      //조건에 상관없이 처음 실행할 구문
 * } while(조건)
 */

let number = 1;

do {
    console.log(`숫자: ${number}`);
    number++;
} while(number <=3);