/**
 * object.js
 * 10_object.html에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    // JSON(JavaScript Object Notation): 자바스크립트 객체 표기법
    // { property: value, ... }
    
    const person = {
        name: '오쌤',
        age: 16,
        phones: ['010-0000-0000', '02-0000-0000'],
    };
    console.log(person);
    
    // 객체가 가지고 있는 프로퍼티 접근(사용): (1)참조 연산자, (2)인덱스 연산자
    console.log(person.name); // 참조 연산자
    console.log(person['age']); // 인덱스 연산자
    console.log(person.phones[0]);
    
    person.name = '홍길동'; // 객체가 가지고 있는 프로퍼티의 값을 변경.
    console.log(person);
    
});
