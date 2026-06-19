# TypeScript 시작하기

## 1. TypeScript란?

TypeScript는 **JavaScript에 강력한 타입(Type) 시스템을 더한 자바스크립트의 상위 확장(Superset) 언어**입니다. 마이크로소프트에서 개발했으며, 결국에는 일반 자바스크립트 코드로 컴파일(변환)되어 브라우저나 Node.js 환경에서 실행됩니다.

**핵심 특징:**
- **정적 타입 지원**: 코드를 실행하기 전(컴파일 시점)에 데이터의 타입을 명시하고 검사합니다.
- **컴파일 언어**: 브라우저는 TypeScript를 이해하지 못하므로, `tsc`라는 컴파일러를 통해 자바스크립트 코드로 변환해야 합니다.
- **JavaScript 호환**: 모든 JavaScript 코드는 유효한 TypeScript 코드입니다.

---

## 2. 환경 설정

### 2-1. Node.js 설치
TypeScript를 사용하려면 먼저 Node.js가 필요합니다.

```bash
# Node.js 설치 확인
node --version
npm --version
```

### 2-2. TypeScript 설치
전역 또는 프로젝트 로컬에 TypeScript를 설치합니다.

```bash
# 전역 설치 (권장하지 않음)
npm install -g typescript

# 프로젝트 로컬 설치 (권장)
npm install --save-dev typescript

# 버전 확인
tsc --version
```

### 2-3. tsconfig.json 생성
TypeScript 컴파일 설정 파일을 생성합니다.

```bash
npx tsc --init
```

생성된 `tsconfig.json` 파일의 주요 옵션:

```json
{
  "compilerOptions": {
    "target": "ES2020",              // 컴파일 대상 JavaScript 버전
    "module": "commonjs",            // 모듈 시스템 (commonjs, es6, esnext 등)
    "lib": ["ES2020"],               // 사용할 라이브러리
    "outDir": "./dist",              // 컴파일 결과 출력 폴더
    "rootDir": "./src",              // TypeScript 소스 폴더
    "strict": true,                  // 엄격한 타입 검사 활성화
    "esModuleInterop": true,         // ES 모듈 호환성
    "skipLibCheck": true,            // .d.ts 파일 검사 스킵
    "forceConsistentCasingInFileNames": true  // 파일명 대소문자 일관성
  },
  "include": ["src"],                // 컴파일할 파일 포함
  "exclude": ["node_modules"]        // 컴파일에서 제외
}
```

---

## 3. 컴파일과 실행

### 3-1. 기본 컴파일
TypeScript 파일을 JavaScript로 컴파일합니다.

```bash
# 단일 파일 컴파일
tsc hello.ts

# 전체 프로젝트 컴파일
tsc

# watch 모드 (파일 변경 시 자동 컴파일)
tsc --watch
```

### 3-2. JavaScript 실행
컴파일된 JavaScript를 실행합니다.

```bash
# Node.js로 실행
node hello.js

# 또는 직접 실행 (src/index.ts를 컴파일 후 실행)
npm start
```

### 3-3. 실행 예제
TypeScript 파일을 작성하고 컴파일해봅시다.

**hello.ts:**
```typescript
function greet(name: string): string {
  return `Hello, ${name}!`;
}

console.log(greet("TypeScript"));
```

**컴파일 및 실행:**
```bash
tsc hello.ts
node hello.js
# 출력: Hello, TypeScript!
```

---

## 4. TypeScript의 핵심 장점

### 4-1. 에러 사전 방지
자바스크립트는 코드가 실제로 실행되어야만 오류를 발견할 수 있는 동적 타입 언어입니다. 반면 TypeScript는 **코드를 작성하는 도중(컴파일 단계)에 타입 오류를 찾아내어 대규모 버그를 사전에 차단**합니다.

```typescript
// ❌ 컴파일 에러 발생
function sum(a: number, b: number): number {
  return a + b;
}
sum('5', 10);  // Error: Argument of type 'string' is not assignable to parameter of type 'number'

// ✅ 올바른 사용
sum(5, 10);  // 15
```

### 4-2. IDE의 강력한 자동 완성
코드 편집기가 변수나 함수의 타입을 정확히 알고 있기 때문에, **강력한 자동 완성(IntelliSense)**과 함수 매개변수 가이드를 제공합니다.

```typescript
const user: { name: string; age: number } = { name: "Alice", age: 25 };
user.  // IDE가 name, age 자동 완성 제시
```

### 4-3. 안전하고 효율적인 리팩토링
규모가 큰 프로젝트에서 변수명이나 함수의 구조를 바꿀 때, TypeScript는 **완벽한 타입 추적으로 프로젝트 전체의 참조를 안전하게 변경**할 수 있습니다.

### 4-4. 자체 문서화
코드 자체가 움직이는 문서 역할을 합니다. 함수의 입력값과 출력값의 타입이 명확히 명시되어 있기 때문에, **코드의 의도를 파악하기 훨씬 쉽습니다**.

```typescript
// 문서 없어도 타입으로 의도가 명확함
function calculatePrice(items: number[], taxRate: number): number {
  // items는 숫자 배열, taxRate는 숫자, 반환값도 숫자
}
```

---

## 5. 개발 워크플로우

### 단계별 프로젝트 구성

```
my-typescript-project/
├── src/
│   ├── index.ts
│   ├── utils.ts
│   └── types.ts
├── dist/                (컴파일 결과)
│   ├── index.js
│   ├── utils.js
│   └── types.js
├── tsconfig.json
├── package.json
└── package-lock.json
```

### 권장되는 개발 흐름

1. **src 폴더에서 TypeScript 코드 작성**
2. **tsc 또는 tsc --watch로 컴파일**
3. **dist 폴더의 JavaScript 파일로 실행**
4. **필요시 타입 검사 및 리팩토링**

---

## 6. 자주 사용되는 tsc 옵션

```bash
# 단일 파일만 컴파일
tsc hello.ts

# 모든 TypeScript 파일 컴파일
tsc

# 특정 대상 버전으로 컴파일
tsc --target es2020

# 모듈 시스템 지정
tsc --module commonjs

# 엄격한 모드 활성화
tsc --strict

# Watch 모드 (자동 컴파일)
tsc --watch

# 설정 파일 지정
tsc --project tsconfig.json
```

---

## 요약

- **TypeScript는 JavaScript의 확장**: 정적 타입 시스템 추가
- **환경 설정**: Node.js, npm, TypeScript 설치 필요
- **tsconfig.json**: 컴파일 설정 파일로 프로젝트 동작 제어
- **컴파일**: TypeScript → JavaScript 변환 과정 필수
- **장점**: 타입 안정성, IDE 지원, 리팩토링 안전성, 자체 문서화
- **학습 흐름**: 기본 개념 → 변수 및 타입 → 고급 기능으로 진행
