package ohgiraffers.section03.interfaceimplements;

public interface IConnectable {

    // 모든 구현체가 공유해야 할 공통 규격 값(상수)을 정의할 수 있다.
    // 인터페이스에 선언된 변수는 자동으로 public static final 상수가 된다.
    public static final int MAX_CONNECTION_COUNT = 4;

    // 인터페이스의 추상 메소드 : 반드시 구현해야 할 기능의 목록 정의 -> 강제성 부여
    // 자동으로 public abstract 추상 메소드가 된다.
    public abstract void connect();
    void disconnect();

    /* default 메소드는 기존 구현체들을 수정하지 않고 새로운 기능을 추가하기 위해 사용된다. (하위 호환성) */
    public default void showStatus() {
        System.out.println("장치가 대기 상태입니다.");
    }
}
