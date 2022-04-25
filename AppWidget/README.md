## App Widget 구현

- Configuration Activity 적용
  - `seekBar`를 통해 배경 투명도를 조절하려던 의도,, 현재는 text에만 투명도를 표시해주었음 
- `android:resizeMode="horizontal"` : 가로 크기 변경만 허용
- `radius` 값을 넣어서 가로 크기변경했을 때 굴곡이 깨지는 지 확인

|Configuration Activity|App Widget 적용 모습|
|--|--|
|<img src="https://user-images.githubusercontent.com/37680108/165030818-4f626ff2-a30b-4c79-aa22-a1bc22b1bc8a.png" width="250">|<img src="https://user-images.githubusercontent.com/37680108/165030825-cfcae29e-ae55-4966-8744-02f8016faa15.png" width="250">|


![Image from Gyazo](https://i.gyazo.com/f1c2e277f3507c3db6dcf189e5431715.gif)

<br><br>

### 해야할 것
- [ ] 배경색 투명도 적용
- [ ] 투명도 로컬에 저장
- [ ] 투명도 낮아지면 폰트 색상 변경
