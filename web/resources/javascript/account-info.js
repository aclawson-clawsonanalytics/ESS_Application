/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    importClass(com.clawsonanalytics.ESS.App.ModelLayer.Campus);;
    SetupAccountInfoUI();
    SetupCampusListUI();
    
    
    // - Click event for ChangeManagerButton
    
    
    
    
});
function showManagerSelector(){
    $("#managerSelector").show();
}

function SetupAccountInfoUI(){
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
        var selectedCampusID = $("#campus-selector").val();
        if (selectedCampusID > 0){
            $("#addCampusButton").hide();
            $("#clearCampusInfoButton").show();
            $("#saveCampusInfoButton").show();
            var campus = Java.type("com.clawsonanalytics.ESS.App.ModelLayer.Campus");
            campus = Campus.GetByID(selectedCampusID);
            campusInfoNameField.innerHTML = campus.getName();
        }
        if (selectedCampusID <= 0){
            $("#addCampusButton").show();
            $("#clearCampusInfoButton").hide();
            $("#saveCampusInfoButton").hide();
        }
        
    });
    
    $("#clearCampusInfoButton").hide();
    $("#saveCampusInfoButton").hide();
}

