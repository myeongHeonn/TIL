---
name: cp
description: Commit all changes and push to remote repository
---

# Commit and Push (cp)

이 스킬은 현재 작업 디렉토리의 모든 변경사항을 자동으로 커밋하고 푸시합니다.

## 사용법

슬래시 커맨드로 호출:
```
/cp
```

## 동작 방식

1. `git add -A` - 모든 변경사항 스테이징
2. `git commit -m` - 커밋 메시지와 함께 커밋 생성
3. `git push` - 원격 저장소에 푸시

## 예시

프로젝트의 파일들을 수정한 후:
```
/cp
```

이 명령어로 모든 변경사항이 자동 커밋 및 푸시됩니다.

## 주의사항

- 커밋 메시지는 자동으로 생성됩니다
- 푸시 전에 변경사항을 확인하려면 `git status`를 먼저 실행하세요
