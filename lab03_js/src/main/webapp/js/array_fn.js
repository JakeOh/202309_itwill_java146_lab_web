/**
 * array_fn.js
 * 09_arrayfn.html에 포함
 */

document.addEventListener('DOMContentLoaded', function () {
    let numbers = []; // 빈 배열
    
    // numbers 배열에 정수 1 ~ 10까지 차례로 저장하고, 콘솔 로그 출력.
    for (let i = 1; i <= 10; i++) {
        // numbers.push(i);
        //-> push는 원본 배열에 원소를 추가. 원본 배열이 변경.
        
        numbers = numbers.concat(i);
        //-> concat은 원본 배열을 변경하지 않음! 새 원소가 추가된 새로운 배열을 만들어서 리턴.
    }
    console.log(numbers);
    
    // numbers에서 홀수들만 찾아서 저장하는 배열을 만들고, 콘솔 로그 출력.
    let odds = []; // 홀수들을 저장하기 위한 빈 배열.
    for (let x of numbers) {
        if (x % 2) { // x % 2 === 1
            odds = odds.concat(x);
        }
    }
    console.log(odds);
    
    odds = numbers.filter(function (x) {
        return x % 2;
    });
    //odds = numbers.filter((x) => x % 2);
    console.log(odds);
    
    // numbers 원소들의 제곱을 저장하는 배열을 만들고, 콘솔 로그 출력.
    let squares = []; // 제곱을 저장할 빈 배열.
    for (let x of numbers) {
        squares = squares.concat(x ** 2); // 거듭제곱 연산자: x ** 2 = x * x, x ** 3 = x * x * x
    }
    console.log(squares);
    
    squares = numbers.map((x) => x ** 2);
    console.log(squares);
    
    // numbers에서 홀수들의 제곱을 저장하는 배열을 만들고, 콘솔 로그 출력.
    const oddSquares = numbers.filter((x) => x % 2).map((x) => x ** 2);
    console.log(oddSquares);
    
});
