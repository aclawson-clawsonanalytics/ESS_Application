/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#managerSelector").hide();
    
    // - Click event for ChangeManagerButton
    $("#ChangeManagerButton").click(function(){
        $("#managerSelector").show();
    });
});
function showManagerSelector(){
    $("#managerSelector").show();
}

