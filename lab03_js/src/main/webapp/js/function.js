/**
 * function.js
 * 08_function.html에 포함.
 */

/*
자바스크립트에서 함수를 선언(정의)하는 방법:
function 함수이름([파라미터 선언, ...]) {
    실행 코드;
    [return [반환값];]
}

함수의 리턴 타입을 선언하지 않음.
파라미터를 선언할 때는 const, let, var 키워드를 사용하지 않음!
*/

// 함수 선언:
function add(x, y) {
    console.log('x =', x, ', y =', y);
    return x + y;
}

let result = add(1, 20); // 함수 호출
console.log('result =', result);

// 자바스크립트의 함수는 파라미터의 타입을 검사하지 않음!
result = add('Hello', 'JavaScript');
console.log('result =', result);

// 자바스크립트 함수는 파라미터의 개수도 검사하지 않음!
result = add(1); // 파라미터 개수보다 적은 수의 아규먼트를 전달.
console.log('result =', result);
//-> 아규먼트를 전달하지 않은 파라미터는 undefined(값이 할당되지 않은 변수).
//-> 1 + undefined = NaN(Not a Number)

result = add(1, 2, 3); // 파라미터 개수보다 많은 수의 아규먼트를 전달.
console.log('result =', result);

// 자바스크립트 함수는 arguments 속성(property)을 가지고 있음.
// arguments 속성은 함수를 호출하는 곳에서 전달한 모든 아규먼트들을 저장하는 객체.
function testArgs() {
    console.log(arguments); // arguments 객체 - 배열.
    for (let x of arguments) {
        console.log(x);
    }
}

testArgs();
testArgs('안녕');
testArgs('안녕', 10, 20, 'hello');

/*
자바스크립트 함수는 객체(object)!
1. 프로퍼티(property, 멤버)를 가질 수 있음. (예) arguments
2. 변수에 저장할 수 있음.
3. 다른 함수를 호출할 때 아규먼트로 함수를 전달할 수 있음.
4. 함수 내부에서 다른 함수를 선언(정의)할 수 있음.
5. 함수 자체를 리턴할 수 있음.
*/

const plus = add; // 함수 객체 add를 변수 plus에 할당(저장).
console.log(plus); // 함수 객체를 출력.
console.log(plus(1, 5)); // 함수 호출 결과를 출력.

// 익명 함수를 선언하고, 변수에 저장.
const minus = function (x, y) {
    return x - y;
};

console.log(minus(1, 2));
