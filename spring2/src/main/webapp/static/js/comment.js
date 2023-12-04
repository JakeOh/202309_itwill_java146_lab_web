/**
 * comment.js
 * 댓글 목록 접기/펼치기
 * 댓글 등록
 * 댓글 수정
 * 댓글 삭제
 */

document.addEventListener('DOMContentLoaded', () => {
    // bootstrap 모듈의 Collapse 생성자를 호출해서 부트스트랩 Collapse 객체 생성.
    const bsCollapse = new bootstrap.Collapse('div#collapseComments', {toggle: false});
    // console.log(bsCollapse);
    
    // btnToggleComment 요소를 찾음.
    const btnToggleComment = document.querySelector('button#btnToggleComment');
    
    // btnToggleCommnet에 클릭 이벤트 리스너를 등록.
    btnToggleComment.addEventListener('click', () => {
        bsCollapse.toggle(); // Collapse 객체의 toggle() 메서드 호출.
        
        if (btnToggleComment.innerHTML === '댓글 보기') {
            btnToggleComment.innerHTML = '댓글 감추기';
        } else {
            btnToggleComment.innerHTML = '댓글 보기';
        }
    });
    
    // button#btnRegisterComment 요소를 찾음.
    const btnRegisterComment = document.querySelector('button#btnRegisterComment');
    
    // btnRegisterComment에 클릭 이벤트 리스너를 등록 -> 댓글 등록.
    btnRegisterComment.addEventListener('click', registerComment);
    
    /*
     * 댓글 등록 버튼의 이벤트 리스너(콜백)
     */
    function registerComment(event) {
        // 댓글을 등록할 포스트 번호:
        const postId = document.querySelector('input#id').value;
        // 댓글 내용:
        const ctext = document.querySelector('textarea#ctext').value;
        // 댓글 작성자:
        const writer = document.querySelector('input#writer').value;
        
        // 댓글 내용이 비어 있는 지 체크.
        if (ctext === '') {
            alert('댓글 내용을 입력하세요.');
            return; // 이벤트 콜백 종료
        }
        
        // Ajax 요청에서 보낼 데이터 객체(object)를 생성.
        // object: { propertyName: propertyValue, ... }
        // 속성 값으로 사용할 변수 이름과 객체의 속성 이름을 같게 만들 때에는 {variable, ...}
        /*
        const data = {
            postId: postId,
            ctext: ctext,
            writer: writer,
        };
        */
        const data = { postId, ctext, writer };
        console.log(data);
        
        // POST 방식의 Ajax 요청을 보냄. 응답/실패 콜백을 등록.
        axios.post('../api/comment', data) // post 방식의 Ajax 요청으로 data를 보냄.
            .then((response) => {
                console.log(response);
            }) // 성공 응답이 왔을 때 실행할 콜백 등록.
            .catch((error) => {
                console.log(error);
            }); // 실패 응답일 때 실행할 콜백 등록.
    }
    
});
