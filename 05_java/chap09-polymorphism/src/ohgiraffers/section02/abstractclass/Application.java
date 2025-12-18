package ohgiraffers.section02.abstractclass;

public class Application {
    public static void main(String[] args) {

        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();

        warrior.attack();
        wizard.attack();

//        Player player = new Player(); // 추상 클래스는 인스턴스화 할 수 없다.

        // 추상클래스는 그 자체로 객체가 될 순 없지만 '대표 타입'의 역할을 한다.
        // 다형성을 적용하기 위한 완벽한 조건이다.
        Player[] players = new Player[2];
        players[0] = new Warrior();
        players[1] = new Wizard();

        for(Player player : players) {
            player.attack();    // 다형성 + 동적 바인딩
            player.levelUp();   // 추상클래스의 일반 메소드도 사용 가능
        }
    }
}
