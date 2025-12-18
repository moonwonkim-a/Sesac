package ohgiraffers.section01.object;

public class Application {
    public static void main(String[] args) {

        Book book1 = new Book(1, "홍길동전", "허균", 50000);
        Book book2 = new Book(2, "목민심서", "정약용", 30000);
        Book book3 = new Book(2, "목민심서", "정약용", 30000);

        /* Object.toString() 기본기능은 '클래스명@해시코드'를 반환한다.
        * 사람이 보기에는 의미없는 정보이다. 따라서 객체의 필드 값을 보여주도록 오버라이딩 하여 사용한다.*/
        System.out.println("book1 = " + book1);

        /*
        * Object.equals()의 기본 기능은 '==' 연산과 같이 두 객체의 주소 값을 비교한다. (동일성 비교)
        * 하지만 때로는 주소가 달라도 필드의 내용이 같으면 '같다(동등하다)'고 판단해야 할 때가 있다.
        * 이런 '동등성 비교'를 위해 equals()를 오버라이딩한다.
        * */
        System.out.println("동일성 비교(==) : " + (book2 == book3));
        System.out.println("동등성 비교(equals) : " + book2.equals(book3));

        /* 자바의 중요한 '일반 규약' : equals() 비교로 true를 반환한다면,
        두 객체의 hashCode() 값은 반드시 같아야 한다.
        나중에 배울 '자료구조' 기술에서 객체를 빠르고 효율적으로 찾기 위해 hashCode() 값으로 객체를 비교하는데
        만약 equals는 같다고 나오고 hashCode는 다르다면,
        컴퓨터가 이 두 객체를 완전히 다른것으로 착각하는 문제가 생길 수 있다.*/
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());

    }
}
