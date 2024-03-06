# 사용 전 확인 사항
- Java가 설치되어 있어야합니다.
- **파일명**과 **폴더명**에 공백을 넣으면 안됩니다. 공백은 '-'로 표현해주세요. ex)영희와 철수(x) 영희와-철수(o)
# 사용 방법
처음 사용하는 상황을 가정합니다. 매우 간단하니 원할한 사용을 위해 읽어주세요.
1. 오른쪽 사이드에 Releases에 있는 TIL Hepler에 클릭 후 들어가서, TIL-HELPER.jar파일을 다운로드 받아주세요. 
![img.png](img.png)
2. 본인(로컬) 컴퓨터에 TIL 기록할 폴더를 생성합니다.
   - 사진 추가
3. 생성한 폴더를 깃허브와 연동 시킵니다. 로컬 Git폴더가 github와 연동되어 있어야지 자동으로 github에 업로그되는 기능을 사용할 수 있습니다. github와 연결해주세요.
4. jar파일을 실행합니다
   - 실행방법 : jar파일이 있는 폴더 위치에서 터미널이나 윈도우쉘에 java -jar a.jar을 
5. Git 저장소 루트 폴더를 찾아보면 README.md 가 생성된걸 확인 할 수 있습니다.
# 주의!!!
- 아래와 같은 폴더형식이 됩니다. 즉 하나의 카테고리만 되고 카테고리 내 카테고리는 현재는 불가합니다.(추후 업데이트)

# TIP
- shell script를 통해서 터미널 열때마다 java -jar a.jar을 직접 입력하지 말고 더블클릭 한번으로 실행이 가능합니다.
```shell
#!/bin/zsh

# jar 파일 경로
JAR_PATH="/Users/seonghunjeong/Desktop/tilHandler/out/artifacts/tilHandler_jar/tilHandler.jar"

# java 명령 실행
java -jar "$JAR_PATH"

```