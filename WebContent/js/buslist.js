function displaySeat(busId, fromCity, toCity,startDate, endDate) {
	
	var busid=busId.split(' ')[1];
	console.log(busid);
    var selectedSeat="";
    
    $('#myModal5').css('z-index', 3000);
    var settings = {
            rows: 5,
            cols: 15,
            rowCssPrefix: 'row-',
            colCssPrefix: 'col-',
            seatWidth: 35,
            seatHeight: 35,
            seatCss: 'seat',
            selectedSeatCss: 'selectedSeat',
            selectingSeatCss: 'selectingSeat'
        };
        var init = function (reservedSeat) {
             var str = [], seatNo, className;
             for (i = 0; i < settings.rows; i++) {
                 for (j = 0; j < settings.cols; j++) {
                     seatNo = (i + j * settings.rows + 1);
                     className = settings.seatCss + ' ' + settings.rowCssPrefix + i.toString() + ' ' + settings.colCssPrefix + j.toString();
                     if ($.isArray(reservedSeat) && $.inArray(seatNo, reservedSeat) != -1) {
                         className += ' ' + settings.selectedSeatCss;
                     }
                     str.push('<li class="' + className + '"' +
                               'style="top:' + (i * settings.seatHeight).toString() + 'px;left:' + (j * settings.seatWidth).toString() + 'px">' +
                               '<a title="' + seatNo + '">' + seatNo + '</a>' +
                               '</li>');
                 }
             }
             $('#place').html(str.join(''));
         };
    
         
         
         $.get('/BusProject/SeatBookedFinder?busid='+busid+'&date='+startDate, function( dataFrom ) {
        	 var bookedSeat=dataFrom.BookedSeat;        	 
        	 var arraySeats = JSON.parse("[" + bookedSeat + "]");     	 
       
        	 if(arraySeats.length>0) {
        		 init(arraySeats);
        	 } else{
        		 init(); 
        	 }
        	 
        	 $('.' + settings.seatCss).click(function () {
                 if ($(this).hasClass(settings.selectedSeatCss)){

                	 popup.alert(
 							{
 								content : 'Unavailable,please select another'
 							}
 						);
                 }
                 else{
                     $(this).toggleClass(settings.selectingSeatCss);
                     }
        	 }); 
         });  
         
       //var bookedSeats = [5, 10, 25];
       //init(bookedSeats);

        
         
         
         $('#btnCancel').click(function () {
        	 console.log('hiding modal');
        	 $('#myModal5').modal('hide'); 
         });
         
         
         $('#btnContinue').click(function() {
        	 console.log('continue');
        	 var str = [], item;
             $.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
                 item = $(this).attr('title');                   
                 str.push(item);                   
             });             
             selectedSeat=str.join(',');
             if(selectedSeat.length<1) {
            	 	popup.alert(
							{
								content : 'Please select atleast one seat'
							}
						);
            	 	return false;
             }
             
             console.log('busid, selctedseat', selectedSeat, busId, fromCity, toCity,startDate, endDate);
             $('#myModal5').modal('hide');
             
             var newForm = $('<form>', {
                 'action': '/BusProject/SeatBooking',
                 'target': '_top',
                 'method': 'post'
             }).append($('<input>', {
                 'name': 'selectedSeat',
                 'value': selectedSeat,
                 'type': 'hidden'
             }));
             
             newForm.append($('<input>', {
                 'name': 'busId',
                 'value': busid,
                 'type': 'hidden'
             }));
             newForm.append($('<input>', {
                 'name': 'fromCity',
                 'value': fromCity,
                 'type': 'hidden'
             }));
             
             newForm.append($('<input>', {
                 'name': 'toCity',
                 'value': toCity,
                 'type': 'hidden'
             }));
             
             newForm.append($('<input>', {
                 'name': 'startDate',
                 'value': startDate,
                 'type': 'hidden'
             }));
             
             newForm.append($('<input>', {
                 'name': 'endDate',
                 'value': endDate,
                 'type': 'hidden'
             }));
             
             
             var fare=$("#fare_"+busid).html()
             
             console.log("#fare_"+busid, fare);
             
             
             newForm.append($('<input>', {
                 'name': 'fare',
                 'value': fare,
                 'type': 'hidden'
             }));
             
             $(document.body).append(newForm);
             newForm.submit();
             
             
         });
         
         
    $('#myModal5').modal('show'); 
    
    //load the details
    
}

