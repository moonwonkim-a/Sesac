const studentHQ = {
    activate: true,
    login: function(){
        console.log(`${this.name}님 로그인 되었습니다.`);
    }
};


function Student(name){
    this.name = name;
}

// 생성자 함수로 새로 만들어질 객체들이 바라볼 프로토타입 객체를 지정
Student.prototype = studentHQ;

// new 연산자를 사용해 만든 객체는
// 생성자 함수의 프로토타입 정보를 사용해 [[Prototype]]을 설정한다.
// student1.__proto__ == studentHQ;
const student1 = new Student('문');
student1.login();
const student2 = new Student('썬');
student2.login();
