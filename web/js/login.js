/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function ValidateLoginForm(){
    //var pathName = window.location.pathname.substring(0,window.location.pathname.indexOf("/",2));
    var loginForm = document.getElementById("loginForm");
    var email = document.getElementById("loginEmail").value;
    var password = document.getElementById("loginPassword").value;
    if (!email || !password){
        alert("Missing username or password.");
    }else{
        
        loginForm.submit();
    }
}

