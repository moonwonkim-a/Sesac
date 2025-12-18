package ohgiraffers.section03.interfaceimplements;

/* 인터페이스는 쉼표로 여러 개를 implements 할 수 있다.
(자바의 단일 상속 한계 극복, 다중 상속의 효과를 내는 방법) */
//public class Keyboard implements IConnectable, Iterable {
public class Keyboard implements IConnectable {

    @Override
    public void connect() {
        System.out.println("키보드가 USB 포트에 연결되었습니다.");

    }
    @Override
    public void disconnect() {
        System.out.println("키보드 연결을 해제합니다.");
    }
}
