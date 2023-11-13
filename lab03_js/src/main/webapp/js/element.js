/**
 * element.js
 * 12_element.html에 포함
 */

// 브라우저가 HTML 문서의 모든 요소들을 생성하고 난 후, 이벤트 리스너 콜백을 실행.
document.addEventListener('DOMContentLoaded', function () {
    // button#btn1 요소를 찾음:
    const btn1 = document.getElementById('btn1'); // document.querySelector('#btn1')
    // console.log(btn1);
    
    // btn1 요소에 클릭 이벤트 리스너를 등록:
    btn1.addEventListener('click', function () {
        // id='d1'인 요소를 찾아서 바탕색 변경:
        const d1 = document.getElementById('d1');
        //-> getElementById() 메서드는 문서 안에 같은 아이디가 여러개 있더라도,
        // 문서에서 가장 먼저 나오는 아이디 요소 "1개"만 리턴.
        
        d1.style.backgroundColor = 'lime';
    });
    
});
