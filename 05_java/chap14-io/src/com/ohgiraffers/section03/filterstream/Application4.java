package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {

        /* 객체단위 입출력 보조스트림 (ObjectOutputStream / ObjectInputStream) */

        MemberDTO[] outputMembers = {
                new MemberDTO("user01", "pass01", "홍길동", 25, 1250.7),
                new MemberDTO("user02", "pass02", "이순신", 49, 1000.2),
                new MemberDTO("user03", "pass03", "유관순", 16, 1489.3)
        };
        try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("src/com/ohgiraffers/section03/filterstream/testObjectStream.txt"))) {
            for (MemberDTO mem : outputMembers) {
                objOut.writeObject(mem);    // writeObject로 객체를 통째로 쓴다!
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("src/com/ohgiraffers/section03/filterstream/testObjectStream.txt"))) {

            while(true) {
                // readObject로 객체를 통째로 읽고, 원래 타입으로 형변환한다.
                System.out.println((MemberDTO)objIn.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("끝!");
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
