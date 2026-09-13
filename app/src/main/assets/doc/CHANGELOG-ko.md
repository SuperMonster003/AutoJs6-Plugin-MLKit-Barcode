******

### 릴리스 기록

******

# v1.0.2

###### 2026/09/13

* `수정` 플러그인 센터의 버전과 ABI 정보가 설치된 APK와 일치
* `수정` 인코딩된 이미지는 최대 64 MiB이며 파일 디스크립터와 파이프를 지원합니다
* `개선` 다운로드 파일 생성 전에 릴리스 APK의 버전, 서명 및 전체 변형 구성을 검증
* `개선` 이미지는 최대 16777216픽셀까지 지원

# v1.0.1

###### 2026/09/11

* `개선` 64비트 네이티브 라이브러리의 16 KB 페이지 정렬을 빌드 시 검증, manifest 계약 검사 및 JSON 보고서 지원

# v1.0.0

###### 2026/09/01

* `추가` 플러그인 ID `mlkit-barcode`, 엔진 `mlkit-barcode`인 ML Kit Barcode 플러그인 서비스 추가
* `추가` `org.autojs.plugin.MLKIT_BARCODE`를 통한 호스트 검색 및 호출 추가
* `추가` 이미지 파일 디스크립터 기반 `detect(imageFd, options)` 바코드 감지 API 추가
* `추가` 바코드 형식 필터, 최대 결과 수 제한, ML Kit `enableAllPotentialBarcodes` 옵션 추가
* `추가` `rawValue`, `displayValue`, `rawBytes`, 형식 이름, 값 유형 이름, 경계 상자, 모서리 좌표, 구조화된 페이로드 JSON 반환
* `추가` 스페인어/프랑스어/러시아어/아랍어/일본어/한국어/영어/중국어 간체/홍콩 중국어 번체/대만 중국어 번체용 로컬라이즈된 플러그인 메타데이터와 사용 설명 추가
* `추가` `arm64-v8a`/`armeabi-v7a`/`x86_64`/`x86` 및 `universal` APK용 ABI 분리 빌드 추가
* `개선` Google ML Kit barcode scanning 의존성, 네이티브 라이브러리, 모델 에셋을 AutoJs6 호스트 APK 외부에 유지
* `개선` 릴리스 APK 파일 이름에 버전과 ABI 변형 포함
* `개선` README 레이아웃과 Gradle 플랫폼 버전 관리 방식을 통일
* `개선` 플러그인 설명을 간결하게 다듬고 다국어 리소스의 문장 부호를 통일
* `의존성` `com.google.mlkit:barcode-scanning:17.3.0` 통합
