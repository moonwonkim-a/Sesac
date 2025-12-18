package ohgiraffers.section02.superkeyword;

public class Computer extends Product {

    private String cpu;
    private int ram;

    public Computer() {
        super();    // 부모 클래스의 기본생성자 호출, 컴파일러가 자동으로 추가
        System.out.println("Computer 기본 생성자 호출");
    }

    public Computer(String code, String name, int price, String cpu, int ram) {
        super(code, name, price); // super()에 인자를 전달하면 부모의 매개변수 있는 생성자를 호출
        this.cpu = cpu;
        this.ram = ram;
        System.out.println("Computer 클래스의 부모 필드도 초기화하는 생성자 호출함");
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
    @Override
    public String getInformation() {

        // super.getInformation() 부모가 만들어주는 문자열을 먼저 가져온다.
        // super를 생략하게 되면 this.가 자동 추가되어 재귀 호출이 일어난다.
        String parentInfo = super.getInformation();

        // 자식 클래스 필드 정보를 덧붙여 완전한 정보를 만든다.
        String computerInfo = ", Computer [cpu=" + cpu + ", ram=" + ram + "]";

        return parentInfo + computerInfo;
    }
}
