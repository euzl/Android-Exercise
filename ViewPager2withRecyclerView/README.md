# ViewPager2 with RecyclerView
뷰페이저에서 각 페이지의 fragment를 따로 만들지 않고, 하나를 재사용하는 테스트!

### 확인완료
- 재사용 매우 잘 됨~
- `fragment` 내부에는 `RecyclerView` 로 구현함
- `position` 을 `fragment`에서 활용할 수 있나 테스트 -> 됨! 상단에 숫자가 `position` 번호
- `GridLayout`도 잘된당 (~~내 달력코드는 뭐가 문제였을까... list갱신에 대체 무슨일이...~~)

### 확인필요
- [ ] `fragment`로 객체 넘겨서 사용
- [ ] 무한 스크롤 구현!!
- [X] 중간부터 시작할 때 휘리릭 안 넘어가는 방법  
    ```java
    viewPager.setCurrentItem(50, false); // 두 번째 파라미터를 false로 하면 됨
    ```

### 기타 (gif)
|LinearLayout|GridLayout|
|--|--|
|[![Image from Gyazo](https://i.gyazo.com/ab6b5592279ca477dab225d8f3707e6d.gif)](https://gyazo.com/ab6b5592279ca477dab225d8f3707e6d)|[![Image from Gyazo](https://i.gyazo.com/7cd2a1cd5f43eb5318bb30580cf4cfca.gif)](https://gyazo.com/7cd2a1cd5f43eb5318bb30580cf4cfca)|
