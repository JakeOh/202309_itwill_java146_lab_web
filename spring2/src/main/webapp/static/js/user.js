/**
 * user.js
 * 회원가입 아이디 중복 체크, 회원가입 버튼 활성화/비활성화.
 */

document.addEventListener('DOMContentLoaded', () => {
    let idChecked = false;
    let pwdChecked = false;
    let emailChecked = false;
    const btnRegister = document.querySelector('button#btnRegister');
        
    const inputUserid = document.querySelector('input#userid');
    inputUserid.addEventListener('change', checkUserid);
    
    const inputPassword = document.querySelector('input#password');
    inputPassword.addEventListener('change', checkPassword);
    
    const inputEmail = document.querySelector('input#email');
    inputEmail.addEventListener('change', checkEmail);
    
    async function checkUserid(e) {
        const userid = e.target.value; // inputUserid.value
        const uri = `checkid?userid=${userid}`;
        const response = await axios.get(uri);
        
        const checkIdResult = document.querySelector('div#checkIdResult');
        if (response.data === 'Y') {
            idChecked = true;
            checkIdResult.innerHTML = '멋진 아이디입니다!';
            checkIdResult.classList.remove('text-danger');
            checkIdResult.classList.add('text-success');
        } else {
            idChecked = false;
            checkIdResult.innerHTML = '사용할 수 없는 아이디입니다.';
            checkIdResult.classList.remove('text-success');
            checkIdResult.classList.add('text-danger');
        }
        
        if (idChecked && pwdChecked && emailChecked) {
            btnRegister.classList.remove('disabled');
        } else {
            btnRegister.classList.add('disabled');
        }
    }
    
    function checkPassword(e) {
        if (e.target.value === '') {
            pwdChecked = false;
        } else {
            pwdChecked = true;
        }
        
        if (idChecked && pwdChecked && emailChecked) {
            btnRegister.classList.remove('disabled');
        } else {
            btnRegister.classList.add('disabled');
        }
    }
    
    function checkEmail(e) {
        if (e.target.value === '') {
            emailChecked = false;
        } else {
            emailChecked = true;
        }
        
        if (idChecked && pwdChecked && emailChecked) {
            btnRegister.classList.remove('disabled');
        } else {
            btnRegister.classList.add('disabled');
        }
    }
    
});
