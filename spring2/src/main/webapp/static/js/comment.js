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
    console.log(bsCollapse);
    
});
