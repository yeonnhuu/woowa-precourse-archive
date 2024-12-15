# java-calculator-7


---

# 프로젝트 개요

## 프로젝트 구조

```plaintext
└── calculator
    ├── Application.java
    ├── controller
    │ └── CalculatorManager.java
    ├── handler
    │ └── ErrorHandler.java
    ├── model
    │ └── StringCalculator.java
    └── view
        ├── InputView.java
        └── OutputView.java
```


---

## 프로젝트 다이어그램

![프로젝트 다이어그램](./main.png)


---

# 구현할 기능 목록

## 🗂️ Model

### StringCalculator
- [ ] 입력 받은 문자열을 토큰화한다.
  - [ ] 커스텀 구분자를 추출한다.
- [ ] 토큰화한 문자열을 숫자로 변환한다.
  - [ ] [예외] 숫자가 아닌 경우, 예외를 발생시킨다. 
  - [ ] [예외] 양수가 아닌 경우, 예외를 발생시킨다.


---

## 👀 View

### InputView
- [ ] 입력 기능을 처리한다.
  - [ ] 계산할 문자열을 입력받는다.

### OutputView
- [ ] 출력 기능을 처리한다.
  - [ ] 문자열을 계산한 결과를 출력한다.


---

## 🕹️ Controller

### CalculatorManager
- [ ] 입력받은 문자열 계산 과정을 관리한다.


---

## 🛠 Handler

### ErrorHandler
- [ ] 잘못된 입력 시 IllegalArgumentException 예외를 발생시킨다.
