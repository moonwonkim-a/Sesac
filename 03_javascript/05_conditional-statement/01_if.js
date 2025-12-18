/**
 * 조건문: if-else
 * if (조건식) {
 *              //조건식이 true 인 경우 실행구문
 * } else {
 *      //조건식이 false인 경우 실행구문
 * }
 */

var temperature = 25;

if(temperature < 10) {
    console.log('오늘은 추운날씨 입니다. 옷을 따뜻하게 입으세요') // 조건이 참일 때 실행
} else {
    console.log('오늘은 날씨가 괜찮습니다.') // 조건이 거짓일 때 실행
}

/**
 * 조건문: if-else if-else
 * if(조건식1) {
 *          // 조건식1 true인 경우 실행구문
 * } else if(조건식2) {
 *          // 조건식2 true인 경우 실행구문
 * } else {
 *          //위의 조건이 다 false일 경우 실행구문
 * }
 */

var score = 85;

if(score >= 90) {
    console.log('성적이 매우 우수합니다.');
} else if(score >= 70) {
    console.log('성적이 양호합니다.');
} else if(score >= 50) {
    console.log('성적이 보통입니다.');
} else {
    console.log('공부가 많이 필요합니다.');
}