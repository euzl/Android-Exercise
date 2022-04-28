## App Widget 구현

### 1차

- Configuration Activity 적용
  - `seekBar`를 통해 배경 투명도를 조절하려던 의도,, 현재는 text에만 투명도를 표시해주었음 
- `android:resizeMode="horizontal"` : 가로 크기 변경만 허용
- `radius` 값을 넣어서 가로 크기변경했을 때 굴곡이 깨지는 지 확인

|Configuration Activity|App Widget 적용 모습|
|--|--|
|<img src="https://user-images.githubusercontent.com/37680108/165030818-4f626ff2-a30b-4c79-aa22-a1bc22b1bc8a.png" width="250">|<img src="https://user-images.githubusercontent.com/37680108/165030825-cfcae29e-ae55-4966-8744-02f8016faa15.png" width="250">|


### 해야할 것
- [X] 배경색 투명도 적용
- [ ] 투명도 로컬에 저장


<br><br>

### 2차
- 투명도 앱 위젯(RemoteViews)에 적용
- 로컬 배경화면 불러와서 미리보기에 표시   


|배경화면미리보기|결과|
|--|--|
|<img src="https://user-images.githubusercontent.com/37680108/165678690-67962366-bb55-4f32-8b0d-f5cc1f9f4477.png" width="250">|<img src="https://user-images.githubusercontent.com/37680108/165678711-28b9e4ad-f06e-4eb1-96ee-cad97d7ca35a.png" width="250">|
