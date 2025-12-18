// forEach: 배열의 각 요소에 대해 콜백 함수를 실행한다. 반환 값은 없다.

const names = ['사자','호랑이','늑대'];

// for 반복문
for(i = 0; i< names.length; i++){
    console.log(names[i]);
}

// forEach 버전
names.forEach(name => console.log(name)); 
// = names.forEach(function(name){
//       console.log(name);
//   });

//콜백 함수는 요소의 값, 인덱스, 배열 자체를 인자로 받을 수 있다.
names.forEach((name,index,array)=>{
    console.log(`${index +1}번째 이름: ${name}`);
})