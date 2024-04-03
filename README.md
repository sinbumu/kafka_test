# kafka_test

## kafka 연습

### aws msk 사용

software.amazon.msk:aws-msk-iam-auth 를 이용해서 접근권한을 얻는데

로컬에서 테스트 할 경우 : 
+ msk가 퍼블릭 서브넷에 있든가, 로컬에서 프라이빗 서브넷 접근 가능하게 vpn같은거 구축해둘것
+ aws cli등을 위한 profile세팅을 해두고 여기에 msk 클러스터로 작업을 수행할 권한이 있을 것

실제 서버 배포환경에서 :
+ 인스턴스에 부여하는 IAM 역할등에서 해당 카프카 프로듀서/컨슈머 서버가 접근 가능하게 권한을 추가해 둘 것

위처럼 했을 경우 이득?? - IAM 역할로 권한을 통제하니 실제 api서버에서 aws에 엑세스 하기 위한 엑세스키 등을 직접 가지고
있을 필요가 없고 클라우드 환경에서만 권한 관리
