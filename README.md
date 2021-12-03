## 따릉이 공급 불균형 해결  프로젝트
-------
## 프로젝트 멤버 및 담당 파트 소개
* 멤버 (1인 프로젝트)
  * 김휘곤 (컴퓨터공학과_20165122) 



## 프로젝트 소개 및 개발 내용 소개
>
>서울시에서 제공하는 공공 자전거 따릉이는 해마다 이용자수가 증가하는 공공 서비스입니다. 
늘어가는 수요에 발 맞춰 대여소에 따른 자전거 공급이 원활하게 이루어 지면 좋겠지만 실정은 그렇지 않습니다. 
특정 시간대에 몇 몇개의 대여소에는 자전거가 많이 몰리고, 다른 대여소에는 자전거가 없는 현상이 나타납니다. 
지금의 따릉이 분배는 따릉이맨(자전거를 분배하는 사람)이 거치율을 기준으로 70퍼센트를 유지하는 것입니다. 
거치율은 ‘자전거 주차 총 건수 / 거치대 개수’ 입니다. 이러한 분배 방식을 수요에 따른 공급 불균형이 필연적으로 나타납니다. 
대여가 많은 대여소와 대여가 많이 일어나지 않은 대여소의 거치대 개수가 크게 차이 나지 않기 때문입니다. 

>이 프로젝트는 이러한 현상을 줄이기 위해 aws forecast를 이용해 미래의 수요를 예측한 다음 예측한 수만큼 자전거를 회수하거나 공급할 수 있습니다. 
따라서 이용자들의 만족도가 높아짐을 기대할 수 있습니다.

>여의도에 있는 따릉이 10개 대여소의 자전거 개수를 1분마다 데이터 수집을 합니다. 이렇게 쌓은 데이터를 AWS forecast에 데이터 예측을 위해 넣어줍니다. 
AWS forecast에서 예측된 데이터를 html을 이용해 대여소 기준으로 나누어 예측된 데이터를 보여줍니다,

##프로젝트 개발 결과물 소개
>서울시 열린 데이터 광장에서 따릉이 실시간 대여정보 API를 가져와 mysql 데이터 베이스에 분마다 데이터를 저장합니다. 
mysql에 저장된 데이터를 csv로 저장시켜 awsforcast에 모델 학습을 합니다. 학습된 모델로 미래의 데이터를 예측한 다음 예측한 데이터를 AWS S3에 저장시킵니다. 
AWS EC2에 우분투를 설치한 다음 아파치를 올립니다. 웹서버에 csv 데이터를 정리한 다음 대여소 마다 결과 값을 웹 페이지로 확인 할 수 있도록 합니다.

![클라우드 컴퓨터 다이어그램](https://user-images.githubusercontent.com/94686003/144669835-ae9d7ec3-1ea0-4f34-8ed7-bf7df476b4fd.jpg)

## 개발 결과물을 사용하는 방법 소개
1. 13.125.251.198를 접속합니다. 다음과 같은 선택지 중 예측이 필요한 대여소를 클릭합니다.

![예시 1](https://user-images.githubusercontent.com/94686003/144670266-466c6297-a5f2-490b-9105-dd66e1d95d89.jpg)

2.  다음과 같이 데이터가 보이고 특정한 시간을 검색하고 싶으면 위의 ‘여기에 시간을 입력하세요’ 에 시간을 검색합니다.

![예시 2](https://user-images.githubusercontent.com/94686003/144670270-8d42c7fc-2738-4ec3-aef8-3068fe8e21d5.jpg)

3. 3시를 입력한 결과물 입니다. mean값에서 예측한 데이터 값을 확인 할 수 있습니다.

![예시 3](https://user-images.githubusercontent.com/94686003/144670275-22967227-af4e-4403-baae-124ab6e68bb9.jpg)

## 개발 결과물의 필요성 및 활용방안
> 기존의 거치율을 기준으로 따릉이를 공급하는 방법으로는 자전거 수요에 따른 공급 불균형을 해결 할 수 없습니다. 
머신러닝을 이용해 미래의 자전거 개수를 예측해 공급 불균형 문제를 해결 할 수 있습니다.
따릉이 맨이 자전거를 공급할 때 아래와 같은 웹사이트를 접속해 미래의 자전거 개수를 확인 할 수 있다면 개수를 비교해 자전거를 공급할 수 있습니다.
따라서 따릉이를 사용하는 이용자의 만족도가 높아질 것입니다.
