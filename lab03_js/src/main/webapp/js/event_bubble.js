/**
 * event_bubble.js
 * 14_event.html에 포함.
 */

document.addEventListener('DOMContentLoaded', function () {
    /*
    addEventListener(event, callback, useCapture) 파라미터:
      - event: 이벤트 이름(문자열).
      - callback: 이벤트가 발생했을 때 브라우저가 실행할 콜백(이벤트 리스너).
      - useCapture: 이벤트 처리 방식(boolean).
        (1) true: capturing 방식. 
            부모 요소가 먼저 이벤트를 처리하고, 자식 요소가 그 다음에 이벤트를 처리하는 방식.
        (2) false, undefined: bubbling 방식.
            자식 요소가 이벤트를 먼저 처리하고, 그 이벤트를 부모 요소에게 전달하는 방식.
    */
   
   const parent = document.querySelector('div#parent');
   // parent.addEventListener('click', function () {}, false);
   parent.addEventListener('click', function() {
       alert('div 1');
   });
   
   const child = document.querySelector('p#child');
   child.addEventListener('click', function (e) {
       alert('p 1');
       e.stopPropagation(); // 이벤트 처리가 끝난 후 부모 요소에게 이벤트를 전달하지 않음.
   });
   
   const parent2 = document.querySelector('div#parent2');
   parent2.addEventListener('click', function () {
       alert('div 2');
   }, true);
   
   const child2 = document.querySelector('p#child2');
   child2.addEventListener('click', function () {
       alert('p 2');
   }, true);
    
});
