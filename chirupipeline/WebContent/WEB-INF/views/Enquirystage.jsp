<%@page import="javax.management.AttributeValueExp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List, com.model.*,com.model.TrackerEnquiry,com.model.RejectEnquiry,com.model.TrackerEnquiry,com.model.RejectRfp,com.model.MainModelForm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>



<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>Enquiry Tracker</title>
 <style type="text/css">
 
 
 table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
        
        
        .form-overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        z-index: 9999;
        display: none;
    }

    .form-container {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
        padding: 20px;
    }

    .close {
        position: absolute;
        top: 10px;
        right: 10px;
    }
   
    .disabled {
        opacity: 0.5;
        pointer-events: none;
    }
 td:nth-child(7):contains("rfpcomplete") {
    color: green;
}

td:nth-child(2):contains("Rejected") {
    background-color: red;
}
.green-background {
  background-color: green;
  color: white;
}





.progress-bar-animated {
  -webkit-animation: progress-bar-stripes 2s linear infinite;
  animation: progress-bar-stripes 2s linear infinite;
}

@-webkit-keyframes progress-bar-stripes {
  0% {
    background-position: 1rem 0;
  }
  100% {
    background-position: 0 0;
  }
}

@keyframes progress-bar-stripes {
  0% {
    background-position: 1rem 0;
  }
  100% {
    background-position: 0 0;
  }
}

 
 
 </style>
   
 
    
</head>
<body>




<div id="formOverlay" class="form-overlay" width="700px">
	  <div class="form-container">
	  
	    <button id="closeFormButton" class="btn btn-secondary close"><i class="fas fa-times"></i></button>
	    

	    <form id="overlayForm" class="hidden-form" style="display: none;">
      <!-- Form fields -->
      <h1>Enquary</h1><br>
      <label for="enqrid">Enquiry ID:</label>
      <input type="text" id="enqrid" name="enqrid" required readonly><br><br>
      
      <label for="enqrcustid">Enquiry Customer ID:</label>
      <input type="text" id="enqrcustid" name="enqrcustid" required readonly><br><br>
      
       <label for="enqrcreatby">Enquiry Created By:</label>
      <input type="text" id="enqrcreatby" name="enqrcreatby" required readonly><br><br>
      
      <label for="enqrsubject">Enquiry Subject:</label>
      <input type="text" id="enqrsubject" name="enqrsubject" required readonly><br><br>
      
      
      
       <label for="enqrassignto">Enquiry Assigned To:</label>
      <input type="text" id="enqrassignto" name="enqrassignto" required readonly><br><br>
      
       <label for="enqrluser">Enquiry last_user:</label>
      <input type="text" id="enqrluser" name="enqrluser" required readonly><br><br>
      
      <label for="status">status:</label>
      <input type="text" id="status" name="status" required readonly><br><br>
      
      
      
   
     
      <div class="progress" style="width:700px;">
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId1" role="progressbar" style="width: 10%">Status</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId2" role="progressbar" style="width: 10%">Enquiry Approved</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId3" role="progressbar" style="width: 20%">Converted to RFP</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId4" role="progressbar" style="width: 20%">RFP Reject</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId5" role="progressbar" style="width: 10%">RFP Approve</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId6" role="progressbar" style="width: 30%">RFP Completed</div>
      </div>




     
   </form>
   
    
   <form id="rfp" class="hidden-form" style="display: none;" width="700px">
   <h1>RFP</h1><br>
   <label for="rfpenqrid">RFP Enquiry ID:</label>
      <input type="number" id="rfpenqrid" name="rfpenqrid" required readonly><br><br>
      
       <label for="rfprcreatedausrid">Rfpr Created Auser Id:</label>
      <input type="text" id="rfprcreatedausrid" name="rfprcreatedausrid" required readonly><br><br>
      
       <label for="rfprstatus">Rfpr Status:</label>
      <input type="text" id="rfprstatus" name="rfprstatus" required readonly><br><br>
      
      <label for="rfpassignto">rfp Assigned To:</label>
      <input type="text" id="rfpassignto" name="rfpassignto" required readonly><br><br>
      
       <label for="rfpsubject">Rfp Subject:</label>
      <input type="text" id="rfpsubject" name="rfpsubject" required readonly><br><br>
      
      <label for="rfpintronote">Rfp Intro Note:</label>
      <input type="text" id="rfpintronote" name="rfpintronote" required readonly><br><br>
      
      <label for="rfpstatus">status:</label>
      <input type="text" id="rfpstatus" name="rfpstatus" required readonly><br><br>
      
      
      
      
    
       
      <div class="progress" style="width:700px;">
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId11" role="progressbar" style="width: 10%>Status</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId22" role="progressbar" style="width: 30%">Enquiry Approved</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId33" role="progressbar" style="width: 40%">Converted to RFP</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId44" role="progressbar" style="width: 50%">RFP Reject</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId55" role="progressbar" style="width: 60%">RFP Approve</div>
        <div class="progress-bar progress-bar-striped progress-bar-animated" id="statusBarId66" role="progressbar" style="width: 90%">RFP Completed</div>
      </div>


     
   
   
   </form>
   
   
   
   
   
   
	</div>
