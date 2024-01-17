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
            getAllComments(); // 댓글 목록 갱신
        } else {
            btnToggleCollapse.innerHTML = '댓글 보기';
        }
    });
    
    // 댓글 등록 버튼의 이벤트 리스너:
    const btnRegisterCmt = document.querySelector('button#btnRegisterCmt');
    btnRegisterCmt.addEventListener('click', registerComment);
    
    
    // ----- 함수 정의(선언)들 -----
    /*
     * btnRegisterCmt 버튼의 클릭 이벤트 리스너.
     * 댓글 등록 Ajax 요청을 보내고, 응답을 받으면 댓글 목록을 갱신하는 "비동기" 함수.
     */
    async function registerComment() {
        // 댓글이 달리는 포스트의 아이디
        const postId = document.querySelector('input#id').value;
        // 댓글 내용
        const text = document.querySelector('textarea#cmtText').value;
        // 댓글 작성자
        const writer = document.querySelector('input#cmtWriter').value;
        
        if (text === '') {
            alert('댓글 내용을 입력하세요!');
            return; // 함수 종료.
        }
        
        // Ajax 요청에 포함시켜서 보낼 데이터
        const data = {postId, text, writer};
        
        try {
            // Ajax POST 요청을 보냄.
            const response = await axios.post('../api/comment', data);
            console.log(response);
            document.querySelector('textarea#cmtText').value = '';
            alert('댓글 등록 성공!');
            
            getAllComments(); // 댓글 목록 갱신
            
        } catch (error) {
            console.log(error);
        }
        
    } // end function registerComment()
    
    /*
     * 포스트 상세보기 페이지에서, 포스트에 달려 있는 모든 댓글 목록을 요청, 응답을 처리.
     * 댓글 목록 Collapase 객체를 펼칠 때, 댓글 등록이 성공했을 때 
     * 댓글 목록을 갱신하기 위해서 호출. 
     */
    async function getAllComments() {
        const postId = document.querySelector('input#id').value;
        const uri = `../api/comment/all/${postId}`; // Ajax 요청을 보낼 주소
        try {
            const response = await axios.get(uri);
            console.log(response);
            
            // TODO: 댓글 목록 html 코드를 작성.
            
        } catch (error) {
            console.log(error);
        }
        
    } // end function getAllComments()
    
});
