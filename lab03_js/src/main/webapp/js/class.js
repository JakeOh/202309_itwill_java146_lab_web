/**
 * class.js
 * 11_class.html에 포함
 */

// 전역 클래스 - 다른 파일에서 객체 생성 가능
class A {}

document.addEventListener('DOMContentLoaded', () => {
    // 지역 클래스 - 함수 내부에서만 사용 가능.
    class B {}
    
    // class 키워드를 사용한 클래스 선언에서,
    // 생성자(constructor), 메서드 선언에서는 function 키워드를 사용하지 않음.
    // 필드들을 선언할 때 const, let, var 키워드를 사용하지 않음.
    class Point {
        // 생성자(constructor): 필드 선언 & 초기화
        constructor(x, y) {
            this.x = x;
            this.y = y;
        }
        
        // 메서드:
        move(dx, dy) {
            this.x += dx;
            this.y += dy;
        }
    }
    
    // 클래스를 사용한 객체 생성:
    const pt1 = new Point(0, 0); // 클래스의 생성자는 클래스 이름으로 호출.
    console.log(pt1);
    
    pt1.move(1, -1);
    console.log(pt1);
    
});
