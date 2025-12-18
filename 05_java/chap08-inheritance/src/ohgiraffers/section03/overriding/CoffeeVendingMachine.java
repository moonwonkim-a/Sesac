package ohgiraffers.section03.overriding;

public class CoffeeVendingMachine extends VendingMachine {

    /* 오버라이딩 성공 조건 :
    * 메소드 이름, 반환타입, 매개변수 목록이 모두 부모와 동일해야 한다.
    * 접근제한자는 부모와 같거나 더 넓어야 한다.
    * ( private < default < protected < public )
    *
    * 오버라이딩 불가 대상 :
    * 1. private 메소드(자식에게 보이지 않음)
    * 2. final 메소드(변경이 금지됨)
    * 3. 생성자 (상속되지 않음)
    * */

    // 모든 규칙(이름, 반환타입, 파라미터)을 지켜서 오버라이딩
    // @Override : 컴파일 단계에서 정확히 오버라이딩 되었는지 체크해줌
    @Override
    public String vend() {
        return "따뜻한 아메리카노";
    }

    // 위반1 : 메소드 이름이 다른 경우(단순히 새로운 메소드 추가)
//    @Override
//    public String vendMachine() {
//        return "음료수";
//    }

    // 위반2 : 반환 타입이 다르면 오버라이딩 할 수 없다.
//    @Override
//    public int vend(){
//        return 100;
//    }

    // 위반3 : 매개변수(파라미터)가 다르면 오버라이딩이 아니다.(오버로딩에 해당)
//    @Override
//    public String vend(String type){
//        return type;
//    }

    // 위반4: private 메소드는 오버라이딩 할 수 없다.
//    @Override
//    private void checkStock() {}

    // 위반5: final 메소드는 '절대 변경 불가'를 의미하므로 오버라이딩 불가
//    @Override
//    public final void powerOn(){}

    // 위반6 : 접근제한자는 부모보다 좁은 범위로 변경할 수 없다.
    // default 접근제한자가 protected보다 좁은 범위이므로 에러 발생
//    @Override
//    void clean() {}

    // 더 넓은 범위로 변경은 가능
    @Override
    public void clean() {
        System.out.println("내부를 스팀으로 청소합니다.");
    }

}
