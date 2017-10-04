function formValidator(){

	var name=document.getElementById('name');
	var email=document.getElementById('email');
	var phone=document.getElementById('phone');
	var pass=document.getElementById('pass');
	var cpass=document.getElementById('cpass');
	var typ=document.getElementById('type');
	  if(isAlphabet(name, "Please enter only letters for your name")) 
                {
							if(emailValidator(email, "Please enter a valid email address"))
                        {
										if(ValidateMob(phone))
	                                     {
													if(checkpass(pass))
	                								{
	                										if(madeSelection(typ, "Please Select a Account Type"))
	                										{
	                											return true;
	                										}
                             
	                								}
								
										}	
								
						}	
				}
	return false;
}
                                



    function isAlphabet(elem, helperMsg)
  {
	var alphaExp = /^[a-zA-Z]+$/;
	 if(isNaN(elem.value))
              {
		return true;
	}      else
                    {
		alert(helperMsg);
		elem.focus();
		return false;
	      }
    }


     function checkpass(elem)
     {
                 var uInput = elem.value;
             if(uInput!=document.getElementById('cpass').value)
            {
              alert('Confirm Password Does Not Matches');
              elem.focus();     
              return false;
            }
	  else
	 {
	  return true;
	}
     }
       



          function ValidateMob(elem)
        {
              var a = elem.value;
               if(a=="")
              {
                alert("Please Enter Mobile No. for Contact");
	  elem.focus();
                 return false;
              }
                  if(isNaN(a))
                 {
                   alert("Enter the valid Mobile Number(Like : 8412826809)");
                   elem.focus();
                   return false;
                 }

                   if((a.length < 10) || (a.length > 10))
                  {
                   alert(" Your Mobile Number must be 10 Integers");
                   elem.focus();
                   return false;
                 }
                 return true;
         }


              function emailValidator(elem, helperMsg)
             {
	   var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	   if(elem.value.match(emailExp))
                {
		return true;
	  }
                   else
                  {
		alert(helperMsg);
		elem.focus();
		return false;
	   }
              }

 function madeSelection(elem, helperMsg)
             {
	      if(elem.value == "Select")
                   {
		alert(helperMsg);
		elem.focus();
		return false;
	     }
                      else
                    {
		return true;
	      }
	}      