세세한 구현사항보다는 우리가 사용한 테스트 케이스가 더 중요하다.
이미 `xUnit`이 구현되어 있더라도 직접 구현해 볼만한 두가지 이유가 있다.

1. `숙달`  
   `xUnit`의 정신은 간결함에 있다. 마틴 파울러는 이런 짧은 코드로 많은 사람들이 은혜를 입었다. 라고 말했다. 하지만 몇몇 구현은 복잡해 보이는데 직접 ㅁ ㅏㄴ들어 사용하면 숙달된 도구를 쓰는 느낌을 받게 될 것이다.
2. `탐험`  
   저자는 새로운 프로그래밍 언어를 처음 접하면 그 언어로 xUnit을 만들어 본다고 한다. 테스트가 10개정도 통과할 떄쯤이면 많은 기능을 경험한다고 한다.

`xUnit`을 사용하다 보면 단언(assertion)의 실패와 나머지 종류의 에러 사이에 큰 차이점이 있음을 알게 된다.  
일반적으로 단언 실패(assertion failure)가 디버깅 시간을 더 많이 잡아먹곤 한다. 이런 이유로 대부분의 xUnit 구현에서는 실패와 에러를 구별한다.

`JUnit`은 간단한 Test 인터페이스를 선언하는데 `TestCase`와 `TestSuite` 모두 이를 상속받는다.

```java
public interface Test {
  public abstract int countTestCases();
  public abstract void run(TestResult result);
}
```

낙관적(동적) typing 언어에서는 인터페이스를 선언할 필요없이 해당 오 퍼레이션을 구현하면 된다.  
스크립트 언어로 테스트를 작성한다면 스크립트에서 `countTestCases()`가 `1`을 반환하도록 구현하고 실패 시에 `TestResult`에 고지하도록 하면, 그 스크립트를 일반 `TestCase`와 함께 실행할 수 있다.
