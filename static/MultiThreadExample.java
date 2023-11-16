/**
 * ** Spring ThreadPool **
 * <p>
 * Spring-Web 디펜던시를 추가하면 내장 서블릿 컨테이너로 Tomcat을 사용한다.
 * <p>
 * Tomcat은 다중 요청을 처리하기 위해서 Thread Pool 전략을 사용하는데,
 * Thread Pool 전략은 Thread를 미리 만들어 놓고, 작업을 할 시 Thread Pool에서 가져가 사용하고,
 * 작업 완료 시 Thread 자원을 해제하는 것이 아닌 Thread Pool에 다시 반납한다.
 */

/**
 * 멀티스레드 출력 예시
 *
 * start :: number=1
 * start :: number=2
 * end :: number=1
 * start :: number=3
 * end :: number=2
 * end :: number=3
 *
 */
public class MemberService {
    public void print(int n) throws InterruptedException {
        log.info("start :: number={}", n);
        Thread.sleep(3000);
        log.info("end :: number={}", n);
    }
}

/**
 * 싱글톤 객체에서 변경 가능성 있는 멤버 변수를 사용하면 안되는 이유.
 * 멀티 스레드 기반으로 동작하기 때문에 기대한 값이 출력된단 보장이 없음. -> 스레드 세이프하지 않음
 */
public class MemberService {
    private String memberStr; // -> NO!!!

    public void print(int n, String str) throws InterruptedException {
        memberStr = str;
        log.info("start :: number={}, memberStr={}", n, memberStr);
        Thread.sleep(3000);
        log.info("end :: number={}, memberStr={}", n, memberStr);
    }
}