</div>




<% List<TrackerEnquiry> enqid = (List<TrackerEnquiry>) request.getAttribute("enquiry"); %>
<% List<RejectEnquiry> rejectdata = (List<RejectEnquiry>) request.getAttribute("reject"); %>
<% List<RejectRfp> convertrfp = (List<RejectRfp>) request.getAttribute("converttorfo"); %>
<% List<RejectRfp> rfprejected = (List<RejectRfp>)request.getAttribute("rfpreject"); %>
<%List<RejectRfp> rfpapprove =(List<RejectRfp>)request.getAttribute("rfpapprove"); %>
<%List<TrackerRfp> rfpcomplete =(List<TrackerRfp>)request.getAttribute("rfpcompleted"); %>
<h1>Enquiry Tracker</h1>
<table id="totalTable">
    <tr>
        <th>Enqr_ID</th>
        <th>Status</th>
        <th>Enq_approve</th>
        <th>Converted_To_Rfp</th>
        <th>RFP Reject</th>
        <th>RFP Approve</th>
        <th>RFP Completed</th>
        <th>View</th>
    </tr>
    <% for (int i = 0; i < enqid.size(); i++) { %>
        <tr id="<%= enqid.get(i).getEnqrid() %>">
            <td><%= enqid.get(i).getEnqrid() %></td>
            
           	<td id="<%= "td2"+""+enqid.get(i).getEnqrid() %>"></td>
           	<td id="<%= "td3"+""+enqid.get(i).getEnqrid() %>"></td>
           	<td id="<%= "td4"+""+enqid.get(i).getEnqrid() %>"></td>
           	<td id="<%= "td5"+""+enqid.get(i).getEnqrid() %>"></td>
           	<td id="<%= "td6"+""+enqid.get(i).getEnqrid() %>"></td>
           	<td id="<%= "td7"+""+enqid.get(i).getEnqrid() %>"></td>
           	
            <td>
                <button  id="showForm1" class="btn btn-primary request-button" data-form="overlayForm" 
                    onclick="getForm('<%=enqid.get(i).getEnqrid() %>');">view</button>
                    
                   
            </td>
        </tr>
    <% } %>
</table>
<script>

$(document).ready(function() {
	
	$('#totalTable').hide();
	
	
	  $("table tr td:nth-child(3)").each(function() {
	    if ($(this).text() === "Approve") {
	      $(this).addClass("green-background");
	    }
	  });
	  
	  
		$('#totalTable').show();

	});

