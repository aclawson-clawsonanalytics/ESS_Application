/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    SetupAccountInfoUI();
    SetupCampusListUI();
    
    
    // - Click event for ChangeManagerButton
    
    
    
    
});
function showManagerSelector(){
    $("#managerSelector").show();
}

function SetupAccountInfoUI(){
    var accountTypeSelector = document.getElementById("accountInfoTypeSelector");
    for(i=0; i < accountTypeSelector.options.length ; i++){
        if (accountTypeSelector.options[i].value === '${account.getType()}'){
            accountTypeSelector.selectedIndex = i;
            break;
        }
    }
    $("#managerSelector").hide();
    $("#ChangeManagerButton").click(function(){
        $("#managerSelector").show();
    });
    $("#SaveAccountInfoChangesButton").click(function(){
        
    });
}

function SetupCampusListUI(){
    var campusInfoNameField = document.getElementById("campusInfoNameField");
    $("#new-campus-form").hide();
    $("#add-campus-button").click(function(){
        $("new-campus-form").show();
    });
    
    $("#campus-selector").on('change',function(){
        var selectedCampus = $("#campus-selector").val();
        var campusInfoNameField = document.getElementById("campusInfoNameField");
        <c:forEach var="campus" items="${campusList}">
            if(selectedCampus === ${campus.getID()}{
                
        }
        </c:forEach>
        if (selectedCampus){
            $("#addCampusButton").hide();
            $("#clearCampusInfoButton").show();
            $("#saveCampusInfoButton").show();
            
        }
        if (!selectedCampus){
            $("#addCampusButton").show();
            $("#clearCampusInfoButton").hide();
            $("#saveCampusInfoButton").hide();
        }
        
    });
    
    $("#clearCampusInfoButton").hide();
    $("#saveCampusInfoButton").hide();
}

