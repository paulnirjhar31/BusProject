<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="myModal5" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" style="display: block;background-color: white;height: 302px;width: 950px;margin: auto;z-index: -50">   
<br/>
<div id="holder"> 
    <ul  id="place">
    </ul>    
</div>
<div style="float:left;"> 
<ul id="seatDescription">
    <li style="background:url('images/seat-3.png') no-repeat scroll 0 0 transparent;">Available Seat</li>
    <li style="background:url('images/seat-4.png') no-repeat scroll 0 0 transparent;">Booked Seat</li>
    <li style="background:url('images/seat-2.png') no-repeat scroll 0 0 transparent;">Selected Seat</li>
</ul>
</div>
    <div style="clear:both;width:100%">
    <input type="button" id="btnCancel" value="Cancel" class="btn btn-danger"/>
    <input type="button" id="btnContinue" value="Continue" class="btn btn-success"/>           
</div>   
</div> 