# Frank_application
2019 모바일 프로그래밍 기말 프로젝트 : 플랭크 어플따라하기

## 기존 어플과 비교
### activity_intro
![image](https://user-images.githubusercontent.com/43840561/99203015-7d24cf80-27f4-11eb-9915-ce59876e8215.png)

### activity_main
![image](https://user-images.githubusercontent.com/43840561/99202989-71d1a400-27f4-11eb-8814-b3516fa401d5.png)
#### 메인화면
##### 기획
인트로 화면이 넘어가고 운동 계획을 선택하면 나오는 화면이 메인이 되게 하도록 기획하였다.
메뉴버튼을 만들어서 운동계획, 보고서, 계획 선택 등등 다른 기능을 가진 화면으로 전환하기 쉽게
만들고자 하였다.
##### 구현
기획한 대로 흰 박스로 표시해 놓은 메뉴 버튼 누르면  네비게이션 드로어를 구현해 메뉴가 보이도록 하였다.  
activity_main에서 app_bar를 include하고 app_bar에서 화면 상단에는 toolbar를 띄우고 content_main은 fragment로 구현하여 메뉴를 누를 때마다 content_main이 
바뀌도록 하였다. 초기 화면은 기획한 것 대로 [운동계획]으로 한다. 메뉴의 레이아웃은 
activity_main_drawer에서 구현하였다.  
네비바의 헤더는 nav_header_main에서 구현하였다.
네비게이션뷰에서 app:menu=“@menu/activity_main_drawer”를 통해 메뉴의 레이아웃을 불러온다.  
네비게이션 드로어인 메뉴에서 각 항목(운동 계획, 보고서, 계획 선택 등)을 클릭 시 각 항목에 해당하는 fragment로 화면이 바뀐다.

### content_main
![image](https://user-images.githubusercontent.com/43840561/99203159-fa504480-27f4-11eb-82d2-8164fcb112cd.png)
![image](https://user-images.githubusercontent.com/43840561/99203171-06d49d00-27f5-11eb-90f4-a12f1106bf88.png)
![image](https://user-images.githubusercontent.com/43840561/99203178-0f2cd800-27f5-11eb-869e-70fcc8864721.png)

#### 메뉴 각 항목 구현
##### 구현
기획한 대로 메뉴에서 각 항목을 누를 시 바뀌는 화면을 기획하였다. Fragment를 사용해서   
메인에서 fragment 부분이 바뀌도록 하였다.

###### 운동계획
(뒷 부분에서 자세히 설명)

###### 보고서 
총 운동 횟수, 소비한 칼로리, 운동한 시간을 볼 수 있게 텍스트 뷰를 설정하였다.   
라인차트로 나타낸 체중 그래프는 MpAndroidChart를 implement해서 구현하였다.  
화면을 실행하면 그래프가 움직이면서 나타나는 애니메이션을 추가하였다.  

###### 계획선택 
초급,중급, 고급 계획들 중 하나를 선택하여 ‘시작’버튼을 누르면 선택한 레벨의 운동계획 화면으로 넘어간다.  
스크롤 뷰로 초급,중급,고급 레벨을 담아 스크롤로 해서 볼 수 있게 구현하였다.  

###### 언어설정 
영어/한국어 항목을 만들었다.

###### 알람 
알람을 끄고 켜는 switc를 만들고 ‘+추가’ 버튼을 구현하였다.

###### 설정 
기획한 설정 화면과 항목을 비슷하게 구현하였다.   
Preferencescreen 레이아웃을 사용하여서 구현하였다.

###### 진행 재설정 
현재까지 운동하면서 설정해 놓았던 레벨이나 일자를 리셋 하는 화면.   
‘예‘,’아니요‘ 버튼을 구현하였다.

### Level 간 이동 / fragment_level1,2,3
![image](https://user-images.githubusercontent.com/43840561/99203308-764a8c80-27f5-11eb-9a8b-8a5f9170be62.png)
![image](https://user-images.githubusercontent.com/43840561/99203336-90846a80-27f5-11eb-8406-a85a5483ba06.png)

#### ‘<’ , ‘>’ 버튼 클릭 시 

##### 구현 
기존의 플랭크 어플 처럼 좌 우 표시의 버튼을 클릭했을 때 전 단계, 혹은 다음 단계 레벨의 화면으로 이동하도록 하였다.  
1일째부터 30일째 버튼을 구현하였고 스크롤 뷰로 내려서 30일째 버튼까지 볼 수 있도록 하였다.  
()일째 버튼을 누르면 MainActivity에서 LevelMainActivity로 새로운 액티비티가 열리면서 해당 날짜의 운동 루틴을 보여주도록 하였다.  
화면의 이미지 밑의 회색 줄(노란 박스)은 몇일 째 까지 했는지 진행을 알려주는 프로그레스 바를 구현하였다.  
상단의 이미지 부분은 부모 레이아웃으로 ReleativeLayout을 사용해서 이미지 위에 텍스트와 이미지 버튼을 구현 하였다. 

### level_()_main
![image](https://user-images.githubusercontent.com/43840561/99203499-202a1900-27f6-11eb-8752-c2621d9e3313.png)

### level_()_start
![image](https://user-images.githubusercontent.com/43840561/99203463-fbce3c80-27f5-11eb-8e35-714bacace58f.png)
![image](https://user-images.githubusercontent.com/43840561/99203473-05f03b00-27f6-11eb-9893-1d66aa7856ca.png)

### level_()_finish
![image](https://user-images.githubusercontent.com/43840561/99203592-5c5d7980-27f6-11eb-805f-2ab1860f08b8.png)


