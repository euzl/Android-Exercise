# 🙄 EditText 의 속성을 확인하기 위해!

## 1. EditText의 Text 변경하기
```kt
// 속성에 직접 대입 (X : Type Mismatch)
// binding.editTextOutput.text = input

// setter 사용 (O)
binding.editTextOutput.setText(input)

// Editable 형태로 바꾸기 (O)
binding.editTextOutput2.text = Editable.Factory.getInstance().newEditable(input)
```

|실행전|실행후|
|--|--|
|![device-2021-09-18-020920](https://user-images.githubusercontent.com/37680108/133829049-cd8784c6-3c3b-4549-a9d8-0dfbee56d180.png)|![device-2021-09-18-021002](https://user-images.githubusercontent.com/37680108/133829055-e93fd688-bfd1-48e3-b1c4-9861ea71efdd.png)|

<br>

## 2. Text 변경 막기

<br>

## 3. 텍스트 변경 이벤트 감지 (Text Watcher)
