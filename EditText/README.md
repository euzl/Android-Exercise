# ๐ EditText ์ ์์ฑ์ ํ์ธํ๊ธฐ ์ํด!

## 1. EditText์ Text ๋ณ๊ฒฝํ๊ธฐ
```kt
// ์์ฑ์ ์ง์  ๋์ (X : Type Mismatch)
// binding.editTextOutput.text = input

// setter ์ฌ์ฉ (O)
binding.editTextOutput.setText(input)

// Editable ํํ๋ก ๋ฐ๊พธ๊ธฐ (O)
binding.editTextOutput2.text = Editable.Factory.getInstance().newEditable(input)
```

|์คํ์ |์คํํ|
|--|--|
|![device-2021-09-18-020920](https://user-images.githubusercontent.com/37680108/133829049-cd8784c6-3c3b-4549-a9d8-0dfbee56d180.png)|![device-2021-09-18-021002](https://user-images.githubusercontent.com/37680108/133829055-e93fd688-bfd1-48e3-b1c4-9861ea71efdd.png)|

<br>

## 2. Text ๋ณ๊ฒฝ ๋ง๊ธฐ

<br>

## 3. ํ์คํธ ๋ณ๊ฒฝ ์ด๋ฒคํธ ๊ฐ์ง (Text Watcher)