$(document).ready(function() { 
	
	
	
	var rowNo=0;
		   $("tr").each(function() {
				if(rowNo==0)
				{
				rowNo=rowNo+1;
				}
			else{
				rowNo=rowNo+1;
				 var enqrid = $(this).attr("id");
			        getStatus(enqrid);
			}		       
		    });
    function getStatus(id) {
  	  $.ajax({
  	    url: "form", // Replace with the actual URL to retrieve the form data
  	    method: "GET",
  	    data: {
  	      id: id
  	    },
  	    success: function(response) {
  	      // Handle the response and populate the form fields
  	      
  	      
  	     console.log(response)
  	      
  	    
  	     const parsedResponse = JSON.parse(response);

  // Extract the values
           const status = parsedResponse.status;
  	      
  	      if (status === 'reject') {
  	    	  const enqrId = parsedResponse.data.enqr_id;
  	    	  
 	    	  

  	    	  const status = parsedResponse.status;
  	    	  
  	    	  console.log('enqr_id:', enqrId);
  	    
  	    	  console.log('status', status);
  	       
  	    	  $("#td2"+id).text(status);
  	        
  	      }
  	      else if (status === 'Approve') {
  	    	  
  	    	  const enqrId = parsedResponse.data.enqr_id;
  	    	 
  	    	  const status = parsedResponse.status;
  	    	  
  	    	 
  	    	  
  	    	  console.log('enqr_id:', enqrId);
  	    	
  	    	  console.log('status', status);
  	    	  
  	        // Handle 'Approve' response
  	        
  	        
  	    	  $("#td3"+id).text(status);
  		       
  	       
  	        
  	      }
  	      
  	      else if (status === 'convertrfp') {
  		        // Handle 'convertrfp' response
  		        
  		    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
  		    	  
  		    	  const status = parsedResponse.status;
  		        	 $('#statusBarId1').show();
 			    	$('#statusBarId2').show();
  					$('#statusBarId3').show();
  		    	  
  		    	  console.log('rfprenqr_id:', rfprenqrId);
  		    	 
  		    	 console.log('rfpstatus', status);    

  		    	 
  		    	  
     	    	  $("#td4"+id).text(status);
     		  
  		     
  		        
  		       
  		        
  		      }
  	      
  	      
  	      
  	      else if (status === 'rfpreject') {
  		        // Handle 'rfpreject' response
  		        
  		    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
  		    	 
  		    	  const status = parsedResponse.status;
  		    	  
  		    	   $('#statusBarId1').show();
 			    	$('#statusBarId2').show();
					$('#statusBarId3').show();
					$('#statusBarId4').show();

  		    	  console.log('rfprenqr_id:', rfprenqrId);
  		    	  
  		    	 console.log('rfpstatus', status);        

  		    
  		    	 $("#td5"+id).text(status);
  		        
  		        
  		        
  		      } else if (status === 'rfpapprove'){
  		        // Handle other responses
  		        
  		    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
  		    	 
  		    	  const status = parsedResponse.status;
  		    	  
  		    	 $('#statusBarId1').show();
 				$('#statusBarId2').show();
				$('#statusBarId3').show();
				$('#statusBarId4').show();
				$('#statusBarId5').show();

  		    	  console.log('rfprenqr_id:', rfprenqrId);
  		    	 
  		    	 console.log('rfpstatus', status);        

  		    	 $("#td6"+id).text(status);
  		      
  		       
  		        
  		        
  		      }
  		      else if(status=="rfpcomplete"){
  		    	  
  		    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
   		    	 
  		    	  const status = parsedResponse.status;
  		    	  
  		    	 $('#statusBarId1').show();
 				$('#statusBarId2').show();
				$('#statusBarId3').show();
				$('#statusBarId4').show();
				$('#statusBarId5').show();
				$('#statusBarId6').show();
  		    	  
  		    	  console.log('rfprenqr_id:', rfprenqrId);
  		    	 
  		    	 console.log('rfpstatus', status);   
  		    	  
  		    	 $("#td7"+id).text(status);
  		    	  
  		      }      
  	    },
  	    error: function() {
  	      // Handle the error case
  	      console.log("Error occurred while retrieving form data.");
  	    }
  	  });
  	}

  var formOverlay = $('#formOverlay');
  var formContainer = formOverlay.find('.form-container');
  

  $('.request-button').click(function(e) {
    e.stopPropagation();
    var formId = $(this).data('form');
    var form = $('#' + formId);
    // Display the selected form and open the overlay
     var enqrid = $(this).data('enqrid');
       var rfpenqrid =$(this).data('rfpenqrid');       
              // Populate form fields with the corresponding data
              form.find('#enqrid').val(enqrid);
              form.find('#enqrcustid').val(''); // Populate with customer ID data
              form.find('#enqrcreatby').val(''); // Populate with created by data
              form.find('#enqrsubject').val(''); // Populate with subject data
                                                 // Populate with description data
              form.find('#enqrassignto').val(''); // Populate with assigned to data
              form.find('#enqrluser').val(''); // Populate with last user data
              form.find('#status').val('');
              
              
              
              
              
              
              form.find('#rfpenqrid').val(rfpenqrid);
              form.find('#rfprcreatedausrid').val('');
              form.find('#rfprstatus').val('');
              form.find('#rfpassignto').val('');
              form.find('#rfpsubject').val('');
              form.find('#rfpintronote').val('');
              form.find('#rfpstatus').val('');
              
              
              
             
              
    
              
   
    formOverlay.fadeIn();
  
    form.show();
    

  });
  
//Close form overlay when the close button is clicked
  $('#closeFormButton').click(function(e) {
    e.stopPropagation();
    closeFormOverlay();
  });
  // Close form overlay when clicking outside the form container or form overlay
  $(document).on('click', function(e) {
    if (!formContainer.is(e.target) && formContainer.has(e.target).length === 0) {
      closeFormOverlay();
    }
  });
  
  /// the form dont show two forms at a time 
  
  function getForm() {
	  var form1 = document.getElementById("overlayForm");
	  var form2 = document.getElementById("rfp");
	  
	 
	  if (form1.style.display === "none") {
		    
	    form1.style.display = "block";
	    form2.style.display = "none";
	    
	    formOverlay.fadeIn();
	    
	    form.show();
	    
	  } else {
 		  
  	    form1.style.display = "none";
  	    form2.style.display = "block";
  	    
  	  formOverlay.fadeIn();
  	  
      form.show();
		
	  }
	}

  
  
  
  function closeFormOverlay() {
    formOverlay.fadeOut();
  }
});
  

