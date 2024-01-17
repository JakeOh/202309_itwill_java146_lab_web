/**
 * comments.js
 * /post/details.html에 포함.
 * 댓글 Collapse 보기/감추기
 * 댓글 등록
 * 댓글 목록 불러오기
 * 댓글 수정/삭제
 */

document.addEventListener('DOMContentLoaded', () => {
    
    // bootstrap 모듈의 Collapse 객체를 생성
    const bsCollapse = new bootstrap.Collapse('div#collapseComments', {toggle: false});
    
    // Collpase 객체 토글 버튼을 찾고 클릭 이벤트 리스너를 등록
    const btnToggleCollapse = document.querySelector('button#btnToggleCollapse');
    btnToggleCollapse.addEventListener('click', () => {
        bsCollapse.toggle(); // 감추기->보기, 보기->감추기.
        
        if (btnToggleCollapse.innerHTML === '댓글 보기') {
            btnToggleCollapse.innerHTML = '댓글 감추기';
        } else {
            btnToggleCollapse.innerHTML = '댓글 보기';
        }
    });
    
    // 댓글 등록 버튼의 이벤트 리스너:
    const btnRegisterCmt = document.querySelector('button#btnRegisterCmt');
    btnRegisterCmt.addEventListener('click', registerComment);
    
    
    // ----- 함수 정의(선언)들
    function registerComment() {
        alert('댓글 등록!');
    }
    
});
