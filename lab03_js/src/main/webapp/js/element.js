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
    // id='d1'인 요소를 찾아서 바탕색 변경:
    btn1.addEventListener('click', function () {
        const d1 = document.getElementById('d1');
        //-> getElementById() 메서드는 문서 안에 같은 아이디가 여러개 있더라도,
        // 문서에서 가장 먼저 나오는 아이디 요소 "1개"만 리턴.
        
        d1.style.backgroundColor = 'lime';
    });
    
    // btn#btn2 요소에 클릭 이벤트 리스너를 등록:
    // class='c1'인 요소들의 바탕색을 변경
    const btn2 = document.querySelector('button#btn2');
    btn2.addEventListener('click', function () {
        const divs = document.getElementsByClassName('c1');
        // console.log(divs);
        for (let el of divs) {
            //console.log(el);
            el.style.backgroundColor = 'lavender';
        }
    });
    
    // button#btn3 요소에 클릭 이벤트 리스너를 등록:
    // tag 이름이 div인 요소들의 바탕색 변경
    const btn3 = document.querySelector('button#btn3');
    btn3.addEventListener('click', function () {
        const divs = document.getElementsByTagName('div');
        //console.log(divs);
        for (let el of divs) {
            el.style.backgroundColor = 'lightpink';
        }
    });
    
    // querySelector(), querySelectorAll(): CSS 선택자 문법을 아규먼트로 전달.
    // tagname, .classname, #id, tagname#id.classname
    // parent(부모) > child(자식)
    // ancestor(조상) desendent(자손)
    // element:pseudo-selector
    
    // button#btn4 요소에 클릭 이벤트 리스너를 등록:
    // id='d4' 요소의 바탕색 변경
    const btn4 = document.querySelector('button#btn4');
    btn4.addEventListener('click', () => {
        const d4 = document.querySelector('div#d4'); // '#d4'
        //-> HTML 문서에서 아이디가 'd4'인 첫번째 요소만 리턴.
        
        d4.style.backgroundColor = 'crimson';
    });
    
    // btn5 버튼에 클릭 이벤트 리스너를 등록:
    // class='c2'인 모든 요소들의 바탕색을 변경
    const btn5 = document.querySelector('button#btn5');
    btn5.addEventListener('click', () => {
        const divs = document.querySelectorAll('div.c2'); // '.c2'
        // console.log(divs);
        for (let el of divs) {
            el.style.backgroundColor = 'dodgerblue';
        }
    });
    
});
