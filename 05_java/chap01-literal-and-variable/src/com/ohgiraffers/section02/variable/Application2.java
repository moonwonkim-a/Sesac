package com.ohgiraffers.section02.variable;

public class Application2 {
    public static void main(String[] args) {

        /* 변수의 명명 규칙 */
        /* 1. 컴파일 에러를 발생시키는 규칙 */
        /* 동일한 범위 내에서 동일한 변수명을 가질 수 없다. */
        int age = 20;
//        int age = 20;

        /* 예약어는 사용이 불가하다.(예약어: 자바에서 미리 사용하겠다고 compiler와 약속한 키워드) */
//        int true = 1;
//        int for = 20;

        /* 변수명은 대/소문자를 구분한다. */
        int Age = 20;   // 위에서 만든 age와 다른 것으로 취급
        int True = 10;  // 예약어 true와 다른 것으로 취급

        /* 변수명은 숫자로 시작할 수 없다. */
//        int 1age = 20;  // 숫자로 시작해서 에러 발생
        int age1 = 20;

        /* 특수기호는 '_'와 '$'만 사용 가능하다. */
//        int sh@rp = 10;
//        int -age = 20;
        int _age = 20;      //언더스코어는 사용 가능하다.
        int $anda = 20;

        /* 컴파일 에러를 발생시키지는 않지만 개발자들끼리의 암묵적 규칙 */
        /* 변수명의 길이 제한은 없지만 적당히 해야겠죠? */
        int dfajdkfjkfjkdlsadjfklskdjfklskdfjksdjfksl;

        /* 합성어로 이루어진 경우 첫 단어는 소문자, 두 번째 시작 단어는 대문자로 시작한다. */
        int maxAge = 20;
        int max_age = 20; // 단어와 단어 사이의 연결을 언더스코어(_)로 하지 않는다.

        /* 한글로 변수명을 짓는 것이 가능하지만, 권장하지 않는다. */
        int 나이;

        /*  변수안에 저장된 값이 어떤 의미를 가지는지 명확하게 표현하도록 한다. */
        String s;   // 변수가 어떤 의미인지 파악하기 힘들다.
        String name; // 문자열 형태의 이름이 저장되겠구나 의도 파악 가능

        /* 전형적 변수 이름이 있다면 가급적 사용 */
        int sum = 0;
        int max = 10;
        int min = 0;
        int count = 1;

        /* boolean형은 의문문으로 가급적 긍정형태로 네이밍 */
        boolean isAlive = true;
        boolean inDead = false; // 부정형 보다는 긍정형이 더 나은 방식
    }
}
