/**
 * switch.js
 * 03_switch.html 파일에 포함.
 * switch-case 구문.
 */

// document.addEventListener('이벤트이름', 이벤트핸들러 함수);
//-> 이벤트가 발생되면 브라우저가 등록된 이벤트핸들러 함수를 호출.
document.addEventListener('DOMContentLoaded', function () {
    // HTML DOM(Document Object Model) 요소(객체)들이 모두 만들어졌을 때 실행되는 코드.
    
    // select#weekday 요소를 찾음:
    // const weekday = document.getElementById('weekday');
    const weekday = document.querySelector('select#weekday');
    console.log(weekday);
    
    // div#result 요소를 찾음:
    const result = document.querySelector('div#result');
    
    // button#btn 요소를 찾음:
    const btn = document.querySelector('button#btn');
    // btn 객체에 이벤트핸들러를 등록:
    btn.addEventListener('click', function () {
        // select에서 선택된 값 찾음:
        const value = weekday.value;
        switch (value) {
            case 'mon':
            case 'tue':
            case 'wed':
            case 'thu':
            case 'fri':
                result.innerHTML = '학원 출석';
                break;
            case 'sat':
            case 'sun':
                result.innerHTML = '쉼...';
                break;
            default:
                result.innerHTML = '몰라요~';
        }
    });
    
});
