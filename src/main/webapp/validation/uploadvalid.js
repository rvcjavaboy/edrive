function chkSize()
{

 var inputFile = document.getElementById('file');

 for (var i = 0; i < inputFile.files.length; i++) 
 {  
              var file = inputFile .files[i];


                        if ('size' in file) 
                    {
                      
                               var sz=file.size/(1024*1024);
                      
                                  //RESTRICTING UPLOAD FILE SIZE TO 2MB

                                 if(sz >= 16)
                                 {
                                 alert('The File Size Must Be Less Than 16 MB');
                               return false;
                                 }
                       
                          }
 }

}