$(document).ready(function() {
    console.log('getting bus list');
    let v=$("#pageData").html();
    console.log('page data', v);
var vArray=v.split(',');
var fromCityId=vArray[0].split(":")[1];
var toCityId=vArray[1].split(":")[1];
var startDate=vArray[2].split(":")[1];
var endDate=vArray[3].split(":")[1];

var busDetailsHtml='<ul class="first"> <li class="trav"> 	<div class="bus-ic"> 		<img src="images/bus.png" class="img-responsive" alt=""> 	</div> 	<div class="bus-txt"> 		<h4>v_busname</h4> 		<p>A/C Sleeper (1+1)</p> 	</div> 	<div class="clearfix"></div> </li> <li class="dept"> 	<div class="bus-ic1"> 		<i class="fa fa-clock-o"></i> 	</div> 	<div class="bus-txt1"> 		<h4><a href="#">v_depart</a></h4> 		<p>duration</p> 	</div> 	<div class="clearfix"></div> </li> <li class="arriv"> 	<div class="bus-txt2"> 		<h4><a href="#">v_arive</a></h4> 		<p>v_duration</p> 	</div> </li> <li class="seat"> 	<div class="bus-ic3"> 		<img src="images/seat.png" class="img-responsive" alt=""> 	</div> 	<div class="bus-txt3"> 		<h4>4 seats</h4> 		<p>Window 4</p> 	</div> 	<div class="clearfix"></div> </li> <li class="fare"> 	<div class="bus-txt4"> 		<h5 id="fare_v_bus_id">v_fare</h4> 		<a id="viewSeat v_bus_id" class="view">View Seats</a> 		</div> </li> 	<div class="clearfix"></div>		</ul>';
var updatedWithvalue="";  
    //get the bus list 

    
$.get( '/BusProject/getCityNameFromId?citiId='+fromCityId, function( dataFrom ) {
	  $.get( '/BusProject/getCityNameFromId?citiId='+toCityId, function( dataTo ) {		  
		  console.log(dataFrom, dataTo);
		  var summery="Busses from "+dataFrom.CityName+" to "+dataTo.CityName;
		  $("#routeSummery").html(summery);
		});
	});
  
    
    $.post('/BusProject/BusList',   // url
       { fromCity: fromCityId,
         toCity: toCityId,
         startDate: startDate,
         endDate :  endDate
		}, 
       function(data, status, jqXHR) {
                for(var index=0;index<data.length;index++) {
                    console.log(data[index]);
                    
                  
                    var arriveTime=(Math.floor(Math.random() * 24) + 1)+":"+  (Math.floor(Math.random() * 59) + 1)
                    arriveTime=arriveTime+":"+data[index].departingTime.split(':')[1];
                    updatedWithvalue=busDetailsHtml;
                    updatedWithvalue=updatedWithvalue.replace("v_bus_id",data[index].busid );
                    updatedWithvalue=updatedWithvalue.replace("v_bus_id",data[index].busid );
                    updatedWithvalue=updatedWithvalue.replace("v_busname",data[index].companyName ); 
                    updatedWithvalue=updatedWithvalue.replace("v_depart",data[index].departingTime ); 
                    updatedWithvalue=updatedWithvalue.replace("v_arive",arriveTime); 
                    updatedWithvalue=updatedWithvalue.replace("v_duration",data[index].totalDistance); 
                    updatedWithvalue=updatedWithvalue.replace("v_fare",data[index].baseFare*data[index].totalDistance); 
                    console.log("updatedWithvalue", updatedWithvalue);
                    $( "#busListDiv" ).append(updatedWithvalue);
                    }  
                    
            //add click handler to view seat
            
            $('.view').click(function () {
                displaySeat($(this).attr('id'), fromCityId, toCityId,startDate, endDate );             
            });
                
        });
});