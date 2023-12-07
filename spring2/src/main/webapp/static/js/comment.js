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
            
            getAllComments(); // 현재 포스트의 댓글 전체 목록 요청
            
        } else {
            btnToggleComment.innerHTML = '댓글 보기';
        }
    });
    
    // button#btnRegisterComment 요소를 찾음.
    const btnRegisterComment = document.querySelector('button#btnRegisterComment');
    
    // btnRegisterComment에 클릭 이벤트 리스너를 등록 -> 댓글 등록.
    btnRegisterComment.addEventListener('click', registerComment);
    
    // 부트스트랩 모달 객체 생성.
    const modal = new bootstrap.Modal('div#commentModal', {backdrop: true});
            
    // 모달의 [저장 내용 변경] 버튼(#btnUpdateComment)을 찾고, 클릭 이벤트 리스너를 등록
    const btnUpdateComment = document.querySelector('button#btnUpdateComment');
    btnUpdateComment.addEventListener('click', updateComment);
    
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
                if (response.data === 1) {
                    alert('댓글 등록 성공!');
                    // 댓글 입력 textarea의 내용을 비움.
                    document.querySelector('textarea#ctext').value = '';
                    getAllComments(); // 댓글 목록 갱신.
                }
                
            }) // 성공 응답이 왔을 때 실행할 콜백 등록.
            .catch((error) => {
                console.log(error);
            }); // 실패 응답일 때 실행할 콜백 등록.
    } // end function registerComment
    
    /*
     * 현재 상세보기 페이지의 포스트에 달려 있는 모든 댓글 목록을 요청(Ajax) 
     * & 응답 처리 콜백 등록 
     */
    function getAllComments() {
        // 댓글 목록을 요청하기 위한 포스트 번호(아이디):
        const postId = document.querySelector('input#id').value;
        
        // 댓글 목록을 요청할 URI(주소, 경로)
        const uri = `../api/comment/all/${postId}`;
        // console.log(uri);
        
        axios.get(uri) // GET 방식의 Ajax 요청으 보냄.
            .then((response) => {
                console.log(response);
                //-> response 객체의 data 속성(property): 서버에서 응답으로 보낸 결과(객체)
                
                // 댓글 목록 HTML을 작성 -> 댓글 목록을 브라우저 화면에 보여줌.
                makeCommentElements(response.data);
                
            }) // 성공 응답이 왔을 때 실행할 콜백 등록
            .catch((error) => {
                console.log(error);
            }); // 요청 실패일 때 실행할 콜백 등록
        
    } // end function getAllComments
    
    /*
     * 댓글 목록 HTML을 작성하고, div#comments 영역에 추가하는 함수.
     * argument data: 댓글 목록(배열).
     */
    function makeCommentElements(data) {
        // 댓글 목록 HTML을 추가할 영역.
        const divComments = document.querySelector('div#comments');
        
        // 댓글 목록 HTML 코드
        let htmlStr = '';
        
        // for (let i = 0; i < data.length; i++) {}
        for (let comment of data) {
            // console.log(comment);
            // comment 객체의 modifiedTime 값(Timestamp)을 날짜/시간 타입의 문자열로 변환
            const time = new Date(comment.modifiedTime).toLocaleString();
            
            htmlStr += `
            <div class="card card-body my-1">
                <div>
                    <span class="d-none">${comment.id}</span>
                    <span class="fw-bold">${comment.writer}</span>
                    <span class="text-secondary">${time}</span>
                </div>
                <div>${comment.ctext}</div>
                `;
           
           // 댓글 작성자 아이디와 로그인 아이디가 같은 경우에만 [삭제/수정] 버튼을 보여줌.
           if (comment.writer === signedInUser) { 
                htmlStr +=`
                <div>
                    <button class="btnCommentDelete btn btn-outline-danger" 
                        data-id="${comment.id}">삭제</button>
                    <button class="btnCommentModify btn btn-outline-success" 
                        data-id="${comment.id}">수정</button>
                </div>`;
            }
            
            htmlStr += '</div>'; // <div class="card">의 종료 태그
            
        }
        
        // 작성된 댓글 목록 HTML 코드를 div#comments 영역에 추가.
        divComments.innerHTML = htmlStr;
        
        // 모든 삭제 버튼을 찾아서 클릭 이벤트 리스너를 등록
        const btnDeletes = document.querySelectorAll('button.btnCommentDelete');
        for (let btn of btnDeletes) {
            btn.addEventListener('click', deleteComment);
        }
        
        // 모든 수정 버튼을 찾아서 클릭 이벤트 리스너를 등록
        const btnModifies = document.querySelectorAll('button.btnCommentModify');
        for (let btn of btnModifies) {
            btn.addEventListener('click', showCommentModal);
        }
        
    } // end function makeCommentElements()
    
    /*
     * 댓글 삭제 Ajax 요청을 보내고, 응답 처리.
     * argument e: 이벤트 객체.
     */
    function deleteComment(e) {
        console.log(e.target); // e.target: 이벤트가 발생한 타겟. 여기서는 삭제 버튼.
        
        const result = confirm('정말 삭제할까요?'); //-> true:확인(Y), false:취소(N)
        if (!result) { // 사용자가 [취소]를 클릭했을 때
            return; // 콜백 종료
        }
        
        // 삭제할 댓글 아이디를 찾음.
        const id = e.target.getAttribute('data-id');
        
        // Ajax 요청을 보냄.
        const uri = `../api/comment/${id}`;
        axios.delete(uri) // DELETE 방식의 Ajax 요청을 보냄.
            .then((response) => {
                console.log(response);
                
                if (response.data === 1) {
                    alert('댓글 삭제 성공!');
                    getAllComments(); // 댓글 목록 갱신.
                }
                
            }) // 응답(response)를 처리하는 콜백 등록.
            .catch((error) => {
                console.log(error);
            }); // 에러(error)를 처리하는 콜백 등록.
        
    } // end function deleteComment()
    
    /*
     * 댓글 [수정] 버튼의 클릭 이벤트 리스너 콜백 - 댓글 수정 모달 보여주기.
     * async function: 비동기식(asynchronous)으로 동작하는 함수를 await 키워드를 사용해서
     * 호출하는 코드가 있을 때.
     */
    async function showCommentModal(e) {
        // 이벤트 타겟(수정 버튼)에서 data-id 속성 값(댓글 아이디)를 읽음.
        const id = e.target.getAttribute('data-id');
        
        try {
            // Ajax 요청을 보내서 해당 아이디의 댓글을 검색
            const response = await axios.get(`../api/comment/${id}`);
            console.log(response);
            const commentId = response.data.id;
            const ctext = response.data.ctext;
            
            // 모달의 input과 textarea를 채움.
            document.querySelector('input#modalCommentId').value = commentId;
            document.querySelector('textarea#modalCommentText').value = ctext;
            
            modal.show(); // 모달 객체 보여줌.
        } catch (error) {
            console.log(error);
        }
        
    } // end async function showCommentModal()
    
    /*
     * 댓글 [변경 내용 저장] 버튼(btnUpdateComment)의 클릭 이벤트 리스너(콜백).
     * Ajax PUT 요청을 보내고, 댓글 업데이트 성공 응답이 오면 모달을 닫음. 
     */
    async function updateComment(e) {
        // 수정할 댓글 아이디
        const id = document.querySelector('input#modalCommentId').value;
        // 댓글 수정 내용
        const ctext = document.querySelector('textarea#modalCommentText').value;
        
        if (ctext === '') { // 댓글이 비어 있으면
            alert('댓글 내용을 입력하세요.');
            return;
        }
        
        if (!confirm('수정한 내용을 저장할까요?')) { // [취소]를 클릭하면
            return; // 콜백 종료
        }
        
        try {
            // Ajax PUT 요청을 보냄.
            const response = await axios.put(`../api/comment/${id}`, { ctext });
            if (response.data === 1) { // 업데이트 성공 응답인 경우
                modal.hide(); // 모달을 숨김.
                getAllComments(); // 댓글 목록 갱신.
            }
        } catch (error) {
            console.log(error);
        }
        
    } // end async function updateComment()
    
});