function getForm(id) {
	  $.ajax({
	    url: "form", // Replace with the actual URL to retrieve the form data
	    method: "GET",
	    data: {
	      id: id
	    },
	    success: function(response) {
	      // Handle the response and populate the form fields
	      
	      console.log("Hello chiru")
	     console.log(response)
	      
	    
	     const parsedResponse = JSON.parse(response);

//Extract the values
       const status = parsedResponse.status;
	      
       if (status === 'reject') {
	    	  const enqrId = parsedResponse.data.enqr_id;
	    	  const enqCustId = parsedResponse.data.enqcustid;
	    	  const enqrCreatedBy = parsedResponse.data.enqrcreatedby;
	    	  const enqrSubject = parsedResponse.data.enqrsubject;
	    	  const enqrLUser = parsedResponse.data.enqrluser;
	    	  const status = parsedResponse.status;
	    	  
	    	  console.log('enqr_id:', enqrId);
	    	  console.log('enqcustid:', enqCustId);
	    	  console.log('enqrcreatedby:', enqrCreatedBy);
	    	  console.log('enqrsubject:', enqrSubject);
	    	  console.log('enqrluser:', enqrLUser);
	    	  console.log('status', status);
	    	 
	    	 


	       
	        $("#enqrid").val(enqrId);
	        $("#enqrcustid").val(enqCustId);
	        $("#enqrcreatby").val(enqrCreatedBy);
	        $("#enqrsubject").val(enqrSubject);
	        $("#enqrassignto").val(enqrLUser);
	        $("#enqrluser").val(enqrLUser);
	        $("#status").val(status);
	        
	        // Show the form overlay
	        $("#overlayForm").fadeIn();
	        $("#rfp").hide();
	        
	        
	        $('#statusBarId1').hide();
	        $('#statusBarId2').hide();
	        $('#statusBarId3').hide();
	        $('#statusBarId4').hide();
	        $('#statusBarId5').hide();
	        $('#statusBarId6').hide();
	        
	        
	        
	        
	        
	        $('#statusBarId1').css('width', '20%').text('Reject').addClass('progress-bar-animated').show();
	      

	        
	        
	      } else if (status === 'Approve') {
	    	  
	    	  const enqrId = parsedResponse.data.enqrid;
	    	  const enqCustId = parsedResponse.data.enqcustid;
	    	  const enqrCreatedBy = parsedResponse.data.enqrcreatedby;
	    	  const enqrSubject = parsedResponse.data.enqrsubject;
	    	  const enqrLUser = parsedResponse.data.enqrluser;
	    	  const status = parsedResponse.status;
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  console.log('enqr_id:', enqrId);
	    	  console.log('enqcustid:', enqCustId);
	    	  console.log('enqrcreatedby:', enqrCreatedBy);
	    	  console.log('enqrsubject:', enqrSubject);
	    	  console.log('enqrluser:', enqrLUser);
	    	  console.log('status', status);
	    	  
	        // Handle 'Approve' response
	        
	        
	    	  
		        $("#enqrid").val(enqrId);
		        $("#enqrcustid").val(enqCustId);
		        $("#enqrcreatby").val(enqrCreatedBy);
		        $("#enqrsubject").val(enqrSubject);
		       
		        $("#enqrassignto").val(enqrLUser);
		        $("#enqrluser").val(enqrLUser);
		        $("#status").val(status);
		        // Show the form overlay
		        $("#overlayForm").fadeIn();
		        $("#rfp").hide();
	       
		        
		        $('#statusBarId1').hide();
		        $('#statusBarId2').hide();
		        $('#statusBarId3').hide();
		        $('#statusBarId4').hide();
		        $('#statusBarId5').hide();
		        $('#statusBarId6').hide();
		        $('#statusBarId1').css('width', '20%').text('Reject').addClass('progress-bar-animated').show();
				  $('#statusBarId2').css('width', '30%').text('Enquiry Approve').addClass('progress-bar-animated').show();
			      
				
	        
	      } else if (status === 'convertrfp') {
	        // Handle 'convertrfp' response
	        
	    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
	    	  const rfprcreatedausrid = parsedResponse.data. rfpr_created_ausr_id;
	    	  const rfprstatus = parsedResponse.data.rfpr_status;
	    	  const rfpassignto = parsedResponse.data.rfpr_assignedto;
	    	  const rfpsubject = parsedResponse.data.rfpr_subject;
	    	  const rfpintronote = parsedResponse.data.rfpr_intro_note;
	    	  const status = parsedResponse.status;
	    	  
	
	    	  
	    	  console.log('rfprenqr_id:', rfprenqrId);
	    	  console.log('rfprcreatedausrid:', rfprcreatedausrid);
	    	  console.log('enqrcreatedby:', rfprstatus);
	    	  console.log('rfprstatus:', rfpassignto);
	    	  console.log('rfpsubject:', rfpsubject);
	    	 console.log('rfpintronote',rfpintronote);
	    	 console.log('rfpstatus', status);    

	    	 
	       
	        $("#rfpenqrid").val(rfprenqrId);
	        $("#rfprcreatedausrid").val(rfprcreatedausrid);
	        $("#rfprstatus").val(rfprstatus);
	        $("#rfpassignto").val(rfpassignto);
	       
	        $("#rfpsubject").val(rfpsubject);
	        $("#rfpintronote").val(rfpintronote);
	        $("#rfpstatus").val(status);
	        // Show the form overlay
	        $("#rfp").fadeIn();
	        $("#overlayForm").hide();
	       
	        
	        $('#statusBarId1').hide();
	        $('#statusBarId2').hide();
	        $('#statusBarId3').hide();
	        $('#statusBarId4').hide();
	        $('#statusBarId5').hide();
	        $('#statusBarId6').hide();
	        
	        $('#statusBarId11').hide();
	        $('#statusBarId22').hide();
	        $('#statusBarId33').hide();
	        $('#statusBarId44').hide();
	        $('#statusBarId55').hide();
	        $('#statusBarId66').hide();
	        
	        $('#statusBarId11').css('width', '10%').text('Reject').addClass('progress-bar-animated').show();
			  $('#statusBarId22').css('width', '30%').text('Enquiry Approve').addClass('progress-bar-animated').show();
		        $('#statusBarId33').css('width', '40%').text('Convert To Rfp').addClass('progress-bar-animated').show();
		     
	        
	      } else if (status === 'rfpreject') {
	        // Handle 'rfpreject' response
	        
	    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
	    	  const rfprcreatedausrid = parsedResponse.data. rfpr_created_ausr_id;
	    	  const rfprstatus = parsedResponse.data.rfpr_status;
	    	  const rfpassignto = parsedResponse.data.rfpr_assignedto;
	    	  const rfpsubject = parsedResponse.data.rfpr_subject;
	    	  const rfpintronote = parsedResponse.data.rfpr_intro_note;
	    	  const status = parsedResponse.status;
	    	  
	
	    	  
	    	  console.log('rfprenqr_id:', rfprenqrId);
	    	  console.log('rfprcreatedausrid:', rfprcreatedausrid);
	    	  console.log('enqrcreatedby:', rfprstatus);
	    	  console.log('rfprstatus:', rfpassignto);
	    	  console.log('rfpsubject:', rfpsubject);
	    	 console.log('rfpintronote',rfpintronote);
	    	 console.log('rfpstatus', status);        
		        
		        $('#statusBarId11').hide();
		        $('#statusBarId22').hide();
		        $('#statusBarId33').hide();
		        $('#statusBarId44').hide();
		        $('#statusBarId55').hide();
		        $('#statusBarId66').hide();
	    	  $('#statusBarId11').css('width', '10%').text('Reject').addClass('progress-bar-animated').show();
			  $('#statusBarId22').css('width', '10%').text('Enquiry Approve').addClass('progress-bar-animated').show();
		        $('#statusBarId33').css('width', '20%').text('Convert To Rfp').addClass('progress-bar-animated').show();
		        $('#statusBarId44').css('width', '20%').text('RFP Reject').addClass('progress-bar-animated').show();
		     
	       
	        $("#rfpenqrid").val(rfprenqrId);
	        $("#rfprcreatedausrid").val(rfprcreatedausrid);
	        $("#rfprstatus").val(rfprstatus);
	        $("#rfpassignto").val(rfpassignto);
	       
	        $("#rfpsubject").val(rfpsubject);
	        $("#rfpintronote").val(rfpintronote);
	        $("#rfpstatus").val(status);
	        // Show the form overlay
	        $("#rfp").fadeIn();
	        $("#overlayForm").hide();
	       
	        
	        
	        
	        
	      } else if (status === 'rfpapprove'){
	        // Handle other responses
	        
	    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
	    	  const rfprcreatedausrid = parsedResponse.data. rfpr_created_ausr_id;
	    	  const rfprstatus = parsedResponse.data.rfpr_status;
	    	  const rfpassignto = parsedResponse.data.rfpr_assignedto;
	    	  const rfpsubject = parsedResponse.data.rfpr_subject;
	    	  const rfpintronote = parsedResponse.data.rfpr_intro_note;
	    	  const status = parsedResponse.status;
	    	  
	
	    	  
	    	  console.log('rfprenqr_id:', rfprenqrId);
	    	  console.log('rfprcreatedausrid:', rfprcreatedausrid);
	    	  console.log('enqrcreatedby:', rfprstatus);
	    	  console.log('rfprstatus:', rfpassignto);
	    	  console.log('rfpsubject:', rfpsubject);
	    	 console.log('rfpintronote',rfpintronote);
	    	 console.log('rfpstatus', status);        

	    	 
	       
	        $("#rfpenqrid").val(rfprenqrId);
	        $("#rfprcreatedausrid").val(rfprcreatedausrid);
	        $("#rfprstatus").val(rfprstatus);
	        $("#rfpassignto").val(rfpassignto);
	       
	        $("#rfpsubject").val(rfpsubject);
	        $("#rfpintronote").val(rfpintronote);
	        $("#rfpstatus").val(status);
	        // Show the form overlay
	        $("#rfp").fadeIn();
	        $("#overlayForm").hide();
	        
	        $('#statusBarId11').hide();
	        $('#statusBarId22').hide();
	        $('#statusBarId33').hide();
	        $('#statusBarId44').hide();
	        $('#statusBarId55').hide();
	        $('#statusBarId66').hide();
	        $('#statusBarId11').css('width', '10%').text('Reject').addClass('progress-bar-animated').show();
			  $('#statusBarId22').css('width', '10%').text('Enquiry Approve').addClass('progress-bar-animated').show();
		        $('#statusBarId33').css('width', '20%').text('Convert To Rfp').addClass('progress-bar-animated').show();
		        $('#statusBarId44').css('width', '20%').text('RFP Reject').addClass('progress-bar-animated').show();
		        $('#statusBarId55').css('width', '10%').text('RFP Approve').addClass('progress-bar-animated').show();
	       
	        
	        
	      }
	      else if(status=="rfpcomplete"){
	    	  
	    	  const rfprenqrId = parsedResponse.data.rfpr_id;
	    	  const rfprcreatedausrid = parsedResponse.data. rpfd_reviewedby;
	    	  const rfprstatus = parsedResponse.data.rfpd_desc;
	    	  const rfpassignto = parsedResponse.data.rfpd_type;
	    	  const rfpsubject = parsedResponse.data.rfpd_sharedstatus;
	    	  const rfpintronote = parsedResponse.data.rpdf_status;
	    	  const status = parsedResponse.status;
	    	  
	
	    	  
	    	  console.log('rfprenqr_id:', rfprenqrId);
	    	  console.log('rfprcreatedausrid:', rfprcreatedausrid);
	    	  console.log('enqrcreatedby:', rfprstatus);
	    	  console.log('rfprstatus:', rfpassignto);
	    	  console.log('rfpsubject:', rfpsubject);
	    	 console.log('rfpintronote',rfpintronote);
	    	 console.log('rfpstatus', status);        

	    	 
	    	 
	    	 
		        $("#rfpenqrid").val(rfprenqrId);
		        $("#rfprcreatedausrid").val(rfprcreatedausrid);
		        $("#rfprstatus").val(rfprstatus);
		        $("#rfpassignto").val(rfpassignto);
		       
		        $("#rfpsubject").val(rfpsubject);
		        $("#rfpintronote").val(rfpintronote);
		        $("#rfpstatus").val(status);
		        // Show the form overlay
		        $("#rfp").fadeIn();
		        $("#overlayForm").hide();
		        
		        $('#statusBarId1').hide();
		        $('#statusBarId2').hide();
		        $('#statusBarId3').hide();
		        $('#statusBarId4').hide();
		        $('#statusBarId5').hide();
		        $('#statusBarId6').hide();
		        
		        
		        $('#statusBarId11').hide();
		        $('#statusBarId22').hide();
		        $('#statusBarId33').hide();
		        $('#statusBarId44').hide();
		        $('#statusBarId55').hide();
		        $('#statusBarId66').hide();
		        
		        
		        $('#statusBarId11').css('width', '10%').text('Reject').addClass('progress-bar-animated').show();
				  $('#statusBarId22').css('width', '20%').text('Enquiry Approve').addClass('progress-bar-animated').show();
			        $('#statusBarId33').css('width', '40%').text('Convert To Rfp').addClass('progress-bar-animated').show();
			        $('#statusBarId44').css('width', '60%').text('RFP Reject').addClass('progress-bar-animated').show();
			        $('#statusBarId55').css('width', '70%').text('RFP Approve').addClass('progress-bar-animated').show();
			        $('#statusBarId66').css('width', '100%').text('RFP Completed').addClass('progress-bar-animated').show();
	      }
	    },
	    error: function() {
	      // Handle the error case
	      console.log("Hello Arun..");
	      console.log("Error occurred while retrieving form data.");
	    }
	  });
	  

	}


</script>
   
</body>
</html>