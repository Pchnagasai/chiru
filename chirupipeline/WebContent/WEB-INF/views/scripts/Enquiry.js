$(document).ready(function() {
	  $("table tr td:nth-child(3)").each(function() {
	    if ($(this).text() === "Approve") {
	      $(this).addClass("green-background");
	    }
	  });
	});

  $(document).ready(function() { 
      $("tr").each(function() {
          var enqrid = $(this).attr("id");
          getStatus(enqrid);
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
    		    	  
    		
    		    	  
    		    	  console.log('rfprenqr_id:', rfprenqrId);
    		    	 
    		    	 console.log('rfpstatus', status);    

    		    	 
    		    	  
       	    	  $("#td4"+id).text(status);
       		  
    		     
    		        
    		       
    		        
    		      }
    	      
    	      
    	      
    	      else if (status === 'rfpreject') {
    		        // Handle 'rfpreject' response
    		        
    		    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
    		    	 
    		    	  const status = parsedResponse.status;
    		    	  
    		
    		    	  
    		    	  console.log('rfprenqr_id:', rfprenqrId);
    		    	  
    		    	 console.log('rfpstatus', status);        

    		    
    		    	 $("#td5"+id).text(status);
    		        
    		        
    		        
    		      } else if (status === 'rfpapprove'){
    		        // Handle other responses
    		        
    		    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
    		    	 
    		    	  const status = parsedResponse.status;
    		    	  
    		
    		    	  
    		    	  console.log('rfprenqr_id:', rfprenqrId);
    		    	 
    		    	 console.log('rfpstatus', status);        

    		    	 $("#td6"+id).text(status);
    		      
    		       
    		        
    		        
    		      }
    		      else if(status=="rfpcomplete"){
    		    	  
    		    	  const rfprenqrId = parsedResponse.data.rfprenqrid;
     		    	 
    		    	  const status = parsedResponse.status;
    		    	  
    		
    		    	  
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
                
                // Populate form fields with the corresponding data
                form.find('#enqrid').val(enqrid);
                form.find('#enqrcustid').val(''); // Populate with customer ID data
                form.find('#enqrcreatby').val(''); // Populate with created by data
                form.find('#enqrsubject').val(''); // Populate with subject data
                                                   // Populate with description data
                form.find('#enqrassignto').val(''); // Populate with assigned to data
                form.find('#enqrluser').val(''); // Populate with last user data
                form.find('#status').val('');
                
     
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
	      
	      
	     console.log(response)
	      
	    
	     const parsedResponse = JSON.parse(response);

// Extract the values
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

	    	 
	    	
	    	 
	    	 
	    	 
	       
	        $("#enqrid").val(rfprenqrId);
	        $("#enqrcustid").val(rfprcreatedausrid);
	        $("#enqrcreatby").val(rfprstatus);
	        $("#enqrsubject").val(rfpassignto);
	       
	        $("#enqrassignto").val(rfpsubject);
	        $("#enqrluser").val(rfpintronote);
	        $("#status").val(status);
	        // Show the form overlay
	        $("#overlayForm").fadeIn();
	        $("#rfp").hide();
	       
	        
	       
	        
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

	    	 
	    	 
	    	 
	    	 
	    	 
		        $("#enqrid").val(rfprenqrId);
		        $("#enqrcustid").val(rfprcreatedausrid);
		        $("#enqrcreatby").val(rfprstatus);
		        $("#enqrsubject").val(rfpassignto);
		       
		        $("#enqrassignto").val(rfpsubject);
		        $("#enqrluser").val(rfpintronote);
		        $("#status").val(status);
		        // Show the form overlay
		        $("#overlayForm").fadeIn();
		        $("#rfp").hide();
	    	 
	    	 
	 
	        
	        
	        
	        
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

	    	 
	    	 
	    	 
	    	 
	    	 
		        $("#enqrid").val(rfprenqrId);
		        $("#enqrcustid").val(rfprcreatedausrid);
		        $("#enqrcreatby").val(rfprstatus);
		        $("#enqrsubject").val(rfpassignto);
		       
		        $("#enqrassignto").val(rfpsubject);
		        $("#enqrluser").val(rfpintronote);
		        $("#status").val(status);
		        // Show the form overlay
		        $("#overlayForm").fadeIn();
		        $("#rfp").hide();
	    	
	        
	        
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

	    	 
	    	 
	    	 
		        $("#enqrid").val(rfprenqrId);
		        $("#enqrcustid").val(rfprcreatedausrid);
		        $("#enqrcreatby").val(rfprstatus);
		        $("#enqrsubject").val(rfpassignto);
		       
		        $("#enqrassignto").val(rfpsubject);
		        $("#enqrluser").val(rfpintronote);
		        $("#status").val(status);
		        // Show the form overlay
		        $("#overlayForm").fadeIn();
		        $("#rfp").hide();
	    	
	      }
	    },
	    error: function() {
	      // Handle the error case
	      console.log("Error occurred while retrieving form data.");
	    }
	  });
	}