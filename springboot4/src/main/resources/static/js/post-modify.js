/**
 * post-modify.js
 * /post/modify.html에 포함.
 * 사용자 확인 후, 포스트 수정/삭제 요청을 보냄.
 */

document.addEventListener('DOMContentLoaded', () => {
    
    const btnDelete = document.querySelector('button#btnDelete');
    btnDelete.addEventListener('click', (e) => {
        const check = confirm('정말로 삭제할까요?');
        if (check) {
            const id = document.querySelector('input#id').value;
            location.href=`delete?id=${id}`;
        }
    });
    
    const btnUpdate = document.querySelector('button#btnUpdate');
    btnUpdate.addEventListener('click', (e) => {
        const title = document.querySelector('input#title').value;
        const content = document.querySelector('textarea#content').value.trim();
        if (title === '' || content === '') {
            alert('제목과 내용은 반드시 입력해야 합니다!');
            return;
        }
        
        const check =confirm('업데이트 내용을 저장할까요?');
        if (check) {
            const updateForm = document.querySelector('form#updateForm');
            updateForm.submit();
        }
    });

});
