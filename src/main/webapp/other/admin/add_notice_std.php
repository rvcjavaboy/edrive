<?php 
extract($_POST);
if(isset($add))
{
$fy=$_POST['fy'];
$sy=$_POST['sy'];
$ty=$_POST['ty'];
$all=$_POST['all'];
$tmp=0;
if($fy=='fy')
{
$v="fy";
$tmp=1;
}
if($sy=='sy')
{
$v="sy";
$tmp=1;
}
if($ty=='ty')
{
$tmp=1;
$v="ty";
}
if($fy=='fy' && $sy=='sy' )
{
$v="fy and sy";
$tmp=1;
}
if($fy=='fy' && $ty=='ty')
{
$tmp=1;
$v="fy and ty";
}
if(ty=='ty' && $sy=='sy' )
{
$v="sy and ty";
$tmp=1;
}
if((ty=='ty' && $sy=='sy' && $fy=='fy')|| $all=='all')
{
$tmp=1;
$v="All";
}
	if($details=="" || $sub=="" )
	{
	$err="<font color='red'>fill all the fileds first</font>";	
	}
	else
	{
		
mysqli_query($conn,"insert into notice values('','$v','$sub','$details',now(),$tmp)");
		
		
		$err="<font color='green'>Notice added Successfully</font>";	
	}
}

?>
<h2>Add New Notice</h2>
<form method="post">
	
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4"><?php echo @$err;?></div>
	</div>
	
	
	
	<div class="row">
		<div class="col-sm-3">
		  
		</div>
		<div class="col-sm-4">
		Enter Subject:
	      <input type="text" name="sub" class="form-control"/></div>
	</div>
	
	
	<div class="row" style="margin-top:10px">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
	</div>	
	
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
		Enter Details:
	  <textarea name="details" class="form-control"></textarea></div>
	</div>
	
	
	<div class="row" style="margin-top:10px">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
	</div>	
	
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-4">
		Select Class
		  :
		
			
	      <label></label>
	      <label>
	      FY
	      <input name="fy" type="checkbox" id="fy" value="fy" />
	      SY
	     
	      <input name="sy" type="checkbox" id="sy" value="sy" />
	  TY    
	  <input name="ty" type="checkbox" id="ty" value="ty" />
	  ALL    
	  <input name="all" type="checkbox" id="all" value="all" />
	   </label>
	  </div>
	</div>
	
	<div class="row" style="margin-top:10px">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
	</div>	
		
		<div class="row" style="margin-top:10px">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
		<input type="submit" value="Add New Notice" name="add" class="btn btn-success"/>
		<input type="reset" class="btn btn-success"/>
		</div>
	</div>
</form>	