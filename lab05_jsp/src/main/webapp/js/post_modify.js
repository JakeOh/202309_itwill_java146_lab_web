/**
 * post_modify.js
 * /post/modify.jsp에 포함.
 * 포스트 삭제, 업데이트 기능.
 */

 document.addEventListener('DOMContentLoaded', () => {
     // form 요소를 찾음.
     const form = document.querySelector('form#postModifyForm');
     
     // 포스트 번호(id)를 가지고 있는 요소를 찾음.
     const inputId = document.querySelector('input#id');
     
     // 포스트 제목(title)을 가지고 있는 요소를 찾음.
     const inputTitle = document.querySelector('input#title');
     
     // 포스트 내용(content)를 가지고 있는 요소를 찾음.
     const textareaContent = document.querySelector('textarea#content');
     
     // 삭제 버튼 찾기.
     const btnDelete = document.querySelector('button#btnDelete');
     
     // 수정 완료 버튼 찾기
     const btnUpdate = document.querySelector('button#btnUpdate');
     
     // 삭제 버튼에 클릭 이벤트 핸들러(리스너)를 등록.
     btnDelete.addEventListener('click', () => {
         const result = confirm('정말 삭제할까요?');
         // console.log(`confirm result = ${result}`); //-> true/false
         if (result) { // result === true: 사용자가 [확인(Yes)]을 선택하면
             location.href = `delete?id=${inputId.value}`; // delete 요청을 보냄.
         }
     });
     
     // 수정완료 버튼에 클릭 이벤트 리스너를 등록.
     btnUpdate.addEventListener('click', () => {
         // TODO
         
         form.action = 'update'; // 폼(양식)을 제출(submit)할 요청 주소.
         form.method = 'post'; // 폼 요청 방식(get/post).
         form.submit();
     });
     
 });